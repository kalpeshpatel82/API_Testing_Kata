package com.booking.pages;

import com.booking.constants.EndPoints;
import com.booking.models.Booking;
import com.booking.models.BookingDates;
import com.booking.models.BookingResponse;
import com.booking.models.LoginPoJo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class CRUD {
    private Response response;
    private String token = "";
    private BookingResponse bookingResponse;


    public void loginToApplication(String user, String pass){
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

    public String validateUserLoginSuccessFul(String code,String msg){
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

    public void userBookRoomWithValidData(String id,
                                          String firstname,
                                          String lastname,
                                          String depositePaid,
                                          String checkin,
                                          String checkout,
                                          String email,
                                          String phone){
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
        bookingResponse = given()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + token)
                .body(newBooking.toString()) // Serialization
                .when()
                .post(EndPoints.BOOKING)
                .then()
                .statusCode(201) // Check for "Created" status
                .extract()
                .as(BookingResponse.class); // Deserialization
    }

    public void validateCreatedBooking(){
        // Assertions using the Object

        assert bookingResponse.getBookingid() > 0;
        assert bookingResponse.getBooking().getFirstname().equals("John");

        System.out.println("Booking Created with ID: " + bookingResponse.getBookingid());

    }

    public void getBookingUsingID(String userID){
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
