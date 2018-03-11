import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class SearchTwitter {
    Twitter twitterInstance;
    List<String> usersList;

    public SearchTwitter(ConfigurationBuilder cb){
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitterInstance = tf.getInstance();
    }
    public List<Status> getTweets(String searchKey){
        try {

            Query query = new Query(searchKey);

            QueryResult result;
            result = twitterInstance.search(query);

            List<Status> tweets = result.getTweets();
            tweets=tweets.parallelStream().limit(Constants.TWEET_COUNT).collect(Collectors.toList());
            addToUserList(tweets);
            return tweets;

        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            return null;
        }
    }

    public List<Tweet> sendTweets(List<Status> tweets){
        List<Tweet> tweetStatus=new ArrayList<>();
        for(Status tweet:tweets) {
            Tweet t = new Tweet(tweet.getUser().getName(), tweet.getUser().getScreenName(),
                    tweet.getText(),tweet.getRetweetCount(),tweet.getFavoriteCount(),tweet.getCreatedAt().toString());
            tweetStatus.add(t);
        }
        return tweetStatus;
    }



    public void addToUserList(List<Status> tweets){
        usersList=tweets.stream().limit(Constants.TWEET_COUNT).map(tweet->tweet.getUser().getScreenName())
                .collect(Collectors.toList());
    }

    public Profile getProfile(List<Status> userTweets){
        User userDetail=userTweets.get(0).getUser();
        Profile profile=new Profile(userDetail.getName(),userDetail.getScreenName(),
                userDetail.getFollowersCount(),userDetail.getFriendsCount(),userDetail.getLocation());
        return profile;
    }

    public List<Status> getUserTweets(String userName){
        try {
            return twitterInstance.getUserTimeline(userName);
        } catch (TwitterException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void getAllUserTweets(){

       usersList.stream().map(userName -> {
            try {
                System.out.println("**********************************************" +
                        "******************************************************");
                System.out.println(userName);
                System.out.println("******************************************" +
                        "**********************************************************");
                return twitterInstance.getUserTimeline(userName);
            } catch (TwitterException e) {
                e.printStackTrace();
                return null;
            }
        }).limit(Constants.TWEET_COUNT).flatMap(userStatuses->userStatuses.stream().
               map(status -> status.getText())).forEach(System.out::println);
    }
}
