package com.leetcode;

/**
 * @Author: Hiccup
 * @Date: 2020/6/24 16:23
 */
public class Symmetric {

    public static void main(String[] args) {
        //[1,2,2,3,4,4,3]
        TreeNode treeNode = new TreeNode(1).setNode(new TreeNode(2).setNode(new TreeNode(3), new TreeNode(4)), new TreeNode(2).setNode(new TreeNode(4), new TreeNode(3)));
        System.out.println(isSymmetric(treeNode));
    }

    private static boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    private static boolean check(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;

        if(left.val != right.val) return false;

        return check(left.left, right.right) && check(left.right, right.left);
    }
}
