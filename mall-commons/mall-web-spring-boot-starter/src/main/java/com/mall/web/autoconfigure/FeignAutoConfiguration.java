
package com.mall.web.autoconfigure;

import com.mall.web.http.RequestUtil;
import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.DispatcherServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Objects;


/**
 * Feign相关配置类
 */
@Configuration
@Slf4j
public class FeignAutoConfiguration {
    /**
     * 让DispatcherServlet向子线程传递RequestContext
     * @param servlet servlet
     * @return 注册bean
     */
    @Bean
    @Primary
    public ServletRegistrationBean<DispatcherServlet> dispatcherRegistration(DispatcherServlet servlet) {
        servlet.setThreadContextInheritable(true);
        return new ServletRegistrationBean<>(servlet, "/**");
    }

    /**
     * 覆写拦截器，在feign发送请求前取出原来的header并转发
     * @return 拦截器
     */
    @Bean
    @Primary
    public RequestInterceptor requestInterceptor() {
        return (template) -> {
            HttpServletRequest httpServletRequest = RequestUtil.getRequest();
            if (!Objects.isNull(httpServletRequest)) {
                //获取请求头
                Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
                if (headerNames != null) {
                    while (headerNames.hasMoreElements()) {
                        String name = headerNames.nextElement();
                        String value = httpServletRequest.getHeader(name);
                        //将请求头保存到模板中
                        template.header(name, value);
                    }
                }
            }
        };
    }
}

