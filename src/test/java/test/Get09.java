package test;

import BaseURLs.JsonPlaceHolderBaseUR;
import TestData.JsonPlaceHolderTestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Get09 extends JsonPlaceHolderBaseUR {




  /*  Given
	   	     https://jsonplaceholder.typicode.com/todos/2
		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
            Header da Server ın cloudflare olduğunu Assert et
		And
		     Response body nin bu şekilde olduğunu doğrular

    "userId": 1,
    "id": 2,
    "title": "quis ut nam facilis et officia qui",
    "completed": false
*/

     @Test
    public void get09() {
        // 1-Set Up url
        specification.pathParams("todosPath","todos","idPath","2");

        // 2-Expected Data

         Map<String, Object> ExpectedDatalist = new HashMap<>();
         ExpectedDatalist.put("userId",1);
         ExpectedDatalist.put("id",2);
         ExpectedDatalist.put("title","quis ut nam facilis et officia qui");
         ExpectedDatalist.put("completed",false);
         System.out.println("ExpectedDatalist = " + ExpectedDatalist);

         //3- Send a request

         Response response = given().spec(specification).get("/{todosPath}/{idPath}");
         System.out.println("Response:  ");
         response.prettyPrint();


         //4-Assertions

         //1. way



         response.then().assertThat().statusCode(200).body("userId",
                 equalTo(1),"id" ,equalTo(2) ,"title",
                 equalTo("quis ut nam facilis et officia qui"),"completed",equalTo(false));


         // 2.way
          //(Ters)

        Assert.assertEquals(1,jsonPath.getInt("userId"));
        Assert.assertEquals(2,jsonPath.getInt("id"));
        Assert.assertEquals("quis ut nam facilis et officia qui",jsonPath.getString("title"));
        Assert.assertEquals(false,jsonPath.getBoolean("completed"));




         //3. way
         //GSON -----> Deserialization
         Map<String,Object> actualData = response.as(HashMap.class);
         System.out.println("actualData = " + actualData);

         Assert.assertEquals(ExpectedDatalist,actualData);


         //4. WAY Storage

         JsonPlaceHolderTestData jsonPlaceHolderTestData = new JsonPlaceHolderTestData();
         HashMap<String,Object> expecteddatastorage = jsonPlaceHolderTestData.setUpDataTodos();
         System.out.println("expecteddatastorage = " + expecteddatastorage);

         Assert.assertEquals(expecteddatastorage.get("Server"),response.getHeader("Server"));
         Assert.assertEquals(expecteddatastorage.get("StatusCode"),response.getStatusCode());
         Assert.assertEquals(expecteddatastorage.get("id"),actualData.get("id"));
         Assert.assertEquals(expecteddatastorage.get("userId"),actualData.get("userId"));
         Assert.assertEquals(expecteddatastorage.get("title"),actualData.get("title"));
         Assert.assertEquals(expecteddatastorage.get("completed"),actualData.get("completed"));








     }

}



