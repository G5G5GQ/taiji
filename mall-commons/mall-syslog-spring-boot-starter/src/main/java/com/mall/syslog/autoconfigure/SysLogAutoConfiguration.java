package com.mall.syslog.autoconfigure;
import com.mall.syslog.core.SysLogAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author
 * @description 系统日志自动配置
 */
@Configuration
@ConditionalOnProperty(prefix = "mall.syslog", name = "enabled", havingValue = "true")
@EnableConfigurationProperties(SysLogProperties.class)
public class SysLogAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    SysLogAspect sysLogAspect() {
        return new SysLogAspect();
    }
}
