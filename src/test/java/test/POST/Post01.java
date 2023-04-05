package test.POST;

import BaseURLs.GorestCoBaseURL;
import TestData.GoRestApiTestData;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Post01 extends GorestCoBaseURL {


  /*
    Given
        https://gorest.co.in/public/v2/users
    When
        Kullanıcı POST Methodu ile Request Gönderir
    Then
        Status Code un "422" olduğunu Assert et

   */

  @Test
    public void post01(){

      specification.pathParam("usersPath","users");

      GoRestApiTestData goRestApiTestData = new GoRestApiTestData();
      System.out.println("Expected Test Data :" +goRestApiTestData.statuscodeforPostInvalid());

      Response response =given().spec(specification).when().
              header("Authorization" , "Bearer 5b9119d06f1e03e6349f75b699a2a68802fbae8766292381a2356f9531efbaf0").post("/{usersPath}");
      System.out.println("Response:  ");
      response.prettyPrint();


      Assert.assertEquals(goRestApiTestData.statuscodeforPostInvalid(),response.getStatusCode());
      response.then().assertThat().statusCode(422);





  }







}
