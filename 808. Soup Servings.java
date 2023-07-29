class Solution {
    HashMap<Integer, HashMap<Integer,Double>> cache = new HashMap();
    public double soupServings(int n) {
        int maxPossibleServing = (int) Math.ceil(n/25.0); // considering 25 ml per serving
        for(int k = 1; k <= maxPossibleServing; k++){
            if(dfs(k, k) > 1-1e-5) return 1.00;
        }
        return dfs(maxPossibleServing, maxPossibleServing);
    }

    private double dfs(int a, int b) {
        if(a == 0) {
            if(b > 0) return 1;
            if(b == 0) return 0.5;
        }

        if(b == 0) return 0;

        if(cache.containsKey(a) && cache.get(a).containsKey(b) ) 
            return cache.get(a).get(b);

        double prob = 0.0;

        prob += (0.25) * dfs(Math.max(0, a-4), b);
        prob += (0.25) * dfs(Math.max(0, a-3), Math.max(0, b-1));
        prob += (0.25) * dfs(Math.max(0, a-2), Math.max(0, b-2));
        prob += (0.25) * dfs(Math.max(0, a-1), Math.max(0, b-3));

        cache.computeIfAbsent(a, v -> new HashMap()).put(b, prob);

        return prob;
    }
}

// class Solution {
//     public double soupServings(int n) {
//         Queue<double[]> q = new LinkedList();
//         q.add(new double[]{n, n, 1.0});

//         double out = 0.00;

//         while(q.size() > 0) {
//             int len = q.size();
//             HashMap<String, double[]> added = new HashMap();
//             for(int k = 0; k < len; k++) {
//                 double[] state = q.poll();
//                 if(state[0] == 0.00){
//                     if(state[1] == 0.00) out += (0.5)*state[2];
//                     if(state[1] > 0.00) out += state[2];
//                     continue;
//                 }

//                 if(state[1] == 0) continue;

//                 for(int i = 0; i < 4; i++){
//                     double[] next = performOperations(state, i);
//                     if(added.containsKey(next[0] + "-" + next[1])) {
//                         added.get(next[0] + "-" + next[1])[2] += next[2];
//                     } else {
//                         q.add(next);
//                         added.put(next[0] + "-" + next[1], next);                  
//                     }
//                 }
//             }
//         }

//         return out;
//     }

//     private double[] performOperations(double[] prevState, int opType) {
//         double[] newState = {0.00, 0.00, 0.00}; //A, B, prob
//         switch(opType){
//             case 0: 
//                 newState[0] = Math.max(0, prevState[0]-100);
//                 newState[1] = prevState[1];
//                 newState[2] = prevState[2]*((double)1/4);
//                 break;
            
//             case 1: 
//                 newState[0] = Math.max(0, prevState[0]-75);
//                 newState[1] = Math.max(0, prevState[1]-25);
//                 newState[2] = prevState[2]*((double)1/4);
//                 break;
            
//             case 2 :
//                 newState[0] = Math.max(0, prevState[0]-50);
//                 newState[1] = Math.max(0, prevState[1]-50);
//                 newState[2] = prevState[2]*((double)1/4);
//                 break;
            
//             case 3 :
//                 newState[0] = Math.max(0, prevState[0]-25);
//                 newState[1] = Math.max(0, prevState[1]-75);
//                 newState[2] = prevState[2]*((double)1/4);
//                 break;
//         };

//         return newState;
//     }
// }