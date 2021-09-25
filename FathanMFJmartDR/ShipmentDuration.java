package FathanMFJmartDR;


/**
 * Write a description of class ShipmentDuration here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ShipmentDuration
{
    // instance variables - replace the example below with your own
    private final int bit;
    public static final ShipmentDuration INSTANT = new ShipmentDuration(1<<0);
    public static final ShipmentDuration SAME_DAY= new ShipmentDuration(1<<1);
    public static final ShipmentDuration NEXT_DAY= new ShipmentDuration(1<<2);
    public static final ShipmentDuration REGULER= new ShipmentDuration(1<<3);
    public static final ShipmentDuration KARGO= new ShipmentDuration(1<<4);
    
    private ShipmentDuration(int bit)
    {
        // initialise instance variables
        this.bit=bit;
    }
    
   /* public  ShipmentDuration(ShipmentDuration args[])
    {
        // initialise instance variables
        return new ShipmentDuration(bit);
    }*/

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
}
