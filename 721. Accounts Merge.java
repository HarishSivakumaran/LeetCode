class Solution {
    HashSet<String>[] mailPerAcc = null;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int[] rank = new int[accounts.size()];
        int[] parent = new int[accounts.size()];
        mailPerAcc = new HashSet[accounts.size()];

        for(int i = 0; i < accounts.size(); i++){
            parent[i] = i;
            rank[i] = i;
            mailPerAcc[i] = new HashSet();
        }

        for(int i = 0; i < accounts.size(); i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                mailPerAcc[i].add(accounts.get(i).get(j));
            }
        }
     

        for(int i = 0; i < accounts.size(); i++){
            for(int j = 0; j < accounts.size(); j++){
                if(i == j || !edgeExists(accounts, i, j)) continue;
                // check if edge exists
                int r1 = getRoot(i, parent);
                int r2 = getRoot(j, parent);
                if(r1 == r2) continue; //already connected
                if(rank[r1] > rank[r2]){
                    rank[r1] += rank[r2];
                    parent[r2] = r1;                
                } else {
                    rank[r2] += rank[r1];
                    parent[r1] = r2;
                }
            }
        }

        for(int i = 0; i < parent.length; i++){
            getRoot(i, parent);
        }

        for(int i = 0; i < parent.length; i++){
            getRoot(i, parent);
        }

        HashMap<Integer, HashSet<String>> acc = new HashMap();
        List<List<String>> out = new ArrayList();

        for(int i = 0; i < parent.length; i++){
            acc.computeIfAbsent(parent[i], v -> new HashSet())
            .addAll(mailPerAcc[i]);
            acc.get(parent[i]).addAll(mailPerAcc[parent[i]]);
        }

        for(Map.Entry<Integer, HashSet<String>> entry : acc.entrySet()){
            List<String> l = new ArrayList();
            l.add(accounts.get(entry.getKey()).get(0)); // added name
            List<String> mail = new ArrayList(entry.getValue());
            Collections.sort(mail, (a,b)->a.compareTo(b));
            l.addAll(mail);
            out.add(l);
        }
        return out;
    }

    public int getRoot(int i, int[] parent){
        while(parent[i] != i){
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    public boolean edgeExists(List<List<String>> accounts, int r, int c){
        for(int i = 1; i < accounts.get(r).size(); i++){
                if(mailPerAcc[c].contains(accounts.get(r).get(i))){
                    return true;
            }
        }

        return false;
    }
}