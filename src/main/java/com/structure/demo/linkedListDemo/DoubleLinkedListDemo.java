package com.structure.demo.linkedListDemo;

/**
 *
 * 双向链表演示
 * @author zhangfeng
 * @date 2019/8/9 2:27 PM
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode2 heroNode1 = new HeroNode2(1,"宋江", "及时雨");
        HeroNode2 heroNode2 = new HeroNode2(2,"卢俊义", "玉麒麟");
        HeroNode2 heroNode3 = new HeroNode2(3,"吴用", "智多星");
        HeroNode2 heroNode4 = new HeroNode2(4,"林冲", "豹子头");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);

        System.out.println("原始链表");
        doubleLinkedList.list();

        // 删除链表
        doubleLinkedList.remove(2);
        System.out.println("打印删除之后的链表");
        doubleLinkedList.list();
    }
}

/**
 * 双向链表
 */
class DoubleLinkedList {

    private HeroNode2 head = new HeroNode2(0,"","");

    public HeroNode2 getHead() {
        return head;
    }

    /**
     * 添加数据到链表尾巴
     * @param heroNode2
     */
    public void add(HeroNode2 heroNode2) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.getNext() == null) {
                // 将新增的数据添加到尾节点
                // 形成双向链表
                temp.setNext(heroNode2);
                heroNode2.setPre(temp);
                break;
            }
            temp = temp.getNext();
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
        HeroNode2 temp = head.getNext();
        boolean flag = false;
        while (true) {
            if (temp == null) {
                // 到达尾节点，退出
                break;
            }
            if (temp.getNo() == no) {
                // 找到指定节点
                flag = true;
                break;
            }
            // 当前节点后移
            temp = temp.getNext();
        }
        if (flag) {
            // 当前节点的上一个节点的next = 要删除的节点的next
            temp.getPre().setNext(temp.getNext());
            // 当前节点的下个节点的pre = 要删除节点的饿 pre
            if (temp.getNext() != null) {
                temp.getNext().setPre(temp.getPre());
            }
        } else {
            System.out.println("移除节点失败");
        }
    }

    /**
     * 更新指定节点
     * @param updateHeroNode
     */
    public void update(HeroNode2 updateHeroNode) {
        if (head.getNext() == null) {
            System.out.println("当前列表为空");
            return;
        }
        // 定义临时节点为头节点的下一个节点
        HeroNode2 temp = head.getNext();
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
     * 遍历所有的节点并打印
     */
    public void list() {
        // 判断链表是否为空
        HeroNode2 temp = head.getNext();
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


class HeroNode2 {
    private int no;
    private String name;
    private String nickName;
    private HeroNode2 next;
    private HeroNode2 pre;

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

    public HeroNode2 getNext() {
        return next;
    }

    public void setNext(HeroNode2 next) {
        this.next = next;
    }

    public HeroNode2 getPre() {
        return pre;
    }

    public void setPre(HeroNode2 pre) {
        this.pre = pre;
    }

    public HeroNode2(int no, String name, String nickName) {
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