package com.sandalen.water.algo.IsoForest;

import org.ejml.data.DenseMatrix64F;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class IForest implements Serializable {
    List<ITree> iTrees;
    int maxSamples;
    double score;

    public IForest(List<ITree> iTrees, int maxSamples, double score) {
        this.iTrees = iTrees;
        this.maxSamples = maxSamples;
        this.score = score;
    }

    public double predict(DenseMatrix64F x){
        if(iTrees.size() == 0 || iTrees == null){
            throw new IllegalArgumentException("请训练后再预测");
        }

        double sum = 0;
        for(int i = 0;i < iTrees.size();i++){
            sum += pathLengh(x,iTrees.get(i),0);
        }

        double exponent = -(sum/iTrees.size())/cost(maxSamples);

        double score = Math.pow(2,exponent);

        if(score > this.score){
            return -1;
        }
        else {
            return 1;
        }
    }

    public double pathLengh(DenseMatrix64F x,ITree tree,int path_length){
        String simpleName = tree.getClass().getSimpleName();
        if(simpleName.equals("ITreeLeaf")){
            ITreeLeaf leaf = (ITreeLeaf) tree;
            int size = leaf.getSize();
            return path_length + cost(size);

        }

        ITreeBranch iTreeBranch = (ITreeBranch)tree;
        int splitAttr = iTreeBranch.getSplitAttr();
        double splitValue = iTreeBranch.getSplitValue();

        double value = x.get(0, splitAttr);

        if(value < splitValue){
            ITree left = iTreeBranch.getLeft();
            return pathLengh(x,left,path_length + 1);
        }
        else {
            ITree right = iTreeBranch.getRight();
            return pathLengh(x,right,path_length + 1);
        }

    }

    public double getHi(int i){
        double constantValue = 0.5772156649;
        return Math.log(i) + constantValue;
    }

    public double cost(int n){
        double hi = getHi(n-1);
        if(n <= 1){
            return 1.0;
        }
        double cost = 2 * hi - 2*(n-1)/n;
        return cost;
    }

    public double getAccurate(String filepath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String line = null;
        List<String> lists = new ArrayList<String>();
        while ((line = reader.readLine()) != null){
            lists.add(line);
        }

        int cols = lists.get(0).split(",").length-1;


        List<DenseMatrix64F> testData = new ArrayList<DenseMatrix64F>();
        List<Double> ys = new ArrayList<Double>();

        for (int i = 0;i< lists.size();i++){
            String[] strings = lists.get(i).split(",");
            DenseMatrix64F denseMatrix64F = new DenseMatrix64F(1, cols);
            for (int j = 0;j < cols;j++){
                denseMatrix64F.set(0,j,Double.parseDouble(strings[j]));
            }
            testData.add(denseMatrix64F);
            ys.add(Double.parseDouble(strings[5]));
        }

        double count = 0.0;
        for (int i = 0; i < testData.size();i++){
            double predict = predict(testData.get(i));
            if(predict == ys.get(i)){
                count += 1.0;
            }
        }

        return count / ys.size();
    }
}
