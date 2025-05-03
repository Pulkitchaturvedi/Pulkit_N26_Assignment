package tests;

import io.restassured.http.ContentType;
import model.Pet;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static io.restassured.RestAssured.given;
import io.qameta.allure.*;

@Epic("Pulkit home assignment")
public class PetTests extends BaseTest {

    @Test
    @Feature("Pet API")
    @Story("Create a new pet")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that a new pet can be created using POST /pet endpoint")
    public void createPetTest() {
        Pet pet = new Pet();
        pet.setId(1);
        pet.setName("Doggie");
        pet.setStatus("available");
        pet.setPhotoUrls(Collections.emptyList());

        given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .post("/pet")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("name", equalTo("Doggie"))
                .body("status", equalTo("available"));
    }

    @Test
    @Feature("Pet API")
    @Story("Update an existing pet")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that an existing pet's name and status can be updated using PUT /pet endpoint")
    public void updatePetTest() {
        Pet pet = createDefaultPet();
        pet.setName("SnoopyUpdated");
        pet.setStatus("sold");

        requestSpec
                .body(pet)
                .when()
                .put("/pet")
                .then()
                .statusCode(200)
                .body("name", equalTo(pet.getName()))
                .body("status", equalTo(pet.getStatus()));
    }

    @Test
    @Feature("Pet API")
    @Story("Delete an existing pet")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that an existing pet can be deleted using DELETE /pet/{petId} endpoint")
    public void deletePetTest() {
        Pet pet = createDefaultPet();

        requestSpec
                .when()
                .get("/pet/" + pet.getId())
                .then()
                .statusCode(200);

        requestSpec
                .header("api_key", "pulkit")
                .when()
                .delete("/pet/" + pet.getId())
                .then()
                .statusCode(200);
    }

    @Test
    @Feature("Pet API")
    @Story("Find pets by status")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify that pets can be retrieved by status using GET /pet/findByStatus endpoint")
    public void findPetsByStatusTest() {
        Pet pet = createDefaultPet();

        requestSpec
                .when()
                .get("/pet/findByStatus?status=" + pet.getStatus())
                .then()
                .statusCode(200)
                .body("status", hasItem(pet.getStatus()));
    }

    @Test
    @Feature("Pet API")
    @Story("Get non-existing pet")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Verify that retrieving a non-existing pet returns expected response")
    public void getNonExistingPetTest() {
        int fakeId = 999199999;

        requestSpec
                .when()
                .get("/pet/" + fakeId)
                .then()
                .statusCode(200);
    }
}
