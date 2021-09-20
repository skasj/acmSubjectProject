package leetCode.datastructure;

import java.util.*;
import java.util.stream.Collectors;

public class CountOfAtomsSolution {
    public String countOfAtoms(String formula) {
        Deque<String> deque = new ArrayDeque<>();
        Deque<Map<String, Integer>> countDeque = new ArrayDeque<>();
        char[] chars = formula.toCharArray();
        Map<String, Integer> count = new HashMap<>();
        int tmpNum = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c >= 'A' && c <= 'Z') {
                if (!deque.isEmpty() && !deque.getLast().equals("(")) {
                    String poll = deque.pollLast();
                    Integer integer = count.getOrDefault(poll, 0);
                    count.put(poll, integer + 1);
                }
                deque.add("" + c);
            } else if (c >= 'a' && c <= 'z') {
                deque.add(deque.pollLast() + c);
            } else if (c == '(') {
                deque.add("" + c);
                countDeque.add(count);
                count = new HashMap<>();
            } else if (c == ')') {
                if (!deque.isEmpty() && !deque.getLast().equals("(")) {
                    String poll = deque.pollLast();
                    Integer integer = count.getOrDefault(poll, 0);
                    count.put(poll, integer + 1);
                }
                Map<String, Integer> newCount = countDeque.isEmpty() ? new HashMap<>() : countDeque.pollLast();
                if (i + 1 >= chars.length || chars[i + 1] < '0' || chars[i + 1] > '9') {
                    count.entrySet().stream().filter(e -> null != e.getValue()).forEach(e -> {
                        newCount.put(e.getKey(), e.getValue() + newCount.getOrDefault(e.getKey(), 0));
                    });
                } else {
                    StringBuilder sb = new StringBuilder();
                    int j = i + 1;
                    while (j < chars.length && chars[j] >= '0' && chars[j] <= '9') {
                        sb.append(chars[j++]);
                        i++;
                    }
                    Integer num = Integer.valueOf(sb.toString());
                    count.entrySet().stream().filter(e -> null != e.getValue()).forEach(e -> {
                        newCount.put(e.getKey(), e.getValue() * num + newCount.getOrDefault(e.getKey(), 0));
                    });
                }
                count = newCount;
                deque.pollLast();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                int j = i + 1;
                while (j < chars.length && chars[j] >= '0' && chars[j] <= '9') {
                    sb.append(chars[j++]);
                    i++;
                }
                Integer num = Integer.valueOf(sb.toString());
                String poll = deque.pollLast();
                Integer integer = count.getOrDefault(poll, 0);
                count.put(poll, integer + num);
            }
        }
        while (!deque.isEmpty()) {
            String poll = deque.pollLast();
            Integer integer = count.getOrDefault(poll, 0);
            count.put(poll, integer + 1);
        }
        StringBuilder sb = new StringBuilder();
        List<String> collect = count.keySet().stream().sorted().collect(Collectors.toList());
        for (String s : collect) {
            sb.append(s);
            Integer obj = count.get(s);
            if (1 != obj) {
                sb.append(obj);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CountOfAtomsSolution countOfAtomsSolution = new CountOfAtomsSolution();
//        System.out.println(countOfAtomsSolution.countOfAtoms("H2O"));
//        System.out.println(countOfAtomsSolution.countOfAtoms("Mg(OH)2"));
//        System.out.println(countOfAtomsSolution.countOfAtoms("K4(ON(SO3)2)2"));
//        System.out.println(countOfAtomsSolution.countOfAtoms("Be32"));
        System.out.println(countOfAtomsSolution.countOfAtoms("(H)"));
    }

}
