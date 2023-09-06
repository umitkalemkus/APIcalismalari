package test;

import BaseURLs.JsonPlaceHolderBaseUR;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get04 extends JsonPlaceHolderBaseUR {

     /* Given
    https://jsonplaceholder.typicode.com/users   --> resources farklı
    When
    Kullanıcı GET Methodu ile Request Gönderir
    Then
    Status Code un "200" olduğunu Assert et
            And
    Content Type ın "application/json" olduğunu assert et
            And
    Data uzunluğunun 10 olduğunu assert ediniz.

        */

     @Test
    public void get04(){

        specification.pathParam("usersPath","users");


        Response response = given().spec(specification).when().get("/{usersPath}");
        response.prettyPrint();



        response.then().assertThat().statusCode(200).contentType("application/json").body("id", Matchers.hasSize(10));









    }


}
