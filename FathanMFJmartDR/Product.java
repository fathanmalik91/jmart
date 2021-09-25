package FathanMFJmartDR;


/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product extends Recognizable implements FileParser
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
    public int storeId;
    
    

    /**
     * Constructor for objects of class Product
     */
    public Product (int id,  String name, int weight, boolean conditionUsed, PriceTag PriceTag, ProductCategory category){
        super(id);
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.PriceTag = PriceTag;
        this.category = category;
        
        this.storeId= storeId;
    }
    
    @Override
    public boolean read(String content){
        return false;
    }
    
}
