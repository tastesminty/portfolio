package exercises;
import java.util.HashSet;
import java.util.Stack;

public class FirstNonRepeat {
	public static void main(String[] args) {
		String s = "ngrhhqbhnsipkcoqjyviikvxbxyphsnjpdxkhtadltsuxbfbrkof";
		System.out.println(firstNotRepeatingCharacter(s));
	}
	
	/**
	 * Find first character that's not repeated, in only one pass o(n).
	 * @param s search string
	 * @return character, or '_' if none are repeated
	 */
	static char firstNotRepeatingCharacter(String s) {
		//mark characters found
		HashSet<Character> found1=new HashSet<Character> (); //chars found once
		HashSet<Character> found2=new HashSet<Character> (); //repeated chars
		 

		Stack<Character> singleChar=new Stack<Character>();
		
		//reverse order, so that the first non-repeating char is found last
		for(int i=s.length()-1;i>=0;i--){
				char c=s.charAt(i);
		        if(found2.contains(c)) continue; //already marked as a repeated char
		        else if(found1.contains(c)) {
		        	found2.add(c); //found a repeated char
		        	singleChar.remove(Character.valueOf(c));  //can't be target 
		        } else { //first instance of c
		        	found1.add(c);
		        	singleChar.push(Character.valueOf(c)); //save as a possible target
		        	
		        }
				
		 } 
		if(singleChar.isEmpty()) return ('_'); //no non-repeated chars
		else return singleChar.pop(); //return last found target (first in string)
	}
}
