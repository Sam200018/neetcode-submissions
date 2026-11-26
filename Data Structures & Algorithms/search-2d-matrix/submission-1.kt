class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var exist = false
        for (row in matrix) {
            exist = row.any{it == target}
            if(exist) return true
        }
        return false 

    }
}
