import java.util.*;
/**
 * This class gets the issuers for each valid credit card number
 */
public class GroupIssuer 
{
    private ArrayList<String> validnum= new ArrayList<String>(); // hold the valid credit card numbers
    private ArrayList<String> issuer=new ArrayList<String>();; // hold the issuers of each valid credit card numbers
 /**
  * This setIssuer methods accepts an ArrayList obejct containing the valid numbers as its argument
  * and gets the issuers for each valid number
  * param: array as a list of valid credit card numbers
  * return: void
  */ 
    public void setIssuer(ArrayList<String> array)
    {    
    
    

          for(int index=0; index<array.size(); index++)
          {
              validnum.add(array.get(index));
          }
         
        for(int index=0; index< array.size(); index++)
        {
           
            if(array.get(index).startsWith("45")||array.get(index).startsWith("44"))
                 issuer.add("VISA");
            else if(array.get(index).startsWith("51")||array.get(index).startsWith("53"))
                 issuer.add("MasterCard");
            else if(array.get(index).startsWith("37")||array.get(index).startsWith("34"))
                 issuer.add("American Express (AMEX)");
            else if(array.get(index).startsWith("60"))
                 issuer.add("Discover");
            else if(array.get(index).startsWith("31")||array.get(index).startsWith("33"))
                 issuer.add("JCB");
            else if(array.get(index).startsWith("54")||array.get(index).startsWith("55"))
                 issuer.add("Diners Club - North America");
            else if(array.get(index).startsWith("30"))
                 issuer.add("Diners Club - Carte Blanche");
            else if(array.get(index).startsWith("36"))
                 issuer.add("Diners Club - International");
            else if(array.get(index).startsWith("58"))
                 issuer.add("Maestro");
            else if(array.get(index).startsWith("67"))
                issuer.add("LASER");
            else if(array.get(index).startsWith("49")||array.get(index).startsWith("48"))
                 issuer.add("Visa Electron");
            else if(array.get(index).startsWith("63"))
                 issuer.add("InstaPayment");
          }
        
        }
  /**
   * This getIssuer methods returns the Issuers of each valid credit card number
   * @param: nothing
   * @return: issuer as the issuers of each valid credit card number
   */
 public ArrayList<String> getIssuer()
        { 
            return issuer;
        }
 /**
  * This checkNum method validates the credit card number of the users and displays its issuer
  * param: nothing
  * return: void
  */
        public void checkNum()
{   
    if(validnum.size()!=0) 
       {
           System.out.println("Your credit card number is valid");
           
           System.out.println("The Issuer of your credit card: " +issuer.get(0));
           issuer.remove(0);
           
        }
    
    else 
    {
        
        System.out.print("The number is invalid");
       
        
    }
    }

}
