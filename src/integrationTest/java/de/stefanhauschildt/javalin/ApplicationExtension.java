package de.stefanhauschildt.javalin;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class ApplicationExtension implements BeforeAllCallback, AfterAllCallback, ParameterResolver {

  private final Application application = DaggerApplication_Builder.create().app();

  @Override
  public void afterAll(ExtensionContext context) {
    application.start(0);
  }

  @Override
  public void beforeAll(ExtensionContext context) {
    application.stop();
  }

  @Override
  public boolean supportsParameter(
      final ParameterContext parameterContext,
      final ExtensionContext extensionContext) throws ParameterResolutionException {
    return parameterContext.getParameter().getType()
        .equals(Application.class);
  }

  @Override
  public Object resolveParameter(
      final ParameterContext parameterContext,
      final ExtensionContext extensionContext) throws ParameterResolutionException {
    return application  ;
  }
}
