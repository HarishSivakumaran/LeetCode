class Solution {
    public String pushDominoes(String dominoes) {
        char[] d = dominoes.toCharArray();
        int l = 0, r = 0;

        while(r < d.length) {
            if(d[r] == '.') {
                r++;
                continue;
            }

            if(l < r) {
                int l1 = l, r1 = r;
                if(l-1 < 0 && d[r] == 'L') {
                    while(l1 <= r1){
                        d[l1++] = 'L';
                    }
                } else {
                    if(l-1 >= 0) {
                        if(d[l-1] == 'R' && d[r] == 'L') {
                            r1--;
                            while(l1 < r1) {
                                d[l1++] = 'R';
                                d[r1--] = 'L';
                            }
                        } else if(d[l-1] == d[r]){
                            while(l1 <= r1) d[l1++] = d[r];
                        }
                    }
                }
                l = r;
                continue;
            }

            r++;
            l = r;

        }

        while(l-1 >= 0 && l < r && d[l-1] == 'R'){
            d[l++] = 'R';
        }

        return new String(d);
    }
}