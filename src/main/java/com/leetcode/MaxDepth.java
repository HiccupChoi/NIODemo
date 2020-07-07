package com.leetcode;

/**
 * @Author: Hiccup
 * @Date: 2020/6/24 16:47
 */
public class MaxDepth {



    private int maxDepthCalc(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepthCalc(root.left);
            int right_height = maxDepthCalc(root.right);
            return java.lang.Math.max(left_height, right_height) + 1;
        }
    }

}
