package FathanMFJmartDR;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.List;
import com.google.gson.*;


public class Jmart{
    class Country{
        public String name;
        public int population;
        public List<String> listOfStates;
    }
    public static void main(String[] args) {
        String filepath = "F:/GITHUB OOP/JMART/src/FathanMFJmartDR/city.json";
        Gson gson = new Gson();

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            Country input=gson.fromJson(br, Country.class);
            System.out.println("name = " + input.name);
            System.out.println("population = " + input.population);
            System.out.println("states = " );
            input.listOfStates.forEach(state-> System.out.println(state));
        }
        catch (IOException e){
            e.printStackTrace();
        }

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