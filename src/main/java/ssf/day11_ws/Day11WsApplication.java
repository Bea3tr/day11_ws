package ssf.day11_ws;

import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

/* Task 3
 * i. mvn clean spring-boot:run -Dspring-boot.run.arguments="--port=3000 --logLevel=TRACE"
 * ii. in user variables, add SERVER_PORT=3000
 * iii. in application.properties -> server.port=3000
 */

@SpringBootApplication
public class Day11WsApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Day11WsApplication.class);

		// Default port #
		String port = "8080";
		ApplicationArguments cliOpts = new DefaultApplicationArguments(args);

		// Port set with command line arguments
		if(cliOpts.containsOption("port")) {
			port = cliOpts.getOptionValues("port").get(0);
		
			// Set server port # (default or args)
			app.setDefaultProperties(
				Collections.singletonMap("server.port", port)
				);
		}

		// System.out.printf("Application started on port %s\n", port);
		app.run(args);
	}
}
