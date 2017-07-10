package structures.binarySearchTree;


/**
 * A node for a Binary Tree
 *
 * @param <V> 
 */
public class MyTreeNode<V extends Comparable<V>>  implements TreeNodeI<V>{
	private V _value=null; //data associated with this node
	private TreeNodeI<V> _left,_right; //children
	private TreeNodeI<V> _parent; 
	
	public TreeNodeI<V> getParent() {
		return _parent;
	}

	public void setParent(TreeNodeI<V> newParent) {
		 _parent=newParent;
	}

	/**
	 * Create a node without data or children
	 */
	public MyTreeNode () {
		super();
	}

	/**
	 * Create a node and set its data
	 * @param newValue data to set
	 */
	public MyTreeNode (V newValue) {
		this();
		setValue(newValue);
	}

	/**
	 * Create a node and set its data, left and right child
	 * @param newData data to set
	 * @param myLeft left child, can be null
	 * @param myRight right child, can be null
	 */
	public MyTreeNode (V newData,TreeNodeI<V> myLeft,TreeNodeI<V> myRight) {
		this(newData);
		setLeftChild(myLeft);
		setRightChild(myRight);
	}

	/**
	 * Create a node and set its data, left and right child
	 * @param newData data to set
	 * @param myLeft left child, can be null
	 * @param myRight right child, can be null
	 */
	public MyTreeNode (V newData,TreeNodeI<V> myParent){
		this(newData);
		setParent(myParent);
	}

	/**
	 * @return the _left child
	 */
	public TreeNodeI<V> getLeftChild() {
		return _left;
	}
	/**
	 * @param _left new left child
	 */
	public void setLeftChild(TreeNodeI<V> _left) {
		this._left = _left;
		if(_left!=null) _left.setParent(this); //back link
	}
	/**
	 * @return the _right child
	 */
	public TreeNodeI<V> getRightChild() {
		return _right;
	}
	/**
	 * @param _right new right child
	 */
	public void setRightChild(TreeNodeI<V> _right) {
		this._right = _right;
		if(_right!=null) _right.setParent(this); //back link
	}
	/**
	 * @return the data
	 */
	public V getValue() {
		return _value;
	}
	/**
	 * @param data the data to set
	 */
	public void setValue(V data) {
		this._value = data;
	}
	 
	/**
	 * Just this nodes' value
	 * @return value, or "()" if not set
	 */
	public String toString(){
		return this._value!=null?this._value+"":"()";
		
	}
	


	@Override
	public boolean isLeaf() {
		return _left==null && _right==null;
	}
}
