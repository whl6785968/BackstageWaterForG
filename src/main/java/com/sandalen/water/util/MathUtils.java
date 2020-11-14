package com.sandalen.water.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sandalen.water.PropertiesClass.IsoForestProperties;
import com.sandalen.water.algo.IsoForest.IForest;
import com.sandalen.water.bean.Equipment;
import com.sandalen.water.bean.Station;
import com.sandalen.water.bean.Waterdata;
import com.sandalen.water.service.DataRelatedService;
import org.ejml.data.DenseMatrix64F;
import org.ejml.ops.CommonOps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ujmp.core.util.MathUtil;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.*;

@Component
public class MathUtils {

    @Autowired
    private IsoForestProperties isoForestProperties;
    private static IsoForestProperties realIsoForestProperties;

    @Autowired
    private DataRelatedService dataRelatedService;
    private static DataRelatedService realDataRelatedService;

    @PostConstruct
    public void init(){
       realDataRelatedService = this.dataRelatedService;
       realIsoForestProperties = this.isoForestProperties;
    }


    public static double getMean(List<Double> list){
        double sum = 0;
        for (int i = 0;i < list.size();i++){
            Double number = list.get(i);
            sum += number;
        }

        return sum / list.size();
    }

    public static double getMean(Object[] array){
        double sum = 0;
        for(int i = 0;i < array.length;i++){
            sum += (double)array[i];
        }

        return sum / array.length;
    }

    public static List<Double> getMeanForDenseMatrix(List<DenseMatrix64F> list){
        double number1 = 0;
        double number2 = 0;
        double number3 = 0;
        double number4 = 0;
        double number5 = 0;

        for (int i = 0;i < list.size();i++){
            number1 += list.get(i).get(0,0);
            number2 += list.get(i).get(0,1);
            number3 += list.get(i).get(0,2);
            number4 += list.get(i).get(0,3);
            number5 += list.get(i).get(0,4);
        }

        List<Double> result = new ArrayList<>();

        result.add(keepDecimal(number1/list.size(),3));
        result.add(keepDecimal(number2/list.size(),3));
        result.add(keepDecimal(number3/list.size(),3));
        result.add(keepDecimal(number4/list.size(),3));
        result.add(keepDecimal(number5/list.size(),3));

        return result;
    }

    public static double keepDecimal(double number,int numOfDecimal){
        String format = "%." + numOfDecimal + "f";
        return Double.parseDouble(String.format(format,number));
    }

    public static List<Double> calcCorr(List<DenseMatrix64F> x,List<Double> y){
        List<Double> x_mean = getMeanForDenseMatrix(x);
        double y_mean = getMean(y);

        List<Double> result = new ArrayList<>();
        for (int i = 0;i < x.get(0).numCols;i++){
            List<Double> xs = new ArrayList<>();
            for (int j = 0;j < x.size();j++){
                xs.add(x.get(j).get(0,i));
            }

            double x_sum_pow2 = sumOfNumSubMean(xs, x_mean.get(i));
            double y_sum_pow2 = sumOfNumSubMean(y,y_mean);

            double x_y_sum = sumOfNumSubMean(xs,x_mean.get(i),y,y_mean);

            double corr = x_y_sum / Math.sqrt(x_sum_pow2 * y_sum_pow2);
            result.add(keepDecimal(corr,3));
        }

        return result;
    }

    public static double sumOfNumSubMean(List<Double> x,double mean){
        double sum = 0;
        for (int i = 0;i < x.size();i++){
            double tmp = x.get(i) - mean;
            sum += Math.pow(tmp,2);
        }

        return sum;
    }

    public static double sumOfNumSubMean(List<Double> x,double x_mean,List<Double> y,double y_mean){
        double sum = 0;
        for (int i = 0;i < x.size();i++){
            double x_tmp = x.get(i) - x_mean;
            double y_tmp = y.get(i) - y_mean;
            sum += x_tmp * y_tmp;
        }

        return sum;
    }

    public static double sum(List<Double> list){
        double sum = 0;
        for (int i = 0;i < list.size();i++){
            sum += list.get(i);
        }

        return sum;
    }

    public static double sumPow2(List<Double> list){
        double sum = 0;
        for (int i = 0;i < list.size();i++){
            sum += Math.pow(list.get(i),2);
        }
        return sum;
    }

    public static double sumt(List<Double>... lists){
        double sum = 0;
        for (int i = 0;i < lists[i].size();i++){
            double tmp = lists[0].get(i);
            for (int j = 0;j < lists.length;j++){
                tmp -= lists[j].get(i);
            }

            sum += tmp;
        }

        return sum;
    }

    public static double calcSc(List<Double> x1,List<Double> x2){
       if (x1.size() < 1 || x2.size()  < 1){
           System.out.println("x1或者x2长度小于1");
           return 0;
       }
       return (sumPow2(x1) - Math.pow(sum(x1) ,2)/x1.size() + sumPow2(x2) - Math.pow(sum(x2),2)) /  x1.size() + x2.size() - 2;
    }

