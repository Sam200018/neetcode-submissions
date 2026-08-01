class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        // array of sets for rows
        // array of sets for colums
        // map for box

        // iterate as matrix
        // check if the curr value exists on 
        // respective column set and row set 
        // check if the curr value exist on 
        // respective box
        // if already exits return false(invalid)
        // once scaning all the matrix return true

        // mutableSet is like hashMap but without key, fast looking for 
        val rows = Array<MutableSet<Char>>(9){
            mutableSetOf()
        }
        val cols = Array<MutableSet<Char>>(9){
            mutableSetOf()
        }
        val boxes = mutableMapOf<String,MutableSet<Char>>()

        for(i in board.indices ){
            for(j in board[i].indices){
                val currVal = board[i][j]
                if(currVal == '.') continue
                // it works because division int vs int
                // result in int
                val currBox = "${i/3}${j/3}"
                if(rows[i].contains(currVal) 
                    || cols[j].contains(currVal) 
                    || boxes.getOrPut(currBox){mutableSetOf()}.contains(currVal)){
                    return false
                }

                rows[i].add(currVal)
                cols[j].add(currVal)
                boxes[currBox]?.add(currVal)

            }
        }

        return true
    }
}
