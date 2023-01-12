// 1871. Jump Game VII

class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        if(s.charAt(s.length()-1) == '1') return false;

        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        int farthest = 0;

        while(q.size() > 0){
            int len = q.size();

            for(int i = 0; i < len; i++){
                int curr = q.poll();
                if(s.charAt(curr) != '0') continue;
                int min = curr + minJump;
                int max = curr + maxJump;
                if(min < s.length() && max >= s.length()-1) return true;
                for(int j = Math.max(min, farthest+1); j <= Math.max(max, farthest+1); j++){
                    if(j < s.length() && s.charAt(j) == '0') q.add(j);
                }

                farthest = Math.max(max, farthest);
            }
        }



        return false;

        
    }
}