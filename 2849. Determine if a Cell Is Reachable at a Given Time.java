class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if(Math.abs(sy-fy) > 0 || Math.abs(sx-fx) > 0)
            return t >= Math.max(Math.abs(sx-fx), Math.abs(sy-fy));
        
        return t == 0 || t > 1;
    }
}