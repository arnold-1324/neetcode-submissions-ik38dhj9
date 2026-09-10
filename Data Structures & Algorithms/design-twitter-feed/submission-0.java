class Twitter {
    private int time;
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<Tweet>> tweetMap;
    private static class Tweet {
        int time, id;
        public Tweet(int time, int id) {
            this.time = time;
            this.id = id;
        }
    }
    private static class TweetNode {
        int userId, index;
        Tweet tweet;
        public TweetNode(int userId, int index, Tweet tweet) {
            this.userId = userId;
            this.index = index;
            this.tweet = tweet;
        }
    }

    public Twitter() {
        time = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new Tweet(time++, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<TweetNode> maxHeap =
            new PriorityQueue<>((a, b) -> Integer.compare(b.tweet.time, a.tweet.time));
        addLatestTweet(userId, maxHeap);
        for (int followeeId : followMap.getOrDefault(userId, Collections.emptySet())) {
            addLatestTweet(followeeId, maxHeap);
        }
        List<Integer> result = new ArrayList<>(10);
        while (!maxHeap.isEmpty() && result.size() < 10) {
            TweetNode current =maxHeap.poll();
            result.add(current.tweet.id);
            if(current.index>0)
            {
                int previdx=current.index-1;
                List<Tweet>tweet=tweetMap.get(current.userId);
                maxHeap.offer(new TweetNode(current.userId,previdx,tweet.get(previdx)));
            }
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId)
           return;
        followMap.computeIfAbsent(followerId,k->new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer>followee=followMap.get(followerId);
        if(followee!=null)
           followee.remove(followeeId);
    }

    private void addLatestTweet(int userid, PriorityQueue<TweetNode> maxHeap) {
        List<Tweet> list = tweetMap.get(userid);
        if (list != null && !list.isEmpty()) {
            int lastidx = list.size() - 1;
            maxHeap.offer(new TweetNode(userid, lastidx, list.get(lastidx)));
        }
    }
}
