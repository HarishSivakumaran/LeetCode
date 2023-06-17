class Solution {
    int ans = 0;
    HashMap<String, Integer> cache = null;
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        cache = new HashMap();
        int val = makeIncreasing(arr1, arr2, -1, 0);
        return val > 3000 ? -1 : val;
    }

    public int makeIncreasing(int[] arr1, int[] arr2, int prev, int index) {
        if(index >= arr1.length) return 0;
        String key = index + "&" + prev;
        if(cache.containsKey(key)) return cache.get(key);
        int posOpt = getLeastGreaterNumber(arr2, prev);

        if(arr1[index] > prev ){
            int v1 = makeIncreasing(arr1, arr2, arr1[index], index+1);
            if(posOpt < arr2.length){
                cache.put(key,  Math.min(v1, 1 + makeIncreasing(arr1, arr2, arr2[posOpt], index+1)));
                return cache.get(key);
            }
            cache.put(key, v1);
        }
        else{
           if(posOpt == arr2.length) return 5000;
           cache.put(key, 1 + makeIncreasing(arr1, arr2, arr2[posOpt], index+1));
        }

        return cache.get(key);
    }

    public int getLeastGreaterNumber(int[] arr2, int val){
        int l = 0, r = arr2.length-1;

        while(l <= r){
            int m = l + (r-l)/2;

            if(arr2[m] > val){
                r = m-1;
            }else{
                l = m+1;
            }
        }
        return l;
    }
}