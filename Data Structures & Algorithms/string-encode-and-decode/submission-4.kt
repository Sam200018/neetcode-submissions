class Solution {

    fun encode(strs: List<String>): String {
        if(strs.isEmpty()){
            return "0"
        }


        // know about length of each string
        // use a separator 
        // store that info on string res and return
        val resString = StringBuilder()
        
        for (s in strs){
            val len = s.length
            val instructions = "$len#"
            
            resString.append(instructions).append(s)
            
        }
        
        return resString.toString()

    }

    fun decode(str: String): List<String> {
        // use the length and the sepator to get the original string
        // store on the list 
        // return it 


        val res = mutableListOf<String>()
        if( str == "0"){
            return res
        }
        
        var strCopy = str
        if(strCopy == ""){
            res.add("")
            return res
        }

        var i = 0
        
        while (i < str.length){
            var j = i
            // get the len of each word
            while(str[j] != '#'){
                j++
            }
            val len = str.substring(i,j).toInt()
            // move to the first char of the word
            i = j + 1

            // why i+len, bc as the same way to get the len
            // here get a substring where get the word + one step more
            // to only the word
            val word = str.substring(i,i+len)

            //store the word
            res.add(word)

            // move i to the next len of the next word
            i += len
        }

        return res
    }
}
