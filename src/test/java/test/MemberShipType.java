package test;

import BaseURLs.MemberShipPojo;
import BaseURLs.a3mURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.JsonToJava;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class MemberShipType extends a3mURL {

    String access_token = "eyJrfaWQiOiIyOGQ1MDVjMy01MDgxLTQwOGEtOGU0NC01NTgzMTYxN2EwYjQiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJncm91cDZAdGVzdC5jb20iLCJzdWJfZGVmYXVsdF9tZW1iZXJzaGlwX3R5cGVfaWQiOjUsInN1Yl9pZCI6MzYsInN1Yl9kZWZhdWx0X3N1YnNjcmlwdGlvbl9pZCI6ImJhMzYxYTE5LTVmYmItNDM2Ni1iNDI1LTUwMjMwZjFkNzkxOCIsInN1Yl9hcHAiOjIsImlzcyI6Imh0dHBzOlwvXC9hM20tcWEtZ20zLnF1YXNwYXJlcGFydHMuY29tIiwic3ViX2RlZmF1bHRfb3JnX2lkIjoxLCJhdWQiOiIxNjczOTg1MTg0X1pYc05UN0N1aFR6cmlqbCIsIm5iZiI6MTY4MDUzMjk4NSwic3ViX2RlZmF1bHRfb3JnX25hbWUiOiJBY21lIExMQyIsInNjb3BlIjpbIlJPTEVfQnVzaW5lc3MgT3duZXIiLCJhcHBsaWNhdGlvbjpyZWFkIiwib3JkZXI6d3JpdGUiLCJmaWxlOndyaXRlIiwiaW52ZW50b3J5OnJlYWQiLCJyZWNlcHRpb246Y29uZmlybSIsIndpc2hsaXN0OmFwcHJvdmVkIiwiaW52b2ljZTpyZWFkIiwiaW52ZW50b3J5OndyaXRlIiwidXNlci1yb2xlOnJlYWQiLCJkYXNoYm9hcmQ6cmVhZCIsInBlcm1pc3Npb246d3JpdGUiLCJ1c2VyOndyaXRlIiwic3BlY3ByaWNlOnJlYWQiLCJhY2NvdW50aW5nOndyaXRlIiwidXNlci1vcmdhbml6YXRpb246cmVhZCIsInVzZXItZ3JvdXA6cmVhZCIsInNwZWNwcmljZTp3cml0ZSIsImNvbXBhbnk6YWRtaW4iLCJtZW1iZXJzaGlwLXR5cGU6d3JpdGUiLCJyb2xlOndyaXRlIiwicGVybWlzc2lvbjpyZWFkIiwicHVyY2hhc2luZzpjb25maXJtIiwicmVjZXB0aW9uOnJlYWQiLCJ3aXNobGlzdDpxdWFsaXR5X2NvbmZpcm0iLCJ1c2VyLWdyb3VwOndyaXRlIiwidXNlci1zdGF0dXM6cmVhZCIsImNvdW50cnk6cmVhZCIsIm1lbWJlcnNoaXAtdHlwZTpyZWFkIiwicHJvY3VyZW1lbnQ6cmVhZCIsIm9yZ2FuaXphdGlvbi1zdGF0dXM6d3JpdGUiLCJjb21wYW55OnJlYWQiLCJjb21wYW55OmZpbl9jb25maXJtIiwidXNlci1zdGF0dXM6d3JpdGUiLCJ3aXNobGlzdDpzZXRfY29kaW5nIiwidXNlci1ncm91cC10eXBlOnJlYWQiLCJ1c2VyLXJvbGU6d3JpdGUiLCJ3aXNobGlzdDpvZmZlcl9yZWFkeSIsInB1cmNoYXNpbmc6cmVhZCIsIm9yZ2FuaXphdGlvbjpyZWFkIiwid2lzaGxpc3Q6YWRtaW4iLCJvcmRlcjpyZWFkIiwidXNlci1vcmdhbml6YXRpb246d3JpdGUiLCJoYW5kbWFkZTp3cml0ZSIsIndpc2hsaXN0Om9mZmVyX2NvbmZpcm0iLCJ3aXNobGlzdDpjYW5jZWwiLCJhcHBsaWNhdGlvbjp3cml0ZSIsInN1YnNjcmlwdGlvbjpyZWFkIiwiZmlsZTpyZWFkIiwidXNlcjpyZWFkIiwidXNlci1ncm91cC10eXBlOndyaXRlIiwib3JnYW5pemF0aW9uLWdyb3VwOnJlYWQiLCJpbnZvaWNlOndyaXRlIiwiaGFuZG1hZGU6Y29uZmlybSIsInJlY2VwdGlvbjp3cml0ZSIsIndpc2hsaXN0OnNldF9wcmljZSIsIm9yZ2FuaXphdGlvbjp3cml0ZSIsInJvbGU6cmVhZCIsIm1lbWJlcnNoaXA6cmVhZCIsIndpc2hsaXN0OnNhbGVfY29uZmlybSIsIm9yZ2FuaXphdGlvbi1ncm91cDp3cml0ZSIsInB1cmNoYXNpbmc6d3JpdGUiLCJ3aXNobGlzdDp2aWV3X3N1cHBfcHJpY2UiLCJpbnZvaWNlOmNvbmZpcm0iLCJjbGllbnQ6d3JpdGUiLCJoYW5kbWFkZTpyZWFkIiwicHJvY3VyZW1lbnQ6d3JpdGUiLCJvcmdhbml6YXRpb24tc3RhdHVzOnJlYWQiLCJjb21wYW55OnF1YWxfY29uZmlybSIsInB1cmNoYXNpbmc6cmVhZF9jb3N0IiwibWVtYmVyc2hpcDp3cml0ZSIsImFjY291bnRpbmc6cmVhZCIsIm9yZGVyOmNvbmZpcm0iLCJzdWJzY3JpcHRpb246d3JpdGUiLCJ3aXNobGlzdDpyZWFkIiwiY2xpZW50OnJlYWQiXSwic3ViX2RlZmF1bHRfcm9sZV9pZCI6NSwiZXhwIjoxNjgwNTM0Nzg1LCJpYXQiOjE2ODA1MzI5ODV9.Sru-j8PWBbM-aEl1gD4cpND9pO2jWg3VnjYPv6oDh0HbR4-tGfuC1buLjupcpbITyyOB8VNBGecmxqSE85ikYL6fgUhPqe3KH8YEjUWgy8UuHtcnlOAKnEnLlh66RPCwN19cHkMpOI_i-bmSeZBQfgzV3aDGZChEJyhbALUfJGkZ6DBSyIJti3yqes33EcQ_FbIQ0lg1BC1RC-4ei30heGrlNrC1oolAFFiSoYfmU3MdRIkWtrAa2-PxaImeQlyIsGlPhhjA3jwpX89ZqrASuCYXK9inFLmLFLg91nQr-Uq8XbHuMoQxZEEUTqEYa0xzraiPwNQETn_T4VTSWOMpAw";

    HashMap<String, Object> MembershipData;
    @Test
    public void GET_TC001_MembershipTypeAppID(){
        specification.pathParams( "applicationPath","application","idPath", 2 ,"MembershiptypePath","membership-type");
//        String URL = "https://a3m-qa-gm3.quaspareparts.com/auth/api/user";
        Response response = given().
                spec(specification).
                when().
                header("Authorization","Bearer "+access_token).
                get("/{applicationPath}/{idPath}/{MembershiptypePath}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
    }




    @Test
    public void GET_TC002_MembershipType(){
        specification.pathParam( "MembershiptypePath","membership-type");
//        String URL = "https://a3m-qa-gm3.quaspareparts.com/auth/api/user";
        Response response = given().
                spec(specification).
                when().
                header("Authorization","Bearer "+access_token).
                get("/{MembershiptypePath}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        System.out.println("response.getStatusCode() = " + response.getStatusCode());

    }


    @Test
    public void POST_TC003_AddNewUser()  {
        String URL = "https://a3m-qa-gm3.quaspareparts.com/auth/api/membership-type";
        MemberShipPojo pj = new MemberShipPojo("Doctors2 Wholesaler", "false");
        Response response = given().
                contentType(ContentType.JSON).
                header("Authorization", "Bearer " + access_token).
                body(pj).
                when().
                post(URL);

        response.prettyPrint();

         MembershipData = JsonToJava.convertJsonToJavaObject(response.asString(), HashMap.class);
        System.out.println("actualDataMap = " + MembershipData);

        response.then().assertThat().statusCode(201);
        System.out.println("response.getStatusCode() = " + response.getStatusCode());








    }

}
