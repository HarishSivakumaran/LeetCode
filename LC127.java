// 127. Word Ladder

class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        boolean lastWordMatch = false;
        HashSet<String> visited = new HashSet<>();
        HashMap<String, List<String>> hm = new HashMap<>();
        
        for(String word : wordList){
            hm.put(word, new ArrayList<>());
            if(endWord.equals(word)){
                lastWordMatch = true;
            }
        }

        if(!lastWordMatch) return 0;   

        hm.put(beginWord, new ArrayList<>());

        //create adj .list
        for(Map.Entry<String, List<String>> entry : hm.entrySet()){
            String curr = entry.getKey();
            List<String> adjList = entry.getValue();
            for(String w : wordList){
                if(!curr.equals(w) && this.checkIfOneCharDiff(w, curr)){
                   adjList.add(w);
                }
             }
        }

        Queue<String> q = new LinkedList();
        q.add(beginWord);
        int level = 1;
        visited.add(beginWord);

        while(q.size() > 0){
            int l = q.size();
            level++;
            for(int i = 0; i < l; i++){
                String curr = q.poll();
                List<String> list = hm.get(curr);

                for(String adj : list){
                    
                    if(adj.equals(endWord)){
                        return level;
                    }

                    if(visited.contains(adj)) continue;

                    visited.add(adj);

                    q.add(adj);
                }
            }
        }

        return 0;
        
    }

    public boolean checkIfOneCharDiff(String a, String b){
        int diff = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) diff++;
            if(diff > 1) return false;
        }
        return true;
    }
}