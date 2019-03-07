package de.stefanhauschildt.javalin.foo;

import io.javalin.Context;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class FooControllerTest {

  private FooController fooController;

  @BeforeEach
  void setUp() {
    fooController = new FooController(null);
  }

  @Test
  void getHelloWorld() {
    Context ctx = mock(Context.class);

    fooController.getHelloWorld(ctx);

    verify(ctx).result("Hello World");
  }

}
