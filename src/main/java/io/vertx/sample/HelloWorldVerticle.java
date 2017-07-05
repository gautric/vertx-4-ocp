package io.vertx.sample;

import io.vertx.core.AbstractVerticle;

public class HelloWorldVerticle extends AbstractVerticle {

  @Override
  public void start() {
    String messageSystemEnv = System.getenv("VERTX_4_OCP_MESSAGE");

    if(messageSystemEnv == null || messageSystemEnv.length()==0){
      messageSystemEnv = "Hello world !!";
    }

    final String message = messageSystemEnv;

    System.out.println("Message " + message);

    vertx.createHttpServer()
      .requestHandler(req -> req.response().end(message))
      .listen(8080);
  }
}
