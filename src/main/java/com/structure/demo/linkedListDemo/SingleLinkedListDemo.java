package com.structure.demo.linkedListDemo;

import java.util.Stack;

/**
 * @author zhangfeng
 * @date 2019/8/8 10:29 AM
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1,"宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2,"卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3,"吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4,"林冲", "豹子头");
        LinkedListStucture linkedListStucture = new LinkedListStucture();

        // 添加节点
//        linkedListStucture.addHeroNode(heroNode1);
//        linkedListStucture.addHeroNode(heroNode2);
//        linkedListStucture.addHeroNode(heroNode3);

        // 按照顺序添加节点
        linkedListStucture.addHeroNodeByOrder(heroNode1);
        linkedListStucture.addHeroNodeByOrder(heroNode3);
//        linkedListStucture.addHeroNodeByOrder(heroNode2);
        linkedListStucture.addHeroNodeByOrder(heroNode4);
        System.out.println("原链表");
        linkedListStucture.list();

//        HeroNode updateHero = new HeroNode(3,"小吴", "----");
//        linkedListStucture.update(updateHero);


//        linkedListStucture.remove(1);
//        linkedListStucture.remove(4);
//        linkedListStucture.remove(3);
//        linkedListStucture.remove(2);

        System.out.println("更新之后的链表");
        linkedListStucture.list();

        // 测试，查询链表的长度
        System.out.println("链表的长度="+size(linkedListStucture.getHead()));

        // 测试，查询倒数第k个节点
        System.out.println("查询倒数第k个节点====1:"+getLastNode(linkedListStucture.getHead(), 1));

        // 移除最后一个节点的数据
//        removeLastNode(linkedListStucture.getHead());
//        linkedListStucture.list();


//        System.out.println("反转单链表");
//        reverseSingleLinkedList(linkedListStucture.getHead());
//        linkedListStucture.list();


        System.out.println("逆序打印单链表");

        reverseSingleLinkedListByStack(linkedListStucture.getHead());
    }

    /**
     * 使用 stack 逆序打印单链表
     * 没有更改原来的单链表的结构
     * @param head
     */
    public static void reverseSingleLinkedListByStack (HeroNode head) {
        if (head == null || head.getNext() == null) {
            System.out.println("单链表为空，请先添加");
            return;
        }

        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.getNext();
        while (cur != null) {
            stack.push(cur);
            cur = cur.getNext();
        }

        while (stack.size() >0) {
            System.out.println(stack.pop());
        }
    }



    /**
     * 反转单链表
     *
     * head 指向尾节点
     * 遍历指定链表，获取位节点之后，将位结点添加到新建的链表中，然后将head 指向新链表
     * 遍历之前的链表，将原链表的每个数据添加到新链表的第一个位置中
     * @param head
     */
    public static void reverseSingleLinkedList (HeroNode head) {
        if (head == null || head.getNext() == null) {
            throw new RuntimeException("传入的链表为空");
        }
        //
        HeroNode newHead = new HeroNode(0,"","");
        HeroNode cur = head.getNext();// 当前节点
        HeroNode next = null;// 当前节点的下一个节点，临时保存
        while (cur != null) {
            // 保存当前节点的下一个节点
            next = cur.getNext();
            // 将当前节点的下一个节点指向新节点的地址
            cur.setNext(newHead.getNext());
            // 将新节点的地址指向当前节点
            newHead.setNext(cur);
            // 遍历
            cur = next;
        }

        // 将传入的链表头指向新建的临时的链表
        head.setNext(newHead.getNext());
    }

    // 删除单链表的最后节点
    public static HeroNode removeLastNode (HeroNode head) {
        if (head.getNext() == null) {
            System.out.println("当前列表为空");
            return null;
        }
        // 定义临时节点为头节点的下一个节点
        HeroNode temp = head;
        HeroNode cur = null;
        while (true) {
            if (temp.getNext() == null) {
                cur.setNext(null);
                // 到达尾节点，退出
                break;
            }
            // 记录当前节点
            cur = temp;
            // 当前节点后移
            temp = temp.getNext();
        }
        return cur;
    }


    /**
     *  新浪面试题
     *  获取单链表的倒数第k个节点
     * @param head 头节点
     * @param index 倒数的第k个节点
     * @return
     */
    public static HeroNode getLastNode(HeroNode head, int index) {
        // 头节点为空或者头节点的下个节点为空，返回null
        if (head == null || head.getNext() == null) {
            return null;
        }
        // 首先遍历，拿到整个链表的长度
        int length = size(head);
        if (index <=0 || index >length) {
            throw new RuntimeException("下标有问题");
        }

        // 遍历所有的节点，倒数第 index 个，正数 size -index,  比如总共5个节点，倒数第三个就是正数第三个，倒数第一个，就是正数第5个
        HeroNode cur = head.getNext();;
        for(int i=0; i< length-index; i++) {
            cur = cur.getNext();
        }
        return cur;
    }


    /**
     * 根据头节点获取单链表的长度
     * @param head
     * @return
     */
    public static int size(HeroNode head) {
        int length = 0;
        if (head == null || head.getNext() == null) {
            return length;
        }
        HeroNode cur = head.getNext();

        // 一，获取所有的数据
//        while (true) {
//            if (cur != null) {
//                length++;
//            } else {
//                break;
//            }
//            cur = cur.getNext();
//        }
        // 二，获取所有的数据
        while (cur != null) {
            length++;
            cur = cur.getNext();
        }
        return length;
    }

}

