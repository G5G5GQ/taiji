package com.mall.syslog.core;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.SystemClock;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.json.JSONUtil;
import com.mall.syslog.annotation.SysLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Optional;

/**
 * @author
 * @description 日志切面
 */
@Aspect
@Order(Integer.MIN_VALUE - 99)
public class SysLogAspect {


    @Around("@annotation(com.mall.syslog.annotation.SysLog)")
    public Object printSysLog(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Logger log = LoggerFactory.getLogger(methodSignature.getDeclaringType());
        long startTime = System.currentTimeMillis();
        String now = DateUtil.now();
        Object result = null;
        try {
            joinPoint.proceed();
        } finally {
            //获取目标方法
            Method method = joinPoint.getTarget().getClass().getDeclaredMethod(methodSignature.getName(), methodSignature.getParameterTypes());
            SysLog sysLog = Optional.ofNullable(method.getAnnotation(SysLog.class)).orElse(joinPoint.getTarget().getClass().getAnnotation(SysLog.class));
            if (!Objects.isNull(sysLog)) {
                SysLogPrint sysLogPrint = new SysLogPrint();
                sysLogPrint.setStartTime(now);
                if (sysLog.input()) {
                    sysLogPrint.setInputParams(buildInputParams(joinPoint));
                }
                if (sysLog.output()) {
                    sysLogPrint.setOutputParams(result);
                }
                String methodType = "";
                String requestURI = "";
                String clientIp = "";
                try {
                    ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                    HttpServletRequest request = servletRequestAttributes.getRequest();
                    methodType = request.getMethod();
                    requestURI = request.getRequestURI();
                    clientIp = ServletUtil.getClientIP(request, null);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
                log.info("【{}】【{}】【{}】, 执行时间: {}ms, info: {}", clientIp, methodType, requestURI, SystemClock.now() - startTime, JSONUtil.toJsonStr(sysLogPrint));
            }
        }
        return result;
    }

    private Object[] buildInputParams(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Object[] printArgs = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            if ((args[i] instanceof HttpServletRequest) || args[i] instanceof HttpServletResponse) {
                continue;
            }
            if (args[i] instanceof byte[]) {
                printArgs[i] = "byte array";
            } else if (args[i] instanceof MultipartFile) {
                printArgs[i] = "file";
            } else {
                printArgs[i] = args[i];
            }
        }
        return printArgs;
    }

}
