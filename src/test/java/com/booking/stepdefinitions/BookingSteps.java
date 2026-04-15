package com.booking.stepdefinitions;

import com.booking.constants.EndPoints;
import com.booking.models.Booking;
import com.booking.models.BookingDates;
import com.booking.models.BookingResponse;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BookingSteps {
    private BookingResponse response;

    @When("I want to create a booking using a valid testdata")
    public void iWantToCreateABookingUsingAValidTestdata() {
        // Set up the Request POJO
        BookingDates dates = new BookingDates();
        dates.setCheckin("2025-10-13");
        dates.setCheckout("2025-10-15");

        Booking newBooking = new Booking();
        newBooking.setRoomid(2);
        newBooking.setFirstname("John");
        newBooking.setLastname("Doe");
        newBooking.setDepositpaid(true);
        newBooking.setBookingdates(dates);
        newBooking.setEmail("john.doe@example.com");
        newBooking.setPhone("1234567890");

        System.out.println(newBooking.toString());

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
