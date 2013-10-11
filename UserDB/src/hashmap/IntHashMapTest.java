package hashmap;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.junit.Test;

public class IntHashMapTest {

	static SecureRandom random = new SecureRandom();
	
	static String randomString()
	  {
	    return new BigInteger(130, random).toString(32);
	  }
	
	@Test
	public void testGetValue() {
		IntHashMap map = new IntHashMap();
		
		for(long i = 0; i < 1000 ; i++ ){
			if(i == 785)
				map.put("key-to-value", new Integer(35));
			else
				map.put(randomString(), new Integer( (int) Math.random()*1000 ));
		}
		
		assertTrue(map.get("key-to-value").compareTo(new Integer(35)) == 0);
		
	}
	
	@Test
	public void testNullVaule(){
		IntHashMap map2 = new IntHashMap();
		
		for(long i = 0; i < 1000 ; i++ ){
				map2.put(randomString(), new Integer( (int) Math.random()*1000 ));
		}
		
		assertTrue(null ==  map2.get("key-to-value") );
		
	}

}
