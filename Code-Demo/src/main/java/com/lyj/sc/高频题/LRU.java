package com.lyj.sc.高频题;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-09-29 18:22
 **/
public class LRU {
    //map
    Map<Integer,ListNode> map;
    Doublecache cache;
    int cap;
    public LRU(int capcity){
        map=new HashMap<>();
        cache=new Doublecache();
        cap=capcity;
    }

    public int get(int key){
        if(map.containsKey(key)){
            int value = map.get(key).value;
            put(key,value);
            return value;
        }
        return -1;
    }

    public void put(int key,int value){
        ListNode node = new ListNode(key, value);
        if(map.containsKey(key)){
            cache.delete(map.get(key));
            cache.addFirst(node);
            map.put(key,node);
        }else {
            if(map.size()==cap){
                int i = cache.deleteTail();
                map.remove(i);
            }
            cache.addFirst(node);
            map.put(key,node);
        }
    }
}

// 双向链表
class Doublecache{

    ListNode head;
    ListNode tail;
    public Doublecache(){
        head=new ListNode(0,0);
        tail=new ListNode(0,0);
        head.next=tail;
        tail.prev=head;
    }

    public void addFirst(ListNode node){
        head.next.prev=node;
        node.next=head.next;
        head.next=node;
        node.prev=head;
    }

    public int delete(ListNode node){
        int key = node.key;
        node.prev.next=node.next;
        node.next.next=node.prev;
        return key;
    }

    public int deleteTail(){
        if(head.next==tail){
            return -1;
        }
        return delete(tail.prev);
    }
}

// 单向链表
class ListNode{
    int key;
    int value;
    ListNode prev;
    ListNode next;
    public ListNode(int key,int value){
        this.key=key;
        this.value=value;
    }
}