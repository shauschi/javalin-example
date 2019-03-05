package de.stefanhauschildt.javalin;

import io.javalin.Handler;

class Controller {

  static Handler getHelloWorld = ctx -> ctx.result("Hello World");
  static Handler getFoo = ctx -> ctx.json(Service.foo(ctx.pathParam("message")));

}
