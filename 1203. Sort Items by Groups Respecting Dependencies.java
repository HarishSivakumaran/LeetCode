class Solution {
    public int[] sortItems(int nums, int mem, int[] group, List<List<Integer>> beforeItems) {
        HashMap<Integer, Node> itemMap = new HashMap();
        HashMap<Node, HashSet<Integer>> depList = new HashMap();
        HashMap<Integer, HashSet<Integer>> groups = new HashMap();
        // pre work
        for(int i = 0; i < nums; i++) {
            groups.computeIfAbsent(group[i], v -> new HashSet()).add(i);
            if(!itemMap.containsKey(i))
                itemMap.put(i, new Node(i));
            if(beforeItems.get(i).size() > 0) {
                for(int before : beforeItems.get(i)) {
                    if(!itemMap.containsKey(before))
                        itemMap.put(before, new Node(before));
                    depList.computeIfAbsent(itemMap.get(before), v -> new HashSet()).add(i);
                }
            }
        }
        // kahn's algo for group
        for(Map.Entry<Integer, HashSet<Integer>> entry : groups.entrySet()) {
            if(entry.getKey() == -1) continue;
            HashMap<Integer, Integer> indegree = new HashMap();
            for(int m : entry.getValue()){
                indegree.put(m, indegree.getOrDefault(m, 0));
                if(depList.containsKey(itemMap.get(m))){
                    for(int next : depList.get(itemMap.get(m))){
                        if(entry.getValue().contains(next)) //indegree only for the group
                            indegree.put(next, indegree.getOrDefault(next, 0)+1);
                    }
                }
            }

            Node groupedNode = new Node();
            Queue<Integer> q = new LinkedList();
            HashSet<Integer> groupDep = new HashSet();
            for(Map.Entry<Integer, Integer> ind : indegree.entrySet()) {
                if(ind.getValue() == 0) q.add(ind.getKey());
            }
            int visited = 0;
            List<Integer> groupedList = new ArrayList();
            while(q.size() > 0){
                int curr = q.poll();
                groupedList.add(curr);
                visited++;
                depList.containsKey(itemMap.get(curr));
                if(depList.containsKey(itemMap.get(curr))) {
                    for(int next : depList.get(itemMap.get(curr))){
                        if(entry.getValue().contains(next)){//indegree only for the group
                            indegree.put(next, indegree.get(next)-1);
                            if(indegree.get(next) == 0) {
                                q.add(next);
                            }
                        }
                    }
                        depList.get(itemMap.get(curr)).removeAll(entry.getValue());
                        groupDep.addAll(depList.get(itemMap.get(curr)));
                        depList.remove(itemMap.get(curr));
                }
                itemMap.put(curr, groupedNode);
            }
            if(visited != entry.getValue().size()) return new int[]{};
            depList.put(groupedNode, groupDep);
            groupedNode.val = groupedList;
        }


        //  Kahn's finale
        HashMap<Node, Integer> indegree = new HashMap();
        for(Map.Entry<Integer, Node> entry : itemMap.entrySet()){
            indegree.put(entry.getValue(), 0);
        }

        for(Map.Entry<Node, HashSet<Integer>> entry : depList.entrySet()){
            for(int n : entry.getValue()) {
                indegree.put(itemMap.get(n), indegree.getOrDefault(itemMap.get(n), 0)+1);
            }
        }
        List<Integer> out = new ArrayList();
        Queue<Node> q = new LinkedList();
        for(Map.Entry<Node, Integer> entry : indegree.entrySet()){
            if(entry.getValue() == 0)
                q.add(entry.getKey());
        }

        int visited = 0;

        while(q.size() > 0) {
            Node curr = q.poll();
            visited++;
            out.addAll(curr.val);
            if(depList.containsKey(curr)) {
                for(int n : depList.get(curr)) {
                    indegree.put(itemMap.get(n), indegree.get(itemMap.get(n))-1);
                    if(indegree.get(itemMap.get(n)) == 0) q.add(itemMap.get(n));
                }
            }
        }

        if(visited != indegree.size()) return new int[] {};
        int[] finalOut = new int[out.size()];
        for(int i = 0; i < out.size(); i++) finalOut[i] = out.get(i);

        return finalOut;
    }
}

class Node{
    List<Integer> val = new ArrayList();
    Node(){}
    Node(int v) {
        val.add(v);
    }
}