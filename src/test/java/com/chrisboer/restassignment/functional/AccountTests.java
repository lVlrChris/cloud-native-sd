package com.chrisboer.restassignment.functional;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.platform.engine.Cucumber;

@Cucumber
@CucumberOptions(features = "src/test/resources")
public class AccountTests {

    @When("^the client calls /api/v1/accounts$")
    public void theClientIssuesGetAccounts() throws Throwable {
        System.out.println("CUCUMBER TEST ---------------- WHEN");
    }

    @Then("^the client receives a status code of (\\d+)$")
    public void theClientReceivesStatusCodeOf(int statusCode) throws Throwable {
        System.out.println("CUCUMBER TEST ---------------- THEN");
    }

    @And("^the client receives a list of all accounts$")
    public void theClientReceivesListOfAllAccounts() throws Throwable {
        System.out.println("CUCUMBER TEST ---------------- AND");
    }

}
