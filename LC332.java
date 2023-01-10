// 332. Reconstruct Itinerary

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, List<String>> hm = new HashMap<>();

        Collections.sort(tickets, new Comparator<List<String>>(){
            public int compare(List<String> first, List<String> second){
                // compare the first element
                int comparedTo = first.get(0).compareTo(second.get(0));
                // if the first element is same (result is 0), compare the second element
                if (comparedTo == 0) return first.get(1).compareTo(second.get(1));
                else return comparedTo;
            }
        });

        for(List<String> ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            if(!hm.containsKey(from)){
                hm.put(from, new ArrayList<>());
            }
            hm.get(from).add(to);
        }

        List<String> res = new ArrayList();

        traverseDFS(hm, "JFK", res, tickets.size()+1);

        return res;
        
    }

    public boolean traverseDFS( HashMap<String, List<String>> hm, String curr, List<String> res, int exp){

        res.add(curr);

        if(res.size() == exp) return true;


        if(hm.get(curr) == null){ 
            res.remove(res.size()-1);
            return false;}

        List<String> temp = new ArrayList(hm.get(curr));  
          
        for(int i = 0; i < temp.size(); i++){
            String c = temp.get(i);
            hm.get(curr).remove(i);
            if(traverseDFS(hm, c, res, exp)) return true; 
            hm.get(curr).add(i, c);        
        }

        res.remove(res.size()-1);

        return false;


    }
}