package com.ftn.webshop.models;

public class Account {

    private String accountId;
    private String accountNumber;

    public Account() {
    }

    public Account(String accountId, String accountNumber) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
