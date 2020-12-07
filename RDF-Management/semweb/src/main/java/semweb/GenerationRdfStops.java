package semweb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.FileWriter;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.riot.Lang; 

public class GenerationRdfStops {

	
	public void generateRdfFile(String Datasourcefile,String outputRDFFile, String outputTTLFile ) throws IOException {
		//Read the CVS file
		//Read the CVS file
				File cvsFile = new File("C:/Users/pret/Desktop/"+Datasourcefile);
					BufferedReader br = new BufferedReader(new FileReader(cvsFile));
					String line = "";
					try {
						int flag = 0;
						
						//Creation of an Empty Model
						Model model = ModelFactory.createDefaultModel();
						
					    // Define the Ontologies
						String ex = "http://www.example.com/";
						String geo = "http://www.w3.org/2003/01/geo/wgs84_pos#";
						String rdfs = "http://www.w3.org/2000/01/rdf-schema#";
						String xsd = "http://www.w3.org/2001/XMLSchema#";
						//We use our ONTOLOGY :)
						String sgto = "http://visualdataweb.org/SGTO/";
						//file = open("stops.rdft", "w");
						//file.write(g.serialize(format="Turtle"));		
						
						
						//OutputStream out = new FileOutputStream(C:/Users/pret/Desktop/RDF-Management/semweb/src/main/java/semweb/");
						//RDFDataMgr.write(out, model, Lang.TTL);
						
						
						// Test to write
					
						FileWriter myWriter = new FileWriter("C:/Users/pret/Desktop/RDF-Management/semweb/src/main/java/semweb/"+outputTTLFile);
						//FileWriter myWriter = new FileWriter("C:/Users/pret/Desktop/RDF-Management/semweb/src/main/java/semweb/TrainStation.rdf");
						//myWriter.write("Bla blabla!");
						// myWriter.close();
						System.out.println("Successfully wrote to the file.");
			
						
						      
						myWriter.write("@prefix ex: <"+ex+"> .\n");
						myWriter.write("@prefix xsd: <"+xsd+"> .\n");
						myWriter.write("@prefix rdfs: <"+rdfs+"> .\n");
						myWriter.write("@prefix sgto: <"+sgto+"> .\n\n");
						//myWriter.close();
						int r = 0;
						
						while((line = br.readLine()) != null && r<5) {
							if(flag == 1) {
								String[] count = line.split(",");
								Resource subject = model.createResource("ex:"+count[0]);
								myWriter.write("ex:"+count[0]);
								String predicatVar = null , objectVar = null;
								int i = 0;
								while(i<4) {
									// in this loop the variation is on ly in 
									if(i == 0) {
										predicatVar = "a";
										objectVar = sgto+"TrainStation";
										myWriter.write(" a sgto:TrainStation;\n");
									}
									else if(i == 1) {
										predicatVar = sgto+"Stop_Name"; 
										objectVar = count[1]+"@fr";
										myWriter.write("	sgto:Stop_Name "+objectVar+";\n");
									}
									else if (i == 2) {
										predicatVar = sgto+"Stop_Lat"; 
										objectVar = count[3]+"^^xsd:decimal";
										myWriter.write("	sgto:Stop_Lat \""+count[3]+"\"^^xsd:decimal;\n");
									}
									else if(i == 3) {
										predicatVar = sgto+"Stop_Long"; 
										objectVar = count[4]+"^^xsd:decimal";
										myWriter.write("	sgto:Stop_Long \""+count[4]+"\"^^xsd:decimal;\n\n");
									}
									Property predicat = model.createProperty(predicatVar);
									Resource object = model.createResource(objectVar);
									
						
									
									//we add the triple data in this model
									model.add(subject,predicat,object);
									//sfile.write(g.serialize(format="Turtle"));	
									model.write(System.out,"Turtle");
									i= i + 1;
								}
							}
							else {
								flag = 1;
							}
							r++;
						}
						
						
							myWriter.close();
						

						OutputStream out = new FileOutputStream("C:/Users/pret/Desktop/RDF-Management/semweb/src/main/java/semweb/"+outputRDFFile);
						RDFDataMgr.write(out, model, Lang.TTL);
						//OutputStream out = new FileOutputStream("C:/Users/pret/Desktop/RDF-Management/semweb/src/main/java/semweb/TrainStation.ttl");
						//RDFDataMgr.write(out, model, Lang.TTL);
						//FileManager.get().addLocatorClassLoader(Main.class.getClassLoader());
						//Model modelbis = FileManager.get().loadModel("/stops.rdf");
						//modelbis.write(System.out,"TURTLE");
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
	}
	
	
	
	public void generateRdfFileBis(String Datasourcefile,String outputRDFFile, String outputTTLFile ) throws IOException {
		//Read the CVS file
		//Read the CVS file
				File cvsFile = new File("C:/Users/pret/Desktop/"+Datasourcefile);
					BufferedReader br = new BufferedReader(new FileReader(cvsFile));
					String line = "";
					try {
						int flag = 0;
						
						//Creation of an Empty Model
						Model model = ModelFactory.createDefaultModel();
						
					    // Define the Ontologies
						String ex = "http://www.example.com/";
						String geo = "http://www.w3.org/2003/01/geo/wgs84_pos#";
						String rdfs = "http://www.w3.org/2000/01/rdf-schema#";
						String xsd = "http://www.w3.org/2001/XMLSchema#";
						//We use our ONTOLOGY :)
						String sgto = "http://visualdataweb.org/SGTO/";
						//file = open("stops.rdft", "w");
						//file.write(g.serialize(format="Turtle"));		
						
						
						//OutputStream out = new FileOutputStream(C:/Users/pret/Desktop/RDF-Management/semweb/src/main/java/semweb/");
						//RDFDataMgr.write(out, model, Lang.TTL);
						
						
						// Test to write
					
						FileWriter myWriter = new FileWriter("C:/Users/pret/Desktop/RDF-Management/semweb/src/main/java/semweb/"+outputTTLFile);
						//FileWriter myWriter = new FileWriter("C:/Users/pret/Desktop/RDF-Management/semweb/src/main/java/semweb/TrainStation.rdf");
						//myWriter.write("Bla blabla!");
						// myWriter.close();
						System.out.println("Successfully wrote to the file.");
			
						
						      
						myWriter.write("@prefix ex: <"+ex+"> .\n");
						myWriter.write("@prefix xsd: <"+xsd+"> .\n");
						myWriter.write("@prefix rdfs: <"+rdfs+"> .\n");
						myWriter.write("@prefix sgto: <"+sgto+"> .\n\n");
						//myWriter.close();
						int r = 0;
						
						while((line = br.readLine()) != null && r<5) {
							if(flag == 1) {
								String[] count = line.split(",");
								Resource subject = model.createResource("ex:"+count[0]);
								myWriter.write("ex:"+count[0]);
								String predicatVar = null , objectVar = null;
								int i = 0;
								while(i<8) {
									// in this loop the variation is on ly in 
									if(i == 0) {
										predicatVar = "a";
										objectVar = sgto+"TrainStation";
										myWriter.write(" a sgto:TrainStation;\n");
									}
									else if(i == 1) {
										predicatVar = sgto+"Stop_Name"; 
										objectVar = count[1]+"@fr";
										myWriter.write("	sgto:Stop_Name "+objectVar+";\n");
									}
									else if (i == 2) {
										predicatVar = sgto+"Stop_Lat"; 
										objectVar = count[6]+"^^xsd:decimal";
										myWriter.write("	sgto:Stop_Lat \""+count[6]+"\"^^xsd:decimal;\n");
									}
									else if(i == 3) {
										predicatVar = sgto+"Stop_Long"; 
										objectVar = count[7]+"^^xsd:decimal";
										myWriter.write("	sgto:Stop_Long \""+count[7]+"\"^^xsd:decimal;\n");
									}
									else if(i == 4) {
										predicatVar = sgto+"INSEE_REG"; 
										objectVar = count[2]+"^^xsd:integer";
										myWriter.write("	sgto:INSEE_REG \""+count[2]+"\"^^xsd:decimal;\n");
									}
									else if(i == 5) {
										predicatVar = sgto+"REG_Name"; 
										objectVar = count[3]+"@fr";
										myWriter.write("	sgto:REG_Name "+count[3]+"@fr;\n");
									}
									else if(i == 6) {
										predicatVar = sgto+"INSEE_DEP"; 
										objectVar = count[4]+"^^xsd:integer";
										myWriter.write("	sgto:INSEE_DEP \""+count[4]+"\"^^xsd:decimal;\n");
									}
									else if(i == 7) {
										predicatVar = sgto+"DEP_Name"; 
										objectVar = count[5]+"@fr";
										myWriter.write("	sgto:INSEE_DEP "+count[5]+"@fr;\n\n");
									}
									
									Property predicat = model.createProperty(predicatVar);
									Resource object = model.createResource(objectVar);
									
						
									
									//we add the triple data in this model
									model.add(subject,predicat,object);
									//sfile.write(g.serialize(format="Turtle"));	
									model.write(System.out,"Turtle");
									i= i + 1;
								}
							}
							else {
								flag = 1;
							}
							r++;
						}
						
						
							myWriter.close();
						

						OutputStream out = new FileOutputStream("C:/Users/pret/Desktop/RDF-Management/semweb/src/main/java/semweb/"+outputRDFFile);
						RDFDataMgr.write(out, model, Lang.TTL);
						//OutputStream out = new FileOutputStream("C:/Users/pret/Desktop/RDF-Management/semweb/src/main/java/semweb/TrainStation.ttl");
						//RDFDataMgr.write(out, model, Lang.TTL);
						//FileManager.get().addLocatorClassLoader(Main.class.getClassLoader());
						//Model modelbis = FileManager.get().loadModel("/stops.rdf");
						//modelbis.write(System.out,"TURTLE");
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
	}
	
	
	
}

