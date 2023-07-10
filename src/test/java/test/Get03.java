package test;

import BaseURLs.JsonPlaceHolderBaseUR;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.path.json.JsonPath.given;
import static org.hamcrest.Matchers.equalTo;

public class Get03 extends JsonPlaceHolderBaseUR {

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


        /*
        {
        "userId": 1,
        "id": 2,
        "title": "quis ut nam facilis et officia qui",
        "completed": false
    }
         */






    @Test
    public void get03(){

    specification.pathParams("todosPath","todos","idPath","2");


        Response response = RestAssured.given().spec(specification).when().get("/{todosPath}/{idPath}");
        response.prettyPrint();


       // 1. yol

       /* response.then().
                assertThat().body("title" , Matchers.equalTo("quis ut nam facilis et officia qui"),
                        "completed",Matchers.equalTo(false),"userId",Matchers.equalTo(1));*/



        // 2. yol

        response.then().
                assertThat().body("title" , equalTo("quis ut nam facilis et officia qui"),
                        "completed",equalTo(false),"userId",equalTo(1));






    }







}
