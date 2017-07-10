package structures.binarySearchTree;

import structures.CollectionI;

import java.util.List;

public interface BinarySearchTreeI<E> extends CollectionI<E>{
	
	
	
	/**
	 * Helper method for testing
	 * @return
	 */
	public TreeNodeI<E> getRoot();
	
	
	
	/**
	 * @return   all of the values in the BST in ascending order
	 */
	public List<E> getValuesInAscOrder();
	/**
	 * @return what? all of the values in the BST in descending order
	 */
	public List<E> getValuesInDesOrder();

	
	/**
	 *  @return highest values
	 */
	public E getMaxValue();

	/**
	 
	 * @return lowest value in tree
	 */
	public E getMinValue();


	/** 
	 * @return number of levels in tree
	 */
	public int getHeight();
	
	//Set 3
	/**
	 * @return get the node holding the next lower value 
	 */
	public TreeNodeI<E> getPredecessor(TreeNodeI<E> examine);
	
	/** 
	 * @return  get the node holding the next higher value 
	 */
	public TreeNodeI<E> getSuccessor(TreeNodeI<E> examine);

	/** 
	 * @return remove node from tree with matching value
	 */
	public boolean remove(E val);
	 
	
}