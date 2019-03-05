package de.stefanhauschildt.javalin;

import io.javalin.Context;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ControllerTest {

  @Test
  void getHelloWorld() throws Exception {
    Context ctx = mock(Context.class);

    Controller.getHelloWorld.handle(ctx);

    verify(ctx).result("Hello World");
  }

}
