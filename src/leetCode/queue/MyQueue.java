package leetCode.queue;

import java.util.Deque;
import java.util.LinkedList;

public class MyQueue {

    private Deque<Integer> inputQueue;
    private Deque<Integer> outputQueue;

    /** Initialize your data structure here. */
    public MyQueue() {
        inputQueue = new LinkedList<>();
        outputQueue = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inputQueue.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (outputQueue.isEmpty()){
            while (!inputQueue.isEmpty()){
                outputQueue.push(inputQueue.pop());
            }
        }
        return outputQueue.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (outputQueue.isEmpty()){
            while (!inputQueue.isEmpty()){
                outputQueue.push(inputQueue.pop());
            }
        }
        return outputQueue.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return outputQueue.isEmpty() && inputQueue.isEmpty();
    }
}
