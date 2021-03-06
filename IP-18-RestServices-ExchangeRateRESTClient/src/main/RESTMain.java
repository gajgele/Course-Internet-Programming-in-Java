package main;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;

/**
 * Calls the RESTful web service at REST_URL defined below
 * @author mlatinovic
 *
 */
public class RESTMain {
	
	public static final String REST_URL = "https://currency-api.appspot.com/api/USD/EUR.json";
	public static final int OK_STATUS = Response.Status.OK.getStatusCode();
	/**
	 * Call the web service and display the response
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// call the service and get the response object (usage of Fluent API)
		Response response = ClientBuilder.newClient()
				.target(REST_URL)
				.request(MediaType.APPLICATION_JSON)
				.get();
	
	// process the response object
		StatusType status = response.getStatusInfo();
		int statusCode = status.getStatusCode();
		if (statusCode == OK_STATUS) {
			System.out.println(response.readEntity(String.class));
		} else {
			System.out.printf("Service returned status: \" %d %s \"\n", statusCode, status.getReasonPhrase());
		}
	}
	
}
