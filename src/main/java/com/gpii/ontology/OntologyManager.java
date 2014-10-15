package com.gpii.ontology;


import com.github.jsonldjava.jena.JenaJSONLD;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import java.io.BufferedReader;

/**
 *
 * @author nkak
 * @author Claudia Loitsch
 * 
 */
public class OntologyManager
{
    private static OntologyManager instance = null;
    
    // default model automatically initialized with data from JSON-LD  	
    public static Model _dmodel;
    
    boolean printDebugInfo;
    public String debug;
    
    private OntologyManager() 
    {
        debug = "";
        printDebugInfo = false;
        
        // JenaJSONLD must be initialized so that the readers and writers are registered with Jena.
        JenaJSONLD.init();
    }
    
    public static OntologyManager getInstance() 
    {
        if(instance == null) 
            instance = new OntologyManager();
        return instance;
    }
    
	public void populateJSONLDInput(String uri){
		
		_dmodel = ModelFactory.createOntologyModel().read(uri, "JSON-LD");
		
	}
    
    public String testHello(String tmpName)
    {
        return "Hello " + tmpName + "!";
    }
    
}