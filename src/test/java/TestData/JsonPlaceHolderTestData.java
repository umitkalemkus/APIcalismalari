package TestData;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {


     public static HashMap<String,Object> expectedData;

    public HashMap setUpDataTodos(){
        expectedData = new HashMap<>();
         expectedData.put("StatusCode",200);
         expectedData.put("Server","cloudflare");
         expectedData.put("userId",1);
        expectedData.put("id",2);
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("completed",false);

        System.out.println("expectedData = " + expectedData);


        return expectedData;
    }





}
