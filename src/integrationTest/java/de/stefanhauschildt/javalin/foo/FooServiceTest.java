package de.stefanhauschildt.javalin.foo;

import de.stefanhauschildt.javalin.Application;
import de.stefanhauschildt.javalin.DaggerApplication_Builder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

class FooServiceTest {

  private static Application application = DaggerApplication_Builder.create().app();

  @BeforeAll
  static void setUp() {
    application.start(0);
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