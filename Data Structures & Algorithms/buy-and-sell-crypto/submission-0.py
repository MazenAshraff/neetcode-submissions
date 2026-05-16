class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        max_profit = 0
        get = prices[0]
        for price in prices:
            if price < get:
                get = price
            else:
                max_profit = max(max_profit, price - get)
        return max_profit
        