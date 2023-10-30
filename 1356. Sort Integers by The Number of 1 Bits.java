class Solution {
    public int[] sortByBits(int[] arr) {
        List<Integer> list = new ArrayList(arr.length);
        for(int n : arr)list.add(n);
        Collections.sort(list, 
        (a, b) -> {
            int t1 = a, t2 = b, c1 = 0, c2 = 0;
            while(t1 > 0){
                c1++;
                t1 &= (t1-1);
            }

            while(t2 > 0){
                c2++;
                t2 &= (t2-1);
            }

            if(c1 == c2) return a-b;
            return c1-c2;
        }) ;
        for(int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        return arr; 
    }
}