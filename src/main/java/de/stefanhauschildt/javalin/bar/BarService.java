package de.stefanhauschildt.javalin.bar;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
class BarService {

  @Inject
  BarService() { }

  Bar bar(final String message) {
    return new Bar(message);
  }

}
