// 2244. Minimum Rounds to Complete All Tasks

class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int max = 0;

        for(int t : tasks){
            hm.put(t, hm.getOrDefault(t, 0)+1);
            max = Math.max(max, hm.get(t));
        } 

        int[] change = {2,3};

        int[] count = new int[max+1];   
        Arrays.fill(count, max+1);
        count[0] = 0;  

        for(int i = 1; i <= max; i++){
            for(int c : change){
                if(i >= c)
                 count[i] = Math.min(count[i],1+count[i-c]);
            }
        }

        int min = 0;

        for(int co : hm.values()){
            if(count[co] == max+1) return -1;
            min += count[co];

        }

        return min;


    }
}