package com.lyj.sc.代码随想录.链表;

/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2022-12-01 13:54
 **/
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode cur=dummy;
        while (cur.next!=null){
            if (cur.next.val == val){
                cur.next=cur.next.next;
            }else {
                cur=cur.next;
            }
        }
        return head.next;
    }


    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode prev = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }

    /**
     * 两两交换链表
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode cur = dummy;
        while (cur.next!=null && cur.next.next!=null){
            ListNode temp1 = cur.next;
            ListNode temp2 = cur.next.next;
            cur.next=temp2;
            temp1.next=temp2.next;
            temp2.next=temp1;
            cur=temp1;
        }
        return dummy;
    }

    public ListNode swapPairs1(ListNode head) {
        // base case 退出提交
        if(head == null || head.next == null) return head;
        // 获取当前节点的下一个节点
        ListNode next = head.next;
        // 进行递归
        ListNode newNode = swapPairs(next.next);
        // 这里进行交换
        next.next = head;
        head.next = newNode;

        return next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode fastNode = dummy;
        ListNode slowNode= dummy;
        for (int i = 0; i < n; i++) {
            fastNode=fastNode.next;
        }
        while (fastNode.next!=null){
            fastNode=fastNode.next;
            slowNode=slowNode.next;
        }
        return dummy.next;
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         int lenA =0;
         int lenB =0;
         ListNode tempA=headA,tempB=headB;
         while (tempA!=null){
             lenA++;
             tempA=tempA.next;
         }
         while (tempB!=null){
             lenB++;
             tempB=tempB.next;
         }
         ListNode t = null;
         if (lenA<lenB){
             int tem = lenA;
             lenA=lenB;
             lenB=tem;
             t=headA;
             headA=headB;
             headB=t;
         }
         int n = lenA-lenB;
        for (int i = 0; i < n; i++) {
            headA=headA.next;
        }
        while (headA!=null){
            if (headA==headB){
                return headA;
            }
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }

    //双指针
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast==null){
            return null;
        }
        fast=head;
        while (fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
