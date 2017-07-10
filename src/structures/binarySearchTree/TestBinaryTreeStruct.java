package structures.binarySearchTree;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class TestBinaryTreeStruct extends TestCase {
	private MyBSTstore<String> ts;
	
	@Before
	protected void setUp() throws Exception   { 
		super.setUp();
		ts=new MyBSTstore<String>();
	}
	
	@Test
	public void testInsertRoot(){
		
		ts.add("I");
		assertEquals(ts.getRoot().getValue(),"I");
		assertTrue(ts.contains("I"));

	}
	
	@Test
	public void testInsertLeftChild(){
		
		ts.add("I");
		ts.add("D");
		assertEquals(ts.getRoot().getLeftChild().getValue(),"D");
		assertTrue(ts.contains("D"));

		ts.add("A");
		assertEquals(ts.getRoot().getLeftChild().getLeftChild().getValue(),"A");
		assertTrue(ts.contains("A"));
	}
	
	@Test
	public void testInsertRightChild(){
		
		ts.add("I");
		ts.add("L");
		
		assertEquals(ts.getRoot().getRightChild().getValue(),"L");
		assertTrue(ts.contains("L"));

		ts.add("M");
		assertEquals(ts.getRoot().getRightChild().getRightChild().getValue(),"M");
		assertTrue(ts.contains("M"));
		
	}
	
	@Test
	public void testInsertDuplicateToRight(){
		
		ts.add("I");
		ts.add("L");
		ts.add("I"); 
		assertSame(ts.size(),3); //allows duplicate
		
		assertEquals(ts.getRoot().getValue(),"I"); //copy 1 
		assertEquals(ts.getRoot().getRightChild().getLeftChild().getValue(),"I"); //copy 2
	  
		
	}
	
	
	
	@Test
	public void testNoNullValues(){
		try{
			String toAdd=null;
		ts.add(toAdd);
		fail();
		} catch(NullPointerException e){}
	}
	
}
