package test;

import BaseURLs.DummyBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

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

        JsonPath jsonPath = response.jsonPath();
        /*employee_age i 55'ten büyük olanları konsola yazdırınız.
        8 tane olduğunu assert ediniz.*/
        List<Integer> EmployeeAges =jsonPath.getList("data.employee_age");

       int count = 0;
        for (Integer w: EmployeeAges) {
            if(w>55){
                count++;
            }

        }
        System.out.println("count = " + count);
        assertEquals(8,count);
/*
        id si 17 den büyük olanları konsola yazdırınız
        7 tane olduğunu assert ediniz.

        */

        // 1. yol

            List<Integer> idList =jsonPath.getList("data.id");
        System.out.println("idList = " + idList);

            int idcount = 0;
        for (Integer w: idList) {
            if(w>17){
             idcount++;
            }
        }
        System.out.println("idcount = " + idcount);
        assertEquals(7,idcount);


        // 2. yol Groovy language

        List<Integer> idS =jsonPath.getList("data.findAll{it.id>17}.id");
        System.out.println("idS = " + idS);
        assertEquals(7,idS.size());


        /* salary si 100.000'den az olanları konsola yazdırınız.
        Doris Wilder'ın bunlardan biri olduğunu assert ediniz.
        */


        List<Integer> Salary =jsonPath.getList("data.findAll{it.employee_salary<100000}.employee_salary");
        System.out.println("Salary = " + Salary);
































    }
}
