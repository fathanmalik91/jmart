package FathanMFJmartDR;


/**
 * Write a description of class PriceTag here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Treasury
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class PriceTag
     */
    public Treasury()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param
     * @return    the sum of x and y
     */
    public static final double  COMMISSION_MULTIPLIER()
    {
        // put your code here
        return 0.05f;
    }
    public static  final double  BOTTOM_PRICE()
    {
        // put your code here
        return 20000.0f;
    }
     public static  final double  BOTTOM_FEE()
    {
        // put your code here
        return 1000.0f;
    }
    double price;
    double discount;
    public Treasury(double price){
        this.price=price;
        this.discount=0.0f;
    }
    public Treasury(double price, double discount){
        this.price=price;
        this.discount=discount;
    }
    private double getDiscountedPrice(){
        if (this.discount > 100.0f) {
            return 0;
        }else{
        return  this.price - (this.price * this.discount/100.0f);
        }
    }
    public double getAdminFee(){
        if (getDiscountedPrice()< BOTTOM_PRICE()){
            return BOTTOM_FEE();
        }else{
            return getDiscountedPrice() * COMMISSION_MULTIPLIER();
        }
    }
    public double getAdjustedPrice(){
        return getDiscountedPrice()+ getAdminFee();
    }
}
