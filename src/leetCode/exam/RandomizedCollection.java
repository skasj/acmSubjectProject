package leetCode.exam;

import org.junit.Assert;

import java.util.*;

public class RandomizedCollection {

    private Random random = new Random();
    // 存储内容，结构类似于RocketMQ；
    private List<Integer> list = new ArrayList<>();
    // 索引结构
    private HashMap<Integer,Set<Integer>> map = new HashMap<>();
    /** Initialize your data structure here. */
    public RandomizedCollection() {
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        Set<Integer> set = map.get(val);
        if (null== set){
            set = new HashSet<>();
            set.add(list.size()-1);
            map.put(val,set);
            return true;
        } else {
            set.add(list.size()-1);
            map.put(val,set);
            return false;
        }
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        Set<Integer> set = map.get(val);
        if (null== set || set.isEmpty()){
            return false;
        } else {
            Integer valIndex = set.iterator().next();
            Integer target = list.get(list.size()-1);
            if (target.equals(val)){
                set.remove(list.size()-1);
                list.remove(list.size()-1);
            } else {
                // 最后一位与当前位不同，就需要交换
                Set<Integer> targetSet = map.get(target);
                targetSet.remove(list.size()-1);
                targetSet.add(valIndex);
                set.remove(valIndex);
                list.set(valIndex, target);
                list.remove(list.size()-1);
            }
            return true;
        }
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedCollection collection = new RandomizedCollection();
        collection.insert(4);
        collection.insert(3);
        collection.insert(4);
        collection.insert(2);
        collection.insert(4);
        collection.remove(4);
        collection.remove(3);
        collection.remove(4);
        Assert.assertTrue(collection.remove(4));
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1(){
        RandomizedCollection collection = new RandomizedCollection();
        collection.insert(1);
        collection.insert(1);
        collection.insert(2);
        int random = collection.getRandom();
//        Assert.assertEquals(1,random);
        collection.remove(random);
//        Assert.assertEquals(1,collection.getRandom());
    }

    private static void test2(){
        RandomizedCollection collection = new RandomizedCollection();
        collection.insert(0);
        collection.insert(1);
        collection.remove(0);
        collection.insert(2);
        collection.remove(1);
        int random = collection.getRandom();
        Assert.assertEquals(2,random);
    }

    private static void test3(){
        System.out.println("test3==========");
        RandomizedCollection collection = new RandomizedCollection();
        collection.insert(0);
        collection.remove(0);
        collection.insert(-1);
        collection.remove(0);
        int random = collection.getRandom();
        Assert.assertEquals(-1,random);
    }

    private static void test4(){
        System.out.println("test4==========");
        RandomizedCollection collection = new RandomizedCollection();
        collection.insert(1);
        collection.insert(1);
        collection.insert(2);
        collection.insert(1);
        collection.insert(2);
        collection.insert(2);
        collection.remove(1);
        collection.remove(2);
        collection.remove(2);
        collection.remove(2);
        Assert.assertEquals(1,collection.getRandom());
        Assert.assertEquals(1,collection.getRandom());
        Assert.assertEquals(1,collection.getRandom());
        Assert.assertEquals(1,collection.getRandom());
        Assert.assertEquals(1,collection.getRandom());
        Assert.assertEquals(1,collection.getRandom());
        Assert.assertEquals(1,collection.getRandom());
    }
}
