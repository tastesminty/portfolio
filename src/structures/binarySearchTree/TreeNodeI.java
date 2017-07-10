package structures.binarySearchTree;

/**
 * The interface for a  node for a Binary Tree
 *
 * @param <V> 
 */
public interface TreeNodeI<V> {

	public TreeNodeI<V> getLeftChild(); //lower value than this node's value

	public TreeNodeI<V> getRightChild();//same or higher value than this node's value

	public void setLeftChild(TreeNodeI<V> in); 

	public void setRightChild(TreeNodeI<V> in);

	public boolean isLeaf(); //no children

	public V getValue(); //value associated with node

	public void setValue(V newData);

	public TreeNodeI<V> getParent(); //link to parent node

	public void setParent(TreeNodeI<V> newp);
 
}