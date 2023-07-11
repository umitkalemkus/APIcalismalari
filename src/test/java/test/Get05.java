package test;

import BaseURLs.TheMovieUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get05 extends TheMovieUrl {

     /*
        Given
            https://api.themoviedb.org/3/movie/popular

            apı_key = 4c841d9ec32b7f8c0069cf3fec36774f
        When
             Kullanıcı GET Methodu ile Request Gönderir
        Then
            Status Code un "200" olduğunu Assert et
		And
            Content Type ın "application/json" olduğunu assert et
		And
		    id lerin içerisnde
		    646389
            536554
            640146 olduğunu assert ediniz.

     */
    @Test
    public void get05(){

        // 1- Set URL
        specification.pathParams("moviePath","movie","popularPath","popular").queryParam("api_key","4c841d9ec32b7f8c0069cf3fec36774f");

        // Set a expected data

        // 2- Send a request
        Response response = given().spec(specification).when().get("/{moviePath}/{popularPath}");
        response.prettyPrint();

        // 4- Assertions


        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).body("results.id", Matchers.hasItems(455476,385687));


















    }



}
