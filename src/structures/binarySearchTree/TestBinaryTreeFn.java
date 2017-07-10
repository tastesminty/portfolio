package structures.binarySearchTree;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import static org.junit.Assert.*;

public class TestBinaryTreeFn extends TestCase {
	//set up a tree

    private MyBSTstore<String> ts;
    private MyBSTstore emptyTree;
     
    @Before
    protected void setUp() throws Exception   { 
        super.setUp();
         
        emptyTree=new MyBSTstore();
         
        ts=new MyBSTstore<String>();
        ts.add("i");
        ts.add("d");
        ts.add("l");
        ts.add("a");
        ts.add("f");
        ts.add("h");
        ts.add("l");
        ts.add("k");
        ts.add("m");
        ts.add("p");   
    }
     
    @Test
    public void testValuesInAscOrder(){
        String[] expInOrder={"a","d","f","h","i","k","l","l","m","p"};
        List<String> getInOrder=ts.getValuesInAscOrder();
        assertArrayEquals(expInOrder,getInOrder.toArray());
    }
     
 
    @Test
    public void testValuesInDesOrder(){
        String[] expInRevOrder={"p","m","l","l","k","i","h","f","d","a"};
        List<String> getInOrder=ts.getValuesInDesOrder();
        assertArrayEquals(expInRevOrder,getInOrder.toArray());
          
    }
     

   /* @Test
    public void testValuesBreadthFirst(){
        String[] expInRevOrder={"i","d","l","a","f","k","m","h","p"};
        List<String> getInOrder=bt.getValuesBreadthFirst();
        assertArrayEquals(expInRevOrder,getInOrder.toArray());
          
    }
     
    @Test
    public void testValuesInAscOrderEmptyTree(){
   
        List<String> getInOrder=emptyTree.getValuesInAscOrder();
        Object[] a=getInOrder.toArray();
        assertTrue(a==null || a.length==0);
    }*/
      
   
 
    @Test
    public void testMinValue(){ 
        assertEquals("a",ts.getMinValue());
        
        assertNull(emptyTree.getMinValue()); 
         
    }
     
    @Test
    public void testMaxValue(){ 
        assertEquals("p",ts.getMaxValue());
        
        assertNull(	emptyTree.getMaxValue());
    }
     
    @Test
    public void testHeight(){ 
        assertEquals(5,ts. getHeight());
        assertEquals(0,emptyTree. getHeight());
    }
    
     
    

}
