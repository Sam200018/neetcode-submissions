// for k = 1
// just return the list itself
// for k = 2 
// use max fun 
// 2,2,1,4,4,6
// for k > 2
// sorted and take the last number 
// avoid created a window every time,
// just add k elems at first
// validate using that window

// a DS not always should have the same values
// I can organize a queue depeding on what order I want

class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val result = mutableListOf<Int>()
        val indicesQueue = ArrayDeque<Int>()
        var r = 0
        var l = 0

        while (r < nums.size) {
            while(indicesQueue.isNotEmpty() && nums[indicesQueue.last()] < nums[r]) {
                indicesQueue.removeLast()
            }
            indicesQueue.addLast(r)

            if (l > indicesQueue.first()) {
                indicesQueue.removeFirst()
            }

            if (r + 1 >= k ) {
                val max = nums[indicesQueue.first()]
                result.add(max)
                l += 1
            }
            r += 1 
        }
        
        return result.toIntArray()
    }
}
