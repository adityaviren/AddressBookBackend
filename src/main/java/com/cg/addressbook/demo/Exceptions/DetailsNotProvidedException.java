package com.cg.addressbook.demo.Exceptions;

public class DetailsNotProvidedException  extends IllegalArgumentException{
    private String msg;

    public DetailsNotProvidedException(String msg){
        super(msg);
        this.msg = msg;

    }
}
