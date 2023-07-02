class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        int max = -1;

        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i)-'a']++;
            max = Math.max(max, count[s.charAt(i)-'a']);
        }

        //min. required > available
        if(max-1 > s.length()-max) return "";
        if(max == 1) return s;

        char[] out = new char[s.length()];
        // char, count
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> b[1]-a[1]);
        for(int i = 0; i < 26; i++){
            if(count[i] > 0) pq.add(new int[]{i, count[i]});
        }

        int start = 0, jump = Math.max(2, s.length()/max), i = start;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            while(curr[1] > 0){
                out[i] = (char)(curr[0]+'a');
                i += jump;
                curr[1]--;
                if(i >= s.length()){
                    start++;
                    i = start;
                }
            }
        }

        return new String(out);


    }
}