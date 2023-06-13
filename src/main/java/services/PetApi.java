package services;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PetApi {
  private static final String BASE_URI = "https://petstore.swagger.io/v2";
  private RequestSpecification spec;
  private static final String PET = "/pet";

  public void exampleTest() {
    given()
            .baseUri(BASE_URI)
            .header("Content-Type", "application/json")
            .basePath(PET)
            .param("petId", "12345")
            .log().all()
            .body("")
            .when()
            .post()
            .then()
            .log().all();
  }

  public PetApi() {
    spec = given()
            .baseUri(BASE_URI)
            .contentType(ContentType.JSON);
  }
}