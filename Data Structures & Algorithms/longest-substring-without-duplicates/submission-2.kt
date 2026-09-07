class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        // point to first L and R
        // as the pointer R goes through the array
        // check if the char at that pos exits on set
        // if not add it and increase the window
        // else, move L one more pos
        //  also point R at L (start window again)
        

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
