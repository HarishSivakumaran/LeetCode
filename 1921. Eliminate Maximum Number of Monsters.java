class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        double[] time = new double[dist.length];

        for(int i = 0; i < dist.length; i++) time[i] = ((double)dist[i]/speed[i]);
        int t = 0, kills = 0, i = 0;
        Arrays.sort(time);

        while(i < time.length) {
            if(t < time[i]) {
                i++;
                kills++;
                t++;
            } else
            break;
        }

        return kills;
    }
}