class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        // kahn's algo
        int[] indegree = new int[n];

        for(int i = 0; i < n; i++) {
            if(leftChild[i] != -1)
                indegree[leftChild[i]]++;
            if(rightChild[i] != -1)
                indegree[rightChild[i]]++;
        }

        Queue<Integer> q = new LinkedList();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 2) return false;
            if(indegree[i] == 0) q.add(i);
        }

        int visited = 0;
        
        if(q.size() > 1) return false;

        while(q.size() > 0) {
            int i = q.poll();
            visited++;

            // left
            if(leftChild[i] != -1) {
                indegree[leftChild[i]]--;
                if(indegree[leftChild[i]] == 0) q.add(leftChild[i]);
            }

            if(rightChild[i] != -1) {
                indegree[rightChild[i]]--;
                if(indegree[rightChild[i]] == 0) q.add(rightChild[i]);
            }
        }

        return visited == n;
    }
}