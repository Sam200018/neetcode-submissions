/*1. Understand the problem
  - Ask clarifying questions
 - Confirm ambiguous terms
 - What inputs produce what outputs?
 - List edge cases and counterexamples

  ] = false
  [ = false
  }} = false 
  [[{]}] = false
  []]]

  2. Demonstrate understanding
 - Don’t optimize prematurely. Briefly discuss brute-force solution.
 - Ground your thinking in algorithmic efficiency (Big O)
 - Express any ideas, named algorithms (e.g. BFS - not pseudo-code), and data structures that come to mind
 I would use a stack to put the left side on it
 then, i would pop the top when i found the right side of the top
  i would return false
  if i got something diferent to complement of the top
 - Explain high-level approach before coding

*/
class Solution {
    fun isValid(s: String): Boolean {
        if(s.length % 2 != 0) {
            return false
        }

        val stack = mutableListOf<Char>()
        for(c in s){
            if(c == '(' || c == '[' || c == '{') {
                stack.add(c)
                continue
            }
            if(stack.isNotEmpty()){
                val top = stack.removeLast()
                if(top == '{' && c!= '}' ||
                top == '[' && c != ']' ||
                top == '(' && c != ')' 
                ) {
                    return false
                }    
            }else{
                return false
            }
            
        }
        
        return stack.isEmpty()
    }
}
