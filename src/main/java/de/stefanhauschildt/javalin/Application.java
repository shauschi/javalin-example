package de.stefanhauschildt.javalin;

import io.javalin.Javalin;

public class Application {

  public static void main(String[] args) {
    final Service service = new Service();

    final Javalin app = Javalin.create().start(7000);
    app.get("/", ctx -> ctx.result("Hello World"));
    app.get("/foo/:message", ctx -> ctx.json(service.foo(ctx.pathParam("message"))));
  }

}
