package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class API_GetResquest {




    //https://jsonplaceholder.typicode.com/posts/44
  /*  // Get request yolladiginizda donen Response'in

    // status code'nun 200,
    ve content type'nin JSON
    ve response body'sinde bulunana userId'nin 5,
    ve response body'sinde bulunanan title'in "optio dolar molestias sit"
    oldugunu test edin.*/


    // 1- Request ve Body olustur
     @Test
     public void get01(){
    String url = "https://jsonplaceholder.typicode.com/posts/44";

    // 2- Expected Data olustur.
         JSONObject expBody = new JSONObject();
    expBody.put("userId",5);
    expBody.put("title","optio dolor molestias sit");


    // 3- Responsu kaydet




         Response response = given().with().get(url);
       response.prettyPrint();


    // 4- Assertion




         response.
                 then().
                 assertThat().
                 statusCode(200).
                 contentType(ContentType.JSON);

         JsonPath actBody = response.jsonPath();
         Assert.assertEquals(expBody.get("userId"),actBody.get("userId"));
         Assert.assertEquals(expBody.get("title"),actBody.get("title"));


     }
}
