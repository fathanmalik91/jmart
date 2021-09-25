package FathanMFJmartDR;


/**
 * Write a description of class FileParser here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface FileParser
{
    // instance variables - replace the example below with your own
    boolean read (String content);
    default Object write() {
        return null;
    }
    public static Object newInstance(String content){
        return null;
    }
    
}
