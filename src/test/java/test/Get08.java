package test;

import BaseURLs.SwapiBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class Get08  extends SwapiBaseUrl {


    @Test
    public void get08(){
     // 1- Set up base Url
    specification.pathParams("vehiclesPath","vehicles","id_Path", "4");

    /*    {
            "name": "Sand Crawler",
                "model": "Digger Crawler",
                "manufacturer": "Corellia Mining Corporation",
                "cost_in_credits": "150000",
                "length": "36.8 ",
                "max_atmosphering_speed": "30",
                "crew": "46",
                "passengers": "30",
                "cargo_capacity": "50000",
                "consumables": "2 months",
                "vehicle_class": "wheeled",
                "pilots": [

    ],
            "films": [
            "https://swapi.dev/api/films/1/",
                    "https://swapi.dev/api/films/5/"
    ],
            "created": "2014-12-10T15:36:25.724000Z",
                "edited": "2014-12-20T21:30:21.661000Z",
                "url": "https://swapi.dev/api/vehicles/4/"
        }*/

      //2- Expected data
      List<String> pilotList = new ArrayList<>();
      System.out.println("pilotList = " + pilotList);

      List<String> filmsList = new ArrayList<>();
      filmsList.add("https://swapi.dev/api/films/1/");
      filmsList.add("https://swapi.dev/api/films/5/");
      System.out.println("filmsList = " + filmsList);


        Map<String,Object> ExpectedDataMap = new HashMap<>();
        ExpectedDataMap.put("name","Sand Crawler");
        ExpectedDataMap.put("model","Digger Crawler");
        ExpectedDataMap.put("manufacturer","Corellia Mining Corporation");
        ExpectedDataMap.put("cost_in_credits","150000");
        ExpectedDataMap.put("length","36.8 ");
        ExpectedDataMap.put("max_atmosphering_speed","30");
        ExpectedDataMap.put("crew","46");
        ExpectedDataMap.put("passengers","30");
        ExpectedDataMap.put("cargo_capacity","50000");
        ExpectedDataMap.put("consumables","2 months");
        ExpectedDataMap.put("vehicle_class","wheeled");
        ExpectedDataMap.put("pilots",pilotList);
        ExpectedDataMap.put("films",filmsList);
        ExpectedDataMap.put("created","2014-12-10T15:36:25.724000Z");
        ExpectedDataMap.put("edited","2014-12-20T21:30:21.661000Z");
        ExpectedDataMap.put("url","https://swapi.dev/api/vehicles/4/");

        System.out.println("ExpectedDataMap = " + ExpectedDataMap);


        // 3-Send a request
        Response response = given().
                spec(specification).
                when().
                get("/{vehiclesPath}/{id_Path}");
      System.out.println("Response:  ");
        response.prettyPrint();




       // 4-Assertions

     // 1. way

    /*  response.then().assertThat().statusCode(200).body("name", equalTo(ExpectedDataMap.get("name")),"model",
              equalTo(ExpectedDataMap.get("model")),"manufacturer", equalTo(ExpectedDataMap.get("manufacturer")),"cost_in_credits", equalTo(ExpectedDataMap.get("cost_in_credits")),
      "length", equalTo(ExpectedDataMap.get("length")),"max_atmosphering_speed",equalTo(ExpectedDataMap.get("max_atmosphering_speed")),"crew",equalTo(ExpectedDataMap.get("crew")),
              "passengers",equalTo(ExpectedDataMap.get("passengers")),"cargo_capacity",equalTo(ExpectedDataMap.get("cargo_capacity")),"consumables",
              equalTo(ExpectedDataMap.get("consumables")),"vehicle_class",equalTo(ExpectedDataMap.get("vehicle_class")),"pilots", equalTo(ExpectedDataMap.get("pilots")),"films",
              equalTo(ExpectedDataMap.get("films")),"created",equalTo(ExpectedDataMap.get("created")),"edited",equalTo(ExpectedDataMap.get("edited")),"url",equalTo(ExpectedDataMap.get("url"))
              );
*/
     /*   JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals("Corellia Mining Corporation",jsonPath.getString("manufacturer"));*/


      //2. way

      Map<String,Object> actualData = response.as(HashMap.class);
      System.out.println("actualData = " + actualData);


   /*
      GSON -----> Deserialization

              Deserialization --> Json objesini , Java objesine convert etmek demektir.



*/
       // Assertion


      Assert.assertEquals(ExpectedDataMap.get("name"), actualData.get("name"));


    }



   // https://swapi.dev/api/vehicles/4



}
