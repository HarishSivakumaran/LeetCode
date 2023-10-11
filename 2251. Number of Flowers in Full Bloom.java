class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        TreeMap<Integer, Integer> prefSetup = new TreeMap();
        int min = Integer.MAX_VALUE, max = 0;

        for(int[] f : flowers) {
            min = Math.min(min, f[0]);
            max = Math.max(max, f[1]);
            prefSetup.put(f[0], prefSetup.getOrDefault(f[0], 0)+1);
            prefSetup.put(f[1]+1, prefSetup.getOrDefault(f[1]+1, 0)-1);
        }
        ArrayList<Integer> count = new ArrayList(prefSetup.size());
        ArrayList<Integer> index = new ArrayList(prefSetup.size());
        int prev = 0;

        for(Map.Entry<Integer, Integer> entry : prefSetup.entrySet()) {
            index.add(entry.getKey());
            prev += entry.getValue();
            count.add(prev);
        }

        int[] out = new int[people.length];

        for(int i = 0; i < people.length; i++) {
            int in = binarySearch(index, people[i]);
            out[i] = in >= 0 && in < count.size() ? count.get(in) : 0;
        }

        return out;
        
    }

    private int binarySearch(List<Integer> list, int p) {
        int l = 0, r = list.size()-1, m = 0;

        while(l <= r) {
            m = l + (r-l)/2;
            if(list.get(m) == p) return m;
            if(list.get(m) > p) {
                r = m-1;
            } else {
                l = m+1;
            }
        }

        return r;
    }
}

/*
class Solution {
    HashMap<Integer, Integer> cache = new HashMap();
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        Arrays.sort(flowers, (a, b) -> {
            if(a[0] == b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        int[] out = new int[people.length];

        for(int i = 0; i < people.length; i++) {
            out[i] = getCount(flowers, people[i]);
        }

        return out;
    }

    private int getCount(int[][] flowers, int p) {
        if(cache.containsKey(p)) return cache.get(p);
        // smallest interval containing
        int l = 0, r = flowers.length-1, m = 0;

        while(l <= r) {
            m = l + (r-l)/2;
            if(flowers[m][1] < p) {
                l = m+1;
            } else {
                r = m-1;
            }
        }

        if(l >= flowers.length || p < flowers[l][0] || p > flowers[l][1]) return 0;

        int from = l;
        l = 0;
        r = flowers.length-1;


        // largest interval containing

        while(l <= r) {
            m = l + (r-l)/2;
            if(p < flowers[m][0]) {
                r = m-1;
            } else {
                l = m+1;
            }
        }

        cache.put(p, r-from+1);

        return r-from+1;
    }
}
 */