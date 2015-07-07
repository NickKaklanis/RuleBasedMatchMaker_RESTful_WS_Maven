package com.gpii.restful;


import com.gpii.jsonld.JsonLDManager;
import com.gpii.utils.Utils;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.io.IOException;
import junit.framework.TestCase;

public class RBMM_WebServiceIT extends TestCase
{
	public void test_(){

		if(JsonLDManager.getInstance().PERFORM_INTEGRATION_TESTS)
        {
			// core  
			//_basicAlignment();
			_MMTest1a();
			_MMTest1b();
			_MMTest1c();
			_MMTest1d();
			//_resolveMSC_MultiSolutionPreffered();
			//_resolveMSC_OneSolutionPreffered();
			
			/*
			// review 3
			_vladimirLobby();
			_vladimirSubway();
			_Mary();
			_Manuel();
			_ChrisWin();
			/*_ChrisAndroid();
			_LiWindows();
			_LiAndroid();
			_Franklin();*/
			
			// review 4
			//_Alicia();			

        }
        else
            System.out.println("INTEGRATION TESTS WAS IGNORED because 'PERFORM_INTEGRATION_TESTS=false' in config.properties");		
		
	}
	
    //Core
    public void _basicAlignment()
    {
    	System.out.println("\n**********************************************************************");
        System.out.println("* Tetsing Basic Alignment of Solutions and Setting *********************");
        System.out.println("** for multiple contetxs. N&P sets:  ***********************************");    	
        System.out.println("** 1. same preference across N&P sets (high contrast)*******************"); 
        System.out.println("** 2. different preference values across N&P sets (cursor size) ********"); 
        System.out.println("** 3. common prefs not matched to app-specific prefs *******************");
    	System.out.println("\n**********************************************************************");    	
	
        String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/basicAlignment.json";
        String filepathExpectedOUT = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/basicAlignmentOUT.json";
	    
	    performTest(filepathIN, filepathExpectedOUT, "_BasicAlignment");           
    }
    
    public void _MMTest1a()
    {
    	System.out.println("\n******************_MMTest1a ******************************************");
        System.out.println("** Multiple ATs of the same type are locally installed *****************");
        System.out.println("** and the user has not indicated which AT is preferred. ***************");    	
        System.out.println("** Resolution based on a expert defined ranking of AT ** ***************");
        System.out.println("** defined in knowledge set rankingOfATs *******************************");        
        System.out.println("\n**********************************************************************");    	
	
        String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/MMTest1a.json";
        String filepathExpectedOUT = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/MMTest1aOUT.json";
	    
	    performTest(filepathIN, filepathExpectedOUT, "_MMTest1a");           
    }
    
    public void _MMTest1b()
    {
    	System.out.println("\n******************_MMTest1b **************************************************");
        System.out.println("** Multiple ATs of the same type are available, either locally or as ***********");
        System.out.println("** cloud-based solution. The user has not indicated which AT is preferred. *****");    	
        System.out.println("** Resolution based on the application layer of a solution (os, browser, cloud)*");
        System.out.println("** OS ATs are prioritized over browser solutions *******************************");        
        System.out.println("\n******************************************************************************");    	
	
        String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/MMTest1b.json";
        String filepathExpectedOUT = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/MMTest1bOUT.json";
	    
	    performTest(filepathIN, filepathExpectedOUT, "_MMTest1b");           
    }    
    public void _MMTest1c()
    {
    	System.out.println("\n******************_MMTest1c **********************************************");
        System.out.println("** Multiple ATs of the same type and sharing functionalities ***************");
        System.out.println("** cloud-based solution. The user has not indicated which AT is preferred. *");    	
        System.out.println("** Resolution based on a expert defined ranking of AT ** *******************");
        System.out.println("** defined in knowledge set rankingOfATs ***********************************");        
        System.out.println("\n**************************************************************************");    	
	
        String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/MMTest1c.json";
        String filepathExpectedOUT = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/MMTest1cOUT.json";
	    
	    performTest(filepathIN, filepathExpectedOUT, "_MMTest1c");           
    }
    public void _MMTest1d()
    {
    	System.out.println("\n******************_MMTest1d **********************************************");
        System.out.println("** Multiple ATs and suits of the same type.**************** ****************");
        System.out.println("** The user has not indicated which AT is preferred. ***********************");    	
        System.out.println("** Resolution based on a expert defined ranking of AT ** *******************");
        System.out.println("** defined in knowledge set rankingOfATs ***********************************");        
        System.out.println("\n**************************************************************************");    	
	
        String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/MMTest1d.json";
        String filepathExpectedOUT = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/MMTest1dOUT.json";
	    
	    performTest(filepathIN, filepathExpectedOUT, "_MMTest1d");           
    }     
    private void _resolveMSC_MultiSolutionPreffered()
    {
    	System.out.println("\n*************************************************************************");
        System.out.println("* Testing 'Resolution of Multiple Solution Conflict  ' ********************");
        System.out.println("* Test criteria: multiple ATs of same type installed ' ********************");
        System.out.println("* multiple preferred installed; one installed not preferred; AT suits ' *");
        System.out.println("***************************************************************************");    	
	
        String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/MSC_multiInstATpreferred_noATSuite.json";
        String filepathExpectedOUT = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/MSC_multiInstATpreferred_noATSuiteOUT.json";
	    
	    performTest(filepathIN, filepathExpectedOUT, "_resolveMSC_MultiSolutionPreffered");           
    }
    
