package com.FathanMFJmartDR;
import com.FathanMFJmartDR.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a description of class Account here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Account extends Serializable
{
    // instance variables - replace the example below with your own
    public String name, email, password;
    public Store store;
    public double balance;
    public static final String REGEX_EMAIL = "^(?!\\.)(?!.*?\\.\\.)[a-zA-Z0-9&_*~.]+@(?!\\-)[a-zA-Z0-9-]+.(?!.*\\.$)[a-zA-Z0-9.]+$"; 
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d](\\S){8,}$";

    public Account( String name, String email, String password, double balance)
    {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }
    public boolean validate()
    {
        Pattern patternEmail = Pattern.compile(REGEX_EMAIL);
        Matcher matcherEmail = patternEmail.matcher(email);
        Pattern patternPassword = Pattern.compile(REGEX_PASSWORD);
        Matcher matcherPassword = patternPassword.matcher(password);
        boolean matchEmail = matcherEmail.find();
        boolean matchPassword = matcherPassword.find();

        if (matchEmail == true && matchPassword==true){
            return true;
        }else {
            return false;
        }
    }


    public boolean read(String content){
        return false;
    }


    public Object write(){
        return null;
    }
    public String toString(){
        return
        "\nName : "+this.name+
        "\nemail : "+this.email+
        "\npassword : "+this.password;
    }
    public static Object newInstance(String content) {
        return null;
    }
}
