package com.restful.booker.crudtest;

import com.restful.booker.model.PartialUpdatePojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PatchBookingTest extends TestBase {

    @Test
    public void partialUpdateBooking(){

        PartialUpdatePojo partialUpdatePojo=new PartialUpdatePojo();
        partialUpdatePojo.setFirstname("James");
        partialUpdatePojo.setLastname("Bond");

        Response response = given()
                .header("Cookie", "token=50b70fe7faa6200")
                .header("Content-Type", "application/json")
                .pathParam("id", "1128")
                .body(partialUpdatePojo)
                .when()
                .patch("/booking/{id}");
         response.then().statusCode(200);
        response.prettyPrint();

    }
}
