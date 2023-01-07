// 1851. Minimum Interval to Include Each Query

class Solution {

    class IntervalComparator implements Comparator<int[]> {

    public static int getSize(int[] interval) {
        return (interval[1] - interval[0] + 1);
    }

    @Override
    public int compare(int[] o1, int[] o2) {
        int o1Size = getSize(o1), o2Size = getSize(o2);
        if (o1Size != o2Size) {
            return (o1Size - o2Size);
        }
        return (o1[1] - o2[1]);
        }
    }   

    public int[] minInterval(int[][] intervals, int[] queries) {

       Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
       int[] out = new int[queries.length];      
       HashMap<Integer, List<Integer>> pos = new HashMap<>();

       for(int i = 0; i < queries.length; i++){
           if(!pos.containsKey(queries[i])){
               pos.put(queries[i], new ArrayList());
           }
           pos.get(queries[i]).add(i);
       }

       Arrays.sort(queries);

       Arrays.fill(out, -1);

       Comparator<int[]> comparator = new IntervalComparator();

       PriorityQueue<int[]> pq = new PriorityQueue<>(comparator);

       int i = 0;

       for(int j = 0; j < queries.length; j++){
          
           int q = queries[j];

           while(i < intervals.length && intervals[i][0] <= q ){
               pq.add(intervals[i]);
               i++;
           }

           while(pq.size() > 0 && pq.peek()[1] < q){
               pq.poll();
           }

           if(pq.size() != 0){ // some intervals matched
           int[] top = pq.peek();
           out[j] = top[1]-top[0]+1;      

           }
           
        }

        int[] out1 = new int[queries.length];    

        for(i = 0; i < queries.length; i++){
            int q1 = queries[i];
            List<Integer> p = pos.get(q1);
            for(int k : p){
                out1[k] = out[i];
            }
        }

        return out1;
           
       }

       

        // int i = 0;

        // for(int q : queries){
        //     for(int[] interval : intervals){
        //         if(q >= interval[0] && q <= interval[1] ){
        //             out[i] = interval[1]  - interval[0]  + 1;
        //             break;
        //         }
        //         out[i] = -1;
        //     }
        //     i++;
        // }


        
}