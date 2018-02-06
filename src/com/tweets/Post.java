package com.tweets;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

class Post {

	public static void main(String args[]) throws IOException {

		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/com/tweets/twitterPropFile.properties");

		// load a properties file
		prop.load(input);
		
		String consumerKey = "Consumer-key from apps.twitter.com";
		String consumerSecret = "Consumer Secret-key from apps.twitter.com";
		String accessToken = "access token from apps.twitter.com";
		String accessSecret = "access secret -key from apps.twitter.com";
		
//		String consumerKey = prop.getProperty("consumerKey");
//		String consumerSecret = prop.getProperty("consumerSecret");
//		String accessToken = prop.getProperty("accessToken");
//		String accessSecret = prop.getProperty("accessSecret");
//		
		String testPost = "my 1st tweet using java code";
		try {
			TwitterFactory factory = new TwitterFactory();
			Twitter twitter = factory.getInstance();
			AccessToken accestoken = new AccessToken(accessToken, accessSecret);

			twitter.setOAuthConsumer(consumerKey, consumerSecret);
			twitter.setOAuthAccessToken(accestoken);
			Status status = twitter.updateStatus(testPost);

			System.out.println("it worked!");
			if (status.getId() == 0) {
				System.out.println("Error occured while posting tweets to twitter");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
