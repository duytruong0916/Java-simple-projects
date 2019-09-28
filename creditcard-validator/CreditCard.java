import java.util.*;
/**
 * This class stores the valid numbers and invalid numbers in a separate array
 */
public class CreditCard extends GroupIssuer
{
  
    private ArrayList<String> validnum= new ArrayList<String>();; // hold the valid bumbers
    private ArrayList<String> invalidnum=new ArrayList<String>();; // hold the invalid numbers
    
/**
 * This setNumber method accepts 2 ArrayList objects as its two argument
 * and add the valid numbers and invalid numbers to its fields
 * @param: ArrayList<String> array1, ArrayList<String> array2 as two lists of invalid numbers and valid numbers
 * @retrun: void
 */
public void setNumber(ArrayList<String> array1, ArrayList<String> array2)
 { 
     setIssuer(array1);
    
          for(int index=0; index<array1.size(); index++)
          {
              validnum.add(array1.get(index));
          }
            
          for(int index1=0; index1<array2.size(); index1++)
          {
              invalidnum.add(array2.get(index1));
          }
            
    }
/**
 * This getinvalidnumber returns an ArrayList obejct containing the invalid numbers
 * param: nothing
 * return: invalidnum as an ArrayList obejct containing the invalid number
 */
public ArrayList<String> getinvalidnumber()
{
    return invalidnum;
}
/**
 * This getvalinumber method returns an Arraylist obejct containing the valid numbers
 * param: nothing
 * return: invalidnum as an Arraylist object containing the valid numbers
 */

public ArrayList<String> getvalidnumber()
{
    return validnum;
}

    


            
}