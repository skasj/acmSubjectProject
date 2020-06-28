package lintCode;

import java.util.ArrayList;
import java.util.List;

public class FlattenTest {

    public interface NestedInteger {
 
              // @return true if this NestedInteger holds a single integer,
              // rather than a nested list.
              public boolean isInteger();
 
              // @return the single integer that this NestedInteger holds,
              // if it holds a single integer
              // Return null if this NestedInteger holds a nested list
              public Integer getInteger();
 
              // @return the nested list that this NestedInteger holds,
              // if it holds a nested list
              // Return null if this NestedInteger holds a single integer
              public List<NestedInteger> getList();
  }

    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        List<Integer> integerList = new ArrayList<>();
        for (NestedInteger nestedInteger1:nestedList){
            addInteger(integerList,nestedInteger1);
        }
        return integerList;
        // Write your code here

    }

    private void addInteger(List<Integer> integerList,NestedInteger nestedInteger){
        if (nestedInteger.isInteger()){
            integerList.add(nestedInteger.getInteger());
        } else {
            for (NestedInteger nestedInteger1:nestedInteger.getList()){
                addInteger(integerList,nestedInteger1);
            }
        }
    }
}
