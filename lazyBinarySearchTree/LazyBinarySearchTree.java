
/**
* This class implement the a binary search tree with lazy deletion.
*/
public class LazyBinarySearchTree {

   private static final int MIN_KEY = 1;
   private static final int MAX_KEY = 99;
   private TreeNode root;  					//this holds the root of the tree

   /**
	 * This default constructor creates a new tree by assigning null to the root
	 * 
	 */
   public LazyBinarySearchTree() 
   {
       this.root = null;
   }

   /**
   * this method returns the height of the node in the tree.
   * @param nodeas tree node
   * @return the height of the node
   */
   private int height(TreeNode node) {
       // Check if node is null
       if (node == null)
           return 0;
       else
           return node.getHeight();
   }

   /**
	 * This method will traverse the tree to find the correct position for the node
	 * if the key of the node has the same value as the deleted node, 
	 * it will erase the "deleted" mark of the node
	 * @param Node 
	 * @param key
	 * @return ResultInsert as the result of the inserting process
	 */
   private boolean insert(TreeNode currentNode, int key) {
       boolean logicalInsert = false;

       if (key < currentNode.getKey()) {
           if (currentNode.getLeftChild() != null)
               logicalInsert = insert(currentNode.getLeftChild(), key);
           else {
               currentNode.setLeftChild(new TreeNode(key));
               logicalInsert = true;
           }

       } else if (key > currentNode.getKey()) {
           if (currentNode.getRightChild() != null)
               logicalInsert = insert(currentNode.getRightChild(), key);
           else {
               currentNode.setRightChild(new TreeNode(key));
               logicalInsert = true;
           }
       } else { // Duplicate found
           // Check whether the node is deleted
           if (currentNode.isDeleted()) {
               // Set currentNode to not deleted
               currentNode.setDeleted(false);
               logicalInsert = true;

           } else
               logicalInsert = false;
       }

       // Update height
       currentNode.setHeight(1 + Math.max(height(currentNode.getLeftChild()), height(currentNode.getRightChild())));
       return logicalInsert;
   }

   /**
	 * This is the insert method that will use another "Advanced" insert method to insert a node into the tree
	 * @param key as the input key of a node
	 * @return the result of the inserting process
	 */
   public boolean insert(int key) throws IllegalArgumentException {
       // Check if key is within range
       if ((key < MIN_KEY) || (key > MAX_KEY))
           throw new IllegalArgumentException("Error in insert: IllegalArgumentException raised");

       if (this.root == null) {
           // If there are no nodes in the tree
           this.root = new TreeNode(key);

           return true;
       } else {
           // If there are nodes in the tree
           return insert(this.root, key);
       }
   }
   /**
	 * This method will traverse the tree to find the correct position for the node
	 * if the key of the node has the same value as the deleted node, 
	 * it will erase the "deleted" mark of the node
	 * @param Node 
	 * @param key
	 * @return ResultInsert as the result of the inserting process
	 */
   private boolean delete(TreeNode currentNode, int key) {
       boolean deleted = true;

       if (key < currentNode.getKey()) {
           if (currentNode.getLeftChild() != null)
               deleted = delete(currentNode.getLeftChild(), key);
           else
               deleted = false;

       } else if (key > currentNode.getKey()) {
           if (currentNode.getRightChild() != null)
               deleted = delete(currentNode.getRightChild(), key);
           else
               deleted = false;

       } else { // Key found
           // Check whether the node is deleted
           if (currentNode.isDeleted())
               deleted = false;
           else {
               // Set currentNode as deleted
               currentNode.setDeleted(true);
               deleted = true;
           }
       }

       return deleted;
   }

   /**
	   * This is the delete method that will use another  "Advanced" delete method to delete a node of the tree
	   * @param key as the input key of a node
	   * @return the result of the deleting process
	   */
   public boolean delete(int key) throws IllegalArgumentException {
       // Check if key is within range
       if ((key < MIN_KEY) || (key > MAX_KEY))
           throw new IllegalArgumentException("Error in insert: IllegalArgumentException raised");

       // Check if root ins not null
       if (this.root != null)
           return delete(this.root, key);
       else
           return false;
   }

   /**
   * this method Checks whether a key exists in the tree and is non-deleted
   * @param currentNode as the current node in tree traversal
   * @param key as the key to be searched
   */
   private boolean contains(TreeNode currentNode, int key) {
       boolean found = true;

       if (key < currentNode.getKey()) {
           if (currentNode.getLeftChild() != null)
               found = contains(currentNode.getLeftChild(), key);
           else {
               found = false;
           }

       } else if (key > currentNode.getKey()) {
           if (currentNode.getRightChild() != null)
               found = contains(currentNode.getRightChild(), key);
           else {
               currentNode.setRightChild(new TreeNode(key));
               found = false;
           }
       } else { // Key found
           // Check whether the node is deleted
           if (currentNode.isDeleted())
               found = false;
           else
               found = true;
       }

       return found;
   }

   /**
   * this method Checks whether a key exists in the tree and is non-deleted
   */
   public boolean contains(int key) throws IllegalArgumentException {
       // Check if key is within range
       if ((key < MIN_KEY) || (key > MAX_KEY))
           throw new IllegalArgumentException("Error in contains: IllegalArgumentException raised");

       // Check if root is not null
       if (this.root != null)
           return contains(this.root, key);
       else
           return false;
   }

