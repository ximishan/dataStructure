package com.structure.demo.queueDemo;

/**
 * @author zhangfeng
 * @date 2019/8/7 1:15 PM
 */
public class ArrayQueueDemoTest {

}

class ArrayQueueDemo {

    // 队列的最大容量
    private int maxSize;
    private int head;
    private int tail;
    private int[] arr;

    public ArrayQueueDemo(int arrMaxSize) {
        // 最大容量+1 添加一个约定，为尾节点的指向
        this.maxSize = arrMaxSize+1;
        this.arr = new int[this.maxSize];
        // 头节点的位置就是队列的第一个下标位置
        this.head = 0;
        this.tail = 0;
    }

    /**
     * 判断队列是否满了
     * @return
     */
    public boolean isFull() {
        return (tail+1) % maxSize == head;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return tail == head;
    }

    /**
     * 向队列中添加数据
     * @param n
     * @return
     */
    public boolean addQueue(int n) {
        if (isFull()) {
            throw new RuntimeException("队列已经满了，请稍后重试");
        }
        // 数据添加到队列末尾,然后 tail+1
        arr[tail] = n;
        tail = (tail+1) % maxSize;
        return true;
    }

    /**
     * 获取队列的长度
     * @return
     */
    public int size() {
        return (tail - head + maxSize) % maxSize;
    }

    /**
     * 获取第一个元素
     * @return
     */
    public int get () {
        if (isEmpty()) {
            throw new RuntimeException("队列已经空了，请先添加");
        }
        int value = arr[head];
        // head 后移
        head = (head + 1) % maxSize;
        return value;
    }

}
