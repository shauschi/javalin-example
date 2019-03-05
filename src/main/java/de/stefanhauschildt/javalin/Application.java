package de.stefanhauschildt.javalin;

import io.javalin.Javalin;

public class Application {

  public static void main(String[] args) {
    final Javalin app = Javalin.create().start(7000);
    app.get("/",             Controller.getHelloWorld);
    app.get("/foo/:message", Controller.getFoo);
  }

}
