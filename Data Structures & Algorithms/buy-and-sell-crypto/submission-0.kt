class Solution {
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        var b = 0 
        var s = 1

        while(b < prices.size && s < prices.size){
            val tempProfit = prices[s] - prices[b]
            
            if(tempProfit > 0){
                maxProfit = max(maxProfit, tempProfit)
                s++
            }else{
                b = s
                s = s + 1
            }
        }

        return maxProfit

        



    }
}