    private void _resolveMSC_OneSolutionPreffered()
    {
    	System.out.println("\n*****************************************************");
        System.out.println("* Testing 'Resolution of Multiple Solution Conflict  ' *");
        System.out.println("* Test criteria: one solution preferred; no AT suits ' *");
        System.out.println("*******************************************************");    	
	
        String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/MSC_oneInstATpreferred_noATSuite.json";
        String filepathExpectedOUT = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/MSC_oneInstATpreferred_noATSuiteOUT.json";
	    
	    performTest(filepathIN, filepathExpectedOUT, "_resolveMSC_OneSolutionPreffered");           
    }    
	
    // Review 3
    private void _vladimirLobby()
    {
        System.out.println("\n*****************************************************");
        System.out.println("* Testing 'Vladimir at the Lobby' *");
        System.out.println("*******************************************************");    	

        String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/vladimir.json";
        String filepathExpectedOUT1 = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/vladimirLobbyOUT.json";
        
	    performTest(filepathIN, filepathExpectedOUT1, "_vladimirLobby");   

    }
    
    private void _vladimirSubway()
    {
	    System.out.println("\n*****************************************************");
	    System.out.println("* Testing 'Vladimir Subway' ***************************");
	    System.out.println("*******************************************************");    	
	
        String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/vladimirSubway.json";
        String filepathExpectedOUT1;
        if(JsonLDManager.getInstance().USE_THE_REAL_ONTOLOGY == false)
            filepathExpectedOUT1 = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/vladimirSubwayOUT.json";
        else
            filepathExpectedOUT1 = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/vladimirSubwayRealOntologyOUT.json";
	    
	    performTest(filepathIN, filepathExpectedOUT1, "_vladimirSubway");           
    }
    
    private void _Mary()
    {
        System.out.println("\n*****************************************************");
        System.out.println("* Testing 'Classroom Marry' ***************************");
        System.out.println("*******************************************************");	
	
        String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/mary.json";
        String filepathExpectedOUT = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/maryOUT.json";
	    
	    performTest(filepathIN, filepathExpectedOUT, "_Mary");           
    }
    
    private void _Manuel()
    {
        System.out.println("\n*****************************************************");
        System.out.println("* Testing 'Classroom Manuel' **************************");
        System.out.println("*******************************************************");
	
        String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/manuel.json";
        String filepathExpectedOUT = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/manuelOUT.json";
	    
	    performTest(filepathIN, filepathExpectedOUT, "_Manuel");           
    }
  
    private void _ChrisWin()
    {
        System.out.println("\n*****************************************************");
        System.out.println("* Testing 'Classroom Chris Windows' *******************");
        System.out.println("*******************************************************");;
	
        String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/chrisWindows.json";
        String filepathExpectedOUT = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/chrisWindowsOUT.json";
	    
	    performTest(filepathIN, filepathExpectedOUT, "testChristWin");           
    }
    
    private void _ChrisAndroid()
    {
        System.out.println("\n*****************************************************");
        System.out.println("* Testing 'Classroom Chris Android' *******************");
        System.out.println("*******************************************************");
	
        String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/chrisAndroid.json";
        String filepathExpectedOUT = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/chrisAndroidOUT.json";
	    
	    performTest(filepathIN, filepathExpectedOUT, "_ChrisAndroid");           
    }   
    
