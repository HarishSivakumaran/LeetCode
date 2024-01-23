class Solution {
    int max = -1;
    public int maxLength(List<String> list) {
      int[][] arr = new int[list.size()][26];
      for(int i= 0; i < arr.length; i++) {
          getCount(list.get(i), arr[i]);
        }
      getMax(arr, 0, new int[26]);

      return max;
    }

    private void getMax(int[][] arr, int i, int[] now) {
        if(i >= arr.length) {
            int sum = 0;
            for(int n : now) sum += n;
            if(sum > max) max = sum;

            return;
        }

        // add
        if(isEdge(now, arr[i])) {
            for(int j = 0; j < 26; j++) now[j] += arr[i][j];
            getMax(arr, i+1, now);
            for(int j = 0; j < 26; j++) now[j] -= arr[i][j];
        }


        // don't add
        getMax(arr, i+1, now);

    }


    private void getCount(String a, int[] count) {
        boolean rep = false;
        for(int i = 0; i < a.length(); i++) {
            count[a.charAt(i)-'a']++;
            rep |= (count[a.charAt(i)-'a'] > 1);
            if(rep) 
                {for(int j = 0; j < 26; j++) count[j] = 0; break;}
        }
        

    }


    private boolean isEdge(int[] a, int[] b) {
        for(int i = 0; i < 26; i++) {
            if(a[i] > 0 && b[i] > 0) return false;
        }

        return true;
    }
}