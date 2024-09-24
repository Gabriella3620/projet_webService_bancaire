package alom.bank.server.WebService;

import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.util.Calendar;

import alom.bank.server.AccountType;
import alom.bank.server.BankAccount;
import alom.bank.server.Client;
import alom.bank.server.exception.AccountAlreadyExistsException;
import alom.bank.server.exception.AccountNotFoundException;
import alom.bank.server.exception.AccountTypeNotFoundException;
import alom.bank.server.exception.ClientAlreadyExistsException;
import alom.bank.server.exception.ClientNotFoundException;
import alom.bank.server.exception.InsufficientFundsException;
import alom.bank.server.exception.InvalidAmountException;

@WebService
public interface IBankService {
// créeons un client
    Client createClient(
        @WebParam(name = "firstName") String firstName, 
        @WebParam(name = "lastName") String lastName, 
        @WebParam(name = "birthDate") Calendar birthDate
    ) throws ClientAlreadyExistsException;

    Client getClient(
            @WebParam(name = "firstName") String firstName, 
            @WebParam(name = "lastName") String lastName, 
            @WebParam(name = "birthDate") Calendar birthDate
        ) throws ClientNotFoundException;
    
    BankAccount createBankAccount(
            @WebParam(name = "client") Client client, 
            @WebParam(name = "accountType") AccountType accountType
        ) throws ClientNotFoundException, AccountTypeNotFoundException, AccountAlreadyExistsException;
    BankAccount getBankAccount(
            @WebParam(name = "client") Client client, 
            @WebParam(name = "accountType") AccountType accountType
        ) throws ClientNotFoundException, AccountTypeNotFoundException, AccountNotFoundException;   
    double addFunds(
            @WebParam(name = "account") BankAccount account, 
            @WebParam(name = "amount") double amount
        ) throws AccountNotFoundException, InvalidAmountException;
    double getBalance(
            @WebParam(name = "account") BankAccount account
        ) throws AccountNotFoundException;
    double withdrawFunds(
            @WebParam(name = "account") BankAccount account, 
            @WebParam(name = "amount") double amount
        ) throws AccountNotFoundException, InvalidAmountException, InsufficientFundsException; 


}



