package binarytree;


/**
 * This class is an implementation of a binary node tree in class. The class is able to do inserts and searches.
 * Each node in the tree is a BinaryNode object that stores a key and a value.
 *
 * @author Alan Morales
 * @see BinaryNode
 */

public class BinaryTree {
	
	private BinaryNode parentNode;

	/**
	 * This method will print the binary tree node. It prints the value of each node, indicating the level in which it is by a preceding number.
	 * It does it through BinaryNode's printChild method.
	 * @see BinaryNode
	 */	
	public void printBinaryTree(){
		if(null != parentNode){
			parentNode.printChild(1);
		}
	}
	
	/**
	 * This method will insert a node with the given key and value into the binary tree. The given key and value will be used to create a new node that will be placed
	 * on the binary tree. 
	 * 
	 * @param key The key that will be used to create the new BinaryNode
	 * @param value The value that will be associated with the given key.
	 * @see BinaryNode
	 */	
	public void insert(String key, String value){
		if(null == parentNode){
			parentNode = new BinaryNode(key, value);
			return;
		}else{
			
			BinaryNode node = parentNode;
			while(!node.nextNodeIsNull(key)){
				node = node.nextNode(key);
			}
			node.setNextNode(key, value);
		}

		
	}
	
	/**
	 * This method will search the binary tree for the given key and return its value.
	 * 
	 * @param key The key that is associated with the binary node that is going to be searched for.
	 * @returns The value of the node associated with the key.
	 * @see BinaryNode
	 */	
	public String get(String key){
		BinaryNode node = parentNode;
		
		while(null != node){
			if(node.getKey().equals(key))
				return node.getValue();
			node = node.nextNode(key);
			
		};
		
		return null;
		
	}
	
	

}
