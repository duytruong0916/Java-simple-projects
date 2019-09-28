import java.util.*;// needed for arraylist class
/**
 * This class validates each credit card number to see if they are a valid number
 */


public class checkvalid extends CreditCard
{
    
    private ArrayList<String> validnumber =new ArrayList<String>();// hold the valid numbers
    private ArrayList<String> invalidnumber= new ArrayList<String>(); // hold the invalid numbers
    

    
    /**
     * This constructor accepts an Arrylist object and check whether it's elements are valid numbers or not
     * @param: Arraylist<String> data as a list of numbers read from the file
     * @retrun: nothing
     */
    
    
    public checkvalid(ArrayList<String> data)
    { 
      ArrayList<String> possiblenum = new ArrayList<String>();// hold the possible credit card numbers
      ArrayList<String> notnum=new ArrayList<String>();// hold the imposisble credit card numbers
      ArrayList<String> lastdigit=new ArrayList<String>(); //hold the last digits
      ArrayList<String> firstpart=new ArrayList<String>(); // hold the numbers without the last digit 
      ArrayList<String> reversepart=new ArrayList<String>(); // hold the reverse parts of the numbers

      
      //Evaluate each number to see if they are representing a possible credit card number
      // Add the possible numbers and impossible numbers to each field
                    for(int index=0; index< data.size(); index++)
              {  
                  if(data.get(index).length()>=13&&data.get(index).length()<=19)
                            possiblenum.add(data.get(index));
                   else 
                        notnum.add(data.get(index));
              }
             
        //get the last digits and the numbers without the last digit and add them to each field    
                    for(int index=0; index< possiblenum.size(); index++)
              {
                    firstpart.add((String.valueOf(Long.parseLong(possiblenum.get(index))/10)));
                    lastdigit.add(index,(String.valueOf(Long.parseLong(possiblenum.get(index))%10)));
              }
                
                
             
     String[] firstpartString = new String[firstpart.size()];// hold the numbers without the last digit of String data type
     
     //conver a firstpart to a String array obejct
     firstpartString= firstpart.toArray(firstpartString);
     
     //get the reverse numbers and add them to the field
            for(int index=0; index< firstpartString.length; index++)
                    {
                        char[] temparray= firstpartString[index].toCharArray();
                        int left,right=0;
                        right =temparray.length-1;
                              for (left=0; left < right ; left++ ,right--)
                            {
                                // Swap values of left and right 
                                char temp = temparray[left];
                                temparray[left] = temparray[right];
                                temparray[right]=temp;
                            }
                         reversepart.add(new String(temparray));
                        }
               
             
   long[] numberworking= new  long[reversepart.size()]; // hold the sum of the digits after multiplying the digits in odd positions
   
     //Multiply the digits in odd positions (1, 3, 5, etc.) by 2 and subtract 9 to all any result higher than 9
     //Add all the numbers together            
                  for( int index=0; index< reversepart.size(); index++)
                  {   numberworking[index]=0;
                      int x;
                      for( int index1=0; index1< reversepart.get(index).length(); index1++)
                      {
                           x= Character.getNumericValue(reversepart.get(index).charAt(index1));
                          if((index1+1)%2!=0)
                            {   
                                x=x*2;
                            }
                            else 
                            { 
                                x=x;
                            }
                                if(x>9)
                                {
                                    x=x-9;
                                }
                            
                             numberworking[index]= numberworking[index]+x;
                         }}
               
   long[] sumtotal= new long[lastdigit.size()];// hold the sum of the digits and the last digits
  
                //add the impossible numbers to the invalidnumber field
                    for(int index =0; index< notnum.size(); index++)
                  {
                      invalidnumber.add(notnum.get(index));
                   }
                   
                  //check if the sum of all the digits and the last digits are the multiple of 10
                  //add the valid numbers to the valinumber field
                  //add the inbvalid numbers to the invalidnumber field
                  for(int index =0; index< lastdigit.size(); index++)
                  {
                      sumtotal[index]= numberworking[index]+ Long.parseLong(lastdigit.get(index));
                                if(sumtotal[index]%10==0)
                                {
                                    validnumber.add(possiblenum.get(index));
                                }
                                else
                                {
                                    invalidnumber.add(possiblenum.get(index));
                                }
   
                                
                      }
                   
                
                  
                // call the super class methods and set the validnumber array and the invalidnumber array
               setNumber(validnumber,invalidnumber); 
          
                   
                  
                  
               
            }
            
            
        }
