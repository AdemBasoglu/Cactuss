package test.adem;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static test.adem.Authentication.generateTokenTrendLife;


public class US_05 {
    /*When a Get Request is sent to the api/get-user
    for details endpoint, the status code should be 200
    and verify the id:39, id:4, id:6, id:17*/
    Response response;

    @Test
    public void TestId39() {
        int id = 39;


        String url = "https://trendlifebuy.com/api/get-user?id="+id;

        response = given().header("Authorization", "Bearer" + generateTokenTrendLife())
                .when().get(url);

        response.then().assertThat().statusCode(200);


    }


    @Test
    public void TestId4() {
        int id = 4;


        String url = "https://trendlifebuy.com/api/get-user?id="+id;

        response = given().header("Authorization", "Bearer" + generateTokenTrendLife())
                .when().get(url);

        response.then().assertThat().statusCode(200);


    }

    @Test
    public void TestId6() {
        int id = 6;


        String url = "https://trendlifebuy.com/api/get-user?id="+id;

        response = given().header("Authorization", "Bearer" + generateTokenTrendLife())
                .when().get(url);

        response.then().assertThat().statusCode(200);


    }


    @Test
    public void TestId17() {
        int id = 17;


        String url = "https://trendlifebuy.com/api/get-user?id="+id;

        response = given().header("Authorization", "Bearer" + generateTokenTrendLife())
                .when().get(url);

        response.then().assertThat().statusCode(200);


    }
}
