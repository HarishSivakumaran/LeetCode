class Solution {
    int ans = 0;
    public int maximumRequests(int n, int[][] requests) {
        int[] state = new int[n];
        getMaxReq(requests,state, 0, 0);
        return ans;
    }
    
    private void getMaxReq(int[][] req, int[] state, int i, int count) {
        if(i >= req.length){
            for(int s : state){
                if(s != 0) return;
            }

            ans = Math.max(ans, count);
            return;
        }

        // accept the request
        state[req[i][0]]--;
        state[req[i][1]]++;
        getMaxReq(req, state, i+1, count+1);

        state[req[i][0]]++;
        state[req[i][1]]--;

        //ignore the request
        getMaxReq(req, state, i+1, count);
    }

}


// class Solution {
//     public int maximumRequests(int n, int[][] requests) {
//         boolean[] served = new boolean[requests.length];
//         HashMap<Integer, List<int[]>> adjList = new HashMap(); //From building -> {{toBuilding, requestIndex}}

//         for(int i = 0; i < requests.length; i++){
//             if(requests[i][0] == requests[i][1]){
//                 served[i] = true;
//                 continue;
//             }
//             adjList.computeIfAbsent(requests[i][0], v -> new ArrayList()).add(new int[]{requests[i][1], i});
//         }
//         for(int i = 0; i < n; i++)checkForCycle(i, served, adjList, -1, new HashSet());
//         int ans = 0;
//         System.out.println(Arrays.toString(served));
//         for(boolean b : served) if(b) ans++;

//         return ans;
//     }
//     // reqId
//     private Node checkForCycle(int currBuild, boolean[] served, HashMap<Integer, List<int[]>> adjList, int request,HashSet<Integer> buildingPath) {

//         if(buildingPath.contains(currBuild)) {
//             Node node = new Node();
//             node.requests = new ArrayList();
//             node.requests.add(request);    
//             node.cycleBegin = currBuild;
//             return node; // found a cycle - all request in this cycle can be served
//         }
//         buildingPath.add(currBuild);
//         boolean s = false;
//         Node out = null;
//         PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> b.requests.size()-a.requests.size());

//         if(adjList.get(currBuild) != null)
//             for(int[] next : adjList.get(currBuild)){
//                 if(!served[next[1]]){
//                     Node temp = checkForCycle(next[0], served, adjList, next[1], buildingPath);
//                     if(temp != null) {
//                         if(temp.cycleBegin == currBuild){
//                             //source
//                             pq.add(temp);
//                             for(int[] n : adjList.get(currBuild)){
//                                 if(!served[n[1]]){
//                                     Node t = checkForCycle(n[0], served, adjList, n[1], buildingPath);
//                                     if(t != null) pq.add(t);
//                                 }
//                             }

//                              while(true) {
//                                 Node curr = pq.poll();
//                                 boolean allNotServed = true;
//                                 for(int r : curr.requests){
//                                     if(served[r]) allNotServed = false;
//                                 }

//                                 if(allNotServed){
//                                     for(int r : curr.requests) served[r] = true;
//                                     break;
//                                 }
//                             }
//                             pq.clear();
//                             continue;
//                         }
//                         if(out != null && out.requests.size() > temp.requests.size()) continue;
//                         out = temp;
//                     }
//                 }
//             }
//         buildingPath.remove(currBuild);
//         if(out != null && out.cycleBegin != -1)out.requests.add(request);


//         return out;
//     }
// }

// class Node{
//     List<Integer> requests;
//     int cycleBegin = -1;
// }