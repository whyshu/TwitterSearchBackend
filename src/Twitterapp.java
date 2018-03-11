import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.auth.*;

import java.util.List;

class Twitterapp {
    public static void main(String[] args) {
        ConfBuilder confBuilder=new ConfBuilder();
        ConfigurationBuilder cb=confBuilder.getConf();

        SearchTwitter searchTwitter=new SearchTwitter(cb);

        String searchKey="English";
        List<Status> tweets=searchTwitter.getTweets(searchKey);
        List<Tweet> tweetsToReturn=searchTwitter.sendTweets(tweets);
        tweetsToReturn.stream().map(Tweet::toString).forEach(System.out::println);
        System.out.println("**************************************" +
                "****************************************************");

        String userName="belle";
        List<Status> userTweets=searchTwitter.getUserTweets(userName);
        Profile profile=searchTwitter.getProfile(userTweets);
        System.out.println(profile.toString());

        List<Tweet> userTweetsToReturn=searchTwitter.sendTweets(userTweets);
        userTweetsToReturn.stream().map(Tweet::toString).forEach(System.out::println);
    }

}

