//649. Dota2 Senate

class Solution {
    public String predictPartyVictory(String senate) {
        PriorityQueue<Integer> pqD = new PriorityQueue<Integer>();
        PriorityQueue<Integer> pqDBuffer = new PriorityQueue<Integer>();
        PriorityQueue<Integer> pqR = new PriorityQueue<Integer>();
        PriorityQueue<Integer> pqRBuffer = new PriorityQueue<Integer>();


        for(int i = 0 ; i < senate.length(); i++){
            if(senate.charAt(i) == 'R'){
                pqR.add(i);
            }else{
                pqD.add(i);
            }
        }

        int r = pqR.size(), d = pqD.size();

        while(r > 0 && d > 0){
            while(pqD.size() > 0 && pqR.size() > 0){
                if(pqD.peek() < pqR.peek()){
                    pqDBuffer.add(pqD.poll());
                    pqR.poll();
                    r--;
                }else{
                    pqRBuffer.add(pqR.poll());
                    pqD.poll();
                    d--;
                }          
            }
            while(pqR.size()>0 && pqDBuffer.size() > 0){
                    pqRBuffer.add(pqR.poll());
                    pqDBuffer.poll();
                    d--;
            }
            while(pqD.size()>0 && pqRBuffer.size() > 0){
                    pqDBuffer.add(pqD.poll());
                    pqRBuffer.poll();
                    r--;
            }

            if(pqD.size() == 0){
                pqD = pqDBuffer;
                pqDBuffer = new PriorityQueue<Integer>();
            }

            if(pqR.size() == 0){

                pqR = pqRBuffer; 
                pqRBuffer = new PriorityQueue<Integer>();
            }           
        }

        return r > 0 ? "Radiant" : "Dire";
    }
}   s
