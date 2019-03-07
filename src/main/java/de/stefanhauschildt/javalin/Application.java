package de.stefanhauschildt.javalin;

import dagger.Component;
import de.stefanhauschildt.javalin.bar.BarController;
import de.stefanhauschildt.javalin.foo.FooController;
import io.javalin.Javalin;
import javax.inject.Inject;
import javax.inject.Singleton;

public class Application extends Javalin {

  @Singleton
  @Component
  public interface Builder {
    Application app();
  }

  public static void main(String[] args) {
    DaggerApplication_Builder.create().app().start();
  }

  @Inject
  Application(
      final FooController fooController,
      final BarController barController) {
    port(7000);

    get("/",             fooController::getHelloWorld);
    get("/foo/:message", fooController::getFoo);
    get("/bar/:message", barController::getBar);
  }

}
