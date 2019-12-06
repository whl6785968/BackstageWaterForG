package com.sandalen.water.util;

import org.ejml.data.DenseMatrix64F;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MathUtils {
    public double getMean(List<Double> list){
        double sum = 0;
        for (int i = 0;i < list.size();i++){
            Double number = list.get(i);
            sum += number;
        }

        return sum / list.size();
    }

    public double getMean(Object[] array){
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
        result.add(number1/list.size());
        result.add(number2/list.size());
        result.add(number3/list.size());
        result.add(number4/list.size());
        result.add(number5/list.size());

        return result;
    }
}
