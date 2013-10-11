package binarytree;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.junit.Test;

public class BinaryTreeTest {
	
	static SecureRandom random = new SecureRandom();
	
	static String randomString()
	  {
	    return new BigInteger(130, random).toString(32);
	  }

	@Test
	public void testGetValue() {
		
		// First, create a simple test to make sure the BinaryTree is able to get a value from a key
		
		BinaryTree BNTree = new BinaryTree();
		
		for(long i = 0; i < 1000 ; i++ ){
			if(i == 535)
				BNTree.insert("key-to-value", "value-returned");
			else
				BNTree.insert(randomString(), randomString());
		}
		
		assertTrue(BNTree.get("key-to-value").equals("value-returned"));
		
		// This will test that, in case a key is not found, the value returned is null

	}
	
	@Test
	public void testGetNullValue(){
		BinaryTree BNTree = new BinaryTree();
		
		for(long i = 0; i < 1000 ; i++ ){
				BNTree.insert(randomString(), randomString());
		}
		
		assertTrue(null == BNTree.get("key-to-value"));
	}
	

}
