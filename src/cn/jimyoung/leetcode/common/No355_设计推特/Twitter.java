package cn.jimyoung.leetcode.common.No355_设计推特;

import java.util.*;

class Tweet {
    int id;//此推特的id
    int time;

    Tweet(int id, int time) {
        this.id = id;
        this.time = time;
    }
}

public class Twitter {

    //保存一个人和他关注的人
    private static Map<Integer, Set<Integer>> followers;
    //一个人和他发的推特
    private static Map<Integer, List<Tweet>> twitter;

    private static int time = 0;

    private static PriorityQueue<Tweet> maxHeap;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        followers = new HashMap<>();
        twitter = new HashMap<>();
        maxHeap = new PriorityQueue<>((o1, o2) -> -o1.time + o2.time);
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        time++;
        if (twitter.containsKey(userId)) {
            twitter.get(userId).add(new Tweet(tweetId, time));
        } else {
            List<Tweet> list = new LinkedList<>();
            list.add(new Tweet(tweetId, time));
            twitter.put(userId, list);
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        maxHeap.clear();
        if (twitter.containsKey(userId)) {
            List<Tweet> list = twitter.get(userId);
            if (list != null && list.size() > 0)
                for (Tweet tweet : list) {
                    maxHeap.offer(tweet);
                }
        }
        Set<Integer> followerList = followers.get(userId);
        if (followerList != null && followerList.size() > 0) {
            for (Integer uid : followerList) {
                List<Tweet> list = twitter.get(uid);
                if (list != null && list.size() > 0)
                    for (Tweet tweet : twitter.get(uid)) {
                        maxHeap.offer(tweet);
                    }
            }
        }
        List<Integer> res = new ArrayList<>(10);
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            res.add(maxHeap.poll().id);
            count++;
        }
        return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId) return;

        if (followers.containsKey(followerId)) {
            followers.get(followerId).add(followeeId);
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(followeeId);
            followers.put(followerId, set);
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId) return;

        if (followers.containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));

    }
}
