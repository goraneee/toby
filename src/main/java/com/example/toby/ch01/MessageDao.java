package com.example.toby.ch01;

public class MessageDao {
    DConnectionMaker dConnectionMaker;

    public MessageDao(DConnectionMaker dConnectionMaker) {
        this.dConnectionMaker = dConnectionMaker;
    }
}
