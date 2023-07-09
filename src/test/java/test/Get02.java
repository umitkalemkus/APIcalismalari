package test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.path.json.JsonPath.given;

public class Get02 {

       /*
    Given
        https://restful-booker.herokuapp.com/booking/78100
    When
        Kullanıcı GET Methodu ile Request Gönderir
    Then
        Status Code un "404" olduğunu Assert et
    And
        Response Body nin "Not Found" olduğunu assert et
    And
        Headers dan Via nın "1.1 vegur" olduğunu assert et.
    And
        Response body nin "Clarusway" yazmadığını assert et
    And
        Status Line "HTTP/1.1 404 Not Found" olduğunu assert et.

     */

    @Test
    public void get02(){

        String URL = "https://restful-booker.herokuapp.com/booking/78100";


        Response response = RestAssured.given().when().get(URL);
        response.prettyPrint();




    }



}
