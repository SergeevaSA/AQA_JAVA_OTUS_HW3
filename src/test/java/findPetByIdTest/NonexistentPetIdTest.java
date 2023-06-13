package findPetByIdTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class NonexistentPetIdTest {

  private static final String BASE_URL = "https://petstore.swagger.io/";
  public static void setup() {
    RestAssured.baseURI = BASE_URL;
  }

  @Test
  public void NonexistentPetId() {
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

    // Добавленный код для проверки результата
    Response response = given()
            .pathParam("petId", petId)
            .when()
            .get("/pet/{petId}")
            .then()
            .statusCode(404)
            .extract().response();

    String errorMessage = response.jsonPath().get("message");

    Assertions.assertEquals("Pet not found", errorMessage, "Incorrect error message");
  }
}
