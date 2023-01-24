/*
 * File Name:leetCode.ListNode is created on 2022/12/105:11 下午 by mac
 *
 * Copyright (c) 2022, shengdiudiu technology All Rights Reserved.
 *
 */
package leetCode;

/**
 * @author ydy
 * @Description:
 * @date: 2022/12/10 5:11 下午
 * @since JDK 1.8
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}