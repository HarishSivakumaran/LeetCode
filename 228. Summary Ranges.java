class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<Integer> l = new ArrayList();
        if(nums.length == 0) return new ArrayList<String>();
        List<List<Integer>> list = new ArrayList();
        l.add(nums[0]);
        list.add(l);

        for(int i = 1; i < nums.length; i++){
            List<Integer> curr = list.get(list.size()-1);
            if(nums[i] == curr.get(curr.size()-1)+1){
                curr.add(nums[i]);
            }else{
                l = new ArrayList();
                l.add(nums[i]);
                list.add(l);
            }
        }

        List<String> out = new ArrayList();

        for(List<Integer> i : list){
            out.add(i.get(0) + ((i.size()>1) ? ("->" + i.get(i.size()-1)) : ""));
        }

        return out;
    }
}