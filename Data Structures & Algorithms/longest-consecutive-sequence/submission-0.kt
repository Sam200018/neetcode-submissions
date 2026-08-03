class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        // convert this into set
        // go through the new set and check
        // if curr value - 1 are in set continue 
        // seach for starting point
        // if curr val is a starting point from
        // that iterate that got find the final point

        // [2,20,4,10,3,4,5]
        // 2,3,4,5
        // 20
        // 4 x
        // 3 x
        // 4 x
        // 5 x

        val numsSet = nums.toSet()
        var longest = 0 

        for(n in numsSet){
            if(numsSet.contains(n-1).not()){
                var length = 0
                while (numsSet.contains(n+length)){
                    length++
                    longest = max(longest,length)
                }
            }
        }

        return longest 
    }
}
