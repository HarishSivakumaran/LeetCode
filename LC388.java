// 388. Longest Absolute File Path

class Solution {
    int res = 0;
    public int lengthLongestPath(String input) {
        Stack<Integer> s = new Stack();
        s.push(0);

        for(String path : input.split("\n")){
            int level = path.lastIndexOf("\t")+1;
            while(level+1 < s.size()) s.pop();
            int len = s.peek() + path.length() - level + 1;
            s.push(len);
            if(path.contains(".")) this.res = Math.max(this.res, len-1);
        }

        return this.res;
    }

    // public void getFilepaths(StringBuilder str, StringBuilder path, String delimiter){
    //     String curr = getStringBasedDel(str, delimiter);
    //     int pos = path.length();
    //     path.append((pos == 0 ? "" : "/" )+ curr);
    //     if(path.indexOf(".") != -1) this.res = Math.max(this.res, path.length());
    //     delimiter = pos == 0 ? "\n" : delimiter;
    //     delimiter += "\t";
    //     boolean hasChildren = true;
    //     while(str.indexOf(delimiter) == 0){ //process children
    //         getFilepaths(str, path, delimiter);
    //     };  
    //     path.replace(pos, path.length(), "");     
        
    // }

    // public String getStringBasedDel(StringBuilder str, String del){

    //     str.replace(0, del.length(), "");

    //     int next = str.indexOf("\n") == -1 ? str.length() : str.indexOf("\n");

    //     String res = str.substring(0, next);
        
    //     str.replace(0, next, "");

    //     return res;


    // }
}