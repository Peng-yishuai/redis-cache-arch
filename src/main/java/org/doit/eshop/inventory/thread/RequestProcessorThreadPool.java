package org.doit.eshop.inventory.thread;

import org.doit.eshop.inventory.request.Request;
import org.doit.eshop.inventory.request.RequestProcessorThread;
import org.doit.eshop.inventory.request.RequestQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author pengyishuai
 * create 2021-03-01 21:32
 */
public class RequestProcessorThreadPool {

    private ExecutorService threadPool = Executors.newFixedThreadPool(10);

    private RequestProcessorThreadPool() {
        RequestQueue requestQueue = RequestQueue.getInstance();

        for (int i = 0; i < 10; i++) {
            ArrayBlockingQueue<Request> queue = new ArrayBlockingQueue<>(100);
            requestQueue.addQueue(queue);
            threadPool.submit(new RequestProcessorThread(queue));
        }
    }

    private static class InstanceHolder {
        private static final RequestProcessorThreadPool INSTANCE = new RequestProcessorThreadPool();
    }

    public static RequestProcessorThreadPool getInstance() {
        return InstanceHolder.INSTANCE;
    }

}
