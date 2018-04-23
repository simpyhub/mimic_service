package info.cukes.cucumber_junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MimicStepDef {
	
	private final static String host = "http://localhost:8080/";
	private HttpServiceCaller service=new HttpServiceCaller();
	private String response;
	

	@Given("^mimic\\.jar is running$")
	public void mimic_jar_is_running() throws Throwable {
		
		// Launches mimic.jar from your C:/Users/<username> folder.
		String user = System.getProperty("user.name");
		String cmd = "java -jar C://Users//" + user + "//mimic.jar";
		Runtime.getRuntime().exec(cmd);
		
		// Tests if LearnNextResponse method returns "OK".
		String request=host+"LearnNextResponse?text=TestIfRunning";
		String response=service.executeGetRequest(request);
		assertEquals(response, "OK");
	}

	
	@When("^I learn a request$")
	public void i_learn_a_request() throws Throwable {
	}
	@When("^I learn a response$")
	public void i_learn_a_response() throws Throwable {
	}
	@Then("^mimic\\.jar is responding with correct response$")
	public void mimic_jar_is_responding_with_correct_response() throws Throwable {
	}
	
	@When("^I unlearn the previous request/response using the \"([^\"]*)\" command$")
	public void i_unlearn_the_previous_request_response_using_the_command(String arg1) throws Throwable {
		String request=host+"unlearn";
		String response=service.executeGetRequest(request);
		assertEquals(response, "OK");
	}
	@Then("^Previous request/response is removed$")
	public void previous_request_response_is_removed() throws Throwable {
		String request=host+"apple";
		String response=service.executeGetRequest(request);
		assertNotEquals(response, "fruit");
	}

	
	
	@When("^I use the mimic\\.jar shutdown function$")
	public void i_use_the_mimic_jar_shutdown_function() throws Throwable {
		
		// Triggers KillMimic method and shuts down the service. Expected return is "OK".
		String request=host+"KillMimic";
		String response=service.executeGetRequest(request);
		assertEquals(response, "OK");
	}

	@Then("^mimic\\.jar is not running$")
	public void mimic_jar_is_not_running() throws Throwable {
		
		// Calls for KillMimic method once again, this time we do not expect any "OK" as the service should already been shutdown.
		String request=host+"KillMimic";
		String response=service.executeGetRequest(request);
		assertNotEquals(service.executeGetRequest(request), "OK");
		
		/*
		// Re-launches the mimic.jar after its being shutdown, requires you to have the mimic.jar in your C:/Users/<username> folder.
		String user = System.getProperty("user.name");
		String cmd = "java -jar C://Users//" + user + "//mimic.jar";
		Runtime.getRuntime().exec(cmd); */
	}

}