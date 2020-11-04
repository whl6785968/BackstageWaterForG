package com.sandalen.water.controller;

import com.sandalen.water.bean.*;
import com.sandalen.water.service.DataRelatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageDeliveryException;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.*;

@RequestMapping("/data/basic/")
@RestController
public class DataRelatedController {

    @Autowired
    private DataRelatedService dataRelatedService;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @RequestMapping("/getBasicData")
    public RespBean getBasicData(){
        Map<String, Integer> basicData = dataRelatedService.getBasicData();
        return RespBean.ok("success",basicData);
    }

    @RequestMapping("/getDataBySid")
    public RespBean getDataBySid(int stationId) throws ParseException {
        List<Waterdata> data = dataRelatedService.getWaterDataBySid(stationId);
        return RespBean.ok("success",data);
    }

    @RequestMapping("/getWQIByDistrict")
    public RespBean getWQIByDistrict(){
        Map<String, Double> wqi = dataRelatedService.getWQIByDistrict();
        return RespBean.ok("success",wqi);
    }

    @RequestMapping("/getWQIByStation")
    public RespBean getWQIByStation(){
        Map<String, Double> wqiByStation = dataRelatedService.getWQIByStation();
        return RespBean.ok("success",wqiByStation);
    }

    @RequestMapping("/getStations")
    public RespBean getStations(){
        List<Station> stations = dataRelatedService.getStations();
        return RespBean.ok("success",stations);
    }

    @RequestMapping("/getEquipAndStation")
    public RespBean getEquipAndStation(@RequestBody SearchCondition searchCondition){
        List<Equipment> equipAndStation = dataRelatedService.getEquipAndStation(searchCondition);
        if(!StringUtils.isEmpty(equipAndStation)){
            return RespBean.ok("获取数据成功",equipAndStation);
        }

        return RespBean.error("获取数据失败");
    }

    @RequestMapping("/getWaterData")
    public RespBean getWaterData(String eid){
        List<Waterdata> formatWaterData = new ArrayList<>();
        List<Waterdata> waterDatas = dataRelatedService.getWaterData(eid);
        if(!StringUtils.isEmpty(waterDatas)){
//            for(Waterdata waterdata:waterDatas){
//
//            }
            return RespBean.ok("获取数据成功",waterDatas);

        }

        return RespBean.error("获取数据失败");
    }

    @RequestMapping("/getStationForMap")
    public RespBean getStationForMap(){
        List<Station> stationForMap = dataRelatedService.getStationForMap();
        if(!StringUtils.isEmpty(stationForMap)){
            return RespBean.ok("获取数据成功",stationForMap);
        }
        return RespBean.error("获取数据失败");
    }

    @RequestMapping("/getAllInfoForStation")
    public RespBean getAllInfoForStation(String district,String responsible,String level){
        System.out.println(district + ":" + ":" + responsible + ":" + level);
        HashMap<String, Object> map = new HashMap<>();
        map.put("district",district);
        map.put("responsible",responsible);
        if(level != null && level != ""){
            map.put("nlevel",Integer.parseInt(level));
        }
        map.put("nlevel",level);

        List<Station> stations = dataRelatedService.getAllInfoForStation(map);
        if(!StringUtils.isEmpty(stations)){
            return RespBean.ok("获取数据成功",stations);
        }
        return RespBean.error("获取数据失败");
    }


    @RequestMapping("/getDynamicData")
    public RespBean getDynamicData(int stationId) throws InterruptedException {
        String thread_name = "dyn_"+stationId;
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        int cnt = threadGroup.activeCount();
        Thread[] threads = new Thread[cnt];
        threadGroup.enumerate(threads);

        for(Thread t:threads){
            if(t.getName().equals(thread_name)){
                System.out.println("关闭"+stationId);
                t.interrupt();
            }
        }

        DynamicDataGetterThread data_thread = new DynamicDataGetterThread(stationId);
        Thread t = new Thread(data_thread);
        t.setName(thread_name);
        t.start();

        return RespBean.ok("success");
    }

    class DynamicDataGetterThread implements Runnable{
        private int stationId;

        public DynamicDataGetterThread(int stationId){
            this.stationId = stationId;
        }

        @Override
        public synchronized void run() {
//            List<Waterdata> old_data = new ArrayList<>();
            List<Waterdata> old_data = MyThreadLocal.threadLocal.get();
            String destination = "/topic/getDynamicData_"+this.stationId;
            while (true){
                System.out.println(new Date()+":轮询:"+this.stationId);
                try {
                    Thread.sleep(10000);
                    List<Waterdata> data = dataRelatedService.getWaterDataBySid(this.stationId);
                    List<Waterdata> dup = new ArrayList<>(data);

                    if(data != null){
                        for(Waterdata od : old_data){
                            for(int i = 0;i < data.size();i++){
                                if(od.getId().equals(data.get(i).getId())){
                                    data.remove(i);
                                    i--;
                                }
                            }
                        }
                    }
                    else {
                        continue;
                    }

                    if(data.size() != 0){
                        old_data = dup;
                        MyThreadLocal.threadLocal.set(old_data);
                        try{
                            simpMessagingTemplate.convertAndSend(destination,data);
                        }
                        catch (MessageDeliveryException e){
                            System.out.println("发生WebSocket发送异常");
                            continue;
                        }
                    }
                } catch (InterruptedException e) {
                    System.out.println("该线程被打断");
                    break;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}

class MyThreadLocal {
    public static ThreadLocal<List<Waterdata>> threadLocal = ThreadLocal.withInitial(() -> new ArrayList<>());
}
