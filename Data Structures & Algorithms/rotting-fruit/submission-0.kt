// reach rotten oranges
// save the fresh oranges count
// check arround that ones and add them to a queue
// check the size and save it as rotten by min
// take out rottens by min of queue and mark as rotten
// check arround to add them by every process
// use the fresh vs rotten to check if oranges fresh left


class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        var freshOranges = 0 
        val queue = ArrayDeque<Pair<Int,Int>>()
        var time = 0 
        
        for (r in grid.indices){
            for (c in grid[r].indices){
                when(grid[r][c]){
                    1 -> freshOranges++
                    2 -> {
                        println(r)
                        println(c)
                        queue.addLast(r to c)
                    }
                    else -> continue
                }
            }
        }

        val directions = arrayOf(
            intArrayOf(0,1),
            intArrayOf(0,-1),
            intArrayOf(1,0),
            intArrayOf(-1,0)
        )
        
        while(freshOranges > 0 && queue.isNotEmpty()) {
            repeat(queue.size) {
                val (currRow,currCol) = queue.removeFirst()

                for (dir in directions) {
                    var newRow = currRow + dir[0]
                    var newCol = currCol + dir[1]
                    println(newRow)
                    println(newCol)

                    if (newRow in grid.indices && 
                        newCol in grid[0].indices &&
                         grid[newRow][newCol]==1 )
                    {
                        grid[newRow][newCol] = 2
                        queue.addLast(newRow to newCol)
                        freshOranges--
                    }

                }

            }
            time++
        }
        return if (freshOranges == 0) time else -1
    }
}
