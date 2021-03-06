package com.FathanMFJmartDR;
import com.FathanMFJmartDR.dbjson.Serializable;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Write a description of class Store here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Store extends Serializable
{
    public String name, address, phoneNumber;
    public double balance;
    public static final String REGEX_PHONE = "^\\d{9,12}$";
    public static final String REGEX_NAME = "^[A-Z](?!.*(\\s)\1).{4,20}$";

    public Store(String name, String address, String phoneNumber, double balance){
        this.name = name;
        this.balance = balance;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    public boolean validate(){
        Pattern pattern = Pattern.compile(REGEX_NAME);
        Matcher matcher = pattern.matcher(name);
        Pattern pattern2 = Pattern.compile(REGEX_PHONE);
        Matcher matcher2 = pattern2.matcher(phoneNumber);
        return matcher.find() && matcher2.find();
    }
    

    public boolean read(String content){
        return false;
    }
    public String toString(){
        return
        "Name : "+this.name+
        "\nemail : "+this.address+
        "\nphoneNumber : "+this.phoneNumber;
    }
}
