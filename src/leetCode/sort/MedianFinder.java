package leetCode.sort;

import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;

    /** initialize your data structure here. */
    public MedianFinder() {
        queMax = new PriorityQueue<>((a,b)->a-b);
        queMin = new PriorityQueue<>((a,b)->b-a);
    }

    public void addNum(int num) {
        if (queMin.size() == 0|| num < queMin.peek()){
            queMin.offer(num);
            if (queMin.size()>1+queMax.size()){
                queMax.offer(queMin.poll());
            }
        } else {
            queMax.offer(num);
            if (queMin.size()<queMax.size()){
                queMin.offer(queMax.poll());
            }
        }
    }

    public double findMedian() {
        if (queMin.size() != queMax.size()){
            return queMin.peek();
        }
        return (queMax.peek()+queMin.peek())/2;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}
