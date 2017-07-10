package exercises;
import java.util.HashSet;
public class FirstDuplicate {
	
	public static void main(String[] args) {
		int[] a = {2, 3, 3, 1, 5, 2};
		System.out.println(firstDuplicate(a));  
	}
	
	/**
	 * Find the  number that's duplicated first in an array, in o(n) time
	 * 
	 * @param a array to check: each value is less than length of array
	 * @return duplicated number, or -1 if no duplicates
	 */
	static int  firstDuplicate(int[] a) {
		boolean[] found=new boolean[a.length]; //track what number's we've seen
		 
		for(int i=0;i<a.length;i++){
		        if(found[a[i]-1]) return a[i]; //found a duplicate
		        else found[a[i]-1]=true; //record number that's found
		 }
		return -1;
	}
}
