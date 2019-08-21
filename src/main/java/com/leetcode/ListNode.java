package com.leetcode;

import lombok.ToString;

/**
 * @Author: Hiccup
 * @Date: 2019/8/21 5:09 PM
 */
@ToString
public class ListNode {
    int value;
    ListNode next;
    ListNode(int value){
        this.value = value;
    }

    ListNode setNext(ListNode listNode){
        this.next = listNode;
        return listNode;
    }
}
