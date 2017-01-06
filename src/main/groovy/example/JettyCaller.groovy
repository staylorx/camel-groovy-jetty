package example

import org.apache.camel.*
import org.apache.camel.builder.*
import org.apache.camel.impl.*
import org.slf4j.*

public class JettyCaller extends org.apache.camel.main.Main {
	
  static Logger LOG = LoggerFactory.getLogger(JettyCaller.class)
  
  public static void main(String... args) {
  
	def jettyCaller = new JettyCaller()
	jettyCaller.enableHangupSupport()
	jettyCaller.addRouteBuilder(createRouteBuilder())
	jettyCaller.run(args)
		
  }
  
  static RouteBuilder createRouteBuilder() {
	  return new JettyRouteBuilder()
  }
  
}