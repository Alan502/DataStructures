package binarytree;

import java.security.SecureRandom;
import java.math.BigInteger;

public class Main {

	/**
	 * @param args
	 */
	static SecureRandom random = new SecureRandom();
	
	public static void main(String[] args) {
		
		String lastKey = "";
		
		BinaryTree BNTree = new BinaryTree();
		long n = 0;
		
		System.out.println("Size of BST:		Total Time:");
		
		for(int j = 0; j < 100; j++){
		
			for(long i = 0; i < 100000 ; i++ ){
				if(i == 5432)
					BNTree.insert("DefinedKey", randomString());
				else
					BNTree.insert(randomString(), randomString());
			}
			
			
			long startTime = System.nanoTime();
			
			BNTree.get("DefinedKey");
			
			long totalTime = System.nanoTime() - startTime;
			
			n += 100000;
			
			System.out.println(n+"		"+totalTime);
			
		}
		
	}
	
	static String randomString()
	  {
	    return new BigInteger(130, random).toString(32);
	  }

}
