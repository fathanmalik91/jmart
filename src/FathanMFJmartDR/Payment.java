package FathanMFJmartDR;


/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
// pake Transaction gabisa
public class Payment extends Invoice
{
    public int productId, productCount;
    public Shipment Shipment;


    public Payment( int buyerId, int productId, int productCount,  Shipment Shipment) {
        super(buyerId,productId);
        this.productId = productId;
        this.Shipment = Shipment;
    }
    public double getTotalPay() {
        return 0.0f;
    }
    public boolean validate() {
        return false;
    }
    public Invoice perform() {
        return null;
    }
    @Override
    public boolean read(String content){
        return false;
    }
}
