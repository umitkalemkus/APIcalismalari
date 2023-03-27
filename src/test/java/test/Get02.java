package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

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

        Response response =given().when().get(URL);
        response.prettyPrint();

        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");
        //response.then().assertThat().statusLine("HTTP/1.1 404 Not Found");

        String str = response.asString();
        System.out.println("str = " + str);

        Assert.assertTrue(str.contains("Not Found"));

        System.out.println("response.getHeaders() = " + response.getHeaders());

        Assert.assertEquals("1.1 vegur",response.getHeader("Via"));

        System.out.println("Single Header1 :" + response.getHeader("Via"));
        System.out.println("Single Header2 :" + response.getHeader("Date"));
        System.out.println("Single Header3 :" + response.getHeader("Connection"));

    }
}
