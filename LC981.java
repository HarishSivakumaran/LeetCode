// 981. Time Based Key-Value Store
// // 

class TimeMap {

    HashMap<String, List<Pair<Integer, String>>> hm = new HashMap<>();

    public TimeMap() {    
        
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair<Integer, String>> lP = null;
        if(this.hm.containsKey(key)){
            lP = this.hm.get(key);
            lP.add(new Pair(timestamp, value));            
        }else{    
            lP = new ArrayList<>();
            lP.add(new Pair(timestamp, value));    
            this.hm.put(key, lP);
        }

        
    }
    
    public String get(String key, int timestamp) {
        if(!this.hm.containsKey(key)) return "";
        
        List<Pair<Integer, String>> keys = this.hm.get(key); 

        int l = 0, r = keys.size()-1;

        while(l<r){
            int m = l + (r-l+1)/2;
            if(keys.get(m).getKey() > timestamp){
                r = m - 1;
            }else{
                l = m;
            }
        }

        return keys.get(l).getKey() <= timestamp ?keys.get(l).getValue() : "";

    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */