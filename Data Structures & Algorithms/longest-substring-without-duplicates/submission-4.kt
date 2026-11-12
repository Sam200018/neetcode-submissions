class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val charSet = mutableSetOf<Char>()
        var maxLen = Int.MIN_VALUE
        var r = 0 
        var l = 0
        // "zyxzxyz"
        //        r
        //     l
        // charSet = [xyz] x

        if(s == ""){
            return 0
        }

        while (r < s.length) {
            while (charSet.contains(s[r])){
                charSet.remove(s[l])
                l++
            }
            charSet.add(s[r])
            maxLen = max(maxLen, r - l + 1)
            r++
        }
        return maxLen
    }
}
