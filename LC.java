// 2013. Detect Squares

class DetectSquares {

    HashMap<String, Integer> hm = new HashMap<>();
    List<int[]> p = new ArrayList<>();

    public DetectSquares() {
        
    }
    
    public void add(int[] point) {
        this.p.add(point);
        this.hm.put(point[0]+"-"+point[1],this.hm.getOrDefault(point[0]+"-"+point[1], 0)+1);       
    }
    
    public int count(int[] point) {
        int countVal =  0;  
        for(int[] possibleDiag : this.p){
            if(possibleDiag[0] == point[0] || 
               possibleDiag[1] == point[1] ||
               Math.abs(possibleDiag[0]-point[0]) != Math.abs(possibleDiag[1]-point[1])) continue;

            if(!this.hm.containsKey(possibleDiag[0]+"-"+ point[1]) || !this.hm.containsKey(point[0]+"-"+ possibleDiag[1])) continue;

            countVal += (this.hm.get(possibleDiag[0]+"-"+ point[1]) * this.hm.get(point[0]+"-"+ possibleDiag[1]));
        }  
            return countVal; 
    }

}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */