package com.structure.demo.linkedListDemo;

/**
 * @author zhangfeng
 * @date 2019/8/9 3:07 PM
 */
public class CircleSingleLinkedDemo {

    public static void main(String[] args) {
        // 生成单项环形链表
        CircleSingleLinked circleSingleLinked = new CircleSingleLinked();
        circleSingleLinked.generator(25);
        // 打印单项环形链表
        circleSingleLinked.list();
    }
}

// 单项环形链表
class CircleSingleLinked {

    private Boy first = null;

    public void generator(int nums) {
        //
        if (nums < 2) {
            System.out.println("传入的数值太小了～");
            return;
        }
        Boy cur = null;
        for (int i=1; i<=nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                cur = first;
            } else {
                cur.setNext(boy);
                boy.setNext(first);
                cur = boy;
            }
        }
    }

    public void list () {
        if (first == null) {
            System.out.println("当前环形链表为空，请先添加数据");
            return;
        }
        Boy cur = first;
        while (true) {
            System.out.printf("小孩的编号:%d\n",cur.getNo());
            if (cur.getNext() == first) {
                break;
            }
            cur = cur.getNext();
        }
    }

}


class Boy {

    private int no;
    private Boy next;

    public Boy (int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}