    public static double calcSx1x2(List<Double> x1,List<Double> x2){
        return Math.sqrt(Math.pow(calcSc(x1,x2),2)*(1/x1.size() + 1/x2.size()));
    }

    public static boolean doubleTCheck(List<Double> x1,List<Double> x2){
        double t = (getMean(x1) + getMean(x2)) / calcSx1x2(x1,x2);
        int num = x1.size();
        double t1 = getT(num);
        boolean isObvious = t < t1;
        return isObvious;

    }

    public static double getT(int num){
        double t = 0.0;
        if(num <= 10){
            t = 2.228;
        }
        else if(num >10 && num <= 20){
            t = 2.086;
        }
        else if (num > 20 && num <= 30){
            t = 2.042;
        }
        else {
            t = 2.0;
        }

        return t;
    }


    public static List<Boolean> isT(List<DenseMatrix64F> x,List<Double> y){
        List<Boolean> result = new ArrayList<>();
        for (int i = 0;i < x.get(0).numCols;i++){
            List<Double> xs = new ArrayList<>();
            for (int j = 0;j < x.size();j++){
                xs.add(x.get(j).get(0,i));
            }

            boolean b = doubleTCheck(xs, y);
            result.add(b);

        }

        return result;
    }

    public static List<DenseMatrix64F> transfer_to_dense(List<Waterdata> waterdataList){
        List<DenseMatrix64F> denseMatrix64FList = new ArrayList<>();
        for (int i = 0;i < waterdataList.size();i++){
            DenseMatrix64F denseMatrix64F = new DenseMatrix64F(1, 5);
            denseMatrix64F.set(0,0,waterdataList.get(i).getPh());
            denseMatrix64F.set(0,1,waterdataList.get(i).getDisslove());
            denseMatrix64F.set(0,2,waterdataList.get(i).getNh());
            denseMatrix64F.set(0,3,waterdataList.get(i).getKmno());
            denseMatrix64F.set(0,4,waterdataList.get(i).getTotalp());
            denseMatrix64FList.add(denseMatrix64F);
        }

        return denseMatrix64FList;

    }
    public static Double get_err_percent(List<Waterdata> waterdataList, IForest iForest){
        List<DenseMatrix64F> denseMatrix64FList = transfer_to_dense(waterdataList);
        double sum = 0.0;
        for(DenseMatrix64F data:denseMatrix64FList){
            double prediction = iForest.predict(data);
            if (prediction == -1.0){
                sum += 1.0;
            }
        }

        double err_percent = sum / waterdataList.size();

        return err_percent;
    }

    public static Double getErrPercentWithPython(List<Waterdata> waterdataList) throws IOException {
        double sum = 0.0;
        for(Waterdata waterdata : waterdataList){
            Double ph = waterdata.getPh();
            Double disslove = waterdata.getDisslove();
            Double nh = waterdata.getNh();
            Double kmno = waterdata.getKmno();
            Double totalp = waterdata.getTotalp();

            String params = ph + "," + disslove + "," + nh +"," + kmno + "," + totalp;
            String uri = "http://127.0.0.1:5000/errCheck/?data=" + params;

            String response = HttpClientUtils.getRequest(uri);

            JSONObject jsonObject = JSON.parseObject(response);
            Object o = JSON.parseObject(jsonObject.getString("data")).get("result");
            String s = o.toString();

            if(Integer.parseInt(s) == 0){
                sum += 1;
            }
        }

        double errPercent = sum / waterdataList.size();

        return errPercent;
    }

    public static Map<String,List<String>> analysis_basin1(Equipment equipment) throws IOException {
        Map<String,List<String>> map = new HashMap();
        Station station = equipment.getStation();
        String upStreams = analysis_basin2(station.getId(),true);
        String[] upStream_array = upStreams.split("->");
        List<String> upstream_list = new ArrayList<>();
        for (int i = 0;i < upStream_array.length - 1;i++){
            if (!upStream_array[i].equals("")){
                upstream_list.add(upStream_array[i]);
            }
        }

        String downstreams = analysis_basin2(station.getId(),false);
        String[] downstream_array = downstreams.split("->");
        List<String> downstream_list = new ArrayList<>();
        for (int i = 1;i < downstream_array.length;i++){
            if(!downstream_array[i].equals("")){
                downstream_list.add(downstream_array[i]);
            }
        }

        map.put("upstream",upstream_list);
        map.put("downstream",downstream_list);

        return map;
    }

