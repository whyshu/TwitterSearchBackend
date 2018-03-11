import twitter4j.Twitter;

public class Tweet {
    private String userName;
    private String screenName;
    private String tweetText;
    private String URL;
    private String tweetTime;
    private int retweetCount;
    private int favoriteCount;


    public Tweet(String uName, String sName, String tText,int rCount,int fCount,String tweetTime){
        this.userName=uName;
        this.screenName=sName;
        this.tweetText=tText;
        this.retweetCount=rCount;
        this.favoriteCount=fCount;
        this.tweetTime=tweetTime;
    }

    public String getUserName(){
        return this.userName;
    }

    public String getScreenName(){
        return this.screenName;
    }

    public String getTweetText(){
        return this.tweetText;
    }
    public int getRetweetCount(){
        return this.retweetCount;
    }
    public int getFavoriteCount(){
        return this.favoriteCount;
    }

    @Override
    public String toString(){
        return this.getUserName()+" :: "+this.getScreenName()+" :: "+this.getTweetText()+
                " :: "+this.getRetweetCount()+" :: "+this.getFavoriteCount()+" :: "+this.tweetTime;
    }

}
