package com.Task2.Alerts;

public class Alerts {
    private boolean empty = true, lessThanOr5 = false, moreThan5 = false;
    int alertCount = 0;

    boolean createAlert(){
        if(empty){
            alertCount++;
            empty = false;
            lessThanOr5 = true;
            return true;
        } else if(lessThanOr5){
            if(alertCount<5){
                alertCount++;
                return true;
            } else{
                alertCount++;
                lessThanOr5 = false;
                moreThan5 = true;
                return true;
            }
        } else if(moreThan5){
            alertCount++;
            return true;
        } else{
            throw new IllegalStateException();
        }
    }

    boolean deleteAlerts(){
        alertCount = 0;
        empty = true;
        lessThanOr5 = false;
        moreThan5 = false;
        return true;
    }

    boolean isEmpty(){return empty;}

    boolean isLessThanOr5(){return lessThanOr5;}

    boolean isMoreThan5(){return moreThan5;}
}
