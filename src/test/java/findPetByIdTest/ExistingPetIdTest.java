package findPetByIdTest;

import dto.pet.Pet;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ExistingPetIdTest {

  private static final String BASE_URL = "https://petstore.swagger.io/";

  @BeforeAll
  public static void setup() {
    RestAssured.baseURI = BASE_URL;
  }

  @Test
  public void ExistingPet() {
    // Тесткейс: Проверяем поиск существующего питомца по его идентификатору
    // Ожидаемый результат: Код ответа 200 и питомец с указанным идентификатором

    long petId = 12345;

    Response response = given()
            .pathParam("petId", petId)
            .when()
            .get("/pet/{petId}")
            .then()
            .statusCode(200)
            .extract().response();

    Pet petResponse = response.as(Pet.class);

    Assertions.assertEquals(petId, petResponse.getId(), "Incorrect pet ID");
    Assertions.assertEquals("Max", petResponse.getName(), "Incorrect pet name");
    Assertions.assertEquals("available", petResponse.getStatus(), "Incorrect pet status");
  }
}
