class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] a = new int[26];
        List<Integer> b = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
          a[s.charAt(i)-'a'] = i;
        }

        int size = 0, end = -1;

        for(int i = 0; i < s.length(); i++){
          end = end >= a[s.charAt(i)-'a'] ? end : a[s.charAt(i)-'a'];
           size++;
          if(i == end){
              b.add(size);
              size = 0;
          }
          a[s.charAt(i)-'a'] = i;
        }

        return b;

    }
}