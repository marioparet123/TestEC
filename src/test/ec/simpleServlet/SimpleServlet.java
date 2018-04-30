package test.ec.simpleServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SimpleServlet implements Servlet {

	ServletConfig servletConfig = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		servletConfig = config;
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) {
		String message = (String) req.getAttribute("message");

		PrintWriter p;
		try {
			p = res.getWriter();
			p.println("Response from " + servletConfig.getInitParameter("servlet-name") + ":" + message);
			p.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {

	}

}
