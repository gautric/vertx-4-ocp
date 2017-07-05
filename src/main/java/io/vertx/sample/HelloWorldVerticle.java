package io.vertx.sample;

import io.vertx.core.AbstractVerticle;

public class HelloWorldVerticle extends AbstractVerticle {

  @Override
  public void start() {
    String message = System.getenv("VERTX_4_OCP_MESSAGE");

    if(message==null || message.length()==0){
      message = "Hello world !!";
    }

    System.out.println("Message " + message);

    vertx.createHttpServer()
      .requestHandler(req -> req.response().end(message))
      .listen(8080);
  }
}
