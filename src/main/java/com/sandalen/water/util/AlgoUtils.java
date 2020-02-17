package com.sandalen.water.util;

import com.sandalen.water.PropertiesClass.IsoForestProperties;
import com.sandalen.water.algo.IsoForest.IForest;
import com.sandalen.water.service.AlgoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class AlgoUtils {
    @Autowired
    private IsoForestProperties isoForestProperties;

    public static AlgoUtils algoUtils;

    @PostConstruct
    public void init(){
        algoUtils = this;
        algoUtils.isoForestProperties = this.isoForestProperties;
    }

    public static IForest getIsoForest() throws IOException {
        String modelStr = IOUtils.getModelStr(algoUtils.isoForestProperties.getModel_path());
        IForest iForest = IOUtils.load_model(modelStr, IForest.class);

        return iForest;
    }

    public static void main(String[] args) throws IOException {
        getIsoForest();
    }
}
