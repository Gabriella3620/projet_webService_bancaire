package alom.bank.server.WebService;

import java.util.Calendar;


import alom.bank.server.AccountType;
import alom.bank.server.BankAccount;
import alom.bank.server.*;
import alom.bank.server.businessLogic.AccountManager;
import alom.bank.server.businessLogic.ClientManager;
import alom.bank.server.exception.*;
import jakarta.jws.WebService;

@WebService(endpointInterface = "alom.bank.server.BankService")
public class BankServiceImpl implements IBankService {

    private ClientManager clientManager = new ClientManager();
    private AccountManager accountManager = new AccountManager();

    @Override
    public Client createClient(String firstName, String lastName, Calendar birthDate) throws ClientAlreadyExistsException {
        return clientManager.createClient(firstName, lastName, birthDate);
    }

    @Override
    public Client getClient(String firstName, String lastName, Calendar birthDate) throws ClientNotFoundException {
        return clientManager.getClient(firstName, lastName, birthDate);
    }

    @Override
    public BankAccount createBankAccount(Client client, AccountType accountType) 
            throws ClientNotFoundException, AccountTypeNotFoundException, AccountAlreadyExistsException {
        return accountManager.createBankAccount(client, accountType);
    }

    @Override
    public BankAccount getBankAccount(Client client, AccountType accountType) 
            throws ClientNotFoundException, AccountTypeNotFoundException, AccountNotFoundException {
        return accountManager.getBankAccount(client, accountType);
    }

    @Override
    public double addFunds(BankAccount account, double amount) 
            throws AccountNotFoundException, InvalidAmountException {
        return accountManager.addFunds(account, amount);
    }

    @Override
    public double getBalance(BankAccount account) throws AccountNotFoundException {
        return accountManager.getBalance(account);
    }

    @Override
    public double withdrawFunds(BankAccount account, double amount) 
            throws AccountNotFoundException, InvalidAmountException, InsufficientFundsException {
        return accountManager.withdrawFunds(account, amount);
    }
}
