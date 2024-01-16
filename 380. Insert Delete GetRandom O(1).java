class RandomizedSet {
    HashMap<Integer, Integer> index = new HashMap();
    List<Integer> list = new ArrayList(100000);
    Random ran = new Random();
    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        if(index.containsKey(val)) return false;
        index.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!index.containsKey(val)) return false;
        int lastVal = list.get(list.size()-1);
        list.set(index.get(val), lastVal);
        index.put(lastVal, index.get(val));
        index.remove(val);
        list.remove(list.size()-1);
        return true;
    }
    
    public int getRandom() {
        int i = ran.nextInt(list.size());
        return list.get(i);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */