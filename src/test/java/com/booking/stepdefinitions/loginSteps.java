package com.booking.stepdefinitions;

import com.booking.constants.EndPoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class loginSteps {
    private Response response;

    @Given("I am on homepage of login endpoint")
    public void iAmOnHomepageOfLoginEndpoint() {
        RestAssured.baseURI= EndPoints.URI;
    }

    @When("I want to login to application using a {string} and {string}")
    public void iWantToLoginToApplicationUsingAAnd(String user, String pass) {
        String requestBody = String.format("{\"username\":\"%s\",\"password\":\"%s\"}", user, pass);
        response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(EndPoints.LOGIN);
    }

    @Then("user should login successful with appropriate message {string} and {string}")
    public void userShouldLoginSuccessfulWithAppropriateMessageAnd(String code, String msg) {
        int receivedCode = Integer.parseInt(code);
        if (receivedCode == 200) {
            response.prettyPrint();
            response.then().statusCode(receivedCode);
            response.then()
                    .statusCode(receivedCode)
                    .body("token", notNullValue());
        }

        if (receivedCode == 401) {
            response.prettyPrint();
            response.then().statusCode(receivedCode);
            response.then()
                    .statusCode(receivedCode)
                    .body("error", equalTo(msg));
        }

    }


}
