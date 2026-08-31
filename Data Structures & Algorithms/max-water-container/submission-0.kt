class Solution {
    fun maxArea(heights: IntArray): Int {
        // point to first and last
        // use the distance between last and fist
        // and the min of the heights
        // calculate the area
        // compare vs the original area
        // save bigger area only

        // when to move the pointers?
        // only move the pointer at smaller height

        var area = 0
        var f = 0
        var l = heights.size - 1

        while (l>f){
            val areaTemp = (l-f) * min(heights[l],heights[f])
            area = max(area, areaTemp)
            if( heights[l] > heights[f] ){
                f++
            }else{
                l--
            }
        }
        return area

    }
}
