package com.Task2.Login;

public class Login {

    private boolean loggedIn = false, loggedOut = true;

    boolean login(){
        if(!loggedIn){
            loggedIn = true;
            loggedOut = false;
            return true;
        } else{
            throw new IllegalStateException();
        }
    }

    boolean logout(){
        if(!loggedOut){
            loggedIn = false;
            loggedOut = true;
            return true;
        } else{
            throw new IllegalStateException();
        }
    }

    boolean viewAlerts(){
        if(loggedIn){
            return true;
        } else{
            throw new IllegalStateException();
        }
    }

    boolean isLoggedIn(){return loggedIn;}

    boolean isLoggedOut(){return loggedOut;}

}
