package com.sandalen.water.algo.IsoForest;

import java.io.Serializable;

public class ITreeBranch extends ITree implements Serializable {
    ITree left;
    ITree right;
    double splitValue;
    int splitAttr;


    public ITreeBranch(ITree left,ITree right,double splitValue,int splitAttr){
        this.left = left;
        this.right = right;
        this.splitValue = splitValue;
        this.splitAttr = splitAttr;
    }

    public ITree getLeft() {
        return left;
    }

    public void setLeft(ITree left) {
        this.left = left;
    }

    public ITree getRight() {
        return right;
    }

    public void setRight(ITree right) {
        this.right = right;
    }

    public double getSplitValue() {
        return splitValue;
    }

    public void setSplitValue(double splitValue) {
        this.splitValue = splitValue;
    }

    public int getSplitAttr() {
        return splitAttr;
    }

    public void setSplitAttr(int splitAttr) {
        this.splitAttr = splitAttr;
    }
}
