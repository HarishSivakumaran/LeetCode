class Solution {
    HashMap<String, Integer> lookUp = null;
    HashMap<String, Long> cache = new HashMap();
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        lookUp = new HashMap();
        int req = 0;
        for(int i = 0; i < req_skills.length; i++){
            lookUp.put(req_skills[i], i);
            req |= (1 << i);
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

        long finalList = Long.MAX_VALUE;

        // hire the person
        int reqBef = req;
        for(String skill : people.get(i)) {
            if(lookUp.get(skill) != null){
                if((req & (1 << lookUp.get(skill))) > 0)
                    req ^= (1 << lookUp.get(skill));
            }
        }


        Long hiredPeopleInclCurrent = Long.MAX_VALUE;
        if(req != reqBef) {
            hiredPeopleInclCurrent =  getMinPeople(i+1, people, req);
            hiredPeopleInclCurrent |= (1 << i);
        }

        // don't hire this person
        Long hiredPeopleExclCurrent = getMinPeople(i+1, people, reqBef);
        

        finalList = 
            getOneCount(hiredPeopleInclCurrent) > getOneCount(hiredPeopleExclCurrent) ? 
            hiredPeopleExclCurrent : hiredPeopleInclCurrent;

        if(getOneCount(finalList) == 0) finalList = Long.MAX_VALUE;

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