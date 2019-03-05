package de.stefanhauschildt.javalin;

import java.io.File;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import static io.restassured.RestAssured.given;

class ServiceTest {

  private static DockerComposeContainer environment = new DockerComposeContainer(
      new File("docker-compose.yml"))
      .withLocalCompose(false)
      .withExposedService("application_1", 7000, Wait.forListeningPort());

  @BeforeAll
  static void setUp() {
    environment.starting(null);
  }

  @AfterAll
  static void tearDown() {
    environment.finished(null);
  }

  @Test
  void get200() {
    given().baseUri("http://" + environment.getServiceHost("application_1", 7000))
        .port(environment.getServicePort("application_1", 7000))
        .when().get("/")
        .then().assertThat().statusCode(200);
  }

}