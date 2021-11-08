package FathanMFJmartDR;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;


public class Jmart{
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

    public static void main(String[] args) {
        try{
            // sesuaikan argument method read sesuai dengan lokasi resource
            List<Product> list = read("F:/GITHUB OOP/JMART/src/FathanMFJmartDR/randomProductList.json");
            List<Product> filtered = filterByPrice(list, 13000.0, 15000.0);
            filtered.forEach(product -> System.out.println(product.price));

            List<Product> nameFiltered = filterByName(list, "gtx", 1, 5);
            nameFiltered.forEach(product -> System.out.println(product.name));
            List<Product> accountFiltered = filterByAccountId(list, 1, 0, 5);
            accountFiltered.forEach(product -> System.out.println(product.name));

        }catch (Throwable t)
        {
            t.printStackTrace();
        }




        System.out.println("account id:" + new Account(null, null, null, -1).id);
        System.out.println("account id:" + new Account(null, null, null, -1).id);
        System.out.println("account id:" + new Account(null, null, null, -1).id);

        System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
        System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
        System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);





    }
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