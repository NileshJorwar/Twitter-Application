package com.tweets;

import twitter4j.Status;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import twitter4j.*;
import twitter4j.ResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class Message {
	public static void main(String args[]) throws Exception {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/com/tweets/twitterPropFile.properties");
		try {
			// load a properties file
			prop.load(input);

			String consumerKey = "Consumer-key from apps.twitter.com";
			String consumerSecret = "Consumer Secret-key from apps.twitter.com";
			String accessToken = "access token from apps.twitter.com";
			String accessSecret = "access secret -key from apps.twitter.com";
			AccessToken accestoken = new AccessToken(accessToken, accessSecret);

			// System.setProperty("java.net.useSystemProxies", "true");
			// String consumerKey = (String)prop.getProperty("consumerKey");
			// String consumerSecret = (String)prop.getProperty("consumerSecret");
			// String accessToken = (String)prop.getProperty("accessToken");
			// String accessSecret = (String)prop.getProperty("accessSecret");
			System.out.println(consumerKey + " " + consumerSecret + " " + accessToken + "" + accessSecret);
			Twitter twitter = new TwitterFactory().getInstance();
			twitter.setOAuthConsumer(consumerKey, consumerSecret);
			twitter.setOAuthAccessToken(accestoken);
			System.out.println("My timeline");

			List<Status> list = twitter.getHomeTimeline();
			for (Status each : list) {
				System.out.println("sent by: @" + each.getUser().getScreenName() + "-" + each.getUser().getName() + "\n"
						+ each.getText() + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
