package FathanMFJmartDR;
import java.util.ArrayList;
import java.util.Date;


/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Invoice extends Serializable
{
    public Date date;
    public int buyerId, productId,complaintId;
    public Rating rating;
    public Status status;
    public ArrayList<Record> history = new ArrayList<Record>();
    public enum Status {
        WAITING_CONFIRMATION,
        CANCELLED,
        ON_PROGRESS,
        ON_DELIVERY,
        COMPLAINT,
        FINISHED,
        FAILED
    }

    public enum Rating {
        NONE,
        BAD,
        NEUTRAL,
        GOOD
    }
    class Record{
    
        public Status status;
        public Date date;
        public String message;
    }

    protected Invoice( int buyerId, int productId)
    {

        this.buyerId = buyerId;
        this.productId = productId;
        this.date = new Date();
        this.rating = Rating.NONE;
        this.status = status.WAITING_CONFIRMATION;
    }


    public boolean read(String content){
        return false;
    }
}