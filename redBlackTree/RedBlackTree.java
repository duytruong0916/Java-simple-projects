
import java.util.ArrayList;
import java.util.List;

// The is the implemented Red-Black tree clas
public class RedBlackTree<E extends Comparable<E>> 
{
	class Node<E extends Comparable<E>> 
	{
        E element;
        boolean color;
        Node<E> parent;
        Node<E> left;
        Node<E> right;
        Node() 
        {
                color = BLACK;
                parent = null;
                left = null;
                right = null;
        }
        // Constructor which sets key to the argument.
        Node(E key) 
        {
                this();
                this.element = key;
        }
}// end class RedBlackNode
        private Node<E> NullNode = new Node<E>();
        private Node<E> root = NullNode;
        public static final boolean BLACK=true;
        public static final boolean RED=false;
        public RedBlackTree() 
        {
                root.left = NullNode;
                root.right = NullNode;
                root.parent =NullNode;
        }

        public boolean insert(E element) 
        {
        	 if(element == null)
             {
                 throw new NullPointerException("Element should not be null.");
             }
            
                return insert(new Node<E>(element));
        }

        // @param: z, the node to be inserted into the Tree rooted at root
        // Inserts z into the appropriate position in the RedBlackTree while
        // updating numLeft and numRight values.
        private boolean insert(Node<E> z)
        {

                // Create a reference to root & initialize a node to nil
                Node<E> y = NullNode;
                Node<E> x = root;

                // While we haven't reached a the end of the tree keep
                // try to figure out where z should go
                while (!isEmpty(x))
                {
                        y = x;
                        // if z.key is < than the current key, go left
                        if (z.element.compareTo(x.element) < 0) 
                        {
                                // Update x.numLeft as z is < than x
                                x = x.left;
                        }

                        // else z.key >= x.key so go right.
                        else  if (z.element.compareTo(x.element) > 0) 
                        {

                                // Update x.numGreater as z is => x
                                x = x.right;
                        }
                        else 
                        {
                        	return false;
                        }
                }
                // y will hold z's parent
                z.parent = y;

                // Depending on the value of y.element, put z as the left or
                // right child of y
                if (isEmpty(y))
                        root = z;
                else if (z.element.compareTo(y.element) < 0)
                        y.left = z;
                else
                        y.right = z;

                // Initialize z's children to nil and z's color to red
                z.left = NullNode;
                z.right = NullNode;
                z.color = RED;

                // Call insertFixup(z)
                insertFixup(z);
                return true;
        }// end insert(RedBlackNode z)
        
        // @param: z, the node which was inserted and may have caused a violation
        // of the RedBlackTree properties
        // Fixes up the violation of the RedBlackTree properties that may have
        // been caused during insert(z)
        private void insertFixup(Node<E> z) {

                Node<E> y = NullNode;
                // While there is a violation of the RedBlackTree properties..
                while (z.parent.color == RED) {

                        // If z's parent is the the left child of it's parent.
                        if (z.parent == z.parent.parent.left) {

                                // Initialize y to z 's cousin
                                y = z.parent.parent.right;

                                // Case 1: if y is red...re color
                                if (y.color == RED)
                                {
                                        z.parent.color = BLACK;
                                        y.color = BLACK;
                                        z.parent.parent.color = RED;
                                        z = z.parent.parent;
                                }
                                // Case 2: if y is black & z is a right child
                                else if (z == z.parent.right)
                                {

                                        // leftRotaet around z's parent
                                        z = z.parent;
                                        leftRotate(z);
                                }

                                // Case 3: else y is black & z is a left child
                                else 
                                {
                                        // recolor and rotate round z's grandpa
                                        z.parent.color = BLACK;
                                        z.parent.parent.color = RED;
                                        rightRotate(z.parent.parent);
                                }
                        }

                        // If z's parent is the right child of it's parent.
                        else {

                                // Initialize y to z's cousin
                                y = z.parent.parent.left;

                                // Case 1: if y is red...recolor
                                if (y.color == RED) {
                                        z.parent.color = BLACK;
                                        y.color = BLACK;
                                        z.parent.parent.color = RED;
                                        z = z.parent.parent;
                                }

                                // Case 2: if y is black and z is a left child
                                else if (z == z.parent.left) {
                                        // rightRotate around z's parent
                                        z = z.parent;
                                        rightRotate(z);
                                }
                                // Case 3: if y is black and z is a right child
                                else
                                {
                                        // recolor and rotate around z's grandpa
                                        z.parent.color = BLACK;
                                        z.parent.parent.color =RED;
                                        leftRotate(z.parent.parent);
                                }
                        }
                }
                // Color root black at all times
                root.color = BLACK;

        }// end insertFixup(RedBlackNode z)
        // @param: x, The node which the lefRotate is to be performed on.
        // Performs a leftRotate around x.
        private void leftRotate(Node<E> x) 
        {
                // Perform the left rotate as described in the algorithm
                // in the course text.
                Node<E> y;
                y = x.right;
                x.right = y.left;

                // Check for existence of y.left and make pointer changes
                if (!isEmpty(y.left))
                        y.left.parent = x;
                y.parent = x.parent;

                // x's parent is a null node
                if (isEmpty(x.parent))
                        root = y;

                // x is the left child of it's parent
                else if (x.parent.left == x)
                        x.parent.left = y;

                // x is the right child of it's parent.
                else
                        x.parent.right = y;

                // Finish of the leftRotate
                y.left = x;
                x.parent = y;
        }// end leftRotate(RedBlackNode x)


        // @param: x, The node which the rightRotate is to be performed on.
        private void rightRotate(Node<E> y) 
        {
                // Perform the rotate as described in the course text.
                Node<E> x = y.left;
                y.left = x.right;

                // Check for existence of x.right
                if (!isEmpty(x.right))
                        x.right.parent = y;
                x.parent = y.parent;

                // y.parent is nil
                if (isEmpty(y.parent))
                        root = x;

                // y is a right child of it's parent.
                else if (y.parent.right == y)
                        y.parent.right = x;

                // y is a left child of it's parent.
                else
                        y.parent.left = x;
                x.right = y;

                y.parent = x;

        }// end rightRotate(Node y)

        // @param: key, the key whose node we want to search for
        // @return: returns true if found. if not found, returns false
        public boolean contains(E key)
        {

                // Initialize a pointer to the root to traverse the tree
                Node<E> current = root;

                // While we haven't reached the end of the tree
                while (!isEmpty(current))
                {

                        // If we have found a node with a key equal to key
                        if (current.element.equals(key))

                                // return that node and exit search(int)
                                return true;

                        // go left or right based on value of current and key
                        else if (current.element.compareTo(key) < 0)
                                current = current.right;

                        // go left or right based on value of current and key
                        else
                                current = current.left;
                }

                // we have not found a node whose key is "key"
                return false;

        }

        // @param: node, the RedBlackNode we must check to see whether it's nulll
        // @return: return's true of node is nulll and false otherwise
        private boolean isEmpty(Node<?> node) 
        {	  // return appropriate value
                return node == NullNode;

        }// end is nil(RedBlackNode node)
        public String toString() 
        {
                return toString(root);
        }
        /* Function for pre-order traversal */
        public String toString(Node r) 
        {
                StringBuilder res = new StringBuilder();
                if (r != NullNode) 
                {
                        
                        if (r.color == RED)
                                res.append(" *" + r.element);
                        else
                                res.append(" " + r.element);

                       res.append(toString(r.left));
                       res.append(toString(r.right));
                }
                return res.toString();
        }

   

}// end class RedBlackTree