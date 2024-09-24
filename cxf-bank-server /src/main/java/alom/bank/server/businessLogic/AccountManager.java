package alom.bank.server.businessLogic;

import java.util.HashMap;
import java.util.Map;

import alom.bank.server.AccountType;
import alom.bank.server.BankAccount;
import alom.bank.server.Client;
import alom.bank.server.exception.*;

public class AccountManager {
    private Map<String, BankAccount> accounts = new HashMap<>();

    public BankAccount createBankAccount(Client client, AccountType accountType) 
            throws AccountAlreadyExistsException {
        String accountKey = client.getClientId() + "-" + accountType.name();
        if (accounts.containsKey(accountKey)) {
            throw new AccountAlreadyExistsException("Un compte de ce type existe déjà pour ce client.");
        }
        BankAccount newAccount = new BankAccount(accountKey, client, accountType, 0.0);
        accounts.put(accountKey, newAccount);
        return newAccount;
    }

    public BankAccount getBankAccount(Client client, AccountType accountType) 
            throws AccountNotFoundException {
        String accountKey = client.getClientId() + "-" + accountType.name();
        if (!accounts.containsKey(accountKey)) {
            throw new AccountNotFoundException("Le compte de ce type n'existe pas.");
        }
        return accounts.get(accountKey);
    }

    public double addFunds(BankAccount account, double amount) 
            throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Le montant doit être supérieur à zéro.");
        }
        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);
        return newBalance;
    }

    public double getBalance(BankAccount account) throws AccountNotFoundException {
        if (account == null) {
            throw new AccountNotFoundException("Le compte n'existe pas.");
        }
        return account.getBalance();
    }

    public double withdrawFunds(BankAccount account, double amount) 
            throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Le montant doit être supérieur à zéro.");
        }
        if (account.getBalance() < amount) {
            throw new InsufficientFundsException("Fonds insuffisants pour effectuer le retrait.");
        }
        double newBalance = account.getBalance() - amount;
        account.setBalance(newBalance);
        return newBalance;
    }
}
