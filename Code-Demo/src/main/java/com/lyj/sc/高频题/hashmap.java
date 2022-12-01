package com.lyj.sc.高频题;

/**
 * @program: code-random
 * @description:
 * @author: lyj
 * @create: 2022-09-09 16:56
 **/
public class hashmap {
    // 1.链表
    static class Node{
        int key,val;
        Node next;

        public Node(int key,int value){
            this.key=key;
            this.val=value;
        }
    }
    // 2. 数组
    private final static int CAPACITY = 10000;
    Node[] nodes = new Node[CAPACITY];
    // 3. hashcode
    public static int hashCode(int value){
        return value;
    }

    //获取key的index
    public int getIndex(int key){
        int hash = hashCode(key);
        //高16位
        hash^=(hash>>>16);
        //取模运算得到索引下标
        return hash%CAPACITY;
    }

    public int get(int key){
        int index = getIndex(key);
        Node now = nodes[index];

        //如果结点不为空的话
        if(now!=null){
            if(now.key==key){
                return now.val;
            }else {
                //如果now 的key 不等于key
                while (now!=null){
                    if(now.key==key){
                        return now.val;
                    }
                    now=now.next;
                }
            }
        }
        return -1;
    }
    //put
    public void put(int key,int val){
        int index = getIndex(key);
        Node now = nodes[index];
        //判断是否为空
        if(now!=null){
            Node prev = null;
            while (now!=null){
                if(now.key==key){
                    now.val=val;
                    return;
                }
                prev=now;
                now=now.next;
            }
            now=prev;
        }
        Node node = new Node(key,val);
        if(now!=null){
            now.next=node;
        }else {
            nodes[index]=node;
        }
    }
    //remove
    public  void remove(int key){
        int index = getIndex(key);
        Node now = nodes[index];
        //判断是否为kong
        if (now!=null){
            Node prev = null;
            //遍历
            while (now!=null){
                if(now.key==key) {
                    if(prev!=null){
                        //如果不是头部
                        prev.next=now.next;
                    }else {
                        //头部
                        nodes[index]=now.next;
                    }
                    now.next=null;
                    return;
                }
                //循环
                prev=now;
                now=now.next;
            }
        }
    }

    public static void main(String[] args) {
        hashmap hashmap = new hashmap();
        hashmap.put(1,1);
        hashmap.put(1,1);
        hashmap.put(2,1);
        System.out.println(hashmap.get(1));
        System.out.println(hashmap.get(2));
    }
}