    public static String analysis_basin2(String stationId,boolean isUpstream) throws IOException {
        String modelStr = IOUtils.getModelStr(realIsoForestProperties.getModel_path());
        IForest iForest = IOUtils.load_model(modelStr, IForest.class);

        if(stationId == null || stationId == ""){
            return "";
        }

        Station station = realDataRelatedService.getStationById(stationId);
        String eid = realDataRelatedService.getEidBySid(stationId);
        List<Waterdata> waterdataList = realDataRelatedService.getWaterdataByEid(eid);
        Double err_percent = get_err_percent(waterdataList, iForest);
        String sid = null;
        if (isUpstream){
            sid = station.getUpstreamId();
            if(err_percent > 0.05){
                return analysis_basin2(sid,true) + "->" +station.getName();
            }
            else {
                return "";
            }
        }
        else {
            sid = station.getDownstreamId();
            if(err_percent > 0.05){
                return  station.getName() + "->" + analysis_basin2(sid,false) ;
            }
            else {
                return "";
            }
        }
    }

    public static String judgeTheTrend(List<Waterdata> waterdataList){
        List<Double> dis = new ArrayList<>();
        List<Double> nh = new ArrayList<>();
        List<Double> kmno = new ArrayList<>();
        List<Double> totalp = new ArrayList<>();

        for(Waterdata waterdata : waterdataList){
            dis.add(waterdata.getDisslove());
            nh.add(waterdata.getNh());
            kmno.add(waterdata.getKmno());
            totalp.add(waterdata.getTotalp());
        }

        boolean disTrend = isDeteriorating(dis, false);
        boolean nhTrend = isDeteriorating(nh,true);
        boolean kmnoTrend = isDeteriorating(kmno,true);
        boolean totalpTrend = isDeteriorating(totalp,true);

        String res = "";

        if(disTrend){
            res += "溶解氧、";
        }

        if(nhTrend){
            res += "氨氮、";
        }

        if(kmnoTrend){
            res += "高锰酸盐、";
        }

        if(totalpTrend){
            res += "总磷";
        }

        if(!res.equals("")){
            if(res.endsWith("、")){
                res = res.substring(0,res.length()-1);
            }
            res += "等指标呈现恶化趋势";
        }

        return res;

    }

    public static boolean isDeteriorating(List<Double> factor,boolean isAscend){
        boolean res = false;

        if(isAscend){
            double cnt = 0.0;
            for(int i = 1;i < factor.size();i++){
                if(factor.get(i) - factor.get(i-1) > 0){
                    cnt += 1.0;
                }
            }

            if(cnt / factor.size() > 0.7){
                res = true;
            }

        }
        else{
            double cnt = 0.0;
            for(int i = 1;i < factor.size();i++){
                if(factor.get(i) - factor.get(i-1) < 0){
                    cnt += 1.0;
                }
            }

            if(cnt / factor.size() > 0.7){
                res = true;
            }
        }

        return res;
    }

    public static String haveMutation(List<Waterdata> waterdataList){
        List<Double> dis = new ArrayList<>();
        List<Double> nh = new ArrayList<>();
        List<Double> kmno = new ArrayList<>();
        List<Double> totalp = new ArrayList<>();

        for(Waterdata waterdata : waterdataList){
            dis.add(waterdata.getDisslove());
            nh.add(waterdata.getNh());
            kmno.add(waterdata.getKmno());
            totalp.add(waterdata.getTotalp());
        }

        haveMutationByFactor(nh);
        haveMutationByFactor(kmno);
        haveMutationByFactor(dis);
        haveMutationByFactor(totalp);

        return null;

    }

    public static boolean haveMutationByFactor(List<Double> data){
        double n = data.size();
        double M = getMean(data);

        double std = 0;

        for(int i = 0;i < n;i++){
            std += Math.pow(M - data.get(i),2);
        }

        std = std / n;
        System.out.println(std);
        return false;
    }

    public static List<String> getSeriousExeededFactor(List<Waterdata> waterdataList) throws IOException {
        Set<String> seriousFactors = new HashSet<>();

        for(Waterdata waterdata : waterdataList){
            double ph = waterdata.getPh();
            double dis = waterdata.getDisslove();
            double nh = waterdata.getNh();
            double kmno = waterdata.getKmno();
            double totalp = waterdata.getTotalp();

            String params = ph + "," + dis + "," + nh + "," +
                    kmno + "," + totalp;

            String uri = "http://127.0.0.1:5000/errCheck/?data=" + params;

            String response = HttpClientUtils.getRequest(uri);

            JSONObject jsonObject = JSON.parseObject(response);
            Object o = JSON.parseObject(jsonObject.getString("data")).get("result");
            String s = o.toString();

            if(Integer.parseInt(s) == 0){
                if((5.0 - dis) / 5.0 > 0.3){
                    seriousFactors.add("dis");
                }

                if((nh - 1.0) / 1.0 > 0.3) seriousFactors.add("nh");

                if((kmno - 6.0) / 6.0 > 0.3) seriousFactors.add("kmno");

                if((totalp-0.2) > 0.3) seriousFactors.add("totalp");
            }
        }


        return new ArrayList<>(seriousFactors);

    }

    public static void main(String[] args) throws IOException {

    }
}
