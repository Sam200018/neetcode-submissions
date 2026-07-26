class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        // [24,12,8,6]

        //        *
        // [1,2,4,6]
        // [1,1,2,8]

        //      *     
        // [1,2,4,6]
        // [1,1,1,1]

        val res = IntArray(nums.size){0}
        val pref = IntArray(nums.size){1}
        val suf = IntArray(nums.size){1}


        var i = 1

        while(i < nums.size){
            val product = nums[i-1] * pref[i-1]

            pref[i] = product
            i++
        }

        
        i = nums.size - 2

        
        while(i!= -1){
            val product = nums[i+1] * suf[i+1]
            suf[i] = product
            i--
        }

        i= 0

        while (i < nums.size){
            val finalProd = pref[i] * suf[i]
            res[i] = finalProd
            i++
        }

        return res
    }
}
