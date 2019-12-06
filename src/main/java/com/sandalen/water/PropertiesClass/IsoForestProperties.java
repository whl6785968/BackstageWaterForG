package com.sandalen.water.PropertiesClass;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:IsoForest.properties")
@Component
@ConfigurationProperties(prefix = "isoforest")
public class IsoForestProperties {
    private String model_path;
    private String train_data;
    private int numTrees;
    private double score;

    public String getModel_path() {
        return model_path;
    }

    public void setModel_path(String model_path) {
        this.model_path = model_path;
    }

    public String getTrain_data() {
        return train_data;
    }

    public void setTrain_data(String train_data) {
        this.train_data = train_data;
    }

    public int getNumTrees() {
        return numTrees;
    }

    public void setNumTrees(int numTrees) {
        this.numTrees = numTrees;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
