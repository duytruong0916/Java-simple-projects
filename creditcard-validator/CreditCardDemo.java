import java.util.*;// needed for Scanner and ArrayList class
import java.io.*; // needed fro File and FileNotFoundException 
/**
*Description: This program will demonstate the validating credit card numver process
*Class: Spring - COSC 1437.83002
*Final project: credit card
*Date: 5/9/2017
*@author  Duy Truong
*@version 0.0.0
*/ 



public class CreditCardDemo 
{ 
 /**
* @param String as args
* @return Void
* @throws Nothing is implemented
*/
    public static void main(String[] args) throws IOException
    {  System.out.println("We are getting data from your file"); 
        
        ArrayList<String> data = new ArrayList<String>(); // create an Arraylist object to get data from file
        ArrayList<String> validnumber = new ArrayList<String>(); // hold the valid numbers
        ArrayList<String> invalidnumber = new ArrayList<String>(); // hold the invalid numbers
        ArrayList<String> issuer = new ArrayList<String>(); // hold the issuer of each valid numbers
            
        // get data from file
            try
            {
                File file=new File("data.txt"); // create a File object to open the file 
                Scanner s= new Scanner(file); // create a Scanner object to read the file
               
                while(s.hasNextLong())
                {
                    data.add(s.nextLine());
                   
                }
                System.out.println("The file was found. \nNow, you can check the output files");
                s.close(); // close the file 
               
                }
                catch(FileNotFoundException e)
                 {
                      System.out.print("The file was not found");
                    }
        
            
            checkvalid object= new checkvalid(data); // create a checkvalid object to check the data
            
            validnumber= object.getvalidnumber(); // assign the return valid numbers to the arraylist object
            invalidnumber=object.getinvalidnumber(); // assign the invalid number to the arraylist object
            issuer=object.getIssuer(); // assign the issuer to the arraylist object
            PrintWriter outputFile1= new PrintWriter("valid_cards.txt"); // create a printwrite object to write the output into file
           
      // write the output valid numvers and the issuers into file
            outputFile1.println("*****The valid Cards******");
            for(int index= 0; index<issuer.size();index++)
            {   
                outputFile1.println("Number: " +validnumber.get(index));
                outputFile1.println("Issuer: " +issuer.get(index));
                outputFile1.println("");
               
            }
           
            outputFile1.close(); // close the file
            
            PrintWriter outputFile2= new PrintWriter("invalid_numbers.txt"); // create a prinwriter object to write the output invalid numbers into file
            // write the output invalid number into file
            outputFile2.println("*****The invalid numbers******");
            for(int index= 0; index<invalidnumber.size();index++)
            {
                outputFile2.println(invalidnumber.get(index));
            }
            outputFile2.close(); // close the file
            
        
            ArrayList<String> input = new ArrayList<String>();  // create an Arraylist object to hold the input from users
            Scanner keyboard=new Scanner(System.in); // create a scanner object to get input from users
            
        
            //get input from users
            System.out.print("\n\nWhat is your credit card number? ");
            input.add(keyboard.nextLine());
        
            checkvalid object2= new checkvalid(input);// create a checkvalid object to check the input number
            object2.checkNum();// call the checkNum method to display the result
       
        
         
            }
 }



        

            
            