    private void _LiWindows()
    {
        System.out.println("\n*****************************************************");
        System.out.println("* Testing 'Classroom Li Windows' **********************");
        System.out.println("*******************************************************");
	
        String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/liWindows.json";
        String filepathExpectedOUT = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/liWindowsOUT.json";
	    
	    performTest(filepathIN, filepathExpectedOUT, "_LiWindows");           
    }

    private void _LiAndroid()
    {
        System.out.println("\n*****************************************************");
        System.out.println("* Testing 'Classroom Li Android' **********************");
        System.out.println("*******************************************************");
	
        String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/liAndroid.json";
        String filepathExpectedOUT = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/liAndroidOUT.json";
	    
	    performTest(filepathIN, filepathExpectedOUT,"_LiAndroid");           
    } 

    private void _Franklin()
    {
        System.out.println("\n*****************************************************");
        System.out.println("* Testing 'Classroom Franklin' **********************");
        System.out.println("*******************************************************"); 
	
        String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/franklin.json";
        String filepathExpectedOUT = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/franklinOUT.json";
	    
	    performTest(filepathIN, filepathExpectedOUT, "_Franklin");           
    }     
   
	// Review 4    
	private void _Alicia()
    {
	    System.out.println("\n*****************************************************");
	    System.out.println("* Testing 'Alica' *************************************");
	    System.out.println("*******************************************************");    	
	
	    String filepathIN = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/preferences/alicia.json";
	    String filepathExpectedOUT1 = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/testData/expectedTestOutcomes/franklinOUT.json";
	    
	    performTest(filepathIN, filepathExpectedOUT1, "_Alicia");           
    }

    public void test_transformOwlToJSONLD() 
    {
        if(JsonLDManager.getInstance().PERFORM_INTEGRATION_TESTS)
        {
            if(JsonLDManager.getInstance().INTEGRATION_TESTS_INCLUDE_ONTOLOGY_TRANSFORMATION_INTO_JSONLD)
            {
                System.out.println("\n*********************************************************************************************************************************");
                System.out.println("* Testing 'transformOwlToJSONLD' web service                                                                                    *");
                System.out.println("*                                                                                                                               *");
                System.out.println("* Please be patient. This process will take some minutes. The whole solutions ontology is being transformed into JSON-LD format.*");
                System.out.println("* You can disable this test by setting in config file -> INTEGRATION_TESTS_INCLUDE_ONTOLOGY_TRANSFORMATION_INTO_JSONLD = false  *");
                System.out.println("*********************************************************************************************************************************");

                Client client = Client.create();
                WebResource webResource = client.resource("http://localhost:8080/RBMM/transformOwlToJSONLD");
                ClientResponse response = webResource.get(ClientResponse.class);
                String output = response.getEntity(String.class);

                System.out.println("\nWeb service output:\n");
                System.out.println(output);

                //assertEquals(output, expectedOutputJsonStr);
            }
            else
            {
                System.out.println("\n******************************************************************************************************************************************************************************");
                System.out.println("* Testing of 'transformOwlToJSONLD' was skipped because it's a time consuming process (config file -> INTEGRATION_TESTS_INCLUDE_ONTOLOGY_TRANSFORMATION_INTO_JSONLD = false) *");
                System.out.println("******************************************************************************************************************************************************************************\n");
            }
        }
        else
            System.out.println("test_transformOwlToJSONLD INTEGRATION TEST WAS IGNORED because 'PERFORM_INTEGRATION_TESTS=false' in config.properties");
    }    
	
    private void performTest(String filepathIN, String filepathExpectedOUT1, String test) {
        
        String filepathActualOUT = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/debug/5_RBMMJsonOutput.json";
    	
    	String inputJsonStr = null;
        String actualOutputStr = null;
        String expectedOutputJsonStr1 = null;
        
        // read input & expected output
        try {
            inputJsonStr = Utils.getInstance().readFile(filepathIN);
            expectedOutputJsonStr1 = Utils.getInstance().readFile(filepathExpectedOUT1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/RBMM/runJSONLDRules");
        ClientResponse response = webResource.accept("application/json").type("application/json").post(ClientResponse.class, inputJsonStr);
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
        if(actualOutputStr.equals(expectedOutputJsonStr1))
            outputIsSimilarToOneOfTheExpected = true;
        else
        {
            System.out.println("\n* ERROR -> " +test+ " INTEGRATION TEST FAILED!");
            //System.exit(-1);
        }
        assertEquals(outputIsSimilarToOneOfTheExpected, true);		
	}
	
	
}