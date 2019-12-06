package com.sandalen.water.service;



import com.sandalen.water.PropertiesClass.IsoForestProperties;
import com.sandalen.water.algo.IsoForest.IForest;
import com.sandalen.water.algo.IsoForest.IsoForest;
import com.sandalen.water.bean.*;
import com.sandalen.water.dao.EquipmentMapper;
import com.sandalen.water.dao.WaterdataMapper;
import com.sandalen.water.other.Constants;
import com.sandalen.water.util.AlgoUtils;
import com.sandalen.water.util.IOUtils;
import com.sandalen.water.util.MathUtils;
import org.ejml.data.DenseMatrix64F;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ujmp.core.util.MathUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AlgoService {
    @Autowired
    private EquipmentMapper equipmentMapper;

    @Autowired
    private WaterdataMapper waterdataMapper;

    @Autowired
    private DataRelatedService dataRelatedService;

    @Autowired
    private IsoForestProperties isoForestProperties;

    public Map<String,Object> isoForest() throws IOException {
        String modelStr = IOUtils.getModelStr(isoForestProperties.getModel_path());
        IForest iForest = IOUtils.load_model(modelStr, IForest.class);

        SearchCondition searchCondition = new SearchCondition();
        List<Equipment> equipAndStation = dataRelatedService.getEquipAndStation(searchCondition);


        Map<String,Object> result = new HashMap<>();
        for (int i = 0;i < equipAndStation.size();i++){
            WaterdataExample waterdataExample = new WaterdataExample();
            WaterdataExample.Criteria criteria = waterdataExample.createCriteria();
            criteria.andEidEqualTo(equipAndStation.get(i).getId());
            List<Waterdata> waterdata = waterdataMapper.selectByExample(waterdataExample);

            List<DenseMatrix64F> bad_data = new ArrayList<>();
            List<DenseMatrix64F> good_data = new ArrayList<>();
            Map<String, Object> map = new HashMap<>();
            double bad_count = 0.0;
            for (int j = 0;j < waterdata.size(); j++){
                DenseMatrix64F denseMatrix64F = new DenseMatrix64F(1, 5);
                denseMatrix64F.set(0,0,waterdata.get(j).getPh());
                denseMatrix64F.set(0,1,waterdata.get(j).getDisslove());
                denseMatrix64F.set(0,2,waterdata.get(j).getNh());
                denseMatrix64F.set(0,3,waterdata.get(j).getKmno());
                denseMatrix64F.set(0,4,waterdata.get(j).getTotalp());

                if (iForest.predict(denseMatrix64F) == -1.0){
                    bad_data.add(denseMatrix64F);
                }
                else {
                    good_data.add(denseMatrix64F);
                }

                bad_count = bad_data.size();
                List<Double> bad_data_mean = MathUtils.getMeanForDenseMatrix(bad_data);
                map.put("bad_count",bad_count);
                map.put("bad_data",bad_data);
                map.put("bad_percent",bad_count/waterdata.size());
                map.put("bad_data_mean",bad_data_mean);
            }
            String key = equipAndStation.get(i).getId() + ":" + equipAndStation.get(i).getStation().getName();
            result.put(key,map);
        }
        return result;
    }

    public int isError(Waterdata waterdata) throws IOException {
        double ph = waterdata.getPh();
        double nh = waterdata.getNh();
        double dissolve = waterdata.getDisslove();
        double totalc = waterdata.getTotalp();
        double kmno = waterdata.getKmno();

        IForest isoForest = AlgoUtils.getIsoForest();
        DenseMatrix64F denseMatrix64F = new DenseMatrix64F(1, 5);
        denseMatrix64F.set(0,0,ph);
        denseMatrix64F.set(0,1,dissolve);
        denseMatrix64F.set(0,2,nh);
        denseMatrix64F.set(0,3,kmno);
        denseMatrix64F.set(0,4,totalc);

        double predict = isoForest.predict(denseMatrix64F);
        if(predict == 1.0){
            return 1;
        }
        else {
            return -1;
        }
    }

    public void trainIsoForest() throws IOException {
        IsoForest isoForest = new IsoForest();
        int numTrees = isoForestProperties.getNumTrees();
        double score = isoForestProperties.getScore();
        isoForest.train(numTrees, score);
    }
}
