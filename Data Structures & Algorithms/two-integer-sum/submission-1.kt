class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        // going trugh the array
        // store the value and elem pos on hashmap
        // check if target - value is on hasmap
        // if so return found elem and current
        val catalog = mutableMapOf<Int, Int>()
        val result = mutableListOf<Int>()

        nums.forEachIndexed { index, value ->
            val op = target - value
            if (catalog.containsKey(op)){
                result.add(catalog.getOrDefault(op,0))
                result.add(index) 
            }
            catalog.put(value,index)
        }

        return result.toIntArray()
    }
}
