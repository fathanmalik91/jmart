package FathanMFJmartDR;


/**
 * Write a description of class Account here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Account extends Recognizable implements FileParser
{
    // instance variables - replace the example below with your own
    public String name, email, password;

    
      public Account(int id, String name, String email, String password)
    {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean read(String content){
        return false;
    }

    @Override
    public Object write(){
        return null;
    }
    public String toString(){
        return
        "Name : "+this.name+
        "\nemail : "+this.email+
        "\npassword : "+this.password;
    }
    public static Object newInstance(String content) {
        return null;
    }
}