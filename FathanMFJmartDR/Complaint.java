package FathanMFJmartDR;


public class Complaint extends Recognizable implements FileParser
{
    
    public String desc, date;

    public Complaint(int id, Payment payment, String desc) {
        super(id);
        
        this.desc = desc;
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
