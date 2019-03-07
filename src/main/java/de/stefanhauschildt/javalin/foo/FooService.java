package de.stefanhauschildt.javalin.foo;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
class FooService {

  @Inject
  FooService() { }

  Foo foo(final String message) {
    return new Foo(message);
  }

}
