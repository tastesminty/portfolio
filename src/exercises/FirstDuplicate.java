package exercises;
import java.util.HashSet;
public class FirstDuplicate {
	
	public static void main(String[] args) {
		int[] a = {2, 3, 3, 1, 5, 2};
		System.out.println(firstDuplicate(a));
	}
	static int  firstDuplicate(int[] a) {
		boolean[] found=new boolean[a.length];
		 
		for(int i=0;i<a.length;i++){
		        if(found[a[i]-1]) return a[i];
		        else found[a[i]-1]=true;
		 }
		return -1;
	}
}
