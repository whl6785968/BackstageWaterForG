package com.sandalen.water.util;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.serializers.JavaSerializer;


import java.io.*;
import java.util.Base64;

public class IOUtils {
    public static  <T extends Serializable> T load_model(String objStr,Class<T> clazz) throws IOException {
        Kryo kryo = new Kryo();
        kryo.setReferences(true);
        kryo.register(clazz,new JavaSerializer());
        ByteArrayInputStream bais = null;
        Input input = null;
        T obj = null;
        try {
            bais = new ByteArrayInputStream(Base64.getDecoder().decode(objStr));
            input = new Input(bais);
            obj = (T)kryo.readClassAndObject(input);
            return obj;
        }
        catch (Exception e){
            e.printStackTrace();
            return obj;
        }
        finally {
            input.close();
            bais.close();
        }




    }

    public static String getModelStr(String filepath) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String line = reader.readLine();

        return line;
    }

//    public static List<DenseMatrix64F> transFormDenseMatrix(List list,int col,int start,int end){
//        List<DenseMatrix64F> denseMatrix64FList = new ArrayList<>();
//        for (int i = start;i < end; i++){
//            DenseMatrix64F denseMatrix64F = new DenseMatrix64F(1, col);
//            for (int j = 0; j < col ; j++){
//                denseMatrix64F.set(1,j);
//            }
//        }
//    }
}
