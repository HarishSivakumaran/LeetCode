class Solution {
    HashMap<String, Integer> lookUp = new HashMap();
    HashMap<Integer, Integer> skillMap = new HashMap();
    HashMap<String, Long> cache = new HashMap();
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        lookUp = new HashMap();
        int req = 0;
        for(int i = 0; i < req_skills.length; i++){
            lookUp.put(req_skills[i], i);
            req |= (1 << i);
        }

        for(int i = 0; i < people.size(); i++) {
            int sk = 0;
            for(String skill : people.get(i)){
                if(lookUp.containsKey(skill)){
                    sk |= (1 << lookUp.get(skill));
                }
            }
            skillMap.put(i, sk);
        }

        Long out = getMinPeople(0, people, req);
        int[] o = new int[getOneCount(out)];
        for(int i = 0, j = 0; i < 64 && j < o.length; i++){
            if((out&(1l << i)) > 0) o[j++] = i;
        }
        return o;
    }

    private long getMinPeople(int i, List<List<String>> people, int req) {
        if(req == 0){
            return 0l;
        }
        if(i >= people.size()) return Long.MAX_VALUE;

        String key = req + "-" + i;

        if(cache.containsKey(key)) 
            return cache.get(key);

        long finalList = 0l;

        // hire the person
        int reqBef = req;
        req &= (~skillMap.get(i));

        Long hiredPeopleInclCurrent = Long.MAX_VALUE;
        if(req != reqBef){
            hiredPeopleInclCurrent =  getMinPeople(i+1, people, req);
            hiredPeopleInclCurrent = hiredPeopleInclCurrent | (1l << i);
        }
        
        // don't hire this person
        Long hiredPeopleExclCurrent = getMinPeople(i+1, people, reqBef);
        

        if(getOneCount(hiredPeopleInclCurrent) < getOneCount(hiredPeopleExclCurrent)){
            finalList = hiredPeopleInclCurrent;
        }else{
            finalList = hiredPeopleExclCurrent;
        }

        cache.put(key, finalList);
        return finalList;
    }

    private int getOneCount(long l){
        int c = 0;
        while(l > 0){
            l &= (l-1);
            c++;
        }

        return c;
    }
}