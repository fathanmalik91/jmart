package com.FathanMFJmartDR.controller;

import com.FathanMFJmartDR.ObjectPoolThread;
import com.FathanMFJmartDR.Payment;
import com.FathanMFJmartDR.dbjson.JsonTable;
import org.springframework.web.bind.annotation.PostMapping;

public class PaymentController {
    public static final long DELIVERED_LIMIT_MS =100;
    public static final long ON_DELIVERY_LIMIT_MS =100;
    public static final long ON_PROGRESS_LIMIT_MS =100;
    public static final long WAITING_CONF_LIMIT_MS =100;
    public static JsonTable<Payment> paymentTable;
    public static ObjectPoolThread<Payment> poolThread;

    @PostMapping("/{id}/accept")
    public boolean accept (int id){
        return true;
    }

    @PostMapping("/{id}/cancel")
    public boolean cancel (int id){
        return true;
    }

    @PostMapping("/create")
    public Payment create (int buyerId, int productId, int productCount, String shipmentAddress, byte shipmentPlan){
        return null;
    }

    public JsonTable<Payment> getJsonTable(){
        return null;
    }

    @PostMapping("/{id}/submit")
    public boolean submit(int id,String receipt){
        return true;
    }


    private boolean timekeeper(Payment payment){
        return true;
    }
}