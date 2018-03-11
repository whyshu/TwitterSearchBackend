public class Profile {
    private String userName;
    private String screenName;
    private int followersCount;
    private int friendsCount;
    private String location;

    public Profile(String uName, String sName,int followers, int friends, String loc){
        this.userName=uName;
        this.screenName=sName;
        this.followersCount=followers;
        this.friendsCount=friends;
        this.location=loc;
    }

    public String getUserName(){
        return this.userName;
    }

    public String getScreenName(){
        return this.screenName;
    }

    public int getFollowersCount(){
        return this.followersCount;
    }

    public int getFriendsCount(){
        return this.friendsCount;
    }
    public String getLocation(){
        return this.location;
    }
    @Override
    public String toString(){
        return this.getUserName()+" :: "+this.getScreenName()+" :: "+this.getFollowersCount()+
                " :: "+this.getFriendsCount()+" :: "+this.getLocation();
    }
}
