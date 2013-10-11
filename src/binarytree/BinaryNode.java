package binarytree;


public class BinaryNode {
	public BinaryNode leftNode;
	public BinaryNode rightNode;
	
	private String key;
	public String value;
	
	/**
	 * Returns a Binary node with the given key and value.
	 *
	 * @param  key_  The key to reference the node in the binary tree
	 * @param  value_ The value sotred in the node that is referenced with they key.
	 * @return BinaryNode
	 * @see         BinaryNode
	 */
	public BinaryNode(String key_, String value_){
		key = key_;
		value = value_;
	}
	
	public void setKey(String BinaryKey){
		key = BinaryKey;		
	}
	
	public void setValue(String BinaryValue){
		value = BinaryValue;
		
	}
	
	public String getKey(){
		return key;
	}
	
	public String getValue(){
		return value;
	}
	
	/**
	 * Returns a boolean indicated whether the children of the node are null or not.
	 * If both left node and right node are null it will return true and false otherwise.
	 *
	 * @return boolean indicated whether the node has children
	 * @see         BinaryNode
	 */
	public boolean hasBranches(){
		if(null == leftNode && null == rightNode)
			return false;
		else
			return true;
	}
	
	/**
	 * Returns a boolean indicated whether the next child node according to key_ is null or not. This is useful when the BinaryNodeTree class is looking
	 * for a place to store a key.
	 *
	 * @return boolean indicated whether the next node that corresponds to the key_ has children or not.
	 * @param key_ The key that will indicate whether the next node to compare is the left or right node. To do this, the function will compare the key of the node to key_
	 * @see         BinaryNode
	 */
	public boolean nextNodeIsNull(String key_){
		int difference = key.compareTo(key_);
		
		if(difference > 0){
			if(null == rightNode)
				return true;
			else
				return false;
		}else if(difference < 0){
			if(null == leftNode)
				return true;
			else
				return false;
		}else{
			return true;
		}
	}
	
	/**
	 * Sets the value of the next node in the binary tree with a string and a value. 
	 *
	 * @param key_ The key that will indicate whether the node to set is the left or right node. To do this, the function will compare the key of the node to key_
	 * @param value_ The value that will be used to set the value of the next node
	 * @see         BinaryNode
	 */
	public void setNextNode(String key_, String value_){
		int difference = key.compareTo(key_);
		
		if(difference > 0){
			rightNode = new BinaryNode(key_, value_);
		}else if(difference < 0){
			leftNode = new BinaryNode(key_, value_);
		}else{
			key = key_;
			value = value_;
		}
	}
	
	/**
	 * This function will print the child nodes of the node.
	 *
	 * @param level The level in which the node has been placed in the binary tree. This may be useful when using the printing function, for formatting.
	 * @see         BinaryNode
	 */
	public void printChild(int level){
		if(null != rightNode){
			System.out.println((level+1)+". : "+rightNode.value);
			rightNode.printChild(level+1);
		}
		if(null != leftNode){
			System.out.println((level+1)+". : "+leftNode.value);
			leftNode.printChild(level+1);
		}
	}
	
	/**
	 * Returns the next node in he binary tree according to a provided key.
	 * The provided key will be compared to the node to determine whether the left or the right node should be returned.
	 *
	 * @param key_ The key that will indicate which child node to return
	 * @see         BinaryNode
	 */	
	public BinaryNode nextNode(String key_){
		int difference = key.compareTo(key_);
		
		if(difference > 0){
			return rightNode;
		}else if(difference < 0){
			return leftNode;
		}else{
			return this;
		}
	}

}
