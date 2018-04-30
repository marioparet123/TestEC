package test.ec.simpleServlet;

public class Main {

	public static void main(String[] args) throws Exception {
		SimpleServletContainer simpleServletContainer = new SimpleServletContainer();
		simpleServletContainer.init();
		simpleServletContainer.go();
	}
}
