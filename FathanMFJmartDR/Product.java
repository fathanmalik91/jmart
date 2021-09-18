package FathanMFJmartDR;


/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product
{
    // instance variables - replace the example below with your own
    private static int idCounter;
    public int id;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag PriceTag;
    public ProductCategory category;
    public ProductRating rating;
    
    

    /**
     * Constructor for objects of class Product
     */
    public Product( String name, int weight, boolean conditionUsed, PriceTag PriceTag, ProductCategory category){
        this.idCounter = idCounter++;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.PriceTag = PriceTag;
        this.category = category;
    }
    

    
}
