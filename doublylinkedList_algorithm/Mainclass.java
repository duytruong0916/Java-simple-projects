package project2;
import java.util.Scanner;
/**
*Name: Duy TRuong
*Class: CS 3345
*Section: 003
*Semester: Fall 2018
*Project: 2
*Description: This program demonstrates the singly linked list operations
*/ 
public class Mainclass
{

	public static void main(String[] agrs)
	{
		Scanner keyboard = new Scanner(System.in);
		IDedObject object; //create an object of the IdedObject class
		Mylinkedlist list = new Mylinkedlist(); //create a linked list object
		int select=0; //to hold the selection of users
		int ID; //to hold the id
		String name, publisher; // to hold the name and publisher 
		do
		{
			System.out.println("Select an operation:\n 1.Make Empty\n 2.Find ID\n 3.Insert At Front\n "
					+"4.Delete At Front\n 5.Delete ID\n 6.Print All Record\n 7.Done");
			select= keyboard.nextInt();
			keyboard.nextLine();
			if(select!=7)
			{
				switch(select)
				{
					case 1:
					list.makeEmpty();
					System.out.println("The list is empty now!\n\n");
					break;
					case 2:
					{
						System.out.print("Enter the ID:");
						ID=keyboard.nextInt();
						object = list.findID(ID);
						if(object==null)
						{
							System.out.println("ID is not found!\n\n");
						}
						else
							object.printID();
						
					}
					break;
					case 3:
					{
						System.out.print("Enter the magazine ID:");
						ID= keyboard.nextInt();
						keyboard.nextLine();
						System.out.print("Enter the the magazine name: ");
						name=keyboard.nextLine();
						System.out.print("Enter the publisher name: ");
						publisher= keyboard.nextLine();
							object = new magazine(ID, name,publisher);
							list.insertAtFront(object);
						System.out.println("Item added!\n\n");
					break;
						
					}
					case 4:
					{
							object=list.deleteFromFront();
							if(object==null)
							System.out.println("Could not find the item at front!\n\n");
							else
							{	
								object.printID();
								System.out.println("The item at front was deleted successfully!\n\n");
							}
					}
					break;
					case 5:
					{
						System.out.print("Enter the ID: ");
						ID= keyboard.nextInt();
						object=list.delete(ID);
						if(object==null)
							System.out.println("The ID was not found!\n\n");
						else
						{
							object.printID();
							System.out.println("The item was deleted successfully!\n\n");
						}
						
					}
					break;
					case 6:
					{
						list.printAllRecords();
					}
					break;
					
			}}
			
		}while(select!=7);
		System.out.println("Program terminated!!\n");
	}		
	
}
