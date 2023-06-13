package findPetByIdTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class InvalidPetIdTest {

  private static final String BASE_URL = "https://petstore.swagger.io/";

  @BeforeAll
  public static void setup() {
    RestAssured.baseURI = BASE_URL;
  }

  @Test
  public void InvalidPetId() {
    // Тесткейс: Проверяем поиск питомца с неправильным форматом идентификатора
    // Ожидаемый результат: Код ответа 400 и сообщение об ошибке

    String petId = "invalid_id";

    Response response = given()
            .pathParam("petId", petId)
            .when()
            .get("/pet/{petId}")
            .then()
            .statusCode(400)
            .extract().response();

    String errorMessage = response.jsonPath().get("message");

    Assertions.assertEquals("Invalid pet ID format", errorMessage, "Incorrect error message");
  }
}