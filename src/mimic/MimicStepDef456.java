package mimic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MimicStepDef456 {

	private final static String host = "http://localhost:8080/";
	private HttpServiceCaller service = new HttpServiceCaller();

	
	// @Test_Case_ID_19
	@When("^I learn basic math operations$")
	public void i_learn_basic_math_operations() throws Throwable {
	}
	@When("^I specify a \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and the \"([^\"]*)\"$")
	public void i_specify_a_and_the(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		System.out.println("Sending: http://localhost:8080/LearnNextResponse?text="+arg4);
		service.executeGetRequest("http://localhost:8080/LearnNextResponse?text="+arg4);
		System.out.println("Sending: http://localhost:8080/"+arg1+"?value1="+arg2+"&value2="+arg3);
		service.executeGetRequest("http://localhost:8080/"+arg1+"?value1="+arg2+"&value2="+arg3);
	}
	@Then("^Mimic learns to calculate the anwers itself$")
	public void mimic_learns_to_calculate_the_anwers_itself() throws Throwable {
	}
	
	
	// @Test_Case_ID_20
	@When("^I ask for math operations that has not been learnt$")
	public void i_ask_for_math_operations_that_has_not_been_learnt() throws Throwable {
	}
	@When("^I loop a series of new add calcuations$")
	public void i_loop_a_series_of_new_add_calcuations() throws Throwable {
		for(int i = 0;i<1000;i=i+51) {
			int x = i/2;
			service.executeGetRequest("http://localhost:8080/add?value1="+i+"&value2="+x);
			System.out.println(i+ " + " +x+ " = "+(i+x));
			assertEquals(Integer.toString(i+x), service.executeGetRequest("http://localhost:8080/add?value1="+i+"&value2="+x));
		}
	}
	@When("^I loop a series of new sub calculations$")
	public void i_loop_a_series_of_new_sub_calculations() throws Throwable {
		for(int i = 1000;i>1;i=i-49) {
			int x = i/2;
			service.executeGetRequest("http://localhost:8080/sub?value1="+i+"&value2="+x);
			System.out.println(i+ " - " +x+ " = "+(i-x));
			assertEquals(Integer.toString(i-x), service.executeGetRequest("http://localhost:8080/sub?value1="+i+"&value2="+x));
		}
	}
	@When("^I loop a series of new mult calculations$")
	public void i_loop_a_series_of_new_mult_calculations() throws Throwable {
		for(int i = 0;i<1000;i=i+57) {
			int x = i/2;
			service.executeGetRequest("http://localhost:8080/mult?value1="+i+"&value2="+x);
			System.out.println(i+ " * " +x+ " = "+(i*x));
			assertEquals(Integer.toString(i*x), service.executeGetRequest("http://localhost:8080/mult?value1="+i+"&value2="+x));
		}
	}
	@When("^I loop a series of new div calculations$")
	public void i_loop_a_series_of_new_div_calculations() throws Throwable {
		for(int i = 2;i<1000;i=i+50) {
			int x = (int) (Math.random() * (50 - 2));
			service.executeGetRequest("http://localhost:8080/div?value1="+i+"&value2="+x);
			System.out.println(i+ " / " +x+ " = "+(i/x));
			assertEquals(Integer.toString(i/x), service.executeGetRequest("http://localhost:8080/div?value1="+i+"&value2="+x));
		}
	}
	@Then("^Mimic is responding with correct sum in each loop$")
	public void mimic_is_responding_with_correct_sum_in_each_loop() throws Throwable {
	}
	
	
	// @Test_Case_ID_21
	// @Test_Case_ID_22
	// @Test_Case_ID_23
	@When("^I learn a sequence of responses$")
	public void i_learn_a_sequence_of_responses() throws Throwable {
		System.out.println();
		System.out.println("****************************************************");
		for (int i = 1; i < 6; i++) {
			service.executeGetRequest("http://localhost:8080/LearnNextResponse?text=state" + i);
			service.executeGetRequest("http://localhost:8080/testing");
		}
		System.out.println("Request 'testing' has been given 5 responses...");
	}
	@When("^I use unlearn in the middle of a sequence$")
	public void i_use_unlearn_in_the_middle_of_a_sequence() throws Throwable {
		System.out.println("Calling for request 'testing' responds: " +service.executeGetRequest("http://localhost:8080/testing"));
		System.out.println("Calling for request 'testing' responds: " +service.executeGetRequest("http://localhost:8080/testing"));
		System.out.println("Calling for request 'testing' responds: " +service.executeGetRequest("http://localhost:8080/testing"));
		System.out.println("Calling for request 'testing' responds: " +service.executeGetRequest("http://localhost:8080/testing"));
		System.out.println("Calling for request 'testing' responds: " +service.executeGetRequest("http://localhost:8080/testing"));
		System.out.println("Using resetState... " +service.executeGetRequest("http://localhost:8080/resetstate"));
		System.out.println("Calling for request 'testing' responds: " +service.executeGetRequest("http://localhost:8080/testing"));
		System.out.println("Calling for request 'testing' responds: " +service.executeGetRequest("http://localhost:8080/testing"));
		System.out.println("Calling for request 'testing' responds: " +service.executeGetRequest("http://localhost:8080/testing"));
		System.out.println("Using unlearn... " +service.executeGetRequest("http://localhost:8080/unlearn"));
	}
	@Then("^All previously learned responses is removed$")
	public void all_previously_learned_responses_is_removed() throws Throwable {
		System.out.println("Calling for request 'testing' responds: " +service.executeGetRequest("http://localhost:8080/testing"));
		System.out.println("Calling for request 'testing' responds: " +service.executeGetRequest("http://localhost:8080/testing"));
		System.out.println("assertEquals should match with state2... state3, state4 and state5 should have been unlearned...");
		assertEquals(service.executeGetRequest("http://localhost:8080/testing"), "state2");
	}

	
	
	@When("^I call for request twice on last state$")
	public void i_call_for_request_twice_on_last_state() throws Throwable {
		System.out.println("Calling for request 'testing' responds: " +service.executeGetRequest("http://localhost:8080/testing"));
		System.out.println("Calling for request 'testing' responds: " +service.executeGetRequest("http://localhost:8080/testing"));
		System.out.println("Calling for request 'testing' responds: " +service.executeGetRequest("http://localhost:8080/testing"));
		System.out.println("Calling for request 'testing' responds: " +service.executeGetRequest("http://localhost:8080/testing"));
		System.out.println("Calling for request 'testing' responds: " +service.executeGetRequest("http://localhost:8080/testing"));
		System.out.println("Calling for request 'testing' responds: " +service.executeGetRequest("http://localhost:8080/testing"));
	}
	@When("^I use unlearn$")
	public void i_use_unlearn() throws Throwable {
		System.out.println("Using unlearn... " +service.executeGetRequest("http://localhost:8080/unlearn"));
	}
	@Then("^I unlearn the last response$")
	public void i_unlearn_the_last_response() throws Throwable {
		System.out.println("Calling for request 'testing' responds: " +service.executeGetRequest("http://localhost:8080/testing"));
		//assertEquals(service.executeGetRequest("http://localhost:8080/testing"), "state4");
	}

	
	@When("^I use resetState$")
	public void i_use_resetState() throws Throwable {
		System.out.println("Using resetState... " +service.executeGetRequest("http://localhost:8080/resetstate"));
	}

	@Then("^All responses for that request is unlearned$")
	public void all_responses_for_that_request_is_unlearned() throws Throwable {;
	System.out.println("All responses should be unlearned... 'testing' now responds: " +service.executeGetRequest("http://localhost:8080/testing"));
	}
	
}