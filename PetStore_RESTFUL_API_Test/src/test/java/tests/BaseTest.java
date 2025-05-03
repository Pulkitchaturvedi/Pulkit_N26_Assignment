package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import model.Pet;
import org.junit.jupiter.api.BeforeAll;
import io.restassured.response.Response;


import java.util.Collections;

import static io.restassured.RestAssured.given;

public class BaseTest {

    protected static RequestSpecification requestSpec;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        requestSpec = given()
                .header("api_key", "pulkit")
                .contentType(ContentType.JSON);
    }

    protected Pet createDefaultPet() {
        Pet pet = new Pet();
        pet.setId((int) (System.currentTimeMillis() % 1000000));
        pet.setName("Snoopy");
        pet.setPhotoUrls(Collections.singletonList("https://example.com/dog.jpg"));
        pet.setStatus("available");
    
        Response response = requestSpec
                .contentType(ContentType.JSON)
                .body(pet)
                .log().all()
                .when()
                .post("/pet")
                .then()
                .log().all()
                .extract()
                .response();
    
        System.out.println("CREATE PET - Status code: " + response.getStatusCode());
        System.out.println("CREATE PET - Response body: " + response.getBody().asString());
    
        int actualId = response.then()
                .statusCode(200)
                .extract()
                .path("id");
    
        pet.setId(actualId);
        return pet;
    }
}
