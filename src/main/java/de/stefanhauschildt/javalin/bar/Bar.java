package de.stefanhauschildt.javalin.bar;

class Bar {
  private final String message;

  Bar(final String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

}
