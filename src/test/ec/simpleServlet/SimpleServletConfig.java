package test.ec.simpleServlet;

import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

public class SimpleServletConfig implements ServletConfig {

	SimpleXMLReader simpleXMLReader = null;

	public SimpleServletConfig(SimpleXMLReader simpleXMLReaderPar) {
		simpleXMLReader = simpleXMLReaderPar;
	}

	@Override
	public String getServletName() {

		return null;
	}

	@Override
	public ServletContext getServletContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInitParameter(String tagName) {
		return simpleXMLReader.getTagContent(tagName);
	}

	@Override
	public Enumeration<String> getInitParameterNames() {
		// TODO Auto-generated method stub
		return null;
	}

}
