// 659 · Encode and Decode Strings

public class Solution {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
     public char delimiter = '#';
    public String encode(List<String> strs) {
        // write your code here
        String res = "";

        for(String s : strs){
         res  = res + s.length() + delimiter + s;
        }

        return res;
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here
        List<String> res = new ArrayList<>();
        int i = 0;

        while(i < str.length()){
            int j = i;
            while(str.charAt(j) != delimiter){
                j++;
            }

            int count = Integer.parseInt(str.substring(i,j));
            res.add(str.substring(j+1, j+count+1));
            i = j+count+1; 

        }

        return res;
    }
}