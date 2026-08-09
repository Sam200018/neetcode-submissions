class Solution {
    fun isPalindrome(s: String): Boolean {
        val sFiltered = s.filter{
            it.isLetter() || it.isDigit()
        }.lowercase()

        var i = 0
        var j = sFiltered.length - 1
        println(sFiltered)

        while(i<j){
            if(sFiltered[i]!=sFiltered[j]){
                return false
            }
            i++
            j--
        }
        return true
    }
}
