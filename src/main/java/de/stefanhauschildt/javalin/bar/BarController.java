package de.stefanhauschildt.javalin.bar;

import io.javalin.Context;
import javax.inject.Inject;
import org.jetbrains.annotations.NotNull;

public class BarController {

  private final BarService service;

  @Inject
  BarController(BarService service) {
    this.service = service;
  }

  public void getBar(@NotNull Context ctx) {
    ctx.json(service.bar(ctx.pathParam("message")));
  }
}
