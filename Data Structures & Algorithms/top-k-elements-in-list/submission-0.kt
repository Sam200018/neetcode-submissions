class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        //Go trough the array
        //Identify the number
        //using a hashMap ask for that if you have plus 1
        // if not just start at 1
        // finally, just return the number of the values by k

        val res = HashMap<Int,Int>()

        for (n in nums) {
            val value = res.getOrDefault(n,0)
            res.put(n,value+1)
        }

        // Sort the key by its value
        // takes first k keys
        // map the key to an List
        // transform it into IntArray
        return res.entries.
        sortedByDescending { it.value }
        .take(k)
        .map{ it.key }
        .toIntArray()

    }
}
