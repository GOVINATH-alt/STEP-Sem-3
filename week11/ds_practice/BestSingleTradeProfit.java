public class BestSingleTradeProfit {

    public static int maxTradeProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println("=== DS P6: Best Single Trade Profit ===");
        int[] prices = {100, 180, 260, 310, 40, 535, 695};
        System.out.println("Max Profit: " + maxTradeProfit(prices));
    }
}
