package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;


public class Get01 {

    public static void main(String[] args) {


        String URL = "https://restful-booker.herokuapp.com/booking/7";


        Response response = given().when().get(URL);
        System.out.println("Response");
        response.prettyPrint();

        String responseBodyStr = response.asString();
        System.out.println("responseBodyStr.length() = " + responseBodyStr.length());
        System.out.println("responseBodyStr.toLowerCase() = " + responseBodyStr.toLowerCase());




        response.then().assertThat().statusCode(200);
        response.then().assertThat().contentType("application/json");
        response.then().assertThat().statusLine("HTTP/1.1 200 OK");
        response.then().assertThat().contentType(ContentType.JSON);

        System.out.println("Status code:  "+ response.getStatusCode());
        System.out.println("Status headers:  "+ response.getHeaders());
        System.out.println("Status body:  "+ response.getBody());
        System.out.println("Status body:  "+ response.contentType());














    }





}
