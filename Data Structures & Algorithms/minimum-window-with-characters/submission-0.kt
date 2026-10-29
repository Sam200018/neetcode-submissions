// every char but not exactly the same
        // duplicates? t = xyzx  s = abscxzxyz
        // 

        // s = "OUZODYXAZV", t = "XYZ"
        // ZODYX 
        // have a bucket of char of t
        // a bucket that we found on during s
        // 
        
        
        // bucketT= {X:1, Y:1, Z:1}
        // tempBucket = {X:1, Y:0, Z: 1}
        // matches = 2
        // minLen = 5  
        // result = "ZODYX"
        // s = "OUZODYXAZV", t = "XYZ"
        //        L
        //            R

        // minLen = 4
        // result = "YXAZ"
        // s = "OUZODYXAZV", t = "XYZ"
        //           L
        //            R

        // s = "OUZODYXAZV", t = "XYZ"
        //            L
        //                R
class Solution {
    fun minWindow(s: String, t: String): String {
    

        val bucketMapNeed = t.groupingBy{ it }.eachCount()
        val bucketMapHave = bucketMapNeed.mapValues { 0 }.toMutableMap()
        var have = 0
        val need = bucketMapNeed.size
        var l = 0
        var minLen = Int.MAX_VALUE
        var startingPoint = 0

        if(s.length < t.length ){
            return ""
        }

        for (r in s.indices){
            val currChar = s[r]
            if ( bucketMapNeed.containsKey(currChar) ){
                val value = bucketMapHave.getOrDefault(currChar,0)
                bucketMapHave[currChar] = value + 1

                if(bucketMapNeed[currChar] == bucketMapHave[currChar]){
                    have++
                }
            }

            while (have == need && l<=r) {
                val currLen = r - l + 1
                if (currLen < minLen) {
                    minLen = currLen
                    startingPoint = l
                }
                val currCharL = s[l]
                if (bucketMapHave.containsKey(currCharL)){
                    val valueHave = bucketMapHave.getOrDefault(currCharL,0)
                    bucketMapHave[currCharL] = valueHave - 1
                    if( bucketMapHave[currCharL]!! < bucketMapNeed[currCharL]!!) {
                     have--
                    }

                }
            

                
                l++
            }

        }
        
        return if (minLen == Int.MAX_VALUE) "" else s.substring(startingPoint, startingPoint + minLen)
    }
}
