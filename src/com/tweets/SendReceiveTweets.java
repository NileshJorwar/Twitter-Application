package com.tweets;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import twitter4j.DirectMessage;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class SendReceiveTweets {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("twitterPropFile.properties");

		// load a properties file
		prop.load(input);
		String consumerKey = "Consumer-key from apps.twitter.com";
		String consumerSecret = "Consumer Secret-key from apps.twitter.com";
		String accessToken = "access token from apps.twitter.com";
		String accessSecret = "access secret -key from apps.twitter.com";
		
		// String consumerKey = prop.getProperty("consumerKey");
		// String consumerSecret = prop.getProperty("consumerSecret");
		// String accessToken = prop.getProperty("accessToken");
		// String accessSecret = prop.getProperty("accessSecret");
		//
		try {
			TwitterFactory factory = new TwitterFactory();
			Twitter twitter = factory.getInstance();
			AccessToken accestoken = new AccessToken(accessToken, accessSecret);

			twitter.setOAuthConsumer(consumerKey, consumerSecret);
			twitter.setOAuthAccessToken(accestoken);
			DirectMessage message = twitter.sendDirectMessage("@ashishryot", "Hi,, how r u today?");
			System.out.println("Direct message successfully sent to " + message.getRecipientScreenName());
			System.exit(0);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
