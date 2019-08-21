package com.leetcode;

/**
 * @Author: Hiccup
 * @Date: 2019/8/17 15:44
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class Three {

    public static void main(String[] args) {
        ListNode listNodeOne = new ListNode(2);
        listNodeOne.setNext(new ListNode(4)).setNext(new ListNode(3));

        ListNode listNodeTwo = new ListNode(5);
        listNodeTwo.setNext(new ListNode(6)).setNext(new ListNode(4));

        System.out.println(addTwoNumbers(listNodeOne,  listNodeTwo));
    }

    private static ListNode addTwoNumbers(ListNode listNodeOne, ListNode listNodeTwo){
        ListNode returnListNode = new ListNode(0);
        ListNode listNode = returnListNode;
        int carry = 0;
        while (listNodeOne != null || listNodeTwo != null){
            int x = (listNodeOne != null) ? listNodeOne.value : 0;
            int y = (listNodeTwo != null) ? listNodeTwo.value : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            listNode.next = new ListNode(sum % 10);
            listNode= listNode.next;
            if (listNodeOne != null) {
                listNodeOne = listNodeOne.next;
            }
            if (listNodeTwo != null) {
                listNodeTwo = listNodeTwo.next;
            }
        }
        if (carry > 0){
            listNode.next= new ListNode(carry);
        }
        return returnListNode.next;
    }

}
