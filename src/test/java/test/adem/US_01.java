package test.adem;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class US_01 {
    /*When sending Request to the /api/login endpoint,
     it should be verified that the status code returned is 200
     and the message information in the Response Body is "Successfully logged In".*/
Response response;



    @Test
    public void test2() {

        // 1 - URL ve Body hazirla

        String url = "https://trendlifebuy.com/api/login";

        JSONObject rqbody = new JSONObject();
        rqbody.put("email","info@trendlifebuy.com").put("password","123123123");
        //System.out.println("rqbody = " + rqbody);


        // 2 - Expected Data hazirla

        // 3 - Response'i kaydet
        Response response =given().
                contentType(ContentType.JSON).
                when().
                body(rqbody.toString()).
                post(url);
        //response.prettyPrint();
        JsonPath token = response.jsonPath() ;
        token.getString("token") ;


        // 4 - Assertion
        response.
                then().
                assertThat().
                statusCode(200).
                body("message", Matchers.equalTo("Successfully logged In")).
                body("token", Matchers.equalTo(token.getString("token")));
        ;

    }
}
