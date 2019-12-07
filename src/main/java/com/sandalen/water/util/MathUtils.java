package com.sandalen.water.util;

import org.ejml.data.DenseMatrix64F;
import org.ejml.ops.CommonOps;
import org.ujmp.core.util.MathUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MathUtils {
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
}
