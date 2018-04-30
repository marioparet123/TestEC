1. Create a ArrayList subclass that would adapt its size on the fly when it is requested for an element at a certain position. Use generics to adapt to any class.
For example:
Let's say we have an instantiated list having no elements. As a consequence,  list.size() == 0 is true.
Write the subclass in such a way that if I would call list.get(2), I would get back an entity and not a array index out of bounds exception . Moreover it would create 3 entities and fill the list up to index 2.

The implementation is in the ArrayList folder.
You can simply run the class; it contains a couple of test cases as an example of usage.

3. Write a basic servlet container that only loads one instance of a servlet. Servlets will be loaded from the same classloader as the daemon.
It should accept socket connection and write the outputstream to the socket whatever si written inside the servlet. 
The container should be very simple. Don't implement the Servelt specification, just allow minimal configuration of a servlet, 
a web.xml file containing the context name and servlet's logical names and implementations.
Write also a simple servlet to work in your container that writes "hello world" to the outputstream.

The implementation is in the simpleServlet folder.
There is a Main class for starting the servlet container.
You can configure the port number in server.xml.
You can configure the servlet in web.xml.
There are 2 implemented servlet; the "Hello world" servlet and the "Echo Servlet". You must choose one in web.xml.
For using the application:
- run it
- telnet localhost <configured port>
- type some text and press ENTER
- you see the servlet's response
- the servlet stays alive and it responds until you shut down the servlet container.






