package com.cg.addressbook.demo.Exceptions;

public class ContactNotFoundException extends IllegalArgumentException{
    private String msg;

    public ContactNotFoundException(String msg){
        super(msg);
        this.msg = msg;
    }
}
