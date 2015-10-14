package com.gpii.restful;

import com.gpii.jsonld.JsonLDManager;
import com.gpii.utils.Utils;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.io.IOException;
import junit.framework.TestCase;

public class RBMM_WebServiceIT extends TestCase {
	public void test_() {

		if (JsonLDManager.getInstance().PERFORM_INTEGRATION_TESTS) {

			_Alicia();
			_CombinedScenario1();
			_CombinedScenario2();
			_AliciaSz2();
			_LiaAndManuel();

		} else
			System.out
					.println("INTEGRATION TESTS WAS IGNORED because 'PERFORM_INTEGRATION_TESTS=false' in config.properties");

	}

	private void _CombinedScenario1() {
		System.out
				.println("\n*****************************************************");
		System.out
				.println("* Testing 'CombinedScenario1' *************************************");
		System.out
				.println("*******************************************************");

		String filepathIN = System.getProperty("user.dir")
				+ "/src/main/webapp/WEB-INF/testData/preferences/combinedScenario1.json";
		String filepathExpectedOUT1 = System.getProperty("user.dir")
				+ "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/combinedScenarioOUT1.json";

		performTest(filepathIN, filepathExpectedOUT1, "_Alicia");
	}

	private void _CombinedScenario2() {
		System.out
				.println("\n*****************************************************");
		System.out
				.println("* Testing 'CombinedScenario2' *************************************");
		System.out
				.println("*******************************************************");

		String filepathIN = System.getProperty("user.dir")
				+ "/src/main/webapp/WEB-INF/testData/preferences/combinedScenario2.json";
		String filepathExpectedOUT1 = System.getProperty("user.dir")
				+ "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/combinedScenarioOUT2.json";

		performTest(filepathIN, filepathExpectedOUT1, "_Alicia");
	}

	private void _Alicia() {
		System.out
				.println("\n*****************************************************");
		System.out
				.println("* Testing 'Alica' *************************************");
		System.out
				.println("*******************************************************");

		String filepathIN = System.getProperty("user.dir")
				+ "/src/main/webapp/WEB-INF/testData/preferences/alicia.json";
		String filepathExpectedOUT1 = System.getProperty("user.dir")
				+ "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/aliciaOUT.json";

		performTest(filepathIN, filepathExpectedOUT1, "_Alicia");
	}

	private void _AliciaSz2() {
		System.out
				.println("\n*****************************************************");
		System.out
				.println("* Testing 'Alica  on Linux (Szenario 2) '**************");
		System.out
				.println("*******************************************************");

		String filepathIN = System.getProperty("user.dir")
				+ "/src/main/webapp/WEB-INF/testData/preferences/aliciaSz2.json";
		String filepathExpectedOUT1 = System.getProperty("user.dir")
				+ "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/aliciaSz2OUT.json";

		performTest(filepathIN, filepathExpectedOUT1, "_AliciaSz2");
	}

	private void _LiaAndManuel() {
		System.out
				.println("\n*****************************************************");
		System.out
				.println("* Testing 'Lia and Manuel (Demo 4) '*******************");
		System.out
				.println("* Conflict Resolution on Multi-User Login *************");
		System.out
				.println("*******************************************************");

		String filepathIN = System.getProperty("user.dir")
				+ "/src/main/webapp/WEB-INF/testData/preferences/liaAndManuel.json";
		String filepathExpectedOUT1 = System.getProperty("user.dir")
				+ "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/liaAndManuelOUT.json";

		performTest(filepathIN, filepathExpectedOUT1, "_LiaAndManuel");
	}

	public void test_transformOwlToJSONLD() {
		if (JsonLDManager.getInstance().PERFORM_INTEGRATION_TESTS) {
			if (JsonLDManager.getInstance().INTEGRATION_TESTS_INCLUDE_ONTOLOGY_TRANSFORMATION_INTO_JSONLD) {
				System.out
						.println("\n*********************************************************************************************************************************");
				System.out
						.println("* Testing 'transformOwlToJSONLD' web service                                                                                    *");
				System.out
						.println("*                                                                                                                               *");
				System.out
						.println("* Please be patient. This process will take some minutes. The whole solutions ontology is being transformed into JSON-LD format.*");
				System.out
						.println("* You can disable this test by setting in config file -> INTEGRATION_TESTS_INCLUDE_ONTOLOGY_TRANSFORMATION_INTO_JSONLD = false  *");
				System.out
						.println("*********************************************************************************************************************************");

				Client client = Client.create();
				WebResource webResource = client
						.resource("http://localhost:8080/RBMM/transformOwlToJSONLD");
				ClientResponse response = webResource.get(ClientResponse.class);
				String output = response.getEntity(String.class);

				System.out.println("\nWeb service output:\n");
				System.out.println(output);

				// assertEquals(output, expectedOutputJsonStr);
			} else {
				System.out
						.println("\n******************************************************************************************************************************************************************************");
				System.out
						.println("* Testing of 'transformOwlToJSONLD' was skipped because it's a time consuming process (config file -> INTEGRATION_TESTS_INCLUDE_ONTOLOGY_TRANSFORMATION_INTO_JSONLD = false) *");
				System.out
						.println("******************************************************************************************************************************************************************************\n");
			}
		} else
			System.out
					.println("test_transformOwlToJSONLD INTEGRATION TEST WAS IGNORED because 'PERFORM_INTEGRATION_TESTS=false' in config.properties");
	}

	private void performTest(String filepathIN, String filepathExpectedOUT1,
			String test) {

		String filepathActualOUT = System.getProperty("user.dir")
				+ "/src/main/webapp/WEB-INF/debug/5_RBMMJsonOutput.json";

		String inputJsonStr = null;
		String actualOutputStr = null;
		String expectedOutputJsonStr1 = null;

		// read input & expected output
		try {
			inputJsonStr = Utils.getInstance().readFile(filepathIN);
			expectedOutputJsonStr1 = Utils.getInstance().readFile(
					filepathExpectedOUT1);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Client client = Client.create();
		WebResource webResource = client
				.resource("http://localhost:8080/RBMM/runJSONLDRules");
		ClientResponse response = webResource.accept("application/json")
				.type("application/json")
				.post(ClientResponse.class, inputJsonStr);
		String output = response.getEntity(String.class);

		System.out.println("\nWeb service output:\n");
		System.out.println(output);

		// read actual output
		try {
			actualOutputStr = Utils.getInstance().readFile(filepathActualOUT);
		} catch (IOException e) {
			e.printStackTrace();
		}

		boolean outputIsSimilarToOneOfTheExpected = false;
		if (actualOutputStr.equals(expectedOutputJsonStr1))
			outputIsSimilarToOneOfTheExpected = true;
		else {
			System.out.println("\n* ERROR -> " + test
					+ " INTEGRATION TEST FAILED!");
			// System.exit(-1);
		}
		assertEquals(outputIsSimilarToOneOfTheExpected, true);
	}

}