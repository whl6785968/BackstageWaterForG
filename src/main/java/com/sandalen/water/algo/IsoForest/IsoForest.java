package com.sandalen.water.algo.IsoForest;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.JavaSerializer;
import com.sandalen.water.PropertiesClass.IsoForestProperties;
import com.sandalen.water.other.Constants;
import org.ejml.data.DenseMatrix64F;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Random;

@Component
public class IsoForest {
    @Autowired
    IsoForestProperties isoForestProperties;


    public static IsoForest isoForest;

    @PostConstruct
    public void init(){
        isoForest = this;
        isoForest.isoForestProperties = this.isoForestProperties;
    }

    public DenseMatrix64F loadFile(String filepath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String line =  null;

        List<String> lines = new ArrayList<String>();
        while ((line = reader.readLine()) != null){
            lines.add(line);
        }

        int col = lines.get(0).split(",").length - 1;
        DenseMatrix64F data = new DenseMatrix64F(lines.size(),col);

        for (int i = 0;i < lines.size(); i++){
            String[] strings = lines.get(i).split(",");
            for (int j = 0;j < col;j++){
                data.set(i,j,Double.parseDouble(strings[j]));
            }
        }

        return data;
    }

    public DenseMatrix64F getSubSample(DenseMatrix64F dataSet,int subSampleCount){
        int features = dataSet.numCols;
        DenseMatrix64F subSample = new DenseMatrix64F(subSampleCount,features);

        for (int i = 0;i < subSampleCount; i++){
            for (int j = 0;j < features;j++){
                subSample.set(i,j,dataSet.get(i,j));
            }
        }

        return subSample;
    }

    public void train(int numTrees,double score) throws IOException {
        String train_data = isoForest.isoForestProperties.getTrain_data();
        System.out.println("开始训练模型");
        IForest iForest = train(train_data, score);
        System.out.println("训练完成");
//        IForest iForest = new IForest(iTrees,maxSamples,score);
//        IForest iForest = train(isoForest.isoForestProperties.getTrain_data(), score);
        save_model(iForest,isoForest.isoForestProperties.getModel_path());
        System.out.println("保存模型至"+isoForest.isoForestProperties.getModel_path());
    }

    public IForest train(String filepath,double score) throws IOException {
        DenseMatrix64F dataSet = loadFile(filepath);
        int rows = dataSet.numRows;

        int maxLength = (int) Math.ceil(bottomChanging(rows,2));
        int numTrees = 500;
        int numFeatures = dataSet.numCols;
        int maxSamples = 256;
        int subSampleSize = Math.min(256,rows);

        List<ITree> iTrees = new ArrayList<ITree>();

        for (int i = 0;i < numTrees;i++){
            DenseMatrix64F subSample = getSubSample(dataSet, subSampleSize);
            ITree iTree = growTree(subSample, maxLength, numFeatures, 0);
            iTrees.add(iTree);
        }

        return new IForest(iTrees,maxSamples,score);

    }

    public ITree growTree(DenseMatrix64F data, int maxLength, int numFeatures, int currentLength){
        if (currentLength >= maxLength || data.numRows <= 1){
            return new ITreeLeaf(data.numRows);
        }

        Random random = new Random();
        int feature = random.nextInt(numFeatures);
        int rows = data.numRows;
        int randomRow = random.nextInt(rows);
        double splitPoint = data.get(randomRow,feature);

        List<Integer> rightList = new ArrayList<Integer>();
        List<Integer> leftList = new ArrayList<Integer>();
        for(int i = 0; i < rows;i++){
            if(data.get(i,feature) >= splitPoint){
                rightList.add(i);
            }
            else {
                leftList.add(i);
            }
        }

        DenseMatrix64F left = new DenseMatrix64F(leftList.size(), numFeatures);
        DenseMatrix64F right = new DenseMatrix64F(rightList.size(), numFeatures);

        for (int i = 0; i < leftList.size();i++){
            for(int j = 0;j < numFeatures;j++){
                left.set(i,j,data.get(i,j));
            }
        }

        for (int i = 0; i < rightList.size();i++){
            for(int j = 0;j < numFeatures;j++){
                right.set(i,j,data.get(i,j));
            }
        }

        return new ITreeBranch(growTree(left,maxLength,numFeatures,currentLength+1),growTree(right,maxLength,numFeatures,currentLength+1),
                splitPoint,feature);

    }

    public double bottomChanging(int x,int bottom){
        double log = Math.log10(x) / Math.log10(bottom);
        return log;
    }

    public String save_model(Object obj,String path) throws IOException {
        Kryo kryo = new Kryo();
        kryo.setReferences(true);
        kryo.register(obj.getClass(),new JavaSerializer());

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Output output = new Output(stream);
        kryo.writeClassAndObject(output,obj);
        output.flush();
        output.close();

        byte[] b = stream.toByteArray();
        try
        {
            stream.flush();
            stream.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        String objStr = Base64.getEncoder().encodeToString(b);
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(objStr);
        writer.close();

        return objStr;
    }

    public <T extends Serializable> T load_model(String objStr,Class<T> clazz){
        Kryo kryo = new Kryo();
        kryo.setReferences(true);
        kryo.register(clazz,new JavaSerializer());
        ByteArrayInputStream bais = new ByteArrayInputStream(Base64.getDecoder().decode(objStr));
        Input input = new Input(bais);
        return (T) kryo.readClassAndObject(input);
    }

    public IForest load_model(String objStr){
        Kryo kryo = new Kryo();
        kryo.setReferences(true);
        kryo.register(IForest.class,new JavaSerializer());

        ByteArrayInputStream bais = new ByteArrayInputStream(Base64.getDecoder().decode(objStr));
        Input input = new Input(bais);

        return (IForest) kryo.readClassAndObject(input);
    }

}
