/*
 * File Name:leetCode.array.MaxStack is created on 2022/12/235:09 下午 by ydy
 *
 * Copyright (c) 2022, shengdiudiu technology All Rights Reserved.
 *
 */
package leetCode.array;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author ydy
 * @Description:
 * @date: 2022/12/23 5:09 下午
 * @since JDK 1.8
 */
public class MaxStack {

    PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
    Deque<Integer> deque = new ArrayDeque<>();
    Deque<Integer> temp = new ArrayDeque<>();

    public MaxStack() {

    }

    public void push(int x) {
        queue.add(x);
        deque.push(x);
    }

    public int pop() {
        Integer res = deque.pop();
        queue.remove(res);
        return res;
    }

    public int top() {
        return deque.peek();
    }

    public int peekMax() {
        return queue.peek();
    }

    public int popMax() {
        Integer max = queue.poll();
        while (!Objects.equals(max, deque.peek())){
            temp.push(deque.pop());
        }
        deque.pop();
        while(!temp.isEmpty()){
            deque.push(temp.pop());
        }
        return max;
    }

    public static void main(String[] args) {
        double d = 0.055d;
        System.out.println(new BigDecimal(d).toPlainString());
    }
}