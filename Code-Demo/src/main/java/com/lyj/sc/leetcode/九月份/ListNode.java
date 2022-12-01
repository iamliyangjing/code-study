package com.lyj.sc.leetcode.九月份;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-09-23 10:23
 **/
class MyLinkedList {
    public ListNode node;
    public int size;
    public MyLinkedList() {
        this.size=0;
        this.node = new ListNode(null,0);
    }

    public int get(int index) {
        if(index<0 || index>=size){
            return -1;
        }
        ListNode t = node;
        for (int i = 0; i < index; i++) {
            t=t.next;
        }
        return t.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        if(index<0 || index>size){
            return;
        }
        size++;
        ListNode listNode = new ListNode(null,val);
        ListNode head=node;
        for (int i = 0; i < index; i++) {
            head=head.next;
        }
        listNode.next=head.next;
        head.next=listNode;
    }

    public void deleteAtIndex(int index) {
        if(index<0 || index>size){
            return;
        }
        size--;
        ListNode head=node;
        for (int i = 0; i < index; i++) {
            head=head.next;
        }
        head.next=head.next.next;
    }
}

public class ListNode{
    public ListNode next;
    public int val;
    public ListNode(ListNode next,int val){
        this.next=next;
        this.val=val;
    }
}