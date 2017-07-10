package structures.binarySearchTree;

public class MyBinaryNode  {
	private int _data=Integer.MIN_VALUE; //data associated with this node
	private MyBinaryNode _left,_right; //children
	
	/**
	 * Create a node without data or children
	 */
	public MyBinaryNode () {
		super();
	}

	/**
	 * Create a node and set its data
	 * @param newData data to set
	 */
	public MyBinaryNode (int newData) {
		this();
		_data=newData;
	}

		
	/**
	 * @return the _left child
	 */
	public MyBinaryNode getLeft() {
		return _left;
	}
	/**
	 * @param _left new left child
	 */
	public void setLeft(MyBinaryNode _left) {
		this._left = _left;
	}
	/**
	 * @return the _right child
	 */
	public MyBinaryNode getRight() {
		return _right;
	}
	/**
	 * @param _right new right child
	 */
	public void setRight(MyBinaryNode _right) {
		this._right = _right;
	}
	/**
	 * @return the data
	 */
	public int getData() {
		return _data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(int data) {
		this._data = data;
	}
	
	/**
	 * 
	 * @return true if data has been set
	 */
	public boolean hasData(){
		return _data==Integer.MIN_VALUE;
	}

	/**
	 * Just this nodes' value
	 * @return value, or "()" if not set
	 */
	public String toString(){
		return this._data!=Integer.MIN_VALUE?this._data+"":"()";
		
	}
	
	
	/**
	 * Convert child nodes to a multiline string
	 * @param lastNodeOnLevel true if there are no nodes to the right of this node
	 * @return subtree text
	 */
	protected String getSubnodesAsString(boolean lastNodeOnLevel){
		String  thisLine="",nextLine="";//default to empty
		
		
		//add next level nodes, as well as their children
		if(getLeft()!=null) {
			
			String leftVal=getLeft().getData()+"";
			String leftSubnodes=getLeft().getSubnodesAsString(lastNodeOnLevel && getRight()==null);//get child text
			thisLine=center(leftVal, leftSubnodes);//center me on child text 
			leftSubnodes=center(leftSubnodes,leftVal); //center child text on me
			if(!Character.isWhitespace(thisLine.charAt(thisLine.length()-1))) thisLine+=" "; //ensure we have a space before next text
			nextLine=leftSubnodes;//set next line to child text
		}
		if(getRight()!=null) {
			String rightVal=getRight().getData()+"";
			String rightSubnodes=getRight().getSubnodesAsString(lastNodeOnLevel); 
			thisLine+=center(rightVal, rightSubnodes);//center on children
			rightSubnodes=center(rightSubnodes,rightVal);//center child text on me
			
			if(lastNodeOnLevel) thisLine+="\n";//requires a new line?
			else if(!Character.isWhitespace(thisLine.charAt(thisLine.length()-1))) thisLine+=" "; //ensure ends in a space
			

			nextLine+=rightSubnodes;//add children to next line
			
		}
 
		
		return   thisLine+nextLine;//return this and next line
	}
	
	/**
	 * Calculate length of first line in a multiline string
	 * @param multiLine cannot be null
	 * @return Length of the first line in multiLine (up to first '\n' ), or its length if it has no '\n'
	 */
	protected static int nextLineLen(String multiLine){
		int loc=multiLine.indexOf('\n');
		if(loc>-1) return loc; else return multiLine.length();
	}
	/**
	 * center topSection string on top of childSection
	 * @param topText first line, not  ending in \n . Must be longer than childText, otherwise returned unmodified
	 * @param childText next line, not  ending in \n 
	 * @return topText, with spaces to center it (extra space at end not start, if required)
	 */
	public static String center(String topText,String childText){
		if(topText==null || childText==null  ) return topText;  //don't change
		
		int topLen=nextLineLen(topText);
		int childLen=nextLineLen(childText);
		if(topLen==0 || childLen==0 ||childLen<= topLen) return topText;  //don't change
		int lenDif=childLen-topLen;
		int startSpaces= lenDif /2; //rounds down odd nums
		String spaces="";
		for(int i=0;i<startSpaces;i++) spaces+=" "; 
		
		return  spaces+topText.substring(0,topLen)+spaces+(lenDif%2==0?"":" ")+topText.substring(topLen); //add an additional space at end reqd (odd difference)
		
	}
}
