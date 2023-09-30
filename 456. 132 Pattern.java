class Solution {
    public boolean find132pattern(int[] nums) {
        TreeMap<Integer, Integer> sortedTail = new TreeMap();
        TreeMap<Integer, Integer> sortedHead = new TreeMap();
        for(int n : nums) sortedTail.put(n, sortedTail.getOrDefault(n, 0)+1);

        for(int i = 0; i < nums.length; i++) {
            // remove curr from tail
            if(sortedTail.get(nums[i]) == 1) {
                sortedTail.remove(nums[i]);
            } else {
                sortedTail.put(nums[i], sortedTail.get(nums[i])-1);
            }

            //check if there is anything in head smaller than curr
            if(sortedHead.size() > 0 && sortedHead.firstKey() < nums[i]) {
                // binary search
                if(sortedTail.size() > 0 && 
                   sortedTail.lastKey() > sortedHead.firstKey() &&
                   sortedTail.firstKey() < nums[i]
                ){
                   int key = sortedTail.floorKey(nums[i]-1);
                   if(key > sortedHead.firstKey()) return true;
                }
            }

            // add curr to head
            sortedHead.put(nums[i], sortedHead.getOrDefault(nums[i], 0)+1);
        }

        return false;
    }
}