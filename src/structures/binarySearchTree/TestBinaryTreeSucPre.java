package structures.binarySearchTree;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import static org.junit.Assert.*;

public class TestBinaryTreeSucPre extends TestCase {
	//set up a tree 
   
    private MyBSTstore<String> bt;
    private MyBSTstore emptyTree;
     
    @Before
    protected void setUp() throws Exception   { 
        super.setUp();
         
        emptyTree=new MyBSTstore();
         
         
        bt=new MyBSTstore<String>();
        
        bt.add("i");
        bt.add("d");
        bt.add("l");
        bt.add("a");
        bt.add("f");
        bt.add("h");
        bt.add("l");
        bt.add("k");
        bt.add("m");
        bt.add("p");  
    }
     
    @Test
    public void testSuccessorIsChild(){
		assertEquals("f",bt.getSuccessor("d"));
		String got=bt.getSuccessor("l");
		assertTrue(got.equals("m") || got.equals("l")); 
		assertEquals("p",bt.getSuccessor("m"));
    }
    
    @Test
    public void testSuccessorIsNull(){
		assertNull(bt.getSuccessor("p")); 
    }
  
    
    @Test
    public void testSuccessorIsMinChild(){
		assertEquals("k",bt.getSuccessor("i"));
    }
    
    @Test
    public void testSuccessorIsParent(){
		assertEquals("d",bt.getSuccessor("a"));
	 	assertEquals("l",bt.getSuccessor("k"));
	
    }
    
    @Test
    public void testSuccessorIsIndirectParent(){
		assertEquals("i",bt.getSuccessor("h"));
	
    }
    

    @Test
    public void testPrecedessorIsChild(){
		assertEquals("a",bt.getPredecessor("d"));
		String got=bt.getPredecessor("l");
		assertTrue(got.equals("k") || got.equals("l")); 
		
    }
    
    @Test
    public void testPrecedessoIsMaxChild(){
		assertEquals("h",bt.getPredecessor("i"));
    }
    
    @Test
    public void testPrecedessorIsParent(){
    	 	
    	assertEquals("l",bt.getPredecessor("m"));
		
		assertEquals("d",bt.getPredecessor("f"));
		assertEquals("f",bt.getPredecessor("h"));
		assertEquals("m",bt.getPredecessor("p"));
	
    }
    
    @Test
    public void testPrecedessorIsIndirectParent(){
		assertEquals("i",bt.getPredecessor("k"));
	
    }
    
    
    @Test
    public void testPrecedessorIsNull(){
		assertNull(bt.getPredecessor("a")); 
    }
}
 