package test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
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

        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");
        // response.then().assertThat().statusLine("HTTP/1.1 404 Not Found");

        String responceBodyStr = response.asString();
        System.out.println("Response Body :" + responceBodyStr);


        Assert.assertTrue(responceBodyStr.contains("Not Found"));
        // Headers


        System.out.println("response.getHeaders() = " + response.getHeaders());
        System.out.println("response.getHeader(\"Via\") = " + response.getHeader("Via"));
        Assert.assertEquals("1.1 vegur",response.getHeader("Via"));
        Assert.assertFalse(responceBodyStr.contains("Clarusway"));




    }



}
