package test.ec.simpleServlet;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class SimpleServletContainer {

	Servlet servlet = null;
	ServletConfig servletConfig = null;
	SimpleXMLReader servletXMLReader = null;
	SimpleXMLReader serverXMLReader = null;
	int port = 0;

	public void init() throws SAXException, IOException, ParserConfigurationException, ClassNotFoundException,
			NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, ServletException {
		servletXMLReader = new SimpleXMLReader("conf/web.xml");
		serverXMLReader = new SimpleXMLReader("conf/server.xml");
		servletConfig = new SimpleServletConfig(servletXMLReader);
		ClassLoader classLoader = this.getClass().getClassLoader();
		@SuppressWarnings("unchecked")
		Class<SimpleServlet> loadedMyClass = (Class<SimpleServlet>) classLoader
				.loadClass(servletConfig.getInitParameter("servlet-class"));
		Constructor<SimpleServlet> constructor = loadedMyClass.getConstructor();
		servlet = constructor.newInstance();
		servlet.init(servletConfig);
		port = Integer.parseInt(serverXMLReader.getTagAttibuteContent("Connector", "port"));

	}

	public void go() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException,
			ServletException, NoSuchMethodException, SecurityException, IllegalArgumentException,
			InvocationTargetException {
		ServerSocket listener = new ServerSocket(9192);
		Socket socket = null;

		try {
			socket = listener.accept();

			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			while (true) {

				String messageIn = input.readLine();

				ServletRequest servletRequest = new SimpleServletRequest();
				servletRequest.setAttribute("message", messageIn);

				ServletResponse servletResponse = new SimpleServletResponse(socket.getOutputStream());

				servlet.service(servletRequest, servletResponse);

			}
		} catch (Exception e) {
		} finally {
			try {
				listener.close();
			} catch (Exception e) {
			}

			try {
				socket.close();
			} catch (Exception e1) {
			}
		}

	}

}
