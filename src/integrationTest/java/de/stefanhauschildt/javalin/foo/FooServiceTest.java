package de.stefanhauschildt.javalin.foo;

import de.stefanhauschildt.javalin.Application;
import de.stefanhauschildt.javalin.ApplicationExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.restassured.RestAssured.given;

@ExtendWith(ApplicationExtension.class)
class FooServiceTest {

  private final Application application;

  FooServiceTest(final Application application) {
    this.application = application;
  }

  @Test
  void get200() {
    given().baseUri("http://localhost")
        .port(application.port())
        .when().get("/")
        .then().assertThat().statusCode(200);
  }

}