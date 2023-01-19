// 166. Fraction to Recurring Decimal

class Solution {
    public String fractionToDecimal(int num, int den) {    

        StringBuilder str = new StringBuilder();

        //-ve sign
        if(((num < 0) ^ (den < 0)) && (num != 0 )) str.append("-");
        long n = Math.abs((long)num);
        long d = Math.abs((long)den);

        str.append(n/d); // integer part
        n %= d;

        HashMap<Long, Integer> hm = new HashMap();
        if(n != 0 )str.append("."); // decimal
        hm.put(n , str.length());

        while(n != 0){
            n *= 10;
            str.append(n/d);
            n %= d;
            if(hm.containsKey(n)){
                int i = hm.get(n);
                str.insert(i, "(");
                str.append(")");
                break;
            }else{
                hm.put(n, str.length());
            }

        }
        return str.toString();
    }

}