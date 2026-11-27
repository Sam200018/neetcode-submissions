class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var rows = matrix.size
        var cols = matrix[0].size 
        var top = 0
        var bot = rows - 1

        while (top <= bot) {
            val row:Int = (top + bot) / 2
            if(target > matrix[row][cols - 1]) {
                top = row + 1
            }else if(target < matrix[row][0]) {
                bot = row - 1
            }else {
                break
            }
        }

        if(!(top <= bot)) return false
        val row: Int = (top + bot) / 2
        var l = 0 
        var r = matrix[row].size
        
        while (l <= r) {
            val m: Int  = (l + r) / 2
            if(target > matrix[row][m]){
                l = m + 1
            }else if(target< matrix[row][m]){
                r = m - 1
            }else{
                return true
            }
        }
        return false

    }
}
