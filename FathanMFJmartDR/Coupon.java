package FathanMFJmartDR;



public class Coupon extends Recognizable implements FileParser
{
    public String name;
    public int code;
    public double cut;
    public Type type;
    private boolean used;
    public double minimum;
    
    public  enum Type
{
    DISCOUNT, REBATE
}
    
    

    /**
     * Constructor for objects of class Coupon
     */
    public Coupon(int id, String name, int code, Type type, double cut, double minimum) 
    {
        // initialise instance variables
        super(id);
        this.name= name;
        this.code= code;
        this.type= type;
        this.cut = cut;
        this.minimum= minimum;
        this.used= false;
    }

    
    public boolean isUsed()
    {
        return this.used;
    }
    public boolean canApply(PriceTag priceTag){
        if (priceTag.getAdjustedPrice() >= minimum & used== false ){
            return true;
        }else{
            return false;
        }
    }
    public double apply (PriceTag priceTag){
        this.used=true;
        if(type==Type.REBATE){
            return priceTag.getAdjustedPrice() - this.cut;
        }
        else{
           return priceTag.getAdjustedPrice() - (priceTag.getAdjustedPrice() *(100- this.cut) /100);
        }
    }
    @Override
    public boolean read(String content){
        return false;
    }
}
