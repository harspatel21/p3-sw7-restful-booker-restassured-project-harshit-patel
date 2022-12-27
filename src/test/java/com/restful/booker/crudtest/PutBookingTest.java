package com.restful.booker.crudtest;


import com.restful.booker.model.UpdatePojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PutBookingTest extends TestBase {

    @Test
    public void updateBookingData() {
        UpdatePojo updatePojo = new UpdatePojo();
        updatePojo.setFirstname("Ramcharan");
        updatePojo.setLastname("Saurya");
        updatePojo.setTotalprice(300);
        updatePojo.setDepositpaid(false);
        HashMap<Object, Object> bookingsDatesData = new HashMap<>();
        bookingsDatesData.put("checkin", "2022-12-29");
        bookingsDatesData.put("checkout", "2023-01-05");
        updatePojo.setBookingdates(bookingsDatesData);
        updatePojo.setAdditionalneeds("Breakfast");

        Response response = given()
                .header("Cookie", "token=50b70fe7faa6200")
                .header("Content-Type", "application/json")
                .pathParam("id", "1128")
                .body(updatePojo)
                .when()
                .put("/booking/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
