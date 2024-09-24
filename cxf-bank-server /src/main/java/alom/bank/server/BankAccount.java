package alom.bank.server;

public class BankAccount {
    private String accountId;
    private Client client;
    private AccountType accountType;
    private double balance;

    // Constructeur
    // Constructeur
    public BankAccount() {

    }
    public BankAccount(String accountId, Client client, AccountType accountType, double balance) {
        this.accountId = accountId;
        this.client = client;
        this.accountType = accountType;
        this.balance = balance;
    }

    // Getters et setters
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
