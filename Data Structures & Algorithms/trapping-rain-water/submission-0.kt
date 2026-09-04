class Solution {
    fun trap(height: IntArray): Int {
        // point to first(l) and last(r)
        // save max height on left and on right
        // if maxHLeft < maxHRight 
        //  checks if curr height is biger or equals
        //  to maxHLeft, and overwrite maxHLeft 
        //  else, calculate water trapped
        //  and move l
        // else
        //  checks if curr height is bigger or equals
        //  to maxHRight, and overwrite maxHRight
        //  else, calculate water trapped
        // and move r
        // return result 


        var l = 0 
        var r = height.size - 1
        var maxHLeft = 0 
        var maxHRight = 0 
        var result = 0 

        while( l <= r ){
            if(maxHLeft < maxHRight){
                if(height[l] >= maxHLeft){
                    maxHLeft = height[l]
                }else{
                    result += maxHLeft - height[l]
                }
                l++
            }else{
                if(height[r] >= maxHRight){
                    maxHRight = height[r]
                }else{
                    result += maxHRight - height[r]
                }
                r--
            }
        } 
        return result 

    }
}
