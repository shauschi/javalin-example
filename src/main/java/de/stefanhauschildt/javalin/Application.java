package de.stefanhauschildt.javalin;

import io.javalin.Javalin;

public class Application extends Javalin {

  public static void main(String[] args) {
    new Application(7000).start();
  }

  Application(final Integer port) {
    port(port);

    get("/",             Controller.getHelloWorld);
    get("/foo/:message", Controller.getFoo);
  }

}
