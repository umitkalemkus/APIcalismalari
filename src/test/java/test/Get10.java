package test;

import BaseURLs.DummyBaseURL;
import TestData.DummyRestApiTestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class Get10 extends DummyBaseURL {

    private DummyRestApiTestData dummyRestApiTestData;

    /* Given
        https://dummy.restapiexample.com/api/v1/employees

        When
        Kullanıcı GET Methodu ile Request Gönderir
        Then
        Status Code un "200" olduğunu Assert et
                And
        Kullanıcı en son daki employee nin isminin "Doris Wilder" olduğunu dogrular
        And
        Kullanıcı 6. employee nin salary sinin 372000 olduğunu doğrular
        And
        Kullanıcı 21, 23 ve 59 yaşlarında employee olduğunu doğrular
    */
  @Test
  public void get10(){
      /*
        1) Set URL
        2) Set Expected Data
        3) Send a Request
        4) Assertion
         */


      //   1) Set URL

      specification.pathParam("employeesPath","employees");



     // 2) Set Expected Data

      DummyRestApiTestData dummyRestApiTestData = new DummyRestApiTestData();
       List<Map<String,Object>> expectedData = dummyRestApiTestData.setUpDummyRestTestData();
      System.out.println("expectedData = " + expectedData);



      //3) Send a Request
      Response response = given().spec(specification).when().get("/{employeesPath}");
     response.prettyPrint();

      response.then().assertThat().statusCode((Integer) expectedData.get(0).get("StatusCode")).body("data[-1].employee_name",equalTo(expectedData.get(1).get("EmployeeName")),
              "data[5].employee_salary",equalTo(expectedData.get(2).get("EmployeeSalary")),"data.employee_age",
              hasItems(((List) expectedData.get(3).get("EmployeeAges")).get(0),((List) expectedData.get(3).get("EmployeeAges")).
                      get(1),((List) expectedData.get(3).get("EmployeeAges")).get(2)));
                                   // list                     // map          //list
      //  Gson

      JsonPath jsonPath = response.jsonPath();























  }




}
