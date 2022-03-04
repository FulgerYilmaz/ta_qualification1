package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ApiRequestsUtils {

    public static Response getRequest( String endPoint){
        return given().headers(
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when()
                .get(endPoint)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
    }
}
