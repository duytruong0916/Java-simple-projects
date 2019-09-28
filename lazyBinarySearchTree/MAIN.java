
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
*Name: Duy TRuong
*Class: CS 3345
*Section: 003
*Semester: Fall 2018
*Project: 3
*Description: This program demonstrates some operations in the Binary Search Tree with lazy deletion
*This program take 2 command line arguments to compile
*if the users do not provide 2 command lines as the names of the input and output files 
*the program will display a direction and give an example
*/ 
public class MAIN 
{
	//these static final variables for holding strings in required format of the input file 
	private static final String INSERT = "Insert:";
	private static final String DELETE = "Delete:";
	private static final String PRINT_TREE = "PrintTree";
	private static final String FIND_MIN = "FindMin";
	private static final String FIND_MAX = "FindMax";
	private static final String HEIGHT = "Height";
	private static final String SIZE = "Size";
	private static final String CONTAINS = "Contains:";

	 public static void main(String[] args)
	 {
	       /* Check if proper arguments are provided
		   */ 
	       if (args.length == 2) 
	       {
	            
	           try {
	              // Scanner to read file and Open file for reading
	              Scanner inFile = new Scanner(new File(args[0]));
	              //Create a File object to hold the name of the output file entered by users in the second command line
	              File outFile = new File(args[1]);
	               // Create file if it does not exists
	               if (!outFile.exists())
	                   outFile.createNewFile();
	               
	               // Open file for writing
	               PrintWriter  pw = new PrintWriter(outFile);
	               
	               // Create LazyBinarySearchTree object
	               LazyBinarySearchTree newtree = new LazyBinarySearchTree();

	               // Read file until the last line
	               while (inFile.hasNextLine()) 
	               {
	                   // Read line and use strim() method to remove leading and trailing space
	                   String line = inFile.nextLine().trim();
	                   // Check operations
	                   if (line.indexOf(INSERT) == 0) //INSERT
	                   { 
	                       // Get key by getting the substring of the input line from an index after the index of INSERT
	                       int key = Integer.parseInt(line.substring(line.indexOf(INSERT) + INSERT.length()));
	                       try 
	                       {
	                           pw.println(CamelCased(newtree.insert(key)));
	                       } catch (IllegalArgumentException iae) 
	                       {
	                           pw.println(iae.getMessage());
	                       }

	                   } 
	                   else if (line.indexOf(DELETE) == 0) //DELETE
	                   { 

	                       // Get key
	                       int key = Integer.parseInt(line.substring(line.indexOf(DELETE) + DELETE.length()));
	                       try {
	                           pw.println(CamelCased(newtree.delete(key)));
	                       } catch (IllegalArgumentException iae) {
	                           pw.println(iae.getMessage());
	                       }

	                   } 
	                   else if (line.indexOf(PRINT_TREE) == 0)
	                   { // PRINT_TREE
	                       pw.println(newtree);

	                   } 
	                   else if (line.indexOf(FIND_MIN) == 0)
	                   { // FIND_MIN
	                       pw.println(newtree.findMin());

	                   }
	                   else if (line.indexOf(FIND_MAX) == 0)
	                   { // FIND_MAX
	                       pw.println(newtree.findMax());

	                   } 
	                   else if (line.indexOf(HEIGHT) == 0)
	                   { // HEIGHT
	                       pw.println(newtree.height());

	                   } 
	                   else if (line.indexOf(SIZE) == 0)
	                   { // SIZE
	                       pw.println(newtree.size());

	                   } 
	                   else if (line.indexOf(CONTAINS) == 0)
	                   { // CONTAINS

	                       // Get key
	                       int key = Integer.parseInt(line.substring(line.indexOf(CONTAINS) + CONTAINS.length()));
	                       try {
	                           pw.println(CamelCased(newtree.contains(key)));
	                       } catch (IllegalArgumentException iae) {
	                           pw.println(iae.getMessage());
	                       }

	                   } else
	                       pw.println("Error in Line: " + line);

	               }

	               // Close in and out file
	               inFile.close();
	               pw.close();
	               System.out.println("Output written to file: " + args[1]);
	               System.out.println("-------PROGRAM TERMINATED------");

	           } catch (FileNotFoundException fnfe)
	           {
	               System.out.println(fnfe.getMessage());
	           } catch (IOException ioe)
	           {
	               ioe.printStackTrace();
	           }

	       } 
	       else
	    	   {
	    	   System.out.println("***This class will take two command line arguments.\n"
	    			   +"***The first argument will be the input file name and second will be output file name");
	           System.out.println("For Example:\n\t\tjava MAIN <inputFileName> <OutputFileName>");
	    	   }
	   }
	 
	 
	 /**
	 * This method converts a boolean to camel-cased string to get the correct format as required
	 * it first converts the boolean value from the called method to String type
	 * it then makes the first letter of the String a capital letter and returns the string
	 * 
	 */
 static String CamelCased(boolean b) 
 {
	  String result = String.valueOf(b);
	   return Character.toUpperCase(result.charAt(0)) + result.substring(1);
 }
	}

