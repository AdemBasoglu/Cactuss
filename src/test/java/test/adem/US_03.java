package test.adem;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static test.adem.Authentication.generateTokenTrendLife;
import static test.adem.Authentication.trendLifeAllUsers;

public class US_03 {
    /*When a Get Request is sent to the api/get-user endpoint,
     the status code should be 200 and Content-Type is application/json,*/
    Response response;

    @Test
    public void test03() {
        response = given()
                .header("Authorization", "Bearer " + generateTokenTrendLife())
                .when()
                .get(trendLifeAllUsers());
       //response.prettyPrint() ;
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json");


    }

}
