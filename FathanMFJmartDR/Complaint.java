package FathanMFJmartDR;
import java.util.Date;

public class Complaint extends Recognizable implements FileParser
{
    
    public String desc;
    public Date date;
    
    

    public Complaint(int id, Payment payment, String desc) {
        super(id);
        
        this.desc = desc;
        this.date = new Date();
    }

    public Complaint(int id, int buyerId, int storeId, int paymentId, String desc) {
        super(id);
        
        this.desc = desc;
    }

    public boolean validate() {
        return false;
    }

    public Transactor perform() {
        return null;
    }

    @Override
    public boolean read(String content){
        return false;
    }
}
