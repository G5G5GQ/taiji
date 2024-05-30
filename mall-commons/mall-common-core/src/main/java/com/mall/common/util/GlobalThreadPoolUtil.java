package com.mall.common.util;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author
 * @description
 * @date 2024/01/21 11:47
 */
public class GlobalThreadPoolUtil {

    private GlobalThreadPoolUtil() {
    }

    private static class GlobalThreadPoolInstance {
        private static final ThreadPoolExecutor INSTANCE = new ThreadPoolExecutor(
                4, 20, 200, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(300),
                new ThreadPoolExecutor.AbortPolicy());
    }

    public static ThreadPoolExecutor getExecutor() {
        return GlobalThreadPoolInstance.INSTANCE;
    }
}

