package test;

import BaseURLs.DummyBaseURL;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get07 extends DummyBaseURL {

    /*
        Given
	   	    https://dummy.restapiexample.com/api/v1/employees
		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
		     employee_age i 55'ten büyük olanları konsola yazdırınız.
		     8 tane olduğunu assert ediniz.
		And
            id si 17 den büyük olanları konsola yazdırınız
            7 tane olduğunu assert ediniz.
        And
            salary si 100.000'den az olanları konsola yazdırınız.
            Doris Wilder'ın bunlardan biri olduğunu assert ediniz.
        And



     */
    @Test
    public void get07() {
        // Set URL
        specification.pathParam("EmployeesPath","employees");

        //Send a request

        Response response = given().spec(specification).when().get("/{EmployeesPath}");
        response.prettyPrint();


       // Assertions

        response.then().assertThat().statusCode(200);











    }
}
