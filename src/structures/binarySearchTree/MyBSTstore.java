package structures.binarySearchTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import structures.CollectionI;

/**
 * Binary Search Tree store implementation
 * @author Danny Navarro
 *
 * @param <V> Generic value of the elements of the tree
 */
public class MyBSTstore<V extends Comparable<V>>   implements BinarySearchTreeStoreI<V> {
	private TreeNodeI<V>   _root; 
	private int _size;
	private TreeNodeI<V> successor;
	
	/**
	 * Default constructor
	 * Root is null
	 */
	public MyBSTstore(){
		super(); 
		_root=null;
		_size=0;
	}

	/**
	 * Constructor
	 * @param newRoot Root of new tree
	 */
	public MyBSTstore(TreeNodeI<V> newRoot){
		super(); 
		_root = newRoot;
		_size = 1;
	}

	/**
	 * Get the size (number of elements) of the tree
	 * @return size
	 */
	@Override
	public int size() {
		return _size;
	}
	
	/**
	 * Clear the tree
	 */
	@Override
	public void clear() {
		_size=0;
		_root=null;
	}

	/**
	 * Get the root (first element) of the tree
	 * @return Root node
	 */
	@Override
	public TreeNodeI<V> getRoot() {
		return _root;
	}

	/**
	 * Get the root (first element) of the tree
	 * @param Root node
	 */ 
	public void setRoot(TreeNodeI<V> newRoot) {
		_root = newRoot;
		_size++;
	}

	/**
	 * Add specified value to the list
	 * Throws a null pointer exception if null is going to be added
	 * @param val Value to add
	 */
	@Override
	public void add(V val) {
		if (val==null) throw new NullPointerException();
		if (_root==null) {
			_root = new MyTreeNode();
			_size++;
			_root.setValue(val);
			return;
		}
		TreeNodeI<V> currentNode = new MyTreeNode<V>();	//Current node
		TreeNodeI<V> parent = new MyTreeNode<V>();	//Parent of cn
		
		//traverse the tree to find insertion point
		currentNode=_root;
		do {
			parent = currentNode;
			if (val.compareTo(currentNode.getValue())<0){ //examine left child
				currentNode = currentNode.getLeftChild();
			}
			else { //examine right child
				currentNode = currentNode.getRightChild();
			}
			if (currentNode==null){ //found insertion point
				
				//create note to accommodate this value
				TreeNodeI<V> toAdd = new MyTreeNode<V>();
				toAdd.setValue(val);
				_size++;
				
				//link to parent node
				if (val.compareTo(parent.getValue())<0){
					parent.setLeftChild(toAdd);
					toAdd.setParent(parent);
				}
				else {
					parent.setRightChild(toAdd);
					toAdd.setParent(parent);
				}
				return;
			}
		} while (currentNode!=null);
	}

	/**
	 * Find if the tree contains a given value (
	 * Throws a null pointer exception if trying to search for null
	 * @param val Value to search for
	 * @return true if found
	 */
	@Override
	public boolean contains(V val) {
		if (val==null) throw new NullPointerException();
		if (isEmpty()) return false;
		TreeNodeI<V> currentNode = new MyTreeNode<V>();	//Current node
		currentNode=_root;
		do {
			
			if (val.compareTo(currentNode.getValue())<0){
				//should follow left child to find it
				currentNode = currentNode.getLeftChild();
			}
			else if (val.compareTo(currentNode.getValue())>0){
				//follow right child
				currentNode = currentNode.getRightChild();
			}
			else {							//Found the value we're looking for
				if(val.equals(currentNode.getValue())) return true; 
				else return false;
			}
		} while (currentNode!=null);
		
		return false; //not found
	}

