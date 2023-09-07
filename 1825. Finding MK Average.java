class MKAverage {
    Queue<Integer> q = new LinkedList();
    int m = 0, k = 0, countTop = 0, countMid = 0, countBot = 0;
    long midSum = 0;
    TreeMap<Integer, Integer> top = new TreeMap(), 
        mid = new TreeMap(), bot = new TreeMap();

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
    }
    
    public void addElement(int num) {
        q.add(num);

        if(q.size() > m) {
            int val = q.poll();
            if(top.containsKey(val)) {
                remove(top, val);
                countTop--;
            } else if(mid.containsKey(val)) {
                remove(mid, val);
                midSum -= val;
                countMid--;
            } else {
                remove(bot, val);
                countBot--;
            }
        }
        add(mid, num);
        midSum += num;
        countMid++;
        balance();
    }

    private void balance() {
        // top
        if(countTop < k && !mid.isEmpty()) {
            midSum -= mid.lastKey();
            add(top, remove(mid, mid.lastKey()));
            countTop++;
        }

        if(mid.size() > 0 && top.size() > 0 && top.firstKey() < mid.lastKey()) {
            int val = remove(top, top.firstKey());
            int midVal = remove(mid, mid.lastKey());
            midSum -= midVal;
            midSum += val;
            add(mid, val);
            add(top, midVal);
        }


        //bottom

        if(countBot < k && mid.size() > 0) {
            midSum -= mid.firstKey();
            add(bot, remove(mid, mid.firstKey()));
            countBot++;
        }
        if(mid.size() > 0 && bot.size() > 0 && bot.lastKey() > mid.firstKey()) {
            int val = remove(mid, mid.firstKey());
            int botVal = remove(bot, bot.lastKey());
            midSum += botVal;
            midSum -= val;
            add(bot, val);
            add(mid, botVal);
        }
    }

    private int remove(TreeMap<Integer, Integer> map, int val) {
        map.put(val, map.getOrDefault(val, 0)-1);
        if(map.get(val) == 0) map.remove(val);
        return val;
    }

     private int add(TreeMap<Integer, Integer> map, int val) {
        map.put(val, map.getOrDefault(val, 0)+1);
        return val;
    }
    
    public int calculateMKAverage() {
        return q.size() == m ? (int)(midSum/(m-(2*k))) : -1;
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */