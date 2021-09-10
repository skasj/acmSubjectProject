package leetCode.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPathSolution {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        if (split.length == 0 ){
            return "/";
        }
        Deque<String> tmp = new ArrayDeque<>();
        for (String s : split) {
            if ("".equals(s)|| ".".equals(s)){
                continue;
            } else if ("..".equals(s)){
                tmp.pollLast();
            } else {
                tmp.addLast(s);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/");
        while (true){
            String str = tmp.pollFirst();
            if (null!=str){
                stringBuilder.append(str);
            }
            if (!tmp.isEmpty()){
                stringBuilder.append("/");
            } else {
                break;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SimplifyPathSolution().simplifyPath("/home/"));
        System.out.println(new SimplifyPathSolution().simplifyPath("/../"));
        System.out.println(new SimplifyPathSolution().simplifyPath("/home//foo/"));
        System.out.println(new SimplifyPathSolution().simplifyPath("/a/./b/../../c/"));
    }
}
