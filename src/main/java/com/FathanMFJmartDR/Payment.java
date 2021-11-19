package com.FathanMFJmartDR;


import java.util.ArrayList;
import java.util.Date;

/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
// pake Transaction gabisa
public class Payment extends Invoice
{
    public transient int productId, productCount;
    public Shipment Shipment;
    public ArrayList<Record> history = new ArrayList<>();

    static class Record {
        public final Date date;
        public String message;
        public Status status;

        public Record(Status status, String message) {
            this.date = new Date();
            this.status = status;
            this.message = message;
        }
    }

    public Payment(int buyerId, int productId, int productCount, Shipment shipment) {
        super(buyerId, productId);
        this.productCount = productCount;
        this.Shipment = shipment;
    }
    public double getTotalPay(Product product) {
        return product.price;
    }

    public boolean validate() {
        return false;
    }
    public Invoice perform() {
        return null;
    }


    @Override
    public boolean read(String content){
        return false;
    }
}
