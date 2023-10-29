class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int req = 1, states = (minutesToTest/minutesToDie)+1;
        while(Math.pow(states, req) < buckets) req++;
        return req;
    }
}

/*

class Solution {
    public int poorPigs(int buckets, int minutesToDie, int tot) {
        int l = 1, r = buckets, m = 0;
        while(l <= r) {
            m = l + (r-l)/2;
            if(possible(buckets, m, minutesToDie, tot)) {
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return l;
    }

    private boolean possible(int buckets, int n, int minutesToDie, int tot) {
        int rounds = 0;

        while(buckets > 0) {
            rounds++;
            buckets -= Math.pow(2, n);
        }
        return rounds*minutesToDie <= tot;
    }
}
 */