package com.structure.demo.queueDemo;

import com.sun.jmx.remote.internal.ArrayQueue;

/**
 * @author zhangfeng
 * @date 2019/8/7 1:15 PM
 */
public class ArrayQueueDemo {

    // 队列的最大容量
    private int maxSize;
    private int front;
    private int tail;
    private int[] arr;

    public ArrayQueueDemo(int maxSize) {
        this.maxSize = maxSize;
        this.front = -1;// 头节点的上一个位置
        this.tail = -1;// 尾节点的下标
        this.arr = new int[maxSize];
    }


}

