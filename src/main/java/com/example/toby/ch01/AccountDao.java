package com.example.toby.ch01;

public class AccountDao {

    DConnectionMaker dConnectionMaker;
    public AccountDao(DConnectionMaker dConnectionMaker) {
        this.dConnectionMaker = dConnectionMaker;
    }
}
