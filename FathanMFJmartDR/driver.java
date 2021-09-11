package FathanMFJmartDR;


/**
 * Write a description of class driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class driver
{
   public void main (String args[]){
       getPromo();
       getCustomer();
       
   }
   public int getPromo(){
       return 0;
   }
   public String getCustomer(){
       return "oop";
   }
   public float getDiscountPercentage(int before, int after){
       if(before<after){
           return 0.0f;
       }else{
           return before - after;
       }
   }
   public float getDiscountedPrice(int price, float discountPercentage){
       if (discountPercentage >100.0f){
           return 0;
       }else{
           return price - discountPercentage;
       }
   }
   public int getOriginalPrice(int discountedPrice, float discountPercentage){
       return discountedPrice + (discountedPrice *(int)discountPercentage/100);
   }
   public float getCommissionMultiplier(){
       return 0.05f;
   }
   public float getAdjustedPrice(int price){
       return price + (price * getCommissionMultiplier());
   }
   public float getAdminFee(int price){
       return (price * getCommissionMultiplier());
   }
}
