import twitter4j.conf.ConfigurationBuilder;

public class ConfBuilder {

    private ConfigurationBuilder cb;

    public ConfBuilder(){
         cb = new ConfigurationBuilder();
    }

    public ConfigurationBuilder getConf(){
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(AccountInformation.CONSUMER_KEY)
                .setOAuthConsumerSecret(AccountInformation.CONSUMER_KEY_SECRET)
                .setOAuthAccessToken(AccountInformation.ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(AccountInformation.ACCESS_TOKEN_SECRET);
        return cb;
    }
}
