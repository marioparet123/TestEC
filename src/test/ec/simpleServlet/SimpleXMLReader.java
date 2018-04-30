package test.ec.simpleServlet;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class SimpleXMLReader {

	Document doc = null;

	SimpleXMLReader(String filePar) throws ParserConfigurationException, SAXException, IOException {
		File inputFile = new File(filePar);

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(inputFile);
		doc.getDocumentElement().normalize();
	}

	public String getTagContent(String tag) {
		return doc.getElementsByTagName(tag).item(0).getTextContent();
	}

	public String getTagAttibuteContent(String tag, String attribute) {
		return doc.getElementsByTagName(tag).item(0).getAttributes().item(0).getTextContent();
	}

	public static void main(String[] args) throws Exception {

		File inputFile = new File("web.xml");

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		doc.getDocumentElement().normalize();

		String val = doc.getElementsByTagName("servlet-name").item(0).getTextContent();

		System.out.println(val);
	}
}
