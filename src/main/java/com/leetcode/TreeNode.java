package com.leetcode;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    TreeNode setNode(TreeNode left, TreeNode right){
        this.left = left;
        this.right = right;
        return this;
    }
}