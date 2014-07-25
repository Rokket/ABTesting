package proctor.org.example.web_service;

import javax.jws.WebService;

@WebService(endpointInterface = "proctor.org.example.web_service.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    @Override
    public String getHelloWorldAsString(String name) {
        return "Hello World JAX-WS" + name;
    }
}
