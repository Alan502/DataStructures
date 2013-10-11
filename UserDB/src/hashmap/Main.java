package hashmap;

import java.math.BigInteger;
import java.security.SecureRandom;




public class Main {
	
	static SecureRandom random = new SecureRandom();
	
	static String randomString()
	  {
	    return new BigInteger(130, random).toString(32);
	  }

	
	public static void main(String[] args) {
		
		String lastKey = "";
		int n = 0;
		
		IntHashMap map = new IntHashMap();	
		for(int j = 0; j < 100; j++){
			
			for(long i = 0; i < 10000 ; i++ ){
				if(i == 668)
					map.put("DistinguisedKey", new Integer( (int) Math.random()*1000 ));
				else
					map.put(randomString(), new Integer( (int) Math.random()*1000 ));
			}
			
			String key = randomString();
			Integer value = (int) Math.random()*1000 ;
			
			long startTime = System.nanoTime();
			
			map.get("DistinguisedKey");
			
			long totalTime = System.nanoTime() - startTime;
			
			n += 10000;
			
			System.out.println(n+"		"+totalTime);
			
		}
		
	}
	
	

}
