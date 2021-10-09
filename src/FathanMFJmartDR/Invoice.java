package FathanMFJmartDR;
import java.util.ArrayList;
import java.util.Date;


/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Invoice extends Recognizable implements FileParser
{
    public String date;
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

    protected Invoice(int id, int buyerId, int productId)
    {
        super(id);
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = "";
        this.rating = Rating.NONE;
        this.status = status.WAITING_CONFIRMATION;
    }

    @Override
    public boolean read(String content){
        return false;
    }
}