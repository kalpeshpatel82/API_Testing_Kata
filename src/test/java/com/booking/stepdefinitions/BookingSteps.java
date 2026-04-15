package com.booking.stepdefinitions;


import com.booking.pages.CRUD;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class BookingSteps {


    @When("I want to create a booking using a valid testdata {string},{string},{string},{string},{string},{string},{string},{string}")
    public void iWantToCreateABookingUsingAValidTestdata(String id,
                                                         String firstname,
                                                         String lastname,
                                                         String depositePaid,
                                                         String checkin,
                                                         String checkout,
                                                         String email,
                                                         String phone) {
        new CRUD().userBookRoomWithValidData(id, firstname, lastname, depositePaid, checkin, checkout, email, phone);
    }


    @Then("I must get a valid response code {int} from categories endpoint")
    public void iMustGetAValidResponseCodeFromCategoriesEndpoint(int arg0) {
        new CRUD().validateCreatedBooking();

    }

    @Then("user should able to get user info of given id {string}")
    public void userShouldAbleToGetUserInfoOfGivenId(String userID) {
        new  CRUD().getBookingUsingID(userID);
    }


}
