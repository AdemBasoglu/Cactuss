package test.adem;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class US_02 {
    Response response;


    @Test
    public void wrongEmailCorrectPasswoordTest() {

        // 1 - URL ve Body hazirla

        String url = "https://trendlifebuy.com/api/login";

        JSONObject rqbody = new JSONObject();
        rqbody.put("email", "test@atest.com").put("password", "123123123");
        //System.out.println("rqbody = " + rqbody);


        // 2 - Expected Data hazirla

        // 3 - Response'i kaydet
        Response response = given().
                contentType(ContentType.JSON).
                when().
                body(rqbody.toString()).
                post(url);
        //response.prettyPrint();


        // 4 - Assertion
        response.
                then().
                assertThat().
                statusCode(401).
                body("message", Matchers.equalTo("Invalid Credintials"));

    }

    @Test
    public void correctEmailWrongPasswoordTest() {

        // 1 - URL ve Body hazirla

        String url = "https://trendlifebuy.com/api/login";

        JSONObject rqbody = new JSONObject();
        rqbody.put("email", "info@trendlifebuy.com").put("password", "123123123aa");
        //System.out.println("rqbody = " + rqbody);


        // 2 - Expected Data hazirla

        // 3 - Response'i kaydet
        Response response = given().
                contentType(ContentType.JSON).
                when().
                body(rqbody.toString()).
                post(url);
        //response.prettyPrint();


        // 4 - Assertion
        response.
                then().
                assertThat().
                statusCode(401).
                body("message", Matchers.equalTo("Invalid Credintials"));

    }

    @Test
    public void wrongEmailWrongPasswoordTest() {

        // 1 - URL ve Body hazirla

        String url = "https://trendlifebuy.com/api/login";

        JSONObject rqbody = new JSONObject();
        rqbody.put("email", "test@atest.com").put("password", "123123123aa");
        //System.out.println("rqbody = " + rqbody);


        // 2 - Expected Data hazirla

        // 3 - Response'i kaydet
        Response response = given().
                contentType(ContentType.JSON).
                when().
                body(rqbody.toString()).
                post(url);
        //response.prettyPrint();


        // 4 - Assertion
        response.
                then().
                assertThat().
                statusCode(401).
                body("message", Matchers.equalTo("Invalid Credintials"));

    }


}
