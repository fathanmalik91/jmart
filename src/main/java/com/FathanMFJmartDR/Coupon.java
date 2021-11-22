package com.FathanMFJmartDR;


import com.FathanMFJmartDR.dbjson.Serializable;

public class Coupon extends Serializable
{
    public String name;
    public int code;
    public double cut;
    public Type type;
    private boolean used;
    public double minimum;
    
    public  enum Type
    {
    DISCOUNT, REBATE
    }
    
    

    /**
     * Constructor for objects of class Coupon
     */
    public Coupon( String name, int code, Type type, double cut, double minimum)
    {
        // initialise instance variables

        this.name= name;
        this.code= code;
        this.type= type;
        this.cut = cut;
        this.minimum= minimum;
        this.used= false;
    }

    
    public boolean isUsed()
    {
        return this.used;
    }
    public boolean canApply(Treasury treasury){
        if (treasury.getAdjustedPrice() >= minimum & used== false ){
            return true;
        }else{
            return false;
        }
    }
    public double apply (Treasury treasury){
        this.used=true;
        if(type==Type.REBATE){
            return treasury.getAdjustedPrice() - this.cut;
        }
        else{
           return treasury.getAdjustedPrice() - (treasury.getAdjustedPrice() *(100- this.cut) /100);
        }
    }

    public boolean read(String content){
        return false;
    }
}
