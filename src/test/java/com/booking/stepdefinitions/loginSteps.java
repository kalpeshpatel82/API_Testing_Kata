package com.booking.stepdefinitions;

import com.booking.constants.EndPoints;
import com.booking.models.LoginPoJo;
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
    private Response response;
    private String token = "";

    @Given("I am on homepage of login endpoint")
    public void iAmOnHomepageOfLoginEndpoint() {
        RestAssured.baseURI = EndPoints.URI;
    }

    @When("I want to login to application using a {string} and {string}")
    public void iWantToLoginToApplicationUsingAAnd(String user, String pass) {
        LoginPoJo loginData = new LoginPoJo();
        loginData.setUsername(user);
        loginData.setPassword(pass);
        System.out.println(loginData);
        response = given()
                .contentType(ContentType.JSON)
                .body(loginData.toString())
                .when()
                .post(EndPoints.LOGIN);
        token = response.then().extract().body().path("token");
        System.out.println("MY token: " + token);
    }

    @Then("user should login successful with appropriate message {string} and {string}")
    public String userShouldLoginSuccessfulWithAppropriateMessageAnd(String code, String msg) {
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
            token = null;
        }
        return token;
    }


    @Then("user should able to get user info of given id {string}")
    public void userShouldAbleToGetUserInfoOfGivenId(String userID) {
        ValidatableResponse response1 = given()
                .header("Cookie", "token=" + token)
                .when()
                .get(EndPoints.BOOKING + "/" + Integer.parseInt(userID))
                .then()
                .statusCode(200);
        System.out.println(response1.extract().body().asString());
        response1.body("firstname",notNullValue());
    }

}

