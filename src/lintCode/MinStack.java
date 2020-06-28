package lintCode;
import java.util.Stack;

public class MinStack {

    Stack<Integer> queue;
    Stack<Integer> minQueue;

    public MinStack() {
        // do intialization if necessary
        queue = new Stack<>();
        minQueue = new Stack<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        int min = Integer.MAX_VALUE;
        Integer peek = minQueue.empty() ? null : minQueue.lastElement();
        if (null != peek && peek<min){
            min = peek;
        }
        min = number < min ? number : min;
        minQueue.push(min);
        queue.push(number);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        minQueue.pop();
        return queue.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return minQueue.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.pop();
        minStack.push(2);
        minStack.push(3);
        minStack.push(1);
    }
}
