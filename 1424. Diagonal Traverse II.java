class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<List<Integer>> posWise = new ArrayList();
        int count = 0;
        for(int r = 0; r < nums.size(); r++) {
            int pos = 0;
            for(int c = 0; c < nums.get(r).size(); c++) {
                count++;
                pos = r+c;
                while(pos >= posWise.size()) posWise.add(new ArrayList());
                posWise.get(pos).add(nums.get(r).get(c));
            }
        }

        int[] out = new int[count]; int o = 0;
        for(int i = 0; i < posWise.size(); i++) {
            for(int j = posWise.get(i).size()-1; j >=0; j--) {
                out[o++] = posWise.get(i).get(j);
            }
        }
        return out;
    }
}