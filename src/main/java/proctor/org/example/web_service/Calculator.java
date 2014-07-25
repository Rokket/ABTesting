package proctor.org.example.web_service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Calculator {

    @WebMethod
    int add(int a, int b);
}
