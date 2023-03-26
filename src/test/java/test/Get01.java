package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 {





    @Test
    public void get01(){

        String URL = "https://restful-booker.herokuapp.com/booking/9";


        Response response =
                given().when().get(URL);

        response.prettyPrint();


        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
        response.then().assertThat().contentType("application/json");


        System.out.println(response.statusCode());
        System.out.println(response.contentType());
        System.out.println(response.statusLine());










    }
}
