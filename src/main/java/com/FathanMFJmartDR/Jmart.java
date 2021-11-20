package com.FathanMFJmartDR;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

import com.FathanMFJmartDR.dbjson.JsonDBEngine;
import com.FathanMFJmartDR.dbjson.JsonTable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;



@SpringBootApplication
public class Jmart{

    public static long DELIVERED_LIMIT_MS = 320;
    public static long ON_DELIVERY_LIMIT_MS = 320;
    public static long ON_PROGRESS_LIMIT_MS = 320;
    public static long WAITING_CONF_LIMIT_MS = 320;


    public static void main (String[] args){

        JsonDBEngine.Run(Jmart.class);
        SpringApplication.run(Jmart.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
    }

    public static List<Product> filterByCategory(List<Product> list, ProductCategory category){
        return Algorithm.collect(
                list.iterator(),(Predicate<Product>) product -> category == product.category);
    }
    public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice){
        List<Product> products = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            if(minPrice <= 0.0){
                if(list.get(i).price <= maxPrice){
                    products.add(list.get(i));
                }
            }else if(maxPrice <= 0.0){
                if(list.get(i).price >= minPrice){
                    products.add(list.get(i));
                }
            }else{
                if(list.get(i).price >= minPrice && list.get(i).price <= maxPrice){
                    products.add(list.get(i));
                }
            }
        }
        return products;


    }


    private static List<Product> paginate (List<Product> list, int page, int pageSize, Predicate<Product> pred){
        if(page <0 ){
            page=0;
        }if(pageSize<0){
            pageSize=0;
        }
            return list.stream().filter(a -> pred.predicate(a)).skip(page * pageSize).limit(pageSize).collect(Collectors.toList());

    }


    public static List<Product> filterByName(List<Product> list, String search, int page, int pageSize) {
        Predicate<Product> predicate = a -> (a.name.toLowerCase().contains(search.toLowerCase()));
        return paginate(list, page, pageSize, predicate);
    }

    public static List<Product> filterByAccountId(List<Product> list, int accountId, int page, int pageSize) {
        Predicate<Product> predicate = a -> (a.accountId == accountId);
        return paginate(list, page, pageSize, predicate);
    }



    public static List<Product> read (String filepath) throws FileNotFoundException{
         Gson gson= new Gson();
        JsonReader jsonReader = new JsonReader(new FileReader(filepath));
        Product[] products= gson.fromJson(jsonReader, Product[].class);
        List<Product> list = new ArrayList<>();
        Collections.addAll(list, products);
        return list;
    }

    public static boolean paymentTimekeeper(Payment payment) {
        Payment.Record record = payment.history.get(payment.history.size() - 1);
        long elapsed = Math.abs(record.date.getTime() - (new Date()).getTime());

        if(record.status == Invoice.Status.WAITING_CONFIRMATION && elapsed > WAITING_CONF_LIMIT_MS) {
            payment.history.add(new Payment.Record(Invoice.Status.FAILED, "Waiting"));
            return true;
        } else if(record.status == Invoice.Status.ON_PROGRESS && elapsed > ON_PROGRESS_LIMIT_MS) {
            payment.history.add(new Payment.Record(Invoice.Status.FAILED, "On process"));
            return true;
        } else if(record.status == Invoice.Status.ON_DELIVERY && elapsed > ON_DELIVERY_LIMIT_MS) {
            payment.history.add(new Payment.Record(Invoice.Status.DELIVERED, "Delivering"));
            return false;
        } else if(record.status == Invoice.Status.DELIVERED && elapsed > DELIVERED_LIMIT_MS) {
            payment.history.add(new Payment.Record(Invoice.Status.FINISHED, "Finished"));
            return true;
        }
        return false;
    }



/*    public static void main(String[] args) {
        try{


            SpringApplication.run(Jmart.class,args);
            JsonTable<Payment> table = new JsonTable<>(Payment.class, "F:/GITHUB OOP/JMART/src/FathanMFJmartDR/randomPaymentList.Json");
            ObjectPoolThread<Payment> paymentPool = new ObjectPoolThread<Payment>("Thread-PP", Jmart::paymentTimekeeper);
            paymentPool.start();

            table.forEach(payment -> paymentPool.add(payment));
            while(paymentPool.size() !=0);
            paymentPool.exit();

            while (paymentPool.isAlive());
            System.out.println("Thread exited successfully");
            Gson gson = new Gson();
            table.forEach(payment-> {
                String history = gson.toJson(payment.history);
                System.out.println(history);
                    });
        }catch (Throwable t)
        {
            t.printStackTrace();
        }
            String filepath = "F:/GITHUB OOP/JMART/src/FathanMFJmartDR/account.json";

            JsonTable<Account> tableAccount = new JsonTable<>(Account.class, filepath);
            tableAccount.add(new Account("name", "email", "password"));
            tableAccount.writeJson();

            tableAccount = new JsonTable<>(Account.class, filepath);
            tableAccount.forEach(account -> System.out.println(account.toString()));



           // sesuaikan argument method read sesuai dengan lokasi resource
            List<Product> list = read("F:/GITHUB OOP/JMART/src/FathanMFJmartDR/randomProductList.json");
            List<Product> filtered = filterByPrice(list, 13000.0, 15000.0);
            filtered.forEach(product -> System.out.println(product.price));

            List<Product> nameFiltered = filterByName(list, "gtx", 1, 5);
            nameFiltered.forEach(product -> System.out.println(product.name));
            List<Product> accountFiltered = filterByAccountId(list, 1, -1, 5);
            accountFiltered.forEach(product -> System.out.println(product.name));
        */





     /*   System.out.println("account id:" + new Account(null, null, null, -1).id);
        System.out.println("account id:" + new Account(null, null, null, -1).id);
        System.out.println("account id:" + new Account(null, null, null, -1).id);

        System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
        System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
        System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);


    */



}






/*public class Jmart
{
     // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Jmart

    public Jmart() {
        // initialise instance variables
        x = 0;
        
    }
    

    public static void main(String[] message) {
        // put your code here
        Store store = new Store(1, "Lopan 88 cuan max","Kelapa gading","021567988442");
        store.validate();
        System.out.print(store);
        Account account = new Account(1,"CaoCao","WUcao@gmail.com","ChingChong1");
        account.validate();
        System.out.print(account);
        Complaint komplain = new Complaint (1333," kurirnya maling ");
        System.out.print(komplain);
        
    }
/*    public static Product Create(){
        PriceTag pricet= new PriceTag(1000,0);
        Product p = new Product (1,11,"duck", 23, false, pricet , ProductCategory.PETCARE,3);
        return p;
    }
    

    public static Product createProduct(){
        return null;
    }
    public static Product createCoupon(){
        return null;
    }
    public static Product ShipmentDuration(){
        return null;    
    }
    
    
}
*/