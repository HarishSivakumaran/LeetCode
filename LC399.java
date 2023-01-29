// 399. Evaluate Division

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<Pair<String,Double>>> var = new HashMap();
        double[] out = new double[queries.size()];
        int i = 0;
        for(List<String> eq : equations){
            var.computeIfAbsent(eq.get(0), v -> new ArrayList()).add(new Pair(eq.get(1), values[i]));
            var.computeIfAbsent(eq.get(1), v -> new ArrayList()).add(new Pair(eq.get(0), 1/values[i]));
            i++;
        }
        i = 0;
        for(List<String> q : queries){
            String a = q.get(0);
            String b = q.get(1);
            if(!var.containsKey(a) || !var.containsKey(b)){
                out[i] = -1.0;
            }else{
                out[i] = evaluate(a,b,var, new HashSet());
            }
            i++;
            
        }

        return out;
                
    }

    public double evaluate(String a, String b, HashMap<String, List<Pair<String,Double>>> var, HashSet<String> prev ){
        if(a.equals(b)) return 1.0;
        
        prev.add(a);

        double out = -1.0;

        for(Pair<String,Double> val : var.get(a)){
            if(!prev.contains(val.getKey())){
                Double value = evaluate(val.getKey(), b, var, prev);
                if(value == -1.0) continue;
                out = value * val.getValue();
                break;
            }
        }

        prev.remove(a);

        return out;
        
    }
}