// 316. Remove Duplicate Letters

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] visited = new boolean[26];
        Stack<Character> st = new Stack();

        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i)-'a']++;
        }

        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i)-'a']--;

            if(visited[s.charAt(i)-'a']) continue;

            while(st.size() > 0 && (st.peek() - s.charAt(i) > 0) && freq[st.peek()-'a'] > 0){
                visited[st.peek()-'a'] = false;
                st.pop();
            }

            st.push(s.charAt(i));
            visited[s.charAt(i)-'a'] = true;
        }

        StringBuilder str = new StringBuilder("");
        
        for(Character c : st){
            str.append(c);
        }

        return str.toString();
        
    }
}