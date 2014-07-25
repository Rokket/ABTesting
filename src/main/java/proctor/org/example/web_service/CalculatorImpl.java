package proctor.org.example.web_service;

import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

@WebService(endpointInterface = "proctor.org.example.web_service.Calculator")
public class CalculatorImpl implements Calculator {

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws MalformedURLException {
//        Endpoint.publish("http://localhost:9997/ws/calc", new CalculatorImpl());
        URL url = new URL("http://localhost:9997/ws/calc");
        QName qName = new QName("http://web_service.example.org.proctor/", "CalculatorImplService");
        Service service = Service.create(url, qName);
        Calculator port = service.getPort(Calculator.class);
        System.out.println(port.add(2, 3));
    }
}
