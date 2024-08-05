package com.aurionpro.creational.factory.abstractcar.model;

public interface IAccountFactory {
    IAccount createAccount(int accountNumber, String name, double balance);
}
