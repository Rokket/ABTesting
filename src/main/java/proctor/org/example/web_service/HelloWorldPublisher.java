package proctor.org.example.web_service;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class HelloWorldPublisher {

    public static void main(String[] args) throws MalformedURLException {
//        Endpoint.publish("http://localhost:9999/ws/hello", new HelloWorldImpl());
        URL url = new URL("http://localhost:9999/ws/hello");

        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://web_service.example.org.proctor/", "HelloWorldImplService");

        Service service = Service.create(url, qname);

        HelloWorld hello = service.getPort(HelloWorld.class);

        System.out.println(hello.getHelloWorldAsString("mkyong"));
    }
}
