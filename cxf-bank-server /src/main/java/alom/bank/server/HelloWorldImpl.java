
package alom.bank.server;

import jakarta.jws.WebService;

@WebService(endpointInterface = "alom.bank.server.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
        return "Hello " + text;

        

        
    }
}

