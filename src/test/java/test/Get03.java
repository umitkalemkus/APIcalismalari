package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get03 {

 /*
        Given
            https://jsonplaceholder.typicode.com/todos/2
        When
             Kullanıcı GET Methodu ile Request Gönderir
        Then
            Status Code un "200" olduğunu Assert et
		And
            Content Type ın "application/json" olduğunu assert et
		And
		    title ın “quis ut nam facilis et officia qui” olduğunu verify et.,
		And
		    “completed” ın false olduğunu verify et.
		And
		    “userId” in 1 olduğunu verify et

		   */
    @Test
         public void get03(){


        String URL = "https://jsonplaceholder.typicode.com/todos/2";


        Response response = given().when().get(URL);
        response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
        String str = response.asString();
        System.out.println("str = " + str);


    }









}
