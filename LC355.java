// 355. Design Twitter

class Twitter {

    Deque<int[]> tweets = new LinkedList<>();
    HashMap<Integer,HashSet<Integer>> followers = new HashMap<>();

    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!this.followers.containsKey(userId)){
            HashSet<Integer> hs = new HashSet<>();
            hs.add(userId);
            this.followers.put(userId, hs);
        }
        this.tweets.addFirst(new int[]{userId, tweetId});     
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> out = new ArrayList<>();
        Iterator<int[]> iteratorVals = this.tweets.iterator();    
        HashSet<Integer> followersId = this.followers.get(userId);  

        while(iteratorVals.hasNext()){
            int[] currTweet = iteratorVals.next();
            if(followersId.contains(currTweet[0])){
                out.add(currTweet[1]);
                if(out.size() == 10) return out;
            }
        }

        return out;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!this.followers.containsKey(followerId)){
            HashSet<Integer> hs = new HashSet<>();
            hs.add(followerId);
            hs.add(followeeId);
            this.followers.put(followerId, hs);
        } else {
            this.followers.get(followerId).add(followeeId);
        } 
    }
    
    public void unfollow(int followerId, int followeeId) {
        this.followers.get(followerId).remove(followeeId);        
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */