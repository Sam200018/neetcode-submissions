// empty == true
// not all connected == false
// loop == false
class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        if (edges.size > n - 1) return false

        //build adjMatrix
        val adjMatrix = mutableMapOf<Int,MutableList<Int>>()
        for ((n,v) in edges){
            adjMatrix.getOrPut(n){mutableListOf<Int>()}.add(v)
            adjMatrix.getOrPut(v){mutableListOf<Int>()}.add(n)
        }
        val visited = HashSet<Int>()
        println(adjMatrix)

        fun dfs(node: Int, parent:Int):Boolean{
            if(visited.contains(node)) return false
            visited.add(node)

            adjMatrix[node]?.forEach { nei ->
                if(nei == parent) return@forEach
                if(!dfs(nei,node)) return false
            }
            return true
        }
        return dfs(0,-1) && visited.size == n
    }
}
