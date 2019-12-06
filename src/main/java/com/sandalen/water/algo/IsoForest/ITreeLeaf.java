package com.sandalen.water.algo.IsoForest;

import java.io.Serializable;

public class ITreeLeaf extends ITree implements Serializable {
    int size;

    public ITreeLeaf(int size){
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}