import java.io.PrintStream;
import java.util.ArrayList;











public class BST {
	
	
	
	
	public Node root;
	
	BST(){
		root=null;
	}
	
	
	
	class Node { 
         int value; 
         Node left; 
       
        Node  right;
  
        private Node(int value) { 
            this.value = value; 
            this.left  = null; 
            this.right = null; 
        } 
    }
	
	
	
	////insert node to binary search tree
	public Node insert(Node root,int value){
		
		if (root==null) {
			root=new Node(value);
			
			return root;	
		}
		if (value < root.value) {
            root.left = insert(root.left, value); 
		}
        else if (value > root.value){
            root.right = insert(root.right, value); 
        }
        return root; 
	}
	///print to txt  file inorder trevaersal
	public void inorder(PrintStream  output,Node root){
		
		    if (root == null) {
		        return; 
		    }
		   
		    inorder(output,root.left); 
		    
		    output.print(root.value+" ");
		    inorder(output,root.right); 
		
		
	}
	
	////find height of binary search tree
	public int findheight(Node root) {
		
		
		        if (root == null) 
		            return 0; 
		        else
		        { 
		         
		            int leftHeight = findheight(root.left); 
		            int rightHeight = findheight(root.right); 
		               
		      
		            return (leftHeight > rightHeight) ? (leftHeight + 1) : (rightHeight + 1); 
		        } 
		    
	}
////find Width of binary search tree
	public  int findWidth( Node root)  
	    { 
	        int maxWidth = 0; 
	        int width; 
	        int h = findheight(root); 
	        int i; 
	        for (i = 1; i <= h; i++){ 
	            width = getWidth(root, i); 
	            if (width > maxWidth) 
	                maxWidth = width; 
	        } 
	   
	        return maxWidth; 
	    } 
	
	 private int getWidth(Node node, int level) { 
	        if (node == null) 
	            return 0; 
	   
	        if (level == 1) 
	            return 1; 
	        else if (level > 1) 
	            return getWidth(node.left, level - 1) + getWidth(node.right, level - 1); 
	        return 0; 
	    }
	 
	 ////print binary search as preorder
	 public void Preorder(PrintStream  output,Node root){
		  	if (root == null) {
		  		
	
		  		return; 
		  	}
	
		  	output.print(root.value + " "); 
		  
		     Preorder(output,root.left); 
		  
		     Preorder(output,root.right); 
		    
	 }
	 ///print leaves of tree
	public void leaves(PrintStream output, Node root) {
		
		    if (root==null) {
		    	 return; 
		    }
		  
		    if (root.left==null && root.right==null)  { 
		    	output.print(root.value+" "); 
		        return; 
		    } 
		  
		    if (root.left!=null) {
		    	leaves(output,root.left);   
		    }
		    if (root.right!=null) {
		    	leaves(output,root.right); 
		    }
		}
	
	///Delete Root from binary search tree
	public Node deleteElement(Node root,int value) {
		
		       
		        if (root == null) {
		        	return root; 
		        } 
		  
		        if (value < root.value) {
		            root.left = deleteElement(root.left, value); 
		            }
		        else if (value > root.value) {
		            root.right = deleteElement(root.right, value);
		        }else{ 
		           
		            if (root.left == null){
		                return root.right; 
		               }
		            else if (root.right == null){
		                return root.left; 
		            }
		            
		            root.value = minValue(root.right); 
		  
		           
		            root.right = deleteElement(root.right, root.value); 
		        } 
		        return root; 
	} 
	private int minValue(Node root) 
    { 
        int minv = root.value; 
        while (root.left != null) 
        { 
            minv = root.left.value; 
            root = root.left; 
        } 
        return minv; 
    }
	
	///Delete All Tree Nodes 
	public void deleteTree(Node t) {
		 if( t == null ) 
		        return;
		    if( t.left != null )
		    	deleteTree(t.left);
		    if( t.right != null )
		    	deleteTree( t.right);
		     
		    t.left=null;
		    t.right=null;
		   
		     
		    return;
		
	}
	
	public  Node sortedArrayToBST(BST  bst,ArrayList<Integer> arr, int start, int end) { 
		  
		  /* Base Case */
        if (start > end) { 
            return null; 
        } 
  
        /* Get the middle element and make it root */
        int mid = (start + end) / 2; 
        Node node = new Node(arr.get(mid)); 
  
        /* Recursively construct the left subtree and make it 
         left child of root */
        node.left = sortedArrayToBST(bst,arr, start, mid - 1); 
  
        /* Recursively construct the right subtree and make it 
         right child of root */
        node.right = sortedArrayToBST(bst,arr, mid + 1, end); 
          
        return node; 
          
       
    } 
	



}
