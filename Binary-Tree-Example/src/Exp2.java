import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;









public class Exp2 {


	
	
	public static void main(String[] args) {
		
		
			BST  bstree=new BST();
			
		 	PrintStream output = null;
			
		 	ArrayList<Integer> val=new ArrayList<>();
		 	
		 	
			try {
			     
				output = new PrintStream(new FileOutputStream(args[1]));
			 } catch (FileNotFoundException e) {
			      e.printStackTrace();
			    }
	        try (BufferedReader br = Files.newBufferedReader(Paths.get(args[0]))) {

	            // read line by line
	            String line;
	            while ((line = br.readLine()) != null) {
	      
	            	String[]  parsestring=line.split(" ");
	            	
	            	if (parsestring[0].equals("CreateBST")){
	            		
	            		for (int i = val.size()-1; i >=0; i--) {
							 
							 bstree.root=bstree.deleteElement(bstree.root,val.get(i));
						
						}
						 
						 for (int i = val.size()-1; i >=0; i--) {
							 
							val.remove(i);
						
						}
						


	            		output.print("BST created with elements:");
	            		String[]  values=parsestring[1].split(",");
	            		int i=0;
	            		while(i<values.length){
	            			
	            			int treenodevalue=Integer.parseInt(values[i]);
	            			bstree.root=bstree.insert(bstree.root, treenodevalue);
	            			val.add(treenodevalue);
	            			i++;
	            		}
	            		bstree.inorder(output, bstree.root);
	            		output.println();
					}else if (parsestring[0].equals("FindHeight")) {
						
						output.print("Height:"+bstree.findheight( bstree.root)+"\n");
						
					}else if (parsestring[0].equals("FindWidth")) {
						
						output.print("Width:"+bstree.findWidth( bstree.root)+"\n");
						
					}else if (parsestring[0].equals("Preorder")) {
						
						output.print("Preorder:");
						bstree.Preorder(output, bstree.root);
						output.print("\n");
					}else if (parsestring[0].equals("LeavesAsc")) {
						
						output.print("LeavesAsc:");
						bstree.leaves(output, bstree.root);
						output.print("\n");
					}else if (parsestring[0].equals("DelRoot")) {
						
						removeval(bstree.root.value, val);
						output.print("DelRoot:"+bstree.root.value);
						bstree.root=bstree.deleteElement(bstree.root,bstree.root.value);
						output.print("\n");
						
					}else if (parsestring[0].equals("DelRootLc")) {
						
						
						if (bstree.root.left!=null  ) {
							removeval(bstree.root.left.value, val);
							output.print("Left Child of Root Deleted:"+bstree.root.left.value);
							bstree.root=bstree.deleteElement(bstree.root,bstree.root.left.value);
							output.print("\n");
						}else {
							output.print("error\n");
						}
						
					}else if (parsestring[0].equals("DelRootRc")) {
						
						
						if ( bstree.root!=null ) {
							removeval(bstree.root.right.value, val);
							output.print("Right Child of Root Deleted:"+bstree.root.right.value);
							bstree.root=bstree.deleteElement(bstree.root,bstree.root.right.value);
							output.print("\n");
							
						}else {
							output.print("error\n");
						}
						
					}else if (parsestring[0].equals("CreateBSTH")) {
						
						
						 for (int i = val.size()-1; i >=1; i--) {
							 
							 bstree.root=bstree.deleteElement(bstree.root,val.get(i));
						}
						 
						for (int i = val.size()-1; i >=0; i--) {
							 
							val.remove(i);
						
						}

						try {
							
							int filedata=Integer.parseInt(parsestring[1])+1;
							if (filedata<1) {
								output.print("error\n");
								
							}else{
								output.print("A full BST created with elements:");
								
								int maxelemt=(int) Math.pow(2, filedata);
								
								
								for (int i = 1; i <maxelemt; i++) {
									output.print(i+" ");
									
									val.add(i);
								}
								output.print("\n");
								bstree.root=bstree.sortedArrayToBST(bstree, val, 0, val.size()-1);
							}
							
						} catch (Exception e) {
							
						}
						
						
						
						
					}
	            	
	            	
	            }

	        } catch (IOException e) {
	            System.err.format("IOException: %s%n", e);
	        }
	        
	        output.close();
		
		
		
		

	}

	

	private static void removeval (int del,ArrayList<Integer> val) {
		
		for (int i = 0; i < val.size(); i++) {
			
			if (val.get(i)==del) {
				val.remove(i);
				break;	
			}
			
			
			
		}
		
	}
	
	
}
