class Solution {
    public String decodeAtIndex(String s, int k) {
        long decodedWordLength = 0;
        int i = 0;
        for(; decodedWordLength < k; i++) {
            if(s.charAt(i) > '0' && s.charAt(i) <= '9') {
                decodedWordLength = decodedWordLength*(s.charAt(i) - '0');
            } else {
                decodedWordLength++;
            }
        }

        for(--i; i >= 0; i--) {
             if(s.charAt(i) > '0' && s.charAt(i) <= '9') {
                decodedWordLength /= (s.charAt(i) - '0');
                k %= decodedWordLength;
            } else {
                if(k%decodedWordLength == 0) break;
                decodedWordLength--;
            }
        }

        return Character.toString(s.charAt(i));
    }
}


// class Solution {
//     public String decodeAtIndex(String s, int k) {
//         StringBuilder str = new StringBuilder();
//         for(int i = 0; i < s.length() && str.length() < k; i++){
//             if(s.charAt(i) > '1' && s.charAt(i) <= '9') {
//                 // repeat or find ans
//                 int count = s.charAt(i)-'0';
//                 if(str.length()*count >= k) {
//                     int minIndex = k%str.length();
//                     return Character.toString(str.charAt((minIndex-1+str.length())%str.length()));
//                 } 
//                 String rep = str.toString();
//                 for(int j = 1; j < count; j++) str.append(rep);
//             } else {
//                 str.append(s.charAt(i));
//             }
//         }

//         return Character.toString(str.charAt(k-1));
//     }
// }