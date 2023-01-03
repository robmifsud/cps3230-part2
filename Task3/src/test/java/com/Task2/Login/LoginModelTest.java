package com.Task2.Login;

import com.Task2.Login.enums.LoginStates;
import nz.ac.waikato.modeljunit.*;
import nz.ac.waikato.modeljunit.coverage.ActionCoverage;
import nz.ac.waikato.modeljunit.coverage.StateCoverage;
import nz.ac.waikato.modeljunit.coverage.TransitionPairCoverage;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class LoginModelTest implements FsmModel{
    // Sut
    private Login login = new Login();

    // State Variables
    private LoginStates modelLogin = LoginStates.LOGGED_OUT;
    private boolean loggedIn = false, loggedOut = true;

    public LoginStates getState(){ return modelLogin;}

    public void reset(final boolean var1){
        if(var1){
            login = new Login();
        }
        modelLogin = LoginStates.LOGGED_OUT;
        loggedIn = false;
        loggedOut = true;
    }

    // Transitions incl. guards
    public boolean loginGuard(){return getState().equals(LoginStates.LOGGED_OUT);}
    public @Action void login(){
        // Update sut
        login.login();

        // Update model
        modelLogin = LoginStates.LOGGED_IN;
        loggedOut = false;
        loggedIn = true;

        // Check
        assertEquals("The SUT's login state does not match the model's login state after logging in",loggedIn,login.isLoggedIn());
    }

    public boolean logoutGuard(){return getState().equals(LoginStates.LOGGED_IN);}
    public @Action void logout(){
        // Update sut
        login.logout();

        // Update model
        modelLogin = LoginStates.LOGGED_OUT;
        loggedIn = false;
        loggedOut = true;

        // Check
        assertEquals("The SUT's login state does not match the model's login state after logging in",loggedOut,login.isLoggedOut());
    }

    public boolean viewAlertsGuard(){return getState().equals(LoginStates.LOGGED_IN);}
    public @Action void viewAlerts(){
        // Update sut
        login.viewAlerts();

        // Update model
//        modelLogin = LoginStates.LOGGED_IN;
//        loggedIn = true;

        // Check
        assertEquals("The SUT's login state does not match the model's login state after viewing alerts", loggedIn, login.isLoggedIn());
    }

    // Test runner
    @Test
    public void LoginModelRunner(){
        final GreedyTester tester = new GreedyTester((new LoginModelTest()));
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