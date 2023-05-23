package FuncionMain;

import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomParser {
	
	String url;
  public DomParser(String u) {
	  this.url = u;
  }
	
  public void parse() throws Exception {

	    //Crea una instancia de DocumentBuilderFactory
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    
	    //Crea un DocumentBuilder
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    
	    URLConnection urlConnection = new URL(url).openConnection();
	    urlConnection.addRequestProperty("Accept", "application/xml");
        
	    Document doc = builder.parse(urlConnection.getInputStream());
	    doc.getDocumentElement().normalize();
	    
	    Element root = doc.getDocumentElement();
	    System.out.println ("Root element: " + root.getNodeName());
	    
	    NodeList itemList = root.getElementsByTagName("item");
	    
        for (int i = 0; i < itemList.getLength(); i++) {
            Node itemNode = itemList.item(i);
            
            if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
                
            	Element itemElement = (Element) itemNode;
                
                String id = itemElement.getElementsByTagName("id").item(0).getTextContent();
                String firstName = itemElement.getElementsByTagName("firstName").item(0).getTextContent();
                String lastName = itemElement.getElementsByTagName("lastName").item(0).getTextContent();
                String emailId = itemElement.getElementsByTagName("emailId").item(0).getTextContent();
                
                System.out.println("ID: " + id);
                System.out.println("  First Name: " + firstName);
                System.out.println("  Last Name: " + lastName);
                System.out.println("  Email ID: " + emailId);
                System.out.println();
            }
        }
  	

   }
}