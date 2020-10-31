package com.sandalen.water.util;

import java.util.Collections;
import java.util.List;

public class CheckCollectionUtils {
    public static boolean isEmpty(List list){
        if (list.size() != 0 && list != null){
            return true;
        }
        return false;
    }

    public static boolean andEmpty(Object object){
        if (object != "" && object != null){
            return true;
        }
        return false;
    }

    public static boolean orEmpty(Object object){
        if (object != "" || object != null){
            return true;
        }
        return false;
    }


}
