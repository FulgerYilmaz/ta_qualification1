package base_url_setup;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class PetStoreBaseUrl {
        protected static RequestSpecification spec;

        public static void petstore(){
            spec = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2").build();
        }
    }

