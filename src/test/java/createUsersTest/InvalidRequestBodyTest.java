package createUsersTest;

import dto.user.UserResponseDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class InvalidRequestBodyTest extends UserBaseTest {

  private static final String BASE_URL = "https://petstore.swagger.io/";
  public static void setup() {
    RestAssured.baseURI = BASE_URL;
  }

  @Test
  public void InvalidRequestBody() {
    // Тесткейс: Проверяем создание пользователя с неправильным телом запроса
    // Ожидаемый результат: Код ответа 400 и сообщение об ошибке

    given()
            .contentType(ContentType.JSON)
            .body("{\"invalid\": \"request body\"}")
            .when()
            .post("/user")
            .then()
            .statusCode(400)
            .body("message", equalTo("Invalid request body"));

    // Добавленный код для проверки результата
    Response response = given()
            .contentType(ContentType.JSON)
            .body("{\"invalid\": \"request body\"}")
            .when()
            .post("/user");

    UserResponseDTO userResponse = response.getBody().as(UserResponseDTO.class);
    String actualType = response.jsonPath().get("type");

    Assertions.assertEquals("unknown", userResponse.getType(), "Incorrect type");
    Assertions.assertEquals("450", userResponse.getMessage(), "Incorrect message");
    Assertions.assertEquals("200", userResponse.getCode(), "Incorrect type");
  }
}
