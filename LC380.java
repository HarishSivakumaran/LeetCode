// 380. Insert Delete GetRandom O(1)
class RandomizedSet {

    HashMap<Integer, Integer> hm;
    List<Integer> list;
    java.util.Random rand = new java.util.Random();


    public RandomizedSet() {
        hm = new HashMap();    
        list = new ArrayList();   
    }
    
    public boolean insert(int val) {
        if(hm.containsKey(val)){
            return false;
        }
        hm.put(val, list.size());
        this.list.add(val);
        return true;
        
    }
    
    public boolean remove(int val) {
        if(hm.containsKey(val)){
            int index = hm.get(val);
            if(index < list.size()-1){
               int lastVal = list.get(list.size()-1);
               hm.put(lastVal, index);
               list.set(index, lastVal);
               index = list.size()-1;
            }
            hm.remove(val);
            list.remove(index);
            return true;
        }
        return false;       
    }
    
    public int getRandom() {
        
        return list.get(rand.nextInt(list.size()));
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */