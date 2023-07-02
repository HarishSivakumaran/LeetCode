class StockSpanner {
    //val, noOfConsLesOrEqVal(includind curr)
    List<int[]> list = new ArrayList();
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        int index = list.size()-1;
        int ans = 1;
        while(index >= 0 && list.get(index)[0] <= price){
            ans += list.get(index)[1];
            index = index-list.get(index)[1];
        }
        list.add(new int[]{price, ans});
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */