package leetCode.exam;

import java.util.*;

public class OutPutTry {

    // --------------  输入  ----------------//
    /**
     * 没有输入行数
     */
    public static class Main {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int a, b;
            while (scanner.hasNext()) {
                a = scanner.nextInt();
                b = scanner.nextInt();
                System.out.println(a+b);
            }
        }
    }

    /**
     * 第一行是输入行数
     */
    public static class Main1{
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int a, b;
            int n = scanner.nextInt();
            while (n-->0) {
                a = scanner.nextInt();
                b = scanner.nextInt();
                System.out.println(a+b);
            }
        }
    }

    /**
     * 最后一行是中止标识
     */
    public static class Main2{
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int a, b;
            do {
                a = scanner.nextInt();
                b = scanner.nextInt();
                if (a ==0 && b ==0){
                    break;
                } else {
                    System.out.println(a+b);
                }
            } while (true);

        }
    }

    /**
     * 每行第一个是数组长度，当长度是0的时候结束输入
     */
    public static class Main3{
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n;
            int sum=0;
            while (true) {
                n = scanner.nextInt();
                if (0==n){
                    break;
                }
                sum=0;
                while (n-->0){
                    sum+=scanner.nextInt();
                }
                System.out.println(sum);
            }
        }
    }

    /**
     * 第一行是数组的数量，每行第一个是数组长度
     */
    public static class Main4{
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int m,sum=0;
            while (n-->0) {
                m = scanner.nextInt();
                sum=0;
                while (m-->0){
                    sum+=scanner.nextInt();
                }
                System.out.println(sum);
            }
        }
    }

    /**
     * 一开始没有约定数组数量，每行第一个是数组长度
     */
    public static class Main5{
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int m,sum=0;
            while (scanner.hasNext()) {
                m = scanner.nextInt();
                sum=0;
                while (m-->0){
                    sum+=scanner.nextInt();
                }
                System.out.println(sum);
            }
        }
    }

    /**
     * 没有行数，也没有列数,数组用特殊符号隔开
     */
    public static class Main6{
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String s;
            int sum=0;
            while (scanner.hasNextLine()) {
                s = scanner.nextLine();
                if (null == s || "".equals(s.trim())){
                    break;
                }
                String[] split = s.split(" ");
                sum=0;
                for (String num:split){
                    sum+=Integer.valueOf(num);
                }
                System.out.println(sum);
            }
        }
    }

    // --------------  输出  ----------------//

    /**
     * 输入2行，第一行是第二行的元素数量
     * 间隔空格输出
     */
    public static class Main7{
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Integer n = Integer.valueOf(scanner.nextLine().trim());
            String s = scanner.nextLine();
            if (null == s || "".equals(s.trim())){
                return;
            }
            String[] split = s.split(" ");
            Arrays.sort(split);
            StringBuilder sb = new StringBuilder();
            int i=0;
            while (i<n) {
                sb.append(split[i++]);
                if (i!=n){
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
        }
    }

    /**
     * 按行读取
     * 间隔空格输出
     */
    public static class Main8{
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String s;
            StringBuilder sb;
            int n=0;
            while (scanner.hasNextLine()) {
                s = scanner.nextLine();
                if (null == s || "".equals(s.trim())){
                    break;
                }
                String[] split = s.split(" ");
                Arrays.sort(split);
                sb = new StringBuilder();
                n=split.length;
                int i=0;
                while (i<n) {
                    sb.append(split[i++]);
                    if (i!=n){
                        sb.append(" ");
                    }
                }
                System.out.println(sb.toString());
            }
        }
    }

    /**
     * 按行读取
     * 间隔空格输出
     */
    public static class Main9{
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String splitTag=",";
            String s;
            StringBuilder sb;
            int n=0;
            while (scanner.hasNextLine()) {
                s = scanner.nextLine();
                if (null == s || "".equals(s.trim())){
                    break;
                }
                String[] split = s.split(splitTag);
                Arrays.sort(split);
                sb = new StringBuilder();
                n=split.length;
                int i=0;
                while (i<n) {
                    sb.append(split[i++]);
                    if (i!=n){
                        sb.append(splitTag);
                    }
                }
                System.out.println(sb.toString());
            }
        }
    }

    /**
     * 没有行数，也没有列数,数组用特殊符号隔开
     */
    public static class Main10{
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String s;
            long sum=0;
            while (scanner.hasNextLine()) {
                s = scanner.nextLine();
                if (null == s || "".equals(s.trim())){
                    break;
                }
                String[] split = s.split(" ");
                sum=0;
                for (String num:split){
                    sum+=Long.valueOf(num);
                }
                System.out.println(sum);
            }
        }
    }
}
