package example

import org.apache.camel.*
import org.apache.camel.builder.*
import org.apache.camel.impl.*
import org.slf4j.*

public class JettyRouteBuilder extends RouteBuilder {

	static Logger LOG = LoggerFactory.getLogger(JettyRouteBuilder.class)
	int num  = 0;
	def number = {++num}
	
	void configure() {
	  LOG.debug("Configure route.")
   	  from("jetty:http://0.0.0.0:8090")
		.routeId("jettyRouteId")
		.shutdownRunningTask(ShutdownRunningTask.CompleteAllTasks)
		.streamCaching()
		.transform({"You called me ${number()} times"})
	}
  
}