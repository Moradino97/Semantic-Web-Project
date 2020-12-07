package semweb;

// Libraries for CVS Reader
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.FileWriter;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.Lang;  


// Library for RDF graph
import org.apache.jena.rdf.model.*;
//import com.hp.hp1.jena.rdf.model.Model;
//import com.hp.hp1.jena.util.FileManager;

public class Main {

	public static void main(String[] args) throws IOException {

		GenerationRdfStops r1 = new GenerationRdfStops();
		r1.generateRdfFileBis("gares-tgv.csv", "TrainStations.rdf", "TrainStations.ttl");
		
			
	}

}
