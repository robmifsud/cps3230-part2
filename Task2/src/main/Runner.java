package main;

import java.util.*;
import java.time.LocalDateTime;

import org.json.simple.parser.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;

public class Runner {
	
	public void run(User u) throws Exception{
		while(true){
			Thread.sleep(1000);
			u.updateLoginStatus();
			LinkedList<Integer> events = getRequest();
			for(int e : events){
				switch(e){
					case 0:{
						alertCreated();
						break;
					}
					case 1: {
						alertsDeleted();
						break;
					}
					case 5:{
						validLogin();
						break;
					}
					case 6:{
						validLogOut();
						break;
					}
					case 7:{
						viewAlerts();
						break;
					}
				}
			}
		}
	}
	
	public LinkedList<Integer> getRequest() throws Exception{
		LinkedList<Integer> events = new LinkedList<Integer>();
		URL eventLog = new URL("https://api.marketalertum.com/EventsLog/bad51e47-636b-42f0-be4b-631d34376a98");
		HttpURLConnection con = (HttpURLConnection) eventLog.openConnection();
		con.setRequestMethod("GET");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while((inputLine = in.readLine()) != null){
			response.append(inputLine);
		}
		in.close();
		
		Object obj = new JSONParser().parse(response.toString());
		JSONArray list = (JSONArray) obj;
		
		for(int i=0; i < list.size(); i++){
			JSONObject jo = (JSONObject) list.get(i);
			long eventType = (Long) jo.get("eventLogType");
			events.add((int)eventType);
		}
		return events;
	}
	
	public void alertCreated(){
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Alert created at: " + now);
	}
	
	public void alertsDeleted(){
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Alerts deleted at: " + now);
	}
	
	public void validLogin(){
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Logged in at: " + now);	
	}
	
	public void validLogOut(){
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Logged out at: " + now);
	}
	
	public void viewAlerts(){
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Viewed alerts at: " + now);
	}

	public static void main(String args[]){
		Runner r = new Runner();
		User u = new User();
		try {
			r.run(u);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}




