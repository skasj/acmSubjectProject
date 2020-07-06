package leetCode.array;

public class SharesMaxProfitSolution {
    /**
     * 解题思路:
     * 低价买入，高价卖出。
     * 低价与高价差值大于手续费才买入，此时低价固定，高价可变。
     * 高价时，如果与下一个低价差值大于手续费才卖出，或者数组用尽，此时重置低价与高价，低价可变，高价固定。
     *
     **/
    public static int maxProfit(int[] prices, int fee) {
        int tempMin = 50001,tempMax = 0;
        int profit = 0;
        // 是否已经买入股票
        boolean hasBuy = false;
        for(int i= 0;i<prices.length; i++){
            if(!hasBuy){
                if(prices[i]<tempMin){
                    // 找最低价位
                    tempMin = prices[i];
                } else if (prices[i]- tempMin>fee){
                    // 满足买入条件
                    tempMax = prices[i];
                    hasBuy = true;
                }
            } else {
                if(prices[i]> tempMax){
                    // 升值，继续持有，并更新最高价
                    tempMax = prices[i];
                } else if (tempMax - prices[i] > fee) {
                    // 满足卖出条件，卖出
                    profit = profit + tempMax - tempMin -fee;
                    tempMax = 0;
                    tempMin = prices[i];
                    hasBuy = false;
                }
            }
        }
        if (hasBuy){
            profit = profit + tempMax - tempMin -fee;
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,3,2,8,4,9},2));
    }
}
