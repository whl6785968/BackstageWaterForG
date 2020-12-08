package com.sandalen.water.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sandalen.water.bean.SystemLog;
import com.sandalen.water.customAnnotation.SystemControllerLog;
import com.sandalen.water.dao.SystemLogMapper;
import com.sandalen.water.service.LogService;
import com.sandalen.water.util.IpUtils;
import com.sandalen.water.util.JwtUtils;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

@Aspect
@Component
public class SystemLogAspect {

    @Autowired
    private LogService logService;

    @Pointcut("@annotation(com.sandalen.water.customAnnotation.SystemControllerLog)")
    public void controllerAspect(){

    }

    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("X-Token");

        DecodedJWT decode = JWT.decode(token);
        List<String> audience = decode.getAudience();
        String userId = audience.get(0);

        //获取ip地址 host:
//        String remoteAddr = request.getRemoteHost();
        String ip = IpUtils.getIP(request).equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : IpUtils.getIP(request);


        //获取浏览器哦
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        Browser browser = userAgent.getBrowser();

        //获取地区
//        String jsonContent = IpUtils.getJsonContent("http://whois.pconline.com.cn/ip.jsp?ip="+ip);
//        jsonContent = new String(jsonContent.getBytes("ISO-8859-1"),"utf-8");

        String jsonContent = IpUtils.sendPost("http://whois.pconline.com.cn/ip.jsp?ip=", ip);
        //请求方法
        String itr = joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName();
        //方法描述
        String descr = getControllerMethodDescription(joinPoint);

        SystemLog systemLog = new SystemLog();
        systemLog.setIp(ip);
        systemLog.setIpOrigin(jsonContent);
        systemLog.setItr(itr);
        systemLog.setBehavior(descr);
        systemLog.setUserId(userId);
        systemLog.setBrowser(browser.getName());
        systemLog.setCreateTime(new Date());

        logService.insertLog(systemLog);

    }

    public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();//目标方法名
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method:methods) {
            if (method.getName().equals(methodName)){
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length==arguments.length){
                    description = method.getAnnotation(SystemControllerLog.class).description();
                    break;
                }
            }
        }
        return description;
    }

}
