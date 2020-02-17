package com.sandalen.water.util;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static boolean isAscend(List<Waterdata> waterdataList){
        boolean isAscend = false;
//        List<Double> ph = new ArrayList<>();
        List<Double> dissolve = new ArrayList<>();
        List<Double> nh = new ArrayList<>();
        List<Double> kmno = new ArrayList<>();
        for (int i = 0;i < waterdataList.size();i++) {
            dissolve.set(i,waterdataList.get(i).getDisslove());
            nh.set(i,waterdataList.get(i).getNh());
            kmno.set(i,waterdataList.get(i).getKmno());
        }

        boolean d = isAscend2(dissolve, false);
        boolean n = isAscend2(nh,true);
        boolean k = isAscend2(kmno,true);

        if(d || n || k){
            return true;
        }

        return false;

    }

    public static boolean isAscend2(List<Double> data,boolean isLarger){
        int ascend_count = 0;
        for (int i = 1;i < data.size();i++){
            if(isLarger){
                if((data.get(i) - data.get(i-1)) > 0){
                    ascend_count += 1;
                }
            }
            else {
                if((data.get(i) - data.get(i-1)) < 0){
                    ascend_count += 1;
                }
            }

        }

        double ascend_percent = ascend_count / (data.size()-1);

        if (ascend_percent > 0.8){
            return true;
        }

        return false;

    }



    public static void s(){
        String[] as = {"1","2","3","4"};
        StringBuffer sb = new StringBuffer();
        for (String a : as ){
            sb.append(a + ",");
        }

        System.out.println(sb.toString());
    }



//    public static List<Boolean> isT(List<DenseMatrix64F> x,List<DenseMatrix64F> y){
//        List<Boolean> result = new ArrayList<>();
//        for (int i = 0;i < x.get(0).numCols;i++){
//            List<Double> xs = new ArrayList<>();
//            for (int j = 0;j < x.size();j++){
//                xs.add(x.get(j).get(0,i));
//            }
//
//            boolean b = doubleTCheck(xs, y);
//            result.add(b);
//
//        }
//
//        return result;
//    }

    public static void main(String[] args) throws IOException {
        s();
    }
}
