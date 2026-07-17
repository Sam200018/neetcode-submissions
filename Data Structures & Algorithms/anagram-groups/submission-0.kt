class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        // Create a Hash map to store the tupple as key and mutable list of string as value
        // Identify the how many times every char appears and make it as key 
        // use that key to asign the current string to its list of strings 
        // return the values of the hash map

        val res = HashMap<List<Int>,MutableList<String>>()

        for(s in strs){
            val tupple = MutableList(26) {0}
            for (c in s){
                tupple[c - 'a']++
            }
            
            // this means get value by key (tupple) 
            // if you have anything put a value '{ xyz }' 
            // then make this op
            res.getOrPut(tupple){
                mutableListOf()
            }.add(s)
        }

        return res.values.toList()
    }
}
