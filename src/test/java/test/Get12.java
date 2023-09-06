package test;

import BaseURLs.GorestCoBaseURL;
import org.junit.Test;

public class Get12 extends GorestCoBaseURL {

  /*  Given
    https://gorest.co.in/public/v2/users/723297
    When
    Kullanıcı GET Methodu ile Request Gönderir
    Then
    Status Code un "200" olduğunu Assert et
            And
    Response body nin bu şekilde olduğunu doğrular

    {
        "id": 724790,
            "name": "Dr. Lalita Rana",
            "email": "rana_dr_lalita@block.org",
            "gender": "male",
            "status": "active"
    }

    */

@Test
    public void get12(){

    // Step 1 : Set URL
    specification.pathParams("userPath","users",
            "idPath","702440");

    // Step 1 : Set Expected Data

    String expectedData = "{\n" +
            "        \"id\": 724790,\n" +
            "            \"name\": \"Dr. Lalita Rana\",\n" +
            "            \"email\": \"rana_dr_lalita@block.org\",\n" +
            "            \"gender\": \"male\",\n" +
            "            \"status\": \"active\"\n" +
            "    }\n";


    System.out.println("expectedData = " + expectedData);





}



}
