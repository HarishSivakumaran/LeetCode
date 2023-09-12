class Solution {
    public int minDeletions(String s) {
        int[] count = new int[26];
        int minDel = 0, max = 0;
        HashMap<Integer, Integer> sameFreq = new HashMap();
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;
            max = Math.max(max, count[s.charAt(i)-'a']);
        }

        for(int i = 0; i < 26; i++) {
            if(count[i] > 0) {
                sameFreq.put(count[i], sameFreq.getOrDefault(count[i], 0)+1);
            }
        }
        List<Integer> availableSlots = new ArrayList(max);
        for(int freq = 1; freq <= max; freq++) {
            if(!sameFreq.containsKey(freq)) {
                availableSlots.add(freq);
            } else {
                int excess = sameFreq.get(freq)-1;
                for(int i = availableSlots.size()-1;
                 excess > 0 && availableSlots.size() > 0 && i >= 0;
                 i--) {
                    minDel += (freq-availableSlots.get(i));
                    excess--;
                    availableSlots.remove(i);
                }
                //delete the entire excess
                minDel += excess*freq;
            }
        }

        return minDel;
    }
}