class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>>[] groups = new ArrayList[groupSizes.length+1];
        for(int i = 0; i < groupSizes.length; i++) {
            if(groups[groupSizes[i]] == null ||
            groups[groupSizes[i]]
            .get(groups[groupSizes[i]].size()-1).size() == groupSizes[i]
             ) {
                if(groups[groupSizes[i]] == null) 
                    groups[groupSizes[i]] = new ArrayList();
                groups[groupSizes[i]].add(new ArrayList());
             }

            groups[groupSizes[i]]
            .get(groups[groupSizes[i]].size()-1).add(i);          
        }
        List<List<Integer>> out = new ArrayList();
        for(List<List<Integer>> list : groups) {
            if(list == null) continue;
            out.addAll(list);
        }

        return out;
    }
}