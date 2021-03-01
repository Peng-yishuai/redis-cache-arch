package org.doit.eshop.inventory.listener;

import org.doit.eshop.inventory.thread.RequestProcessorThreadPool;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author pengyishuai
 * create 2021-03-01 21:12
 */
public class InitListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        RequestProcessorThreadPool threadPool = RequestProcessorThreadPool.getInstance();
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("=========================环境关闭==========================");
    }
}
