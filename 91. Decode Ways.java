class Solution {
    Integer[] cache = null;
    public int numDecodings(String s) {
        char[] arr = s.toCharArray();
        cache = new Integer[arr.length];
        return ways(0, arr);
    }

    private int ways(int i, char[] arr) {
        if(i == arr.length) return 1;
        if(arr[i] == '0') return 0;

        if(cache[i] != null) return cache[i];

        //take one
        int way = ways(i+1, arr);

        //if possible take 2
        if((i+1 < arr.length) && ((arr[i] == '1') || (arr[i] == '2' && arr[i+1] < '7'))){
            way += ways(i+2, arr);
        }

        return cache[i] = way;
    }
}