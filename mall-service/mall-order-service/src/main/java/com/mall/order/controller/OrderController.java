package com.mall.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gy
 * @date 2024/5/29
 */
@RestController
public class OrderController {
//    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @PostMapping("test")
    public void test(){
//        logger.info("get in test");
        System.out.println("hello world");
    }
}
