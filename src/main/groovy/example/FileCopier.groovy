package example

import org.apache.camel.*
import org.apache.camel.impl.*
import org.apache.camel.builder.*

public class FileCopier {

  public static void main(String... args) {
  
    def context = new DefaultCamelContext()

    context.addRoutes(new RouteBuilder() {
      public void configure() {
        from("file:temp/inbox")
          .to("file:temp/outbox")
      }
    })

    context.start()

    Thread.sleep(60000);
    context.stop();
    
  }
  
}