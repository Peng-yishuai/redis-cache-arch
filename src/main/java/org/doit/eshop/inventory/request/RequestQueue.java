package org.doit.eshop.inventory.request;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author pengyishuai
 * create 2021-03-01 22:03
 */
public class RequestQueue {

    private List<ArrayBlockingQueue<Request>> queues = new ArrayList<>(10);

    private RequestQueue() {
    }

    public void addQueue(ArrayBlockingQueue<Request> queue) {
        queues.add(queue);
    }

    private static class InstanceHolder {
        private static final RequestQueue INSTANCE = new RequestQueue();
    }

    public static RequestQueue getInstance() {
        return RequestQueue.InstanceHolder.INSTANCE;
    }

}
