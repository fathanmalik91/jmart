package FathanMFJmartDR;


/**
 * Write a description of class Jmart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Jmart
{
     // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Jmart
     */
    public Jmart() {
        // initialise instance variables
        x = 0;
    }
    

    public static void main(String[] message) {
        // put your code here
        
    }
    public static Product Create(){
        PriceTag pricet= new PriceTag(1000,0);
        Product p = new Product ("duck", 23, false, pricet , ProductCategory.PETCARE);
        return p;
    }
    
    
}