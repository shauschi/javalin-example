package de.stefanhauschildt.javalin;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

class ServiceTest {

  private static Application application = new Application(0);

  @BeforeAll
  static void setUp() {
    application.start();
  }

  @AfterAll
  static void tearDown() {
    application.stop();
  }

  @Test
  void get200() {
    given().baseUri("http://localhost")
        .port(application.port())
        .when().get("/")
        .then().assertThat().statusCode(200);
  }

}