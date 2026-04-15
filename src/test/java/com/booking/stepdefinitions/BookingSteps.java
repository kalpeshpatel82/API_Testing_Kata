package com.booking.stepdefinitions;

import com.booking.constants.EndPoints;
import com.booking.models.Booking;
import com.booking.models.BookingDates;
import com.booking.models.BookingResponse;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.List;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class BookingSteps {
    private BookingResponse response;


    @When("I want to create a booking using a valid testdata {string},{string},{string},{string},{string},{string},{string},{string}")
    public void iWantToCreateABookingUsingAValidTestdata(String id,
                                                         String firstname,
                                                         String lastname,
                                                         String depositePaid,
                                                         String checkin,
                                                         String checkout,
                                                         String email,
                                                         String phone) {
        // Set up the Request POJO
        BookingDates dates = new BookingDates();
        dates.setCheckin(checkin);
        dates.setCheckout(checkout);

        Booking newBooking = new Booking();
        newBooking.setRoomid(Integer.parseInt(id));
        newBooking.setFirstname(firstname);
        newBooking.setLastname(lastname);
        newBooking.setDepositpaid(Boolean.parseBoolean(depositePaid));
        newBooking.setBookingdates(dates);
        newBooking.setEmail(email);
        newBooking.setPhone(phone);

        System.out.println(newBooking);

        // Execute Request and Extract Response as POJO
        response = given()
                .contentType(ContentType.JSON)
                .body(newBooking.toString()) // Serialization
                .when()
                .post(EndPoints.BOOKING)
                .then()
                .statusCode(200) // Check for "Created" status
                .extract()
                .as(BookingResponse.class); // Deserialization
    }


    @Then("I must get a valid response code {int} from categories endpoint")
    public void iMustGetAValidResponseCodeFromCategoriesEndpoint(int arg0) {
        // Assertions using the Object

        assert response.getBookingid() > 0;
        assert response.getBooking().getFirstname().equals("John");

        System.out.println("Booking Created with ID: " + response.getBookingid());


    }


}
