package com.testing;

public class BankAccount {

    private String firstName;
    private String LastName;
    private double balance;

    public BankAccount(String firstName, String lastName, double balance) {
        this.firstName = firstName;
        LastName = lastName;
        this.balance = balance;
    }

    // the branch argument is true  if the customer is
    // performing transaction at a branch with a teller
    public double deposit(double amount, boolean branch){
        balance+= amount;
        return balance;
    }

    public double withdraw(double amount, boolean branch){
        balance -= amount;
        return balance;
    }

    public double getBalance(){
        return balance;
    }
}
