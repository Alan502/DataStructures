package hashmap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * This class is an implementation of a HashMap of Integer objects in Java. It may be used as an alternative
 * to the already existing HashMap class in Java.
 *
 * @author Alan Morales
 */
public class IntHashMap{
		private Integer[] values;
		private String[] keys;
		private LinkedList<String>[] listKeys;
		private ArrayList<Integer>[] listValues;
		private int bucket;
		private int entriesNum;
		
		/**
		 * This constructor creates a new HashMap of Integers, the bucket size to start with can be determined through the bucketSize paramenter.
		 *
		 */
		public IntHashMap(int bucketSize){
			bucket = bucketSize;	
			entriesNum = 0;			
			initVars();
		}
		/**
		 * This constructor creates a new HashMap of Integers, the starting bucket size will be of 16.
		 */
		public IntHashMap(){
			bucket = 16;
			entriesNum = 0;
			initVars();
		}
		/**
		 * Adds a new entry into the HashMap. The new entry will have a key and a value that is associated with. The key is a String and the value stored is an Integer object.
		 * 
		 * @param key A string object that will be the key for the new entry in the HashMap.
		 * @param value An Integer object that will be the value store in the entry of the HashMap.
		 */
		public void put(String key, Integer value){
			
			double e = (double) entriesNum;
			double b = (double)  bucket;
			
			if( (e/b) > 0.75 ){
				expand();
			}
				
			
			int hash = key.hashCode() < 0 ? key.hashCode() * -1 : key.hashCode();
			int index = hash % bucket;
			
			
			if( null == keys[index] && null == listKeys[index]){
				keys[index] = key;
				values[index] = value;
			}else if(null != keys[index] && null == listKeys[index]){
				listKeys[index] = new LinkedList<String>();
				listValues[index] = new ArrayList<Integer>();
				
				listKeys[index].add(keys[index]);
				listValues[index].add(values[index]);
				
				keys[index] = null;
				values[index] = null;
				
				listKeys[index].add(key);
				listValues[index].add(value);
			}else if(null == keys[index] && null != listKeys[index]){
				listKeys[index].add(key);
				listValues[index].add(value);
			}
			
			entriesNum++;
			
		}
		
		/**
		 * This method can get the Integer object associated with a given key.
		 * 
		 * 
		 * @param key The key to look for in the HashMap.
		 * @return An Integer object that is the one associated with the provided key.
		 */
		public Integer get(String key){
			
			int hash = key.hashCode() < 0 ? key.hashCode() * -1 : key.hashCode();
			
			int index = hash % bucket;
			
			if(null != keys[index] && null == listKeys[index]){
				return values[index];
			}else if(null == keys[index] && null != listKeys[index]){
				
				int c = 0;
				
				for(Iterator<String> i = listKeys[index].iterator(); i.hasNext(); c++){
					if(i.next().equals(key)){
						return listValues[index].get(c);
					}
				}
				
				return null;
			}else{
				return null;
			}
			
						
		}
		
		public void expand(){
			bucket *= 2;
			Integer[] valuesHold = values;
			String[] keysHold = keys;
			LinkedList<String>[] listKeysHold = listKeys;
			ArrayList<Integer>[] listValuesHold = listValues;
			
			initVars();
			
			for(int i = 0; i<keysHold.length; i++){
								
				if(null != keysHold[i] && null == listKeysHold[i]){
					
					put(keysHold[i], valuesHold[i]);
					
				}else if(listKeysHold[i] != null && keysHold[i] == null){
						int c = 0;
						for(Iterator<String> j = listKeysHold[i].iterator(); j.hasNext(); c++){
							put(j.next(), listValuesHold[i].get(c));
						}
				}
					
				
			}
						
		}
		
		private void initVars(){
			values = new Integer[bucket];
			keys = new String[bucket];
			listKeys = new LinkedList[bucket];
			listValues = new ArrayList[bucket];
		}
		
}
