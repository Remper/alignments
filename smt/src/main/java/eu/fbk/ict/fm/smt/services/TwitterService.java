package eu.fbk.ict.fm.smt.services;

import twitter4j.*;

import javax.inject.Inject;
import java.util.*;

/**
 * Our Twitter tooling on top of the regular Twitter instance
 *
 * @author Yaroslav Nechaev (remper@me.com)
 */
public class TwitterService {
    private final List<TwitterInstance> twitter;

    public static final String USERS_SEARCH = "/users/search";
    public static final String FRIENDS_LIST = "/friends/list";
    public static final int MAX_VALUE = 100500;

    @Inject
    public TwitterService(Twitter[] twitter) {
        this.twitter = new LinkedList<>();
        for (Twitter connection : twitter) {
            this.twitter.add(new TwitterInstance(connection));
        }
    }

    public List<User> searchUsers(String query) throws RateLimitException {
        return getReadyInstance(USERS_SEARCH).searchUsers(query);
    }

    public List<User> getFriends(long uid) throws RateLimitException {
        return getReadyInstance(FRIENDS_LIST).getFriends(uid);
    }


    public TwitterInstance getReadyInstance(String method) throws RateLimitException {
        int minTime = MAX_VALUE;
        TwitterInstance minInstance = twitter.get(0);

        for (TwitterInstance instance : this.twitter) {
            int readyIn = instance.readyIn(method);
            if (readyIn == 0) {
                return instance;
            }

            if (minTime > readyIn) {
                minTime = readyIn;
                minInstance = instance;
            }
        }

        if (minTime < 10) {
            try {
                Thread.sleep((minTime + 5) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return minInstance;
        }

        throw new RateLimitException(minTime);
    }


    public static class TwitterInstance {
        private Map<String, RateLimitStatus> limits = new HashMap<>();
        public Twitter twitter;

        public TwitterInstance(Twitter twitter) {
            this.twitter = twitter;
        }

        public int readyIn(String method) {
            int curTime = (int) new Date().getTime()/1000;

            RateLimitStatus status = getLimitStatus(method);
            if (status == null) {
                return MAX_VALUE; //Never
            }
            return status.getRemaining() > 0 ? 0 : Math.max(status.getResetTimeInSeconds() - curTime, 0);
        }

        private RateLimitStatus getLimitStatus(String method) {
            RateLimitStatus status = limits.get(method);

            if (status != null) {
                return status;
            }

            try {
                limits.putAll(twitter.getRateLimitStatus());
            } catch (TwitterException e) {
                return null;
            }
            return limits.get(method);
        }

        private List<User> searchUsers(String query) {
            try {
                ResponseList<User> users = twitter.users().searchUsers(query, 0);
                limits.put(USERS_SEARCH, users.getRateLimitStatus());
                return users;
            } catch (TwitterException e) {
                limits.put(USERS_SEARCH, e.getRateLimitStatus());
            }

            return new LinkedList<>();
        }

        private List<User> getFriends(long uid) {
            return getFriends(uid, -1);
        }

        private List<User> getFriends(long uid, int cursor) {
            try {
                PagableResponseList<User> friends = twitter.friendsFollowers().getFriendsList(uid, cursor, 200);
                limits.put(FRIENDS_LIST, friends.getRateLimitStatus());

                return friends;
            } catch (TwitterException e) {
                limits.put(FRIENDS_LIST, e.getRateLimitStatus());
            }

            return new LinkedList<>();
        }
    }

    public static class RateLimitException extends Exception {
        public RateLimitException(int remaining) {
            super("The API is out of capacity, please try again in "+remaining+" seconds");
        }
    }
}
