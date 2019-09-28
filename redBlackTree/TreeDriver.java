
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
	*Project: 4
	*Description: This program demonstrates some operations in the Red-Black Tree 
	*This program take 2 command line arguments to compile
	*if the users do not provide 2 command lines as the names of the input and output files 
	*the program will display a direction and give an example
	*/ 
	public class TreeDriver  
	{
		private static final String INSERT = "Insert:";
		private static final String PRINT_TREE = "PrintTree";
		private static final String CONTAINS = "Contains:";
		
		 public static void main(String[] args)
		 {

			 String objectType;
		       /* Check if proper arguments are provided
			   */ 
		       if (args.length == 2) 
		       {
		            
		           try 
		           {
		              // Scanner to read file and Open file for reading
		              Scanner inFile = new Scanner(new File(args[0]));
		              //Create a File object to hold the name of the output file entered by users in the second command line
		              File outFile = new File(args[1]);
		               // Create file if it does not exists
		               if (!outFile.exists())
		                   outFile.createNewFile();
		               // Open file for writing
		               PrintWriter  pw = new PrintWriter(outFile);
		               //Read the first line in the file
		               //if it is "Integer" -> create an Integer object of the tree
		               //otherwise, create a String object of the tree
		        
		          objectType = inFile.nextLine().trim();
		        if(objectType == "Integer")
		          {
		        	 RedBlackTree<Integer> InTree = new RedBlackTree<Integer>();
		               while (inFile.hasNextLine()) 
		               {
		            
		            	   String line = inFile.nextLine().trim();
		            	 if(line.indexOf(INSERT) == 0)
		            	{
		                
		            		 int key = Integer.parseInt(line.substring(line.indexOf(INSERT) + INSERT.length()));
		            	   try 
	                       {
		            		   pw.println(CamelCased(InTree.insert(key)));
	                        } catch (IllegalArgumentException iae) 
	                       {
	                         pw.println(iae.getMessage());
	                        }
		                }
		            	 else if(line.indexOf(CONTAINS) == 0)
		            	 {
		            		 int key = Integer.parseInt(line.substring(line.indexOf(INSERT) + INSERT.length()));
			            	 try 
		                      {
			            		 pw.println(CamelCased(InTree.contains(key)));
		                       } catch (IllegalArgumentException iae) 
		                       {
		                         pw.println(iae.getMessage());
		                       }
			               }
		                
		            	 else if(line.indexOf(PRINT_TREE) == 0)
		             		{
		            	 		pw.println(InTree.toString());
		             		}
		             	else
		                       pw.println("Error in Line: " + line);

		                  }
		               }
		      else
		         {
		        	 RedBlackTree<String> StTree = new RedBlackTree<String>();
		        	 while (inFile.hasNextLine()) 
		               {
		            
		            	   String line = inFile.nextLine().trim();
		            	 if(line.indexOf(INSERT) == 0)
		            	 	{
		                
		            		 String key = line.substring(line.indexOf(INSERT) + INSERT.length());
		            	 try 
	                      {
		            		 pw.println(CamelCased(StTree.insert(key)));
	                       } catch (IllegalArgumentException iae) 
	                       {
	                         pw.println(iae.getMessage());
	                       }
		                    }
		            	 else if(line.indexOf(CONTAINS) == 0)
		            	 {
		            		 String key = line.substring(line.indexOf(INSERT) + INSERT.length());
			            	 try 
		                      {
		        
		                    	   pw.println(CamelCased(StTree.contains(key)));
		                       } catch (IllegalArgumentException iae) 
		                       {
		                         pw.println(iae.getMessage());
		                       }
			               }
		            	 
		            	 else if(line.indexOf(PRINT_TREE) == 0)
		             		{
		            	 		pw.println(StTree.toString());
		             		}
		            	 else
		                       pw.println("Error in Line: " + line);

		                  }
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
		           System.out.println("For Example:\n\t\tjava TreeDriver <inputFileName> <OutputFileName>");
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


