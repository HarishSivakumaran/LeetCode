// 118. Pascal's Triangle

class Solution {
    int[][] dir = {{-1,0}, {-1,-1}};
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> out = new ArrayList();

        for(int i = 0; i < n; i++){
            List<Integer> row = new ArrayList();
            out.add(row);            
            for(int j = 0; j <= i; j++){
                if(i == j || j == 0){
                    row.add(1);
                }else{
                    int a = 0;
                    for(int[] d : dir){
                        a += out.get(i+d[0]).get(j+d[1]);
                    }
                    row.add(a);
                }

            }
        }

        return out;
        
    }
}