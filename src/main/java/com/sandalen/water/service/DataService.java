package com.sandalen.water.service;

import com.sandalen.water.algo.IsoForest.IForest;
import com.sandalen.water.bean.Station;
import com.sandalen.water.bean.StationExample;
import com.sandalen.water.bean.Waterdata;
import com.sandalen.water.dao.StationMapper;
import com.sandalen.water.util.IOUtils;
import com.sandalen.water.util.MathUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class DataService {
    @Autowired
    private DataRelatedService dataRelatedService;

    @Autowired
    private StationMapper stationMapper;

    public String analysis_basin2(String stationId) throws IOException {

        String modelStr = IOUtils.getModelStr("F:/water/src/main/resources/model/IsoForest.txt");
        IForest iForest = IOUtils.load_model(modelStr, IForest.class);

        if(stationId == null){
            return null;
        }

        Station station = dataRelatedService.getStationById(stationId);
        String eid = dataRelatedService.getEidBySid(stationId);
        List<Waterdata> waterdataList = dataRelatedService.getWaterdataByEid(eid);
        Double err_percent = MathUtils.get_err_percent(waterdataList, iForest);
        String upstreamId = station.getUpstreamId();
        if(err_percent > 0.2){
            return analysis_basin2(upstreamId) + "异常站点:"+station.getName();
        }
        else {
            return null;
        }
    }

    public List<Station> getErrStation(){
        StationExample example = new StationExample();
        StationExample.Criteria criteria = example.createCriteria();
        criteria.andIsAlertEqualTo(1);

        List<Station> stations = stationMapper.selectByExample(example);

        return stations;
    }

    public List<Station> getErrStationAndRecord(){
        List<Station> stations = stationMapper.getErrStationAndRecord();
        return stations;
    }

    public static void main(String[] args) throws IOException {
        DataService dataService = new DataService();
        dataService.analysis_basin2("003");
    }
}
