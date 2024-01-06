class Solution {
    Integer[] cache;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] job = new int[startTime.length][3];
        for(int i = 0; i < startTime.length; i++) {
            job[i][0] = startTime[i];
            job[i][1] = endTime[i];
            job[i][2] = profit[i];
        }

        Arrays.sort(job, (a, b) -> {
            if(a[0] == b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });  

        cache = new Integer[startTime.length];  

        return getMax(job, 0);  
    }


    private int getMax(int[][] job, int i) {
        if(i >= job.length) return 0;

        if(cache[i] != null) return cache[i];
        
        // choose the job
        int max = job[i][2] + getMax(job, getNext(job, job[i][1], i+1));
        // skip this
        max = Math.max(max, getMax(job, i+1));

        return cache[i] = max;
    }

    private int getNext(int[][] job, int end, int l) {
        int r = job.length-1, m = 0;
        while(l <= r) {
            m = l + (r-l)/2;
            if(job[m][0] < end) {
                l = m+1;
            } else {
                r = m-1;
            }
        }

        return l;
    }
}