package alom.bank.server;

import jakarta.jws.WebService;

@WebService
public interface HelloWorld {
    String sayHi(String text);
}

