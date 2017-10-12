package com.dreamnight.test;

/**
 * Created by tianbenzhen on 2017/10/10.
 */
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode reverseHead = reverse(head);
        System.out.println(reverseHead);
    }

    public static ListNode reverse(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = null;
        while(head != null){
            ListNode tempNode = head.next;
            if(tempNode != null && tempNode.next != null){
                ListNode nextHead = tempNode.next;
                if(newHead == null){
                    head.next = null;
                    tempNode.next = head;
                    newHead = tempNode;
                    head = nextHead;
                } else {
                    head.next = newHead;
                    newHead = head;
                    head = tempNode;
                }
            }

            if (tempNode != null && tempNode.next == null) {
                head.next = newHead;
                tempNode.next = head;
                newHead = tempNode;
                head = null;
            }
        }
        return newHead;
    }

}
