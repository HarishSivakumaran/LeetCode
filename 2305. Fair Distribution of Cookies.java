class Solution {
    int max = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        if(k == cookies.length){
            int m = -1;
            for(int c : cookies){
                m = Math.max(c, m);
            }
            return m;
        }
        List<List<Integer>> cBags = new ArrayList();
        while(k > 0){
            k--;
            cBags.add(new ArrayList());
        }

        getMaxFairness(cookies, 0, cBags);
        return max;
    }

    private void getMaxFairness(int[] c, int index, List<List<Integer>> cBags) {
        if(index >= c.length) {
            int lMax = -1;
            for(List<Integer> l : cBags){
                int s = 0;
                for(int n : l) s += n;
                lMax = Math.max(lMax, s);
            }
            max = Math.min(max, lMax);
            return;
        }

        for(List<Integer> l : cBags){
            l.add(c[index]);
            getMaxFairness(c, index+1, cBags);
            l.remove(l.size()-1);
        }

    }
}