## Web Container

Tomcat is a web container, when a request is made from Client to web server, it passes the request to web container and it’s web container job to find the correct resource to handle the request (servlet or JSP) and then use the response from the resource to generate the response and provide it to web server. Then web server sends the response back to the client.

When web container gets the request and if it’s for servlet then container creates two Objects HTTPServletRequest and HTTPServletResponse. Then it finds the correct servlet based on the URL and creates a thread for the request. Then it invokes the servlet service() method and based on the HTTP method service() method invokes doGet() or doPost() methods. Servlet methods generate the dynamic page and write it to response. Once servlet thread is complete, container converts the response to HTTP response and send it back to client.

- Communication Support 
- Lifecycle and Resource Management – Container takes care of managing the life cycle of servlet. 
- Multithreading Support
- JSP Support

## Deployment Descriptor

web.xml file is the deployment descriptor of the web application and contains mapping for servlets (prior to 3.0), welcome pages, security configurations, session timeout settings etc.

---

## Servlets

Servlet is Java EE server driven technology to create web applications in java. 

All servlets must implement the javax.servlet.Servlet interface, which defines servlet lifecycle methods. When implementing a generic service, we can extend the GenericServlet class provided with the Java Servlet API. The HttpServlet class provides methods, such as doGet() and doPost(), for handling HTTP-specific services.

**CGI vs Servlet**

- Servlets provide better performance that CGI in terms of processing time, memory utilization because servlets uses benefits of multithreading and for each request a new thread is created, 

- Servlets and platform and system independent, the web application developed with Servlet can be run on any standard web container such as Tomcat, JBoss, Glassfish servers and on operating systems such as Windows, Linux, Unix, Solaris, Mac etc.

### Servlet API Hierarchy

![Servlet-Hierarchy.png](./_image/Servlet-Hierarchy.png)

`javax.servlet.Servlet` is the base interface of Servlet API. Servlet interface declares the life cycle methods of servlet. All the servlet classes are required to implement this interface. The methods declared in this interface are:

`public abstract void init(ServletConfig paramServletConfig) throws ServletException`

invoked by servlet container to initialized the servlet and ServletConfig parameters. This method is called only once in servlet lifecycle and make Servlet class different from normal java objects. extend this method in our servlet classes to initialize resources such as DB Connection, Socket connection etc.

`public abstract ServletConfig getServletConfig()`

returns a servlet config object, which contains any initialization parameters and startup configuration for this servlet. Use this method to get the init parameters of servlet defines in deployment descriptor (web.xml) or through annotation in Servlet 3.

`public abstract void service(ServletRequest req, ServletResponse res) throws ServletException, IOException`

Whenever servlet container receives any request, it creates a new thread and execute the service() method by passing request and response as argument.

`public abstract void destroy()` – This method can be called only once in servlet life cycle and used to close any open resources. This is like finalize method of a java class.

---

**ServletConfig Interface**

javax.servlet.ServletConfig is used to pass configuration information to Servlet. Every servlet has it’s own ServletConfig object and servlet container is responsible for instantiating this object. We can provide servlet init parameters in web.xml file or through use of WebInitParam annotation.

**ServletContext interface**

javax.servlet.ServletContext interface provides access to web application variables to the servlet. The ServletContext is unique object and available to all the servlets in the web application. We can get the ServletContext object via the getServletContext() method of ServletConfig.

**ServletRequest interface**

ServletRequest interface is used to provide client request information to the servlet. Servlet container creates ServletRequest object from client request and pass it to the servlet service() method for processing.

**ServletResponse interface**

ServletResponse interface is used by servlet in sending response to the client. Servlet container creates the ServletResponse object and pass it to servlet service() method and later use the response object to generate the HTML response for client.

**RequestDispatcher interface**

RequestDispatcher interface is used to forward the request to another resource that can be HTML, JSP or another servlet in the same context. We can also use this to include the content of another resource to the response. This interface is used for servlet communication within the same context.

There are two methods defined in this interface:

- `void forward(ServletRequest request, ServletResponse response)` – forwards the request from a servlet to another resource (servlet, JSP file, or HTML file) on the server.

- `void include(ServletRequest request, ServletResponse response)` – includes the content of a resource (servlet, JSP page, HTML file) in the response.

get RequestDispatcher in a servlet using ServletContext `getRequestDispatcher(String path)` method.

**GenericServlet class**

GenericServlet is an abstract class that implements Servlet, ServletConfig and Serializable interface. GenericServlet provide default implementation of all the Servlet life cycle methods and ServletConfig methods 

**HTTPServlet class**

HTTPServlet is an abstract class that extends GenericServlet and provides base for creating HTTP based web applications. There are methods defined to be overridden by subclasses for different HTTP methods.

- doGet(), for HTTP GET requests
- doPost(), for HTTP POST requests
- doPut(), for HTTP PUT requests
- doDelete(), for HTTP DELETE requests

**Servlet Attributes**

Servlet attributes are used for inter-servlet communication, we can set, get and remove attributes in web application. There are three scopes for servlet attributes – request scope, session scope and application scope.

ServletRequest, HttpSession and ServletContext interfaces provide methods to get/set/remove attributes from request, session and application scope respectively.

**Annotations in Servlet 3**

WebServlet – We can use this annotation with Servlet classes to define init parameters, loadOnStartup value, description and url patterns etc. The class on which this annotation is declared MUST extend HttpServlet.

WebInitParam – This annotation is used to define init parameters for servlet or filter, it contains name, value pair and we can provide description also. This annotation can be used within a WebFilter or WebServlet annotation.

WebFilter – This annotation is used to declare a servlet filter. This annotation is processed by the container during deployment, the Filter class in which it is found will be created as per the configuration and applied to the URL patterns, Servlets and DispatcherTypes. The annotated class MUST implement javax.servlet.Filter interface.

WebListener – The annotation used to declare a listener for various types of event, in a given web application context.


---

## session management


---

## Java Servlet Filter

Java Servlet Filter is used to intercept request and do some pre-processing and can be used to intercept response and do post-processing before sending to client in web application.

Uses:

- Logging request parameters to log files.
- Authentication and autherization of request for resources.
- Formatting of request body or header before sending it to servlet.
- Compressing the response data sent to the client.
- Alter response by adding some cookies, header information etc.

servlet filters are pluggable and configured in deployment descriptor (web.xml) file. Servlets and filters both are unaware of each other and we can add or remove a servlet filter just by editing web.xml.

create a Servlet Filter by implementing javax.servlet.Filter interface.

















Filter
Interceptor
Listener