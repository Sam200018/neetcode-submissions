class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val sortedNums = nums.sorted()
        // [-4, -1, -1, 0, 1, 2]
        // x         y.      z

        var res = mutableListOf<List<Int>>()


        for(i in sortedNums.indices){
            // this is for the case on the array only contains positive numbers
            if( sortedNums.get(i)>0 ) break
            if(i > 0 && sortedNums.get(i) == sortedNums.get(i-1)){
                continue
            }
            var left = i + 1
            var rigth = sortedNums.size - 1
            
            while( left < rigth ){
                val one:Int = sortedNums.get(i)
                val two:Int = sortedNums.get(left)
                val three:Int = sortedNums.get(rigth)
                val op:Int =  one + two + three 
                
                when{
                    (op > 0) -> {
                        rigth--
                    }
                    (op < 0) -> {
                        left++
                    }
                    else -> {
                        val listTemp = listOf(one, two, three)
                        res.add(listTemp)
                        left++
                        rigth--
                        // when the code already found a valid trepple,
                        // it has to skip the same ocurrances from left 
                        // and rigth 
                        while(
                            left<rigth &&
                             sortedNums.get(left) == sortedNums.get(left - 1)){
                            left++
                        }
                        while(
                            left<rigth &&
                             sortedNums.get(rigth) == sortedNums.get(rigth + 1)){
                            rigth--
                        }

                    }
                }
            }

        }

        return res
    }
}
