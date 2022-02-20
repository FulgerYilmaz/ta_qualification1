package stepdefinitions.api_steps;

import java.util.HashMap;
import java.util.Map;

public class ExpectedData {
    /* {
  "id": 0,
  "petId": 0,
  "quantity": 0,
  "shipDate": "2022-02-19T20:34:01.698Z",
  "status": "placed",
  "complete": true
}

}*/

    public HashMap<String,Object> postData(){
        HashMap<String,Object> expectedDataMap= new HashMap<>();
                expectedDataMap.put("id", 8);
                expectedDataMap.put("petId", 9);
                expectedDataMap.put("quantity", 0);
                expectedDataMap.put("shipDate", "2022-02-19T20:34:01.698Z");
                expectedDataMap.put("status", "placed");
                expectedDataMap.put("complete", true);
                return expectedDataMap;


    }


}
