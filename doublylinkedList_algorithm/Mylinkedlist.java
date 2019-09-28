package project2;

/**
 * this is the generic singly linked list java class (Give an appropriate name) to hold objects
of the generic type <Anytype>. This AnyType extends IDedObject
*/

public class Mylinkedlist<AnyType extends IDedObject> {
  
   //Header Node
   private Node start;
   //Size of list
   private int size;
  
   /**
   * Constructor
   */
   public Mylinkedlist(){
       start = null;
       size = 0;
   }
  
   /**
   * Method to empty the list
   */
   public void makeEmpty(){
       start = null;
       size = 0;
   }
  
   /**
   * Method to insert AnyType object at the front of the list
   * @param object
   * @return
   */
   public boolean insertAtFront(AnyType magazine){
      
       Node node = new Node(magazine, null);
      
       //If list empty, insert x and return true
       if(start == null)
       {
           start = node;
           size++;
           return true;
       }
      
       Node nptr = start;
      
       while(nptr!=null){
           //If ID already present return false
           if(nptr.getData().getID() == magazine.getID()){
               return false;
           }
           else{
               nptr = nptr.getLink();
           }
       }
      
       //ID not present in the list. Insert x at the front of the list and return true;
       node.setLink(start);
       start = node;
       size++;
      
       return true;
   }
  
   /**
   * Method to find and return AnyType object
   */
   public AnyType findID(int ID){
       Node nptr = start;
      
       while(nptr!=null){
           if(nptr.getData().getID() == ID){
               return nptr.getData();
           }
           else{
               nptr = nptr.getLink();
           }
       }
      
       return null;
   }
  
   /**
   * Method to delete from the front of the list
   * and return the deleted record
   * @return AnyType object
   */
   public AnyType deleteFromFront()
   {
      
       if(start == null)
       {
           return null;
       }
      
       AnyType magazine = start.getData();
       start = start.getLink();
       size--;
       return magazine;
   }
  
   /**
   * Method to delete record which contains ID
   * and return the deleted record
   * @param ID
   * @return
   */
   public AnyType delete(int ID){
      
       if(start == null)
           return null;
      
       if(start.getData().getID() == ID){
           AnyType x = start.getData();
           start = start.getLink();
           size--;
           return x;
       }
      
       AnyType x = null;
       Node ptr = start;
       Node nptr = start.getLink();
      
       while(nptr!=null){
           if(nptr.getData().getID() == ID){
               x=nptr.getData();
               ptr.setLink(nptr.getLink());
               size--;
               break;
           }
           else{
               ptr = nptr;
               nptr = nptr.getLink();
           }
          
       }
       return x;
   }
  
   /**
   * Print all records in the list
   */
   public void printAllRecords(){
      
       if(start==null){
           System.out.println("List is empty\n\n");
       }
      
       Node nptr = start;
      
       while(nptr!=null)
       {
           nptr.getData().printID();
           nptr = nptr.getLink();
       }
   }
  
   /**
   * Inner Node class
   * @author Anonymous
   *
   */
   public class Node{
      
       private AnyType data;
       //Link to next node
       private Node link;
      
       Node(AnyType data, Node link)
       {
           this.data = data;
           this.link = link;
       }

       public AnyType getData() {
           return data;
       }

       public void setData(AnyType data) {
           this.data = data;
       }

       public Node getLink() {
           return link;
       }

       public void setLink(Node link) {
           this.link = link;
       }
      
      
   }
}