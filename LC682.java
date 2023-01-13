// 682. Baseball Game

class Solution {
    public int calPoints(String[] o) {
        Stack<Integer> s = new Stack<>();
        for(String i : o){
            switch(i){
                case "+": int k = s.pop(), j = s.pop();
                            s.push(j);
                            s.push(k);
                            s.push(k+j); 
                break;
                case "D": s.push(2*s.peek());
                break;
                case "C": s.pop();
                break;
                default: s.push(Integer.parseInt(i));
            }
        }

        int sum = 0;

        while(s.size()>0){
            sum += s.pop();
        }

        return sum;
    }
}