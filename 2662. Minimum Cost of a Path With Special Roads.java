class Solution {
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        if(start[0] == target[0] && start[1] == target[1]) return 0;
        HashMap<String, Integer> nodes = new HashMap();
        List<Edge> edges = new ArrayList();
        buildEdges(start, target, specialRoads, nodes, edges);

        int[] dist = new int[nodes.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        // bellman
        for(int i = 0; i < nodes.size()-1; i++) {
            boolean changes = false;
            for(Edge e : edges) {
                if(dist[nodes.get(e.from)] != Integer.MAX_VALUE &&
                    dist[nodes.get(e.from)] + e.dist < dist[nodes.get(e.to)]
                ) {
                    dist[nodes.get(e.to)] = dist[nodes.get(e.from)] + e.dist;
                    changes = true;
                }
            }
            if(!changes) break;
        }


        return dist[nodes.get(target[0]+"#"+target[1])];
        

    }

    private void buildEdges(int[] start, int[] target, int[][] specialRoads,
      HashMap<String, Integer> nodes, List<Edge> edges) {
        int i = 0;
        nodes.put(start[0]+"#"+start[1], i++);
        nodes.put(target[0]+"#"+target[1], i++);
        HashMap<String, HashSet<String>> paired = new HashMap();
        for(int[] r : specialRoads) {
            if(!nodes.containsKey(r[0]+"#"+r[1]))
                nodes.put(r[0]+"#"+r[1], i++);
            if(!nodes.containsKey(r[2]+"#"+r[3]))
                nodes.put(r[2]+"#"+r[3], i++);
            int dist = Math.abs(r[0]-r[2]) + Math.abs(r[1]-r[3]);
            edges.add(new Edge(r[0]+"#"+r[1], r[2]+"#"+r[3], Math.min(dist, r[4])));
            paired.computeIfAbsent(r[0]+"#"+r[1], v -> new HashSet()).add(r[2]+"#"+r[3]);
        }
        for(Map.Entry<String, Integer> node : nodes.entrySet()) {
            for(Map.Entry<String, Integer> others : nodes.entrySet()) {
                if(others == node) continue;
                String[] n1 = node.getKey().split("#");
                String[] n2 = others.getKey().split("#");
                int dist = Math.abs(Integer.parseInt(n1[0])-Integer.parseInt(n2[0])) + 
                        Math.abs(Integer.parseInt(n1[1])-Integer.parseInt(n2[1]));

                if(!paired.containsKey(others.getKey()) ||!paired.get(others.getKey()).contains(node.getKey())){
                    edges.add(new Edge(others.getKey(), node.getKey(), dist));   
                    paired.computeIfAbsent(others.getKey(), v -> new HashSet()).add(node.getKey());
                }

                if(!paired.containsKey(node.getKey()) || !paired.get(node.getKey()).contains(others.getKey())){
                    edges.add(new Edge(node.getKey(), others.getKey(), dist));   
                    paired.computeIfAbsent(node.getKey(), v -> new HashSet()).add(others.getKey());
                }

            }
        }
    }
        
}

class Edge{
    String from;
    String to;
    int dist;

    Edge(String f, String t, int d) {
        this.from = f;
        this.to = t;
        this.dist = d;
    }

    @Override
    public String toString(){
        return this.from + "-" + this.to +"-" + this.dist;
    }
}