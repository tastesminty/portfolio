package structures.binarySearchTree;

import java.util.List;

import structures.CollectionI;

public interface BinarySearchTreeStoreI<E extends Comparable<E>> extends CollectionI<E> {
	
	
	
	/**
	 * Helper method for testing
	 * @return
	 */
	public TreeNodeI<E> getRoot();
	 
	
	/**
	 * In order (left, node, right)
	 * @return all values in the node, in ascending order, or empty list if none
	 */
	public List<E> getValuesInAscOrder();
	/**
	 * Rev order (right, node, left)
	 * @return all values in the node, in descending order, or empty list if none
	 */
	public List<E> getValuesInDesOrder();

	 
	
	/**
	 * 
	 * @return maximum value in tree, or null is none
	 */
	public E getMaxValue();

	/**
	 * 
	 * @return minimum value in tree, or null is none
	 */
	public E getMinValue();
	

	/**
	 * 
	 * @return maximum height of tree, or 0 if no nodes
	 */
	public int getHeight();
	
	 
	
	public boolean remove(E val);
}
