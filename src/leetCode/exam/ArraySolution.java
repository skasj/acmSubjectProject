package leetCode.exam;

import java.util.*;
import java.util.concurrent.DelayQueue;
import java.util.function.IntPredicate;

public class ArraySolution {
    public int getWinner(int[] arr, int k) {
        int temWinner = arr[0];
        int winCount = 0;
        for (int i = 1; i < arr.length; i++) {
            if (winCount == k) {
                return temWinner;
            }
            if (temWinner > arr[i]) {
                winCount++;
            } else {
                winCount = 1;
                temWinner = arr[i];
            }
        }
        return temWinner;
    }


    /**
     * 两个有序数组计算获得中位数，二分算法
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int l = 0, r = m;
        int medMax = 0, medMin = 0;
        while (l <= r) {
            int i = (l + r) / 2;
            int j = (m + n + 1) / 2 - i;
            int nums1_il = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1_i = i == m ? Integer.MAX_VALUE : nums1[i];
            int nums2_jl = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2_j = j == n ? Integer.MAX_VALUE : nums2[j];
            if (nums2_j >= nums1_il) {
                medMax = Math.max(nums1_il, nums2_jl);
                medMin = Math.min(nums1_i, nums2_j);
                l = i + 1;
            } else {
                r = i - 1;
            }
        }
        return (m + n) % 2 == 0 ? (medMin + medMax) / 2d : medMax;
    }

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int count = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][][] sums = new int[rows][rows][cols + 1];
        // 计算每行的和
        int[][] rowSum = new int[rows][cols + 1];
        for (int j = 0; j < rows; j++) {
            for (int y = 0; y < cols; y++) {
                rowSum[j][y + 1] = rowSum[j][y] + matrix[j][y];
                sums[j][j][y + 1] = rowSum[j][y + 1];
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < rows; j++) {
                for (int y = 0; y < cols + 1; y++) {
                    sums[i][j][y] = sums[i][j - 1][y] + rowSum[j][y];
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = i; j < rows; j++) {
                for (int x = 0; x < cols; x++) {
                    for (int y = x + 1; y < cols + 1; y++) {
                        if (sums[i][j][y] - sums[i][j][x] == target) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    // 面试题 17.21. 直方图的水量
    // 从先找到最高点，再减去空气部分，再减去模板部分的思路发展过来
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        int count = 0;
        while (left < right) {
            if (leftMax > rightMax) {
                count += rightMax - height[right];
                rightMax = Math.max(rightMax, height[--right]);
            } else {
                count += leftMax - height[left];
                leftMax = Math.max(leftMax, height[++left]);
            }
        }
        return count;
    }

    public int maxDistance(int[] position, int m) {
        // 排序
        Arrays.sort(position);
        // 按照二分法，判断当最小磁力小于某值时，是否还能满足条件。
        int left = 1;
        int right = position[position.length - 1] - position[0];
        int mid, ans = -1;
        while (left <= right) {
            mid = (right + left) / 2;
            if (check(position, m, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean check(int[] position, int m, int min) {
        int pre = position[0];
        int count = 0;
        for (int p : position) {
            if (p - pre >= min) {
                count++;
                pre = p;
            }
        }
        return count >= (m - 1);
    }

    public int longestSubarray(int[] nums, int limit) {
        int ans = 0;
        Deque<Integer> maxIndexDeque = new LinkedList<>();
        Deque<Integer> minIndexDeque = new LinkedList<>();
        int start = 0;
        // 右沿
        for (int end = 0; end < nums.length; end++) {
            // 更新最大值下标维护队列,如果已有的最大值比当前值小，则更新最大值
            while (!maxIndexDeque.isEmpty() && nums[maxIndexDeque.peekLast()] < nums[end]) {
                maxIndexDeque.pollLast();
            }
            maxIndexDeque.add(end);
            // 更新最小值下标维护队列
            while (!minIndexDeque.isEmpty() && nums[minIndexDeque.peekLast()] > nums[end]) {
                minIndexDeque.pollLast();
            }
            minIndexDeque.add(end);
            // 左沿，当最大最小值差值大于limit时
            while (!maxIndexDeque.isEmpty() && !minIndexDeque.isEmpty() && nums[maxIndexDeque
                    .peekFirst()] - nums[minIndexDeque.peekFirst()] > limit) {
                if (minIndexDeque.peekFirst() < maxIndexDeque.peekFirst()) {
                    start = minIndexDeque.peekFirst() + 1;
                    minIndexDeque.pollFirst();
                } else {
                    start = maxIndexDeque.peekFirst() + 1;
                    maxIndexDeque.pollFirst();
                }
            }
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }

    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> strings = new ArrayList<>();
        if (nums.length == 0) {
            return strings;
        }
        int left = nums[0];
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (pre + 1 != nums[i]) {
                if (left == pre) {
                    strings.add("" + left);
                } else {
                    strings.add(String.format("%d->%d", left, pre));
                }
                left = nums[i];
                pre = nums[i];
            } else {
                pre = nums[i];
            }
        }
        if (left == pre) {
            strings.add("" + left);
        } else {
            strings.add(String.format("%d->%d", left, pre));
        }
        return strings;
    }

    public int countServers(int[][] grid) {
        // 两个数组，分别用来维护每行列第一个服务器的坐标；
        for (int[] t:grid){
            System.out.println(Arrays.toString(t));
        }
        int[] colPosi = new int[grid[0].length];
        int ans=0;
        for (int row = 0; row < grid.length; row++) {
            int rowPosi = -1;
            for (int col = 0; col < grid[0].length; col++) {
                // 如果存在行、列第一个服务器，就把自己和行列的第一的标记值修改
                // 如果不存在，就把自己作为第一个服务器计入
                if (grid[row][col] != 0) {
                    if (rowPosi != -1) {
                        grid[row][col] = 2;
                        grid[row][rowPosi] = 2;
                    } else {
                        rowPosi = col;
                    }
                    if (colPosi[col] != 0) {
                        grid[row][col] = 2;
                        grid[colPosi[col] - 1][col] = 2;
                    } else {
                        colPosi[col] = row + 1;
                    }
                }
            }
        }
        for (int[] t:grid){
            System.out.println(Arrays.toString(t));
        }
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (2==grid[row][col]) ans++;
            }
        }
        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        int[] newH = new int[heights.length + 2];
        System.arraycopy(heights,0,newH,1,heights.length);
        Deque<Integer> hTag= new ArrayDeque<>();
        hTag.add(0);
        int ans=0;
        for (int i=1;i<newH.length;i++){
            // 入栈
            if (newH[i]>newH[hTag.peekLast()]){
                hTag.add(i);
            } else {
                while (newH[i]<newH[hTag.peekLast()]){
                    //出栈
                    Integer integer = hTag.pollLast();
                    ans=Math.max(ans,(i-hTag.peekLast()-1)*newH[integer]);
                }
                hTag.add(i);
            }
        }
        return ans;
    }

    /**
     * 1330. 翻转子数组得到最大的数组值
     * 给你一个整数数组 nums 。「数组值」定义为所有满足 0 <= i < nums.length-1 的 |nums[i]-nums[i+1]| 的和。
     * 你可以选择给定数组的任意子数组，并将该子数组翻转。但你只能执行这个操作一次 。
     * 请你找到可行的最大数组值 
     *
     * @param nums
     * @return
     */
    public int maxValueAfterReverse(int[] nums) {
        // src = abs|l1-l2|+ abs|r1-r2|+abs|l2-r1|
        // 倒置l2与r1区间
        // tar = abs|l1-r1|+abs|l2-r2|+abs|l2-r1|
        // 假设L[l]，H[l]分别为l1，l2中的较小值较大值
        // 假设L[r]，H[r]分别为r1，r2中的较小值较大值
        // L[l]，H[l],L[r]，H[r]的相对位置有以下两种情况：
        // L[r]<H[l]
        // L[l].............H[l]
        //            L[r].................H[r]
        // L[r]>=H[l]
        // L[l].......H[l]
        //                  L[r]... .......H[r]
        // tar = Math.max(src + (L[r]-H[l])*2,tar)
        int n1,n2;
        int lr=0,hl=Integer.MAX_VALUE;
        int grade =0;
        int sum =0;
        for (int i=0;i<nums.length-1;i++){
            n1 = i;
            n2 = i+1;
            // 计算原始分数
            sum += Math.abs(nums[n1]-nums[n2]);
            // 计算[0,i]反转的情况
            grade = Math.max(grade,Math.abs(nums[n2]-nums[0])-Math.abs(nums[n1]-nums[n2]));
            // 计算[i,length-1]反转的情况
            grade = Math.max(grade,Math.abs(nums[n1]-nums[nums.length-1])-Math.abs(nums[n1]-nums[n2]));
            lr=Math.max(lr,Math.min(nums[n1],nums[n2]));
            hl=Math.min(hl,Math.max(nums[n1],nums[n2]));
        }
        return sum+Math.max(grade,(lr-hl)*2);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size()==1){
            return triangle.get(0).get(0);
        }
        // 动态规划，从倒数第二层开始计算
        List<Integer> now;
        List<Integer> pre = triangle.get(triangle.size()-1);
        for (int layer = triangle.size()-2;layer>-1;layer--){
            now = triangle.get(layer);
            for (int i=0;i<now.size();i++){
                now.set(i,now.get(i)+Math.min(pre.get(i),pre.get(i+1)));
            }
            pre = now;
        }
        return triangle.get(0).get(0);
    }

    public int findLengthOfShortestSubarray(int[] arr) {
        if (arr.length==1||arr.length==0){
            return 0;
        }
        // 先找到左右侧的递增数组
        int leftEnd=1;
        while (leftEnd<arr.length&&arr[leftEnd]>=arr[leftEnd-1]){
            leftEnd++;
        }
        leftEnd--;
        // 有序
        if (leftEnd==arr.length-1){
            return 0;
        }
        int rightStart=arr.length-2;
        while (rightStart>-1&& arr[rightStart]<=arr[rightStart+1]){
            rightStart--;
        }
        rightStart++;
        // 如果两数组没有交集，则全部保留或者保留最长的一个
        if (arr[leftEnd]<=arr[rightStart]){
            return rightStart-leftEnd-1;
        }
        // 只保留一侧
        int minCut = arr.length-Math.max(arr.length-rightStart,leftEnd+1);
        // 两边各保留一部分
        for (int i= rightStart,leftTemp=0;i<arr.length;i++){
            while (leftTemp <= leftEnd && arr[leftTemp] <= arr[i]){
                leftTemp++;
            }
            minCut=Math.min(minCut,i-leftTemp);
            if (arr[i]>arr[leftEnd]){
                break;
            }
        }
        return minCut;
    }

    public int numMagicSquaresInside(int[][] grid) {
        // 非暴力求解
        if (grid.length<3 || grid[0].length<3){
            return 0;
        }

        // 1. 3*3 的幻方的解唯一，有正序逆序区别
        int[] res = new int[]{8,1,6,7,2,9,4,3,8,1,6,7,2,9};
        int count =0;
        int[] horns = new int[]{8,6,2,4};
        for (int i=1;i<grid.length-1;i++){
            for (int j=1;j<grid.length-1;j++){
                if (5==grid[i][j]){
                    // 找到正确的位置
                    for (int k=0;k< horns.length;k++){
                        if (horns[k]==grid[i-1][j-1]){
                            // 正序 与 逆序
                            if ((grid[i-1][j]==res[2*k+1] &&
                                    grid[i-1][j+1]==res[2*k+2]&&
                                    grid[i][j+1]==res[2*k+3]&&
                                    grid[i+1][j+1]==res[2*k+4]&&
                                    grid[i+1][j]==res[2*k+5]&&
                                    grid[i+1][j-1]==res[2*k+6]&&
                                    grid[i][j-1]==res[2*k+7])||
                                    (grid[i-1][j]==res[2*k+7] &&
                                    grid[i-1][j+1]==res[2*k+6]&&
                                    grid[i][j+1]==res[2*k+5]&&
                                    grid[i+1][j+1]==res[2*k+4]&&
                                    grid[i+1][j]==res[2*k+3]&&
                                    grid[i+1][j-1]==res[2*k+2]&&
                                    grid[i][j]==res[2*k+1]))
                                count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public int maxDistToClosest(int[] seats) {
        int seat=0,left=0;
        boolean first = true;
        int max = 0;
        for (int i=0;i<seats.length;i++){
            seat=seats[i];
            if (seat==1){
                if (first){
                    max=Math.max(max,i-left);
                    first=false;
                } else {
                    max= Math.max(max,(i-left)/2);
                }
                left=i;
            } else if (i==seats.length-1){
                max=Math.max(max,i-left);
            }
        }
        return max;
    }

    public int countTriplets(int[] arr) {
        // 如果存在，左右区间的异或结果是0
        // 并且任意划分的结果满足，即数量等于k-i
        // 综上，n只与k和i相关
        // 0 <= i < k < arr.length
        int result=0;
        int count = 0;
        for(int i=0;i<arr.length-1;i++){
            result=arr[i];
            for(int k=i+1;k<arr.length;k++){
                result= arr[k] ^ result;
                if (result==0){
                    count=count+k-i;
                }
            }
        }
        return count;
    }

    private int swimming(int x,int n){
        if (n==0){
            return 0;
        }
        int result = (n/7)*1250+(n%7)*250;
        int tmp = n%7+x;
        if (tmp>7){
            result-=250;
        }
        if (x<7 && tmp>6){
            result-=250;
        }
        return result;
    }

    public boolean exist(char[][] board, String word) {
        // 1. 遍历所有节点，存入hashmap
        HashMap<String, List<int[]>> stringHashMap = new HashMap<>();
        List<int[]> orDefault;
        for (int row=0;row< board.length;row++){
            for (int col=0;col<board[0].length;col++){
                String key = String.valueOf(board[row][col]);
                orDefault = stringHashMap.getOrDefault(key, new ArrayList<>());
                orDefault.add(new int[]{row,col});
                stringHashMap.put(key, orDefault);
            }
        }
        char[] wordChars = word.toCharArray();
        // 2. 通过hashMap获取可能的头节点
        List<int[]> posiablePositionList = stringHashMap.get(String.valueOf(wordChars[0]));
        if (null == posiablePositionList || posiablePositionList.isEmpty()){
            return false;
        } else if (wordChars.length==1){
            return true;
        }

        int[][] usedFalgs = new int[board.length][board[0].length];
        for (int[] posiablePosition:posiablePositionList){
            // 3. 通过深度优先遍历，检验是否可以找到
            if (depthFirstTraversal(board,usedFalgs,posiablePosition[0],posiablePosition[1],wordChars,0)){
                return true;
            }
        }
        return false;
    }

    private boolean depthFirstTraversal(char[][] board, int[][] usedFalgs,int x,int y,char[] wordChars ,int charIndex){
        // 退出条件，所有字符都匹配
        if (charIndex>=wordChars.length){
            return true;
        }
        // 判断当前字段是否满足期待
        // 1.不能超出范围
        // 2.不能用已使用的位置
        if (x<0 || x+1>board.length||y<0||y+1>board[0].length || usedFalgs[x][y]==1||board[x][y]!=wordChars[charIndex]){
            return false;
        }
        usedFalgs[x][y]=1;
        // 递归调用上下左右四个方向，有一个成功的就返回
        // 上
        if (depthFirstTraversal(board,usedFalgs,x-1,y,wordChars,charIndex+1) ||
                depthFirstTraversal(board,usedFalgs,x+1,y,wordChars,charIndex+1) ||
                depthFirstTraversal(board,usedFalgs,x,y-1,wordChars,charIndex+1)||
                depthFirstTraversal(board,usedFalgs,x,y+1,wordChars,charIndex+1)){
            return true;
        } else {
            usedFalgs[x][y]=0;
            return false;
        }
    }

    /**
     * 思路：单调栈
     * @param hours
     * @return
     */
    public int longestWPI(int[] hours) {
        for (int i = 0; i< hours.length; i++){
            if (hours[i]>8){
                hours[i]=1;
            } else {
                hours[i]=-1;
            }
        }
        int[] preSums = new int[hours.length+1];
        preSums[0]=0;
        for (int i = 0, j = 1; i< hours.length; i++,j++){
            preSums[j]=preSums[i]+ hours[j];
        }
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(0);
        for (int i=0;i<preSums.length;i++){
            if (stack.peek()<preSums[i]){
                stack.push(i);
            }
        }
        return 0;
    }

    public int minIncrementForUnique(int[] A) {
        if (A.length<2){
            return 0;
        }
        // 先排序
        Arrays.sort(A);
        // 再使递增
        int result=0;
        for (int i=1;i<A.length;i++){
            if (A[i]<=A[i-1]){
                result+=A[i-1]-A[i]+1;
                A[i]=A[i-1]+1;
            }
        }
        return result;
    }

    public boolean canReorderDoubled(int[] A) {
        // 先排序
        Arrays.sort(A);
        // 再根据是否大于0进行不同的处理
        int dividingPointIndex=-1;//(包含了小于0的部分，不包含0)
        for (int a:A){
            if (a<0){
                dividingPointIndex++;
            } else {
                break;
            }
        }
        if (dividingPointIndex%2==0)
            return false;
        int[] flags=new int[A.length];
        // 小于0的
        int temp =1;
        for(int i=0;i<=dividingPointIndex;i++){
            if (flags[i]==1){
                continue;
            }
            for (;temp<=dividingPointIndex;temp++){
                if (A[i]==2*A[temp]){
                    flags[i]=1;
                    flags[temp++]=1;
                    break;
                }
            }
        }
        // 大于0的，后二分之一的每个值，恰好是前二分之一的一倍。
        for(int i=dividingPointIndex+1;i<A.length;i++){
            if (flags[i]==1){
                continue;
            }
            for (;temp<A.length;temp++){
                if (2*A[i]==A[temp]){
                    flags[i]=1;
                    flags[temp++]=1;
                    break;
                }
            }
        }
        // 检验是否有没有满足条件的，如果有返回false;
        return 0==Arrays.stream(flags).filter(new IntPredicate() {
            @Override
            public boolean test(int value) {
                return value==0;
            }
        }).count();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        ArraySolution solution = new ArraySolution();
        System.out.println(solution.canReorderDoubled(new int[]{2,1,2,6}));
    }
}
