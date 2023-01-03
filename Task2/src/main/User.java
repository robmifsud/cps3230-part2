package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class User {
	public boolean loggedIn;
	
	public User(){
		loggedIn = false;
	}
	
	public void updateLoginStatus() throws Exception{
		URL loginStatusUrl = new URL("https://api.marketalertum.com/EventsLog/bad51e47-636b-42f0-be4b-631d34376a98/login-status");
		
		HttpURLConnection con = (HttpURLConnection) loginStatusUrl.openConnection();
		con.setRequestMethod("GET");
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while((inputLine = in.readLine()) != null){
			response.append(inputLine);
		}
		in.close();

		Object obj = new JSONParser().parse(response.toString());
		JSONObject jo = (JSONObject) obj;
		boolean loginStatus = (Boolean) jo.get("isLoggedInOnWebsite");
		
		if (loggedIn != loginStatus){
			loggedIn = loginStatus;
			statusChanged();
		}
	}
	
	public void statusChanged(){
		//Method used to trigger action in Larva
	}
}
