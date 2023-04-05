package TestData;

import java.util.HashMap;

public class GoRestApiTestData {


    //422

    public int statuscodeforPostInvalid(){



        return 422;

    }

 /*   {
        "name": "Tenali Ramakrishna",
            "gender": "male",
            "email": "tenali.ramakrishna@15ce.com",
            "status": "active"
    }*/



    public HashMap<String ,String> RequestBodyAndExpectedData(String name ,String gender , String email , String status){


              HashMap<String ,String> RequestBodyAndExpectedMap = new HashMap<>();
              RequestBodyAndExpectedMap.put("name",name);
              RequestBodyAndExpectedMap.put("gender" , gender);
              RequestBodyAndExpectedMap.put("email",email);
              RequestBodyAndExpectedMap.put("status",status);


              return RequestBodyAndExpectedMap;






    }






}
