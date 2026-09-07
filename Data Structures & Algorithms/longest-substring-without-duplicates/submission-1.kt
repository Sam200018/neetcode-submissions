class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        // point to first L and R
        // as the pointer R goes through the array
        // check if the char at that pos exits on set
        // if not add it 
        // else, move L at R pos and repeat the process
        // until L and R are at last elem 

        var l = 0
        var r = 0
        var charsSet = mutableSetOf<Char>()
        var longest = 0

        while(l < s.length  && r < s.length){
            if(charsSet.contains(s[r]).not()){
                charsSet.add(s[r])
                longest = max(longest, 1 + r - l )
                r++
            }else{
                l++
                r = l
                charsSet.clear()
            }
        }
        return longest 
    }
}
