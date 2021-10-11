package FathanMFJmartDR;


/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product extends Recognizable
{
    public int storeId; 
    public String name;
    public int weight;
    public boolean conditionUsed;
    public Treasury Treasury;
    public ProductCategory category;
    public ProductRating rating;
    public Shipment.MultiDuration multiDuration;

    public Product(int id, int storeId, String name, int weight, boolean conditionUsed, Treasury Treasury, ProductCategory category, Shipment.MultiDuration multiDuration)
    {
        super(id);
        this.storeId = storeId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.Treasury = Treasury;
        this.category = category;
        this.rating = new ProductRating();
        this.multiDuration = multiDuration;
    }
       public String toString() {
        return 
        "Name: " + this.name +
        "\nWeight: " + this.weight +
        "\nconditionUsed: " + this.conditionUsed +
        "\npriceTag: " + this.Treasury +
        "\ncategory: " + this.category +
        "\nrating: " + this.rating +
        "\nstoreId: " + this.storeId;
    }

    public boolean read(String content){
        return false;
    }
}
