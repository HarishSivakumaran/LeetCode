// 621. Task Scheduler

class Solution {
    public int leastInterval(char[] tasks, int n) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b - a);
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();

        int[] aChar  = new int[26];

        for(char a: tasks) aChar[a - 'A']++;

        for(int i : aChar){
            if(i > 0)
             pq.add(i);
        }

        int time = 0;

        while(pq.size() != 0 || q.size() != 0  ){
            time++;
            if(pq.size() != 0){
                int v = pq.poll();
                v--;
                if(v > 0)q.add(new Pair(v, time+n));
            }      

            if(q.size() != 0 && q.peek().getValue() == time){
                pq.add(q.poll().getKey());
            }     
        }

        return time;

    }      