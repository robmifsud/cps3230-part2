package com.Task2.Alerts;

import com.Task2.Alerts.enums.AlertsStates;
import nz.ac.waikato.modeljunit.Action;
import nz.ac.waikato.modeljunit.FsmModel;
import nz.ac.waikato.modeljunit.GreedyTester;
import nz.ac.waikato.modeljunit.StopOnFailureListener;
import nz.ac.waikato.modeljunit.coverage.ActionCoverage;
import nz.ac.waikato.modeljunit.coverage.StateCoverage;
import nz.ac.waikato.modeljunit.coverage.TransitionPairCoverage;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class AlertsModelTest implements FsmModel{
    //Linking the SUT
    private Alerts alertsSUT = new Alerts();

    //State Variables
    private AlertsStates modelAlerts = AlertsStates.EMPTY;
    private boolean empty = true, lessThanOr5 = false, moreThan5 = false;
    private int count = 0;

    //Method implementations
    public AlertsStates getState(){return modelAlerts;}

    public void reset(final boolean var1) {
        if(var1){
            alertsSUT = new Alerts();
        }
        modelAlerts = AlertsStates.EMPTY;
        empty = true;
        lessThanOr5 = true;
        moreThan5 = true;
        count = 0;
    }

    // Transitions incl. guards
    public boolean addWhenEmptyGuard(){return getState().equals(AlertsStates.EMPTY);}
    public @Action void addWhenEmpty(){
        // Updating SUT
        alertsSUT.createAlert();

        // Updating model
        count++;
        modelAlerts = AlertsStates.LESS_THAN_OR_5;
        lessThanOr5 = true;
        empty = false;

        // Check
        assertEquals("States do not match when adding alert to empty system", lessThanOr5, alertsSUT.isLessThanOr5());
        assertEquals("States do not match when adding alert to empty system", empty, alertsSUT.isEmpty());

    }

    public boolean addWhenLessThan5Guard(){
        boolean check = count < 5;
        return (getState().equals(AlertsStates.LESS_THAN_OR_5)) && check;
    }
    public @Action void addWhenLessThan5(){
        // Updating SUT
        alertsSUT.createAlert();

        // Updating model
        count++;
        lessThanOr5 = true;

        // Check
        assertEquals("States do not match when adding to system with <=5 alerts",lessThanOr5,alertsSUT.isLessThanOr5());
    }

    public boolean addWhen5Guard(){
        boolean check = count == 5;
        return (getState().equals(AlertsStates.LESS_THAN_OR_5)) && check;
    }
    public @Action void addWhen5(){
        // Updating SUT
        alertsSUT.createAlert();

        // Updating model
        count++;
        modelAlerts = AlertsStates.MORE_THAN_5;
        lessThanOr5 = false;
        moreThan5 = true;

        // Check
        assertEquals("States do not match when adding to system with 5 alerts",moreThan5,alertsSUT.isMoreThan5());
    }

    public boolean addWhenMoreThan5Guard(){return getState().equals(AlertsStates.MORE_THAN_5);}
    public @Action void addWhenMoreThan5(){
        // Updating SUT
        alertsSUT.createAlert();

        //Updating model
        count++;
        moreThan5 = true;

        // Check
        assertEquals("States do not match when adding to system with >5 alerts",moreThan5,alertsSUT.isMoreThan5());
    }

    public @Action void deleteAlerts(){
        // Updating SUT
        alertsSUT.deleteAlerts();

        //Updating model
        modelAlerts = AlertsStates.EMPTY;
        count = 0;
        empty = true;
        moreThan5 = false;
        lessThanOr5 = false;

        // Check
        assertEquals("States do not match when deleting alerts",empty,alertsSUT.isEmpty());
        assertEquals("States do not match when deleting alerts",lessThanOr5,alertsSUT.isLessThanOr5());
        assertEquals("States do not match when deleting alerts",moreThan5,alertsSUT.isMoreThan5());
    }

    // Test runner
    @Test
    public void AlertsModelRunner(){
        final GreedyTester tester = new GreedyTester((new AlertsModelTest()));
        tester.setRandom(new Random());
        tester.buildGraph();
        tester.addListener(new StopOnFailureListener());
        tester.addListener("verbose");
        tester.addCoverageMetric(new TransitionPairCoverage());
        tester.addCoverageMetric(new StateCoverage());
        tester.addCoverageMetric((new ActionCoverage()));
        tester.generate(500);
        tester.printCoverage();
    }
}
