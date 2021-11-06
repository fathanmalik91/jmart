package FathanMFJmartDR;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Complaint extends Serializable
{
    
    public String desc;
    public Date date;
    
    

    public Complaint(int id, String desc) {
        super(id);
        
        this.desc = desc;
        this.date = new Date();
    }

    
    public String toString(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = formatter.format(this.date);
        return"\nComplaint{date=" + formattedDate + ", desc='" +this.desc+ "'}";
    }

    public boolean validate() {
        return false;
    }




    public boolean read(String content){
        return false;
    }
}
