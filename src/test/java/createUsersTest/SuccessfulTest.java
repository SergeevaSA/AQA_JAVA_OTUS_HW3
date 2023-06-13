package createUsersTest;

import dto.user.UserResponseDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SuccessfulTest extends UserBaseTest {

  private static final String BASE_URL = "https://petstore.swagger.io/";
  public static void setup() {
    RestAssured.baseURI = BASE_URL;
  }

  @Test
  public void Successful() {
    // Тесткейс: Проверяем успешное создание пользователя
    // Ожидаемый результат: Код ответа 200 и созданный пользователь с указанным именем и статусом

    String username = "john_doe";
    String status = "active";

    // Добавленный код для проверки результата
    Response response = given()
            .contentType(ContentType.JSON)
            .body("{\"username\": \"" + username + "\", \"status\": \"" + status + "\"}")
            .when()
            .post("/user");

    UserResponseDTO userResponse = response.getBody().as(UserResponseDTO.class);
    String actualType = response.jsonPath().get("type");

    Assertions.assertEquals("unknown", userResponse.getType(), "Incorrect type");
    Assertions.assertEquals("450", userResponse.getMessage(), "Incorrect message");
    Assertions.assertEquals("200", userResponse.getCode(), "Incorrect code");
  }
}

