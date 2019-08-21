package com.leetcode;

/**
 * @Author: Hiccup
 * @Date: 2019/8/21 5:07 PM
 * 合并有序列表
 */
public class Nine {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.setNext(new ListNode(2)).setNext(new ListNode(4));

        ListNode l2 = new ListNode(2);
        l2.setNext(new ListNode(3)).setNext(new ListNode(4));

        System.out.println(mergeTwoLists(l1, l2));
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode mergeList = new ListNode(0);
        ListNode returnList = mergeList;
        while (l1 != null && l2 != null){
            if (l1.value < l2.value){
                mergeList.next = new ListNode(l1.value);
                mergeList = mergeList.next;
                l1 = l1.next;
            } else {
                mergeList.next = new ListNode(l2.value);
                mergeList = mergeList.next;
                l2 = l2.next;
            }
        }
        if (l1 == null){
            mergeList.next = l2;
        }
        if (l2 == null){
            mergeList.next = l1;
        }
        return returnList.next;
    }

}
