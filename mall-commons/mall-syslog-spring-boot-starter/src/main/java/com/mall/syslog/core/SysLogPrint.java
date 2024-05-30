package com.mall.syslog.core;
import lombok.Data;

/**
 * @author
 * @description 系统日志记录类
 * @date 2023/05/25 11:33
 */
@Data
public class SysLogPrint {

    private String startTime;

    private Object[] inputParams;

    private Object outputParams;

}
