package com.booking.stepdefinitions;

import com.booking.constants.EndPoints;
import com.booking.models.LoginPoJo;
import com.booking.pages.CRUD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.*;



import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class loginSteps {


    @Given("I am on homepage of login endpoint")
    public void iAmOnHomepageOfLoginEndpoint() {
        RestAssured.baseURI = EndPoints.URI;
    }

    @When("I want to login to application using a {string} and {string}")
    public void iWantToLoginToApplicationUsingAAnd(String user, String pass) {
        new CRUD().loginToApplication(user, pass);
    }

    @Then("user should login successful with appropriate message {string} and {string}")
    public void userShouldLoginSuccessfulWithAppropriateMessageAnd(String code, String msg) {
        new CRUD().loginToApplication(code, msg);
    }




}

