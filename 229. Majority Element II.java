class Solution {
    public List<Integer> majorityElement(int[] nums) {
     List<Integer> out = new ArrayList(nums.length);
     int[] first = {0, 0}, sec = {1, 0}; //num, count

     for(int n : nums) {
         if(n == first[0]) {
             first[1]++;
         } else if(n == sec[0]) {
             sec[1]++;
         } else if(first[1] == 0) {
             first[0] = n;
             first[1] = 1;
         } else if(sec[1] == 0) {
             sec[0] = n;
             sec[1] = 1;
         } else {
             first[1]--;
             sec[1]--;
         }
     }
     
     first[1] = 0; sec[1] = 0;
     for(int n : nums) {
         if(n == first[0]) first[1]++;
         if(n == sec[0]) sec[1]++;
     }

     if(first[1] > nums.length/3) out.add(first[0]);
     if(sec[1] > nums.length/3) out.add(sec[0]);

     return out;
    }
}