package steps;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;


public class Config {

    @Before
    public void setup(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(); //Em caso de erro no response, trazer um log mais detalhado

        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/user";


        RestAssured.requestSpecification = new RequestSpecBuilder().
                addHeader("Authorization", getToken()).
                setContentType(ContentType.JSON). // Especificando que iremos trabalhar com JSON no request

                build();

        RestAssured.responseSpecification = new ResponseSpecBuilder(). // Especificando que iremos trabalhar com JSON no response
                expectContentType(ContentType.JSON).// Especificando que iremos trabalhar com JSON no response
                build();

    }

    private String getToken() {
        return "grant acess";

    }


}
