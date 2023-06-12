package findPetByIdTest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FindPetByIdTests {

  private static final String BASE_URL = "https://petstore.swagger.io/";

  @BeforeAll
  public static void setup() {
    RestAssured.baseURI = BASE_URL;
  }

  @Test
  public void testFindPetById_ExistingPetId() {
    // Тесткейс: Проверяем поиск существующего питомца по его идентификатору
    // Ожидаемый результат: Код ответа 200 и питомец с указанным идентификатором

    long petId = 12345;

    given()
            .pathParam("petId", petId)
            .when()
            .get("/pet/{petId}")
            .then()
            .statusCode(200)
            .body("id", equalTo(petId))
            .body("name", equalTo("Max"))
            .body("status", equalTo("available"));
  }

  @Test
  public void testFindPetById_NonexistentPetId() {
    // Тесткейс: Проверяем поиск несуществующего питомца по его идентификатору
    // Ожидаемый результат: Код ответа 404 и сообщение об ошибке

    long petId = 99999;

    given()
            .pathParam("petId", petId)
            .when()
            .get("/pet/{petId}")
            .then()
            .statusCode(404)
            .body("message", equalTo("Pet not found"));
  }

  @Test
  public void testFindPetById_InvalidPetId() {
    // Тесткейс: Проверяем поиск питомца с неправильным форматом идентификатора
    // Ожидаемый результат: Код ответа 400 и сообщение об ошибке

    String petId = "invalid_id";

    given()
            .pathParam("petId", petId)
            .when()
            .get("/pet/{petId}")
            .then()
            .statusCode(400)
            .body("message", equalTo("Invalid pet ID format"));
  }
}
