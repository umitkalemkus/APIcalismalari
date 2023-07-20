package test;

import BaseURLs.ZippopotamusBaseUrl;
import com.beust.ah.A;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojoDatas.ZippoPotamPlaces;
import pojoDatas.ZippoPotamPojos;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Get11 extends ZippopotamusBaseUrl {
      /*


        Given
            http://api.zippopotam.us/TR/34010
       When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
 		And
 		    Response body nin bu şekilde olduğunu doğrular

            {
    "post code": "34010",
    "country": "Turkey",
    "country abbreviation": "TR",
    "places": [
        {
            "place name": "Maltepe Mah.",
            "longitude": "32.3609",
            "state": "İstanbul",
            "state abbreviation": "34",
            "latitude": "40.1589"
        }
    ]
}




       */
   @Test
   public void get11(){

      specification.pathParams("CountryPath","TR","idPath","34010");


      ZippoPotamPlaces zippoPotamPlaces = new ZippoPotamPlaces("Maltepe Mah.","32.3609","İstanbul","34","40.1589");
      ZippoPotamPojos zippoPotamPojos = new ZippoPotamPojos("34010","Turkey","TR",zippoPotamPlaces);

      System.out.println("Expected Data  = " + zippoPotamPojos);


      Response response = given().spec(specification).get("/{CountryPath}/{idPath}");
      System.out.println("Responce :");
      response.prettyPrint();

      //Assertion
      Map<String ,Object> actualData = response.as(HashMap.class);
      System.out.println("actualData = " + actualData);


      Assert.assertEquals(zippoPotamPojos.getCountry(),actualData.get("country"));
      Assert.assertEquals(zippoPotamPojos.getPostCode(),actualData.get("post code"));
      Assert.assertEquals(zippoPotamPojos.getCountryAbbreviation(),actualData.get("country abbreviation"));
      Assert.assertEquals(zippoPotamPojos.getZippoPotamPlaces().getPlaceName(),(((Map)((List)actualData.get("places")).get(0))).get("place name"));
      Assert.assertEquals(zippoPotamPojos.getZippoPotamPlaces().getLatitude(),(((Map)((List) actualData.get("places")).get(0))).get("latitude"));
      Assert.assertEquals(zippoPotamPojos.getZippoPotamPlaces().getStateAbbreviation(),(((Map)((List) actualData.get("places")).get(0))).get("state abbreviation"));








   }







}
