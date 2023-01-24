/*
 * File Name:PACKAGE_NAME.TreeNode is created on 2023/1/161:56 下午 by ydy
 *
 * Copyright (c) 2023, shengdiudiu technology All Rights Reserved.
 *
 */

/**
 * @author ydy
 * @Description:
 * @date: 2023/1/16 1:56 下午
 * @since JDK 1.8
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
