// 460. LFU Cache

class LFUCache {
    private int capacity;
    private HashMap<Integer, int[]> cache;
    private HashMap<Integer, LinkedHashSet<Integer>> freq;
    private int minF;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap();
        freq = new HashMap();
        minF = 0;        
    }

    public void updateFreq(int key, int toFreq){
        freq.computeIfAbsent(toFreq, v -> new LinkedHashSet()).add(key);
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;

        int[] f_v = cache.get(key);
        Set<Integer> keys = freq.get(f_v[0]);
        keys.remove(key);

        if(minF == f_v[0] && keys.size() == 0) minF++;

        f_v[0]++;
        updateFreq(key, f_v[0]);

        return f_v[1];
                        
    }
    
    public void put(int key, int value) {
        
        if(this.capacity <= 0) return;

        if(cache.containsKey(key)){
            int[] f_v = cache.get(key);
            f_v[1] = value;
            get(key);
            return;
        }

        if(cache.size() == this.capacity){
            Set<Integer> keys = freq.get(minF);
            int keyForDel = keys.iterator().next();
            cache.remove(keyForDel);
            keys.remove(keyForDel);
        }
        
        minF = 1;
        cache.put(key, new int[]{minF,value});
        updateFreq(key,1);
  
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */