package structures.binarySearchTree;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class TestBinaryTreeRemove extends TestCase {
	private MyBSTstore<String> bt;

	@Before
	protected void setUp() throws Exception   { 
		super.setUp();
		bt=new MyBSTstore<String>();
	}

	@Test
	public void testRemoveOnlyNode(){

		bt.add("I");
		assertTrue(bt.remove("I"));
		assertFalse(bt.contains("I"));
		assertNull(bt.getRoot()); 
	}

	@Test
	public void testRemoveNonExistantValue(){
		bt.add("I");
		assertFalse(bt.remove("X"));
	}


	@Test
	public void testRemoveNullValue(){
		try{
			bt.remove(null); 
			fail();
		}catch(NullPointerException e){}

	}

	@Test
	public void testRemoveLeaf(){

		bt.add("I");
		bt.add("D");



		bt.add("A");
		assertEquals("A",bt.getRoot().getLeftChild().getLeftChild().getValue());
		assertTrue(bt.contains("A"));

		assertTrue(bt.remove("A"));
		assertFalse(bt.contains("A"));
		assertNull(bt.getRoot().getLeftChild().getLeftChild()); 

		//check retained D
		assertEquals("D",bt.getRoot().getLeftChild().getValue());
		assertTrue(bt.contains("D"));

		bt.remove("D");
		assertFalse(bt.contains("D"));
		assertNull(bt.getRoot().getLeftChild()); 
	}

	@Test
	public void testRemoveNodeWithOneChild(){

		bt.add("I");
		
		bt.add("N");
		bt.add("O");
		bt.add("K");
		bt.add("P");

		assertEquals("N",bt.getRoot().getRightChild().getValue());
		assertEquals("O",bt.getRoot().getRightChild().getRightChild().getValue());
		assertEquals("K",bt.getRoot().getRightChild().getLeftChild().getValue());
		assertEquals("P",bt.getRoot().getRightChild().getRightChild().getRightChild().getValue());


		//remove L
		assertTrue(bt.remove("O"));
		assertFalse(bt.contains("O"));

		assertTrue(bt.contains("K"));
		assertTrue(bt.contains("N"));
		assertTrue(bt.contains("P"));
		assertEquals("N",bt.getRoot().getRightChild().getValue());
		assertEquals("P",bt.getRoot().getRightChild().getRightChild().getValue());
		assertEquals("K",bt.getRoot().getRightChild().getLeftChild().getValue());

	}


	@Test
	public void testRemoveRootWithOneRightChild(){

		bt.add("I");
		
		bt.add("N");
		assertEquals(2,bt.size());
		assertEquals("N",bt.getRoot().getRightChild().getValue());

		
		assertTrue(bt.remove("I"));
		assertFalse(bt.contains("I"));
		assertTrue(bt.contains("N"));
		assertEquals(1,bt.size());
 

	}
	

	@Test
	public void testRemoveRootWithOneLeftChild(){

		bt.add("I");
		
		bt.add("C");
		assertEquals(2,bt.size());
		assertEquals("C",bt.getRoot().getLeftChild().getValue());

	
		assertTrue(bt.remove("I"));
		assertFalse(bt.contains("I"));
		assertTrue(bt.contains("C"));
		assertEquals(1,bt.size());
 

	}
	
 
	@Test
	public void testRemoveNodeWithTwoChildren(){
		bt.add("I");		bt.add("D");		bt.add("L");
		bt.add("A");		bt.add("F");		bt.add("H");
		bt.add("M");		bt.add("K");		bt.add("P");
		assertTrue(bt.remove("D"));
		assertTrue(bt.contains("A"));
		assertTrue(bt.contains("F"));
		assertTrue(bt.contains("H"));
		assertEquals("F",bt.getRoot().getLeftChild().getValue());
		assertEquals("H",bt.getRoot().getLeftChild().getRightChild().getValue());
		assertEquals("A",bt.getRoot().getLeftChild().getLeftChild().getValue());}
	
	@Test
	public void testRemoveRootWithTwoChildren(){
		bt.add("I");		bt.add("D");		bt.add("L");
		bt.add("A");		bt.add("F");		bt.add("H");
		bt.add("M");		bt.add("K");		bt.add("P");
		assertTrue(bt.remove("I"));
		assertTrue(bt.contains("D"));
		assertTrue(bt.contains("K"));
		assertTrue(bt.contains("L"));
		assertEquals("D",bt.getRoot().getLeftChild().getValue());
		assertEquals("K",bt.getRoot().getValue());
		assertEquals("L",bt.getRoot().getRightChild().getValue());}
}
