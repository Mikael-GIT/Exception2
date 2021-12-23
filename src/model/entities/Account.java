package model.entities;

import model.exceptions.DomainException;

public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;


    public Account() {
    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        if(balance < 0) {
            throw new DomainException("Amount of deposit cannot be negative.");
        } else {
            this.balance = balance;
        }
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }


    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return this.holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return this.balance;
    }

    public Double getWithdrawLimit() {
        return this.withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }


    public void deposit(Double amount){
        if(amount < 0) {
            throw new DomainException("Amount of deposit cannot be negative.");
        } else {
            this.balance += amount;
        }
    }

    public void withdraw(Double amount) {
        if(amount > withdrawLimit) {
            throw new DomainException("Withdraw error: The amount exceeds withdraw limit.");    
        } 
        else if(amount > this.balance){
            throw new DomainException("Withdraw error: Not enough balance");
        }
        else {
            this.balance -= amount;
        }
    }
}