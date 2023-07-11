package test;

import BaseURLs.GorestCoBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get06 extends GorestCoBaseURL {


     /*
        Given
            https://gorest.co.in/public/v2/todos/19955
        When
             Kullanıcı GET Methodu ile Request Gönderir
        Then
            Status Code un "200" olduğunu Assert et
		And
            Content Type ın "application/json" olduğunu assert et
        And
            Response Body nin aşağıdai gibi olduğunu asssert et
       {
"id": 14071,
"user_id": 592752,
"title": "Pariatur spoliatio odit defaeco uberrime ambulo asperiores velut et eveniet.",
"due_on": "2023-03-20T00:00:00.000+05:30",
"status": "pending"
}
 */
    @Test
   public void get06(){

       specification.pathParams("TodosPath","todos","idPath","19955");

       Response response = given().spec(specification).when().get("/{TodosPath}/{idPath}");
       response.prettyPrint();

  //1. way
     /*  response.then().assertThat().statusCode(200).
               contentType(ContentType.JSON).
               body("id", Matchers.equalTo(19955),"user_id",Matchers.equalTo(3582393),"title",
                       Matchers.equalTo("Bos arbustum tam aranea veritas facilis accusantium baiulus."));
*/
   //2. way

        JsonPath jsonPath = response.jsonPath();
        assertEquals(3582393,jsonPath.getInt("user_id"));
        assertEquals("Bos arbustum tam aranea veritas facilis accusantium baiulus.",jsonPath.getString("title"));
        assertEquals("2023-07-29T00:00:00.000+05:30",jsonPath.getString("due_on"));
        assertEquals("completed",jsonPath.getString("status"));





   }





}
