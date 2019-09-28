package project2;
/**
* Magazine Class implements interface IDedObject
*
*/
public class magazine implements IDedObject 
{
	private int magazineID;
	private String magazineName;
	private String publisherName;
	 /**
	  * Constructor
	 */
	public magazine(int ID, String name, String pubname)
	{
		magazineID= ID;
		magazineName = name;
		publisherName = pubname;
	}
 /**
  * Returns magazineID
 */
	public int getID()
	{
		return magazineID;
	}
/**
 * Prints magazine details
 */
	public void printID()
	{
		System.out.printf(" Magazine ID: %d\n Magazine Name: %s\n Magazine publisher: %s\n\n", magazineID, magazineName, publisherName);
	}
}

