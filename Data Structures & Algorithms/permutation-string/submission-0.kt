class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val tupples = mutableSetOf<MutableList<Int>>()

        val sizeS1 = s1.length
        var l = 0 
        var r = sizeS1 - 1
        val tuppleS1 = MutableList(26) {0}

        for (c in s1){
            tuppleS1[c - 'a']++
        }
        

        while( l < s2.length && r < s2.length){
            val subString = s2.substring(l..r)
            println(subString)
            
            val tupple = MutableList(26) {0}
            for (c in subString){
                tupple[c - 'a']++
            }
            tupples.add(tupple)
            l++
            r++
        }
        return tupples.contains(tuppleS1)


    }
}
