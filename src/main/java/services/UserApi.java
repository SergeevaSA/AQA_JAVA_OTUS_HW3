package services;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserApi {
  private static final String BASE_URI = "https://petstore.swagger.io/v2/";
  private RequestSpecification spec;
  private static final String USER = "/user";

  public void exampleTest() {
    given()
            .baseUri("https://petstore.swagger.io/v2")  //https://petstore.swagger.io/v2{userName}
            .header("Content-Type", "application/json")
            .basePath("user")
            .param("userName", "testUser")
            .log().all()
            .body("")
            .when()
            .post()
            .then()
            .log().all();
  }

  public UserApi() {
    spec = given()
            .baseUri(BASE_URI)
            .contentType(ContentType.JSON);
  }
}