package test.POST;

import BaseURLs.GorestCoBaseURL;
import TestData.GoRestApiTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Post02 extends GorestCoBaseURL {

      /*

    Given
        https://gorest.co.in/public/v2/users
    And

           Request Body olarak aşağıdaki pattern de body gönderiniz
           {
  "name": "Tenali Ramakrishna",
  "gender": "male",
  "email": "tenali.ramakrishna@15ce.com",
  "status": "active"
}
    When
        Kullanıcı POST Methodu ile Request Gönderir
    Then
        Status Code un "201" olduğunu Assert et
    And
           Response Body nin aşağıdaki şekilde olduğunu doğrulayınız
             {
  "name": "Tenali Ramakrishna",
  "gender": "male",
  "email": "tenali.ramakrishna@15ce.com",
  "status": "active"
}

   */


    @Test
    public void Post02(){


        specification.pathParam("usersPath", "users");


        GoRestApiTestData goRestApiTestData = new GoRestApiTestData();
        HashMap<String,String> requestBodyAndExpectedMap =goRestApiTestData.RequestBodyAndExpectedData("Umit Kalemkus","male","umitkalemkus@gmail.com", "active");
        System.out.println(requestBodyAndExpectedMap);


        Response response = given().spec(specification).
                body(requestBodyAndExpectedMap).contentType(ContentType.JSON).
                when().
                header("Authorization" , "Bearer 5b9119d06f1e03e6349f75b699a2a68802fbae8766292381a2356f9531efbaf0").post("/{usersPath}");
        System.out.println("Response");
        response.prettyPrint();








    }






}