   /**
   * this method returns the height of the tree
   */
   public int height() 
   {
       return this.root.getHeight();
   }

   /**
   * Finds the minimum non-deleted element
   *
   * @return - the minimum non-deleted element, -1 if none exists
   */
   private int findMin(TreeNode node, int min) {
       if (node.getLeftChild() != null) {
           // Check if node is not deleted
           if (!node.isDeleted() && !node.getLeftChild().isDeleted())
               min = Math.min(node.getLeftChild().getKey(), min);

           return findMin(node.getLeftChild(), min);
       } else
           return min;
   }

   /**
   * Finds the minimum non-deleted element
   *
   * @return - the minimum non-deleted element, -1 if none exists
   */
   public int findMin() {
       // Check if root is not null
       if (this.root != null) {
           // Set root key as min
           int min = this.root.getKey();

           // Check if left child exists
           if (this.root.getLeftChild() != null)
               return findMin(this.root.getLeftChild(), min);
           else
               return min;
       }

       return -1;
   }

   /**
   * Finds the maximum non-deleted element
   ** @return - the maximum non-deleted element, -1 if none exists
   */
   private int findMax(TreeNode node, int max) {
       if (node.getRightChild() != null) {
           // Check if node is not deleted
           if (!node.isDeleted() && !node.getRightChild().isDeleted())
               max = Math.max(node.getRightChild().getKey(), max);

           return findMax(node.getRightChild(), max);
       } else
           return max;
   }

   /**
    * this method Finds the maximum non-deleted element by using the the Advancedfindmax method
    * @return - the maximum non-deleted element, -1 if none exists
    */
   public int findMax() {
       // Check if root is not null
       if (this.root != null) {
           // Set root key as max
           int max = this.root.getKey();

           // Check if right child exists
           if (this.root.getRightChild() != null)
               return findMax(this.root.getRightChild(), max);
           else
               return max;
       }

       return -1;
   }
   
   /**
    * Returns the count of elements in the tree,including deleted elements
    */
    public int size() {
        // Check if root is not null
        if (this.root != null) 
        {
            return size(this.root, 0);
        }
        return 0;
    }

   /**
   * Returns the count of elements in the tree,including deleted elements
   */
   private int size(TreeNode node, int count) {
       // Check if node is not null
       if (node != null)
       {
           count += 1;
           // Traverse left
           count = size(node.getLeftChild(), count);
           // Traverse right
           count = size(node.getRightChild(), count);
       }
       return count;
   }

   /**
   * this method performs the preorder traversal of the tree
   * @return - Returns a string containing the preorder traversal
   */
   public String toString()
   {
       StringBuffer sb = new StringBuffer();
       sb = preorder(this.root, sb);
       return sb.toString();
   }
   /**
   * this method returns the preorder traversal of the tree
   * @param node as a node of this tree
   * @param sb to holds the string representation of node(s)
   */
   public StringBuffer preorder(TreeNode node, StringBuffer sb) 
   {
	 //We need do the root-lest-right strategy to get the preorder traversal of the tree
       if (node != null) 
       {
           // Append key at node
           // Check if node is deleted
           if (node.isDeleted())
               sb.append("*" + node.getKey() + " ");
           else
               sb.append(node.getKey() + " ");
       
           // Traverse left
           preorder(node.getLeftChild(), sb);
           // Traverse right
           preorder(node.getRightChild(), sb);
       }

       return sb;
   }


   
// Inner class
   private class TreeNode {
       // Instance variable
       private int key;
       private TreeNode leftChild;
       private TreeNode rightChild;
       private boolean deleted;
       private int height;

       /**
       * Constructor
       */
       public TreeNode(int key) {
           this.key = key;
           this.leftChild = null;
           this.rightChild = null;
           this.deleted = false;
           this.height = 1;
       }

       /**
       * Returns the key
       */
       public int getKey() {
           return key;
       }

       /**
       * Returns the left Child node
       */
       public TreeNode getLeftChild() {
           return leftChild;
       }

       /**
       * Returns the right Child node
       */
       public TreeNode getRightChild() {
           return rightChild;
       }

       /**
       * Returns the deleted
       */
       public boolean isDeleted() {
           return deleted;
       }

       /**
       * Returns the height
       */
       public int getHeight() {
           return height;
       }

       /**
       * Sets the key
       * @param key as key to be set
       */
       public void setKey(int key) {
           this.key = key;
       }

       /**
       * Sets the left child node
       * @param leftChild as the leftChild to set
       */
       public void setLeftChild(TreeNode leftChild) {
           this.leftChild = leftChild;
       }

       /**
       * Sets the right node
       * @param rightChid as the rightChild to set
       */
       public void setRightChild(TreeNode rightChild) {
           this.rightChild = rightChild;
       }

       /**
       * Sets whether the TreeNode is deleted or not
       * @param deleted as the deleted to set
       */
       public void setDeleted(boolean deleted) {
           this.deleted = deleted;
       }

       /**
       * Sets the height of the node
       * @param heigt as the height to set
       */
       public void setHeight(int height) {
           this.height = height;
       }

       @Override
       public String toString() {
           return String.valueOf(this.key);
       }
   }
}