	/**
	 * Find if the tree has any elements
	 * @return true if empty
	 */
	@Override
	public boolean isEmpty() {
		return _size==0;
	}
	 

	
	/**
	 * Remove a value of the tree
	 * @param val to remove, can't be null
	 * @return true if the value was found and removed
	 */
	@Override
	public boolean remove(V val) {
		if (!contains(val)) {
			return false;
		}
		
		//Finding the node to remove: match the target value
		TreeNodeI<V> currentNode = _root;
		while (!currentNode.getValue().equals(val)){
			if (val.compareTo(currentNode.getValue())<0){
				currentNode = currentNode.getLeftChild();
			}
			else {
				currentNode = currentNode.getRightChild();
			}
		}
		
		//If node to remove has no children
		if (currentNode.isLeaf()) {
			_size--;
			if (currentNode.equals(_root)) { //special case - was root node
				_root.setValue(null);
				_root = null;
			}
			else if (currentNode.getValue().compareTo(currentNode.getParent().getValue())>=0){
				currentNode.getParent().setRightChild(null);
			}
			else {
				currentNode.getParent().setLeftChild(null);
			}
		}
		else if (currentNode.getRightChild()==null){ //has left child but not right
			_size--;
			if (currentNode.equals(_root)){
				_root = currentNode.getLeftChild();
			}
			else{
				currentNode.getLeftChild().setParent(currentNode.getParent());
				currentNode.getParent().setLeftChild(currentNode.getLeftChild());
				currentNode=null;
			}
		}
		else if (currentNode.getLeftChild()==null){ //has right but not left
			_size--;
			if (currentNode.equals(_root)){
				_root = currentNode.getRightChild();
			}
			else {
				currentNode.getRightChild().setParent(currentNode.getParent());
				currentNode.getParent().setRightChild(currentNode.getRightChild());
				currentNode=null;
			}
		}
		else { //has right and left
			//find node with next highest value
			V suc = getSuccessor(val);
			remove(suc); //remove successor node
			currentNode.setValue(suc); //replace my value with successor's 
			
			//make sure my parent's link are valid, post remove
			if (!currentNode.equals(_root)){
				if (suc.compareTo(currentNode.getParent().getValue())>=0){
					currentNode.getParent().setRightChild(currentNode);
				}
				else {
					currentNode.getParent().setLeftChild(currentNode);
				} 
			}
			else _root = currentNode;
		}
		return true;
	}
	
	/**
	 * Get the values in ascending order
	 * @return A list of values in ascending order
	 */
	@Override
	public List<V> getValuesInAscOrder() {
		if (isEmpty()) return null;
		List<V> l = new LinkedList();
		addValueToAscList(_root, l);
		return l;
	}
	
	/**
	 * Recursive method made to assist the getValuesInAscOrder() method.
	 * The getValuesInAscOrder() method is the base case for the recursion
	 * in this method. It adds the values, recursively, to a list, in ascending order.
	 * @param cn Current node of recursion
	 * @param l List of values
	 */
	public void addValueToAscList(TreeNodeI<V> cn, List<V> l){
		if (!cn.isLeaf()){
			if (cn.getLeftChild()!=null){
				addValueToAscList(cn.getLeftChild(), l);
			}
		}
		l.add(cn.getValue()); 
		if (cn.getRightChild()!=null){
			addValueToAscList(cn.getRightChild(), l);
		}
	}

	/**
	 * Get the values in descending order
	 * @return A list of values in descending order
	 */
	@Override
	public List<V> getValuesInDesOrder() {
		if (isEmpty()) return null;
		List<V> l = new LinkedList();
		addValueToDesList(_root, l);
		return l;
	}
	
	/**
	 * Recursive method made to assist the getValuesInDesOrder() method.
	 * The getValuesInDesOrder() method is the base case for the recursion
	 * in this method. It adds the values, recursively, to a list, in descending order.
	 * @param cn Current node of recursion
	 * @param l List of values
	 */
	public void addValueToDesList(TreeNodeI<V> cn, List<V> l){
		if (!cn.isLeaf()){
			if (cn.getRightChild()!=null){
				addValueToDesList(cn.getRightChild(), l);
			}
		}
		l.add(cn.getValue()); 
		if (cn.getLeftChild()!=null){
			addValueToDesList(cn.getLeftChild(), l);
		}
	}

	/**
	 * Get the largest value in the tree
	 * @return the largest value
	 */
	@Override
	public V getMaxValue() {
		if (isEmpty()) return null;
		TreeNodeI<V> cn = new MyTreeNode();
		cn=_root;
		while (cn.getRightChild()!=null){
			cn = cn.getRightChild();
		}
		return cn.getValue();
	}

