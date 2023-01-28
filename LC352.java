// 352. Data Stream as Disjoint Intervals

class SummaryRanges {

    List<int[]> list  = new ArrayList();

    public SummaryRanges() {
        
    }
    
    public void addNum(int value) {
        this.binaryInsertPos(value);
                
    }

    public void binaryInsertPos(int n){
        int[] curr = new int[]{n,n};

        int l = 0, r = list.size()-1;

        while(l <= r){
            int m = l + (r-l)/2;
            int[] arr = this.list.get(m);
            if(n <= arr[1] && n >= arr[0]){
                return;
            }else if(n > arr[1]){
                l = m+1;
            }else if(n < arr[0]){
                r = m-1;
            }

        }

        int merge = 0;

        //checking for merge in pos l
        if(l < list.size() && list.size() != 0 && list.get(l) != null){
            int next[] = list.get(l);
            if(n <= next[1] && n >= next[0]){
                // current number get absorbed in the interval
                return;
            }else if(curr[1]+1 == next[0]){
                next[0] = curr[0];
                curr = next;
                merge++;
            }
            
        }

         if(l-1 >= 0 && list.size() != 0 && list.get(l-1) != null){
             int[] prev = list.get(l-1);
             if(n <= prev[1] && n >= prev[0]){
                // current number get absorbed in the interval
                return;
            }else if(curr[0] == prev[1]+1){
                prev[1] = curr[1];
                merge++;
            }
        }

        if(merge == 0){
            this.list.add(l, curr);
        }else if(merge == 2){
            this.list.remove(l);
        }

    }
    
    public int[][] getIntervals() {
        int[][] a = new int[this.list.size()][2];
        a =  this.list.toArray(a);
        return a;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */