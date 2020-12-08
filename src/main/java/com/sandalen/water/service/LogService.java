package com.sandalen.water.service;

import com.sandalen.water.bean.SystemLog;
import com.sandalen.water.bean.SystemLogExample;
import com.sandalen.water.dao.SystemLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    @Autowired
    private SystemLogMapper systemLogMapper;

    public void insertLog(SystemLog systemLog){
        systemLogMapper.insert(systemLog);
    }

    public List<SystemLog> getLog(String userid){
        SystemLogExample systemLogExample = new SystemLogExample();
        systemLogExample.createCriteria().andUserIdEqualTo(userid);

        List<SystemLog> systemLogs = systemLogMapper.selectByExample(systemLogExample);

        return systemLogs;
    }
}