class LinkedListStucture {

    // 这里是头节点，头节点没有数据，只是指向第一个节点的位置
    private HeroNode head = new HeroNode(0,"","");

    // 获取头节点
    public HeroNode getHead() {
        return head;
    }

    /**
     * 添加节点
     *
     * 在尾节点添加数据，
     * 如果链表中没有数据，则将head的next指向新增的节点，
     * 否则遍历链表，找到最后的节点，将数据添加到尾节点之后
     * @param heroNode
     * @return
     */
    public boolean addHeroNode(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.getNext() == null) {
                // 将新增的数据添加到尾节点
                temp.setNext(heroNode);
                break;
            }
            temp = temp.getNext();
        }
        return true;
    }

    /**
     * 按照指定的顺序添加节点
     *
     * 首先要查找链表的插入位置,
     * 将前一个节点的next指向新添加的节点，
     * 将新添加的节点的后一个位置指向前一个地址指向的后一个节点的位置
     * @param newHeroNode
     * @return
     */
    public boolean addHeroNodeByOrder (HeroNode newHeroNode) {
        HeroNode temp = head;
        // 首先判断指定的 no 是否存在，如果存在，则添加失败，如果不存在，则插入
        boolean flag = false;
        while (true) {
            if (temp.getNext() == null) {
                // 到尾节点, 跳出本次循环
                break;
            }
            if (temp.getNext().getNo() == newHeroNode.getNo()) {
                // 指定位置的节点存在数据，添加失败
                flag = true;
                break;
            }
            if (newHeroNode.getNo() < temp.getNext().getNo()) {
                // 并且下个节点的位置大于当前节点的编号
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            System.out.printf("准备插入的编号 %d 已经存在\n", newHeroNode.getNo());
            return false;
        } else {
            // 即将添加数据
            newHeroNode.setNext(temp.getNext());
            temp.setNext(newHeroNode);
        }
        return true;
    }

    /**
     * 更新指定节点
     * @param updateHeroNode
     */
    public void update(HeroNode updateHeroNode) {
        if (head.getNext() == null) {
            System.out.println("当前列表为空");
            return;
        }
        // 定义临时节点为头节点的下一个节点
        HeroNode temp = head.getNext();
        boolean flag = false;
        while (true) {
            if (temp == null) {
                // 到达尾节点，退出
                break;
            }
            if (temp.getNo() == updateHeroNode.getNo()) {
                // 找到指定节点
                flag = true;
                break;
            }
            // 当前节点后移
            temp = temp.getNext();
        }
        if (flag) {
            temp.setNickName(updateHeroNode.getNickName());
            temp.setName(updateHeroNode.getName());
        } else {
            System.out.println("更新节点失败");
        }

    }

    /**
     * 移除指定no的节点
     *
     * 找到待删除节点的上一个节点
     *
     * @param no
     */
    public void remove (int no) {
        if (head.getNext() == null) {
            System.out.println("当前列表为空");
            return;
        }
        // 定义临时节点为头节点的下一个节点
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.getNext() == null) {
                // 到达尾节点，退出
                break;
            }
            if (temp.getNext().getNo() == no) {
                // 找到指定节点
                flag = true;
                break;
            }
            // 当前节点后移
            temp = temp.getNext();
        }
        if (flag) {
            temp.setNext(temp.getNext().getNext());
        } else {
            System.out.println("移除节点失败");
        }
    }

    /**
     * 遍历所有的节点并打印
     */
    public void list() {
        // 判断链表是否为空
        HeroNode temp = head.getNext();
        if (temp == null) {
            System.out.println("链表为空，请先添加数据");
            return;
        }

        while (true) {
            if (temp == null) {
                // 当前数据的下一个不存在，说明当前数据是尾节点
                break;
            }
            System.out.println("heroNode="+temp.toString());
            temp = temp.getNext();
        }
    }
}

class HeroNode {

    private int no;
    private String name;
    private String nickName;
    private HeroNode next;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
