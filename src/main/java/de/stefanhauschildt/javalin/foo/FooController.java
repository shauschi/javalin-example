package de.stefanhauschildt.javalin.foo;

import io.javalin.Context;
import javax.inject.Inject;
import org.jetbrains.annotations.NotNull;

public class FooController {

  private final FooService fooService;

  @Inject
  FooController(FooService fooService) {
    this.fooService = fooService;
  }

  public void getHelloWorld(@NotNull Context ctx) {
    ctx.result("Hello World");
  }

  public void getFoo(@NotNull Context ctx) {
    ctx.json(fooService.foo(ctx.pathParam("message")));
  }
}
