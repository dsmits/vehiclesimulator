package main;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class RootHandler implements HttpHandler {

	@Override
	public void handle(HttpExchange he) throws IOException {
		String response = "This is the vehicle simulation server.";
		he.sendResponseHeaders(200, response.getBytes().length);
		
		OutputStream os = he.getResponseBody();
		os.write(response.toString().getBytes());

		os.close();

	}

}