	/**
	 * Get the smallest value in the tree
	 * @return the smallest value
	 */
	@Override
	public V getMinValue() {
		if (isEmpty()) return null;
		TreeNodeI<V> cn = new MyTreeNode();
		cn=_root;
		while (cn.getLeftChild()!=null){
			cn = cn.getLeftChild();
		}
		return cn.getValue();
	}

	/**
	 * Get the number of rows in the tree (height)
	 * @return height of tree
	 */
	@Override
	public int getHeight() {
		return getHeight( _root);
		
	}
	
	/**
	 * Recursive method used for finding height
	 * @param hi current height value
	 * @param cn current node in recursion
	 * @return current height in traversing through list
	 */
	public int getHeight(TreeNodeI<V> cn){
		int lHi=0,rHi=0;
		if(cn==null) return 0;
		
		if (cn.getLeftChild()!=null){ //height of left child
			lHi = getHeight( cn.getLeftChild());
		} 
		if (cn.getRightChild()!=null){//height of right child
			rHi = getHeight( cn.getRightChild());
		}
		return (lHi>rHi?lHi:rHi)+1; //return highest of each child tree +1 for this node
	}
	

	/**
	 * Get the value of the  node that's less than this one
	 * @param value of node to find
	 * @return value of the parent of the key node
	 */
	 
	public V getPredecessor(V key) {
		if (key == null) throw new NullPointerException();
		if (!contains(key)) throw new NullPointerException();
		V predecessor = null;
		
		//first find this node
		TreeNodeI<V> kNode = _root; //Node with value of k

		while (!kNode.getValue().equals(key)){
			if (key.compareTo(kNode.getValue())<0){
				kNode = kNode.getLeftChild();
			}
			else {
				kNode = kNode.getRightChild();
			}
		}

		TreeNodeI<V> currentNode = kNode;
		 
		if (kNode.getLeftChild()!=null){ //If kNode has left child
			currentNode = kNode.getLeftChild();
			//find right-most child of left child
			while (currentNode.getRightChild()!=null){ //While cn has right
				currentNode = currentNode.getRightChild();
			}
			predecessor = currentNode.getValue();
			return predecessor;
		}
		else {
			currentNode = kNode;
			//go up to the right
			while (currentNode.getValue().compareTo(currentNode.getParent().getValue())<0){  
				currentNode = currentNode.getParent();
				if (currentNode.equals(_root)){
					return null;	//No predecessor
				}
			}
			predecessor = currentNode.getParent().getValue();
			return predecessor;
		}
	}

	/**
	 * Get the value of the first child node of the given node
	 * @param value of node to find
	 * @return value of the first child of the key node
	 */ 
	public V getSuccessor(V k) {
		if (k == null) throw new NullPointerException();
		if (!contains(k)) throw new NullPointerException();
		V suc = null;
		TreeNodeI<V> myNode = _root; //Node with value of k
		
		//find the node for this value
		while (!myNode.getValue().equals(k)){
			if (k.compareTo(myNode.getValue())<0){
				myNode = myNode.getLeftChild();
			}
			else {
				myNode = myNode.getRightChild();
			}
		}
		
		TreeNodeI<V> currentNode = myNode;
		
		if (myNode.getRightChild()!=null){ //If kNode has right child
			currentNode = myNode.getRightChild();
			while (currentNode.getLeftChild()!=null){ // Look for left-most child
				currentNode = currentNode.getLeftChild();
			}
			suc = currentNode.getValue();
			successor = currentNode;
			return suc;
		}
		else { //find left-most parent
			currentNode = myNode;
			while (currentNode.getValue().compareTo(currentNode.getParent().getValue())>0){ 
				currentNode = currentNode.getParent();
				if (currentNode.equals(_root)){
					successor = null;
					return null;	//No successor
				}
			}
			//successor is the parent who's value is higher than me
			suc = currentNode.getParent().getValue();
			if (suc.compareTo(myNode.getValue())<0){
				successor = null;
				return null;
			}
			successor = currentNode.getParent();
			return suc;
		}
	} 
	
	@Override
	public String toString(){
		 
		return _root==null?null:_root.getValue().toString();
	}
 

}