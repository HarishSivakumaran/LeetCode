// 853. Car Fleet

class Solution {
    public int carFleet(int t, int[] p, int[] s) {
        if(p.length < 2) return p.length;
       
        int[][] posSpeed = new int[p.length][2];

        for(int i = 0; i < p.length; i++){
            posSpeed[i] = new int[]{p[i],s[i]};
        }

        Arrays.sort(posSpeed, (a,b)->a[0]-b[0]);

        Stack<int[]> st = new Stack<>();

        for(int i = p.length-1; i >= 0; i--){
            if(st.size() > 0){
                int[] frontCar = st.peek();
                double timeToReachF = (double)(t-frontCar[0])/frontCar[1];
               
                int[] backCar = posSpeed[i];
                double timeToReachB = (double)(t-backCar[0])/backCar[1];

                if(timeToReachF >= timeToReachB){
                    // cars will meet
                }else{
                    st.push(backCar);
                }
            
            }else{
               st.push(posSpeed[i]);
            }
        }

        return st.size();
        

      } 
    

}