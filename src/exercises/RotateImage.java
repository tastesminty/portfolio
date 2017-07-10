package exercises;

public class RotateImage {
	public static void main(String[] args){
		int[][] a =  {{10,9,6,3,7}, 
		              {6,10,2,9,7}, 
		              {7,6,3,8,2}, 
		              {8,9,7,9,9}, 
		              {6,8,6,8,2}};
		rotate(a);
		
	}
	
	/**
	 * Rotate a square image (2D matrix) 90 degrees clockwise, in place, using o(1) additional space
	 * @param in image to rotate
	 * @return rotated image
	 */
	static int[][] rotate(int[][] in){
		int offset=-1;
		for(int squareSize=in.length;squareSize>1;squareSize-=2){ //start on the outer square, move in
			offset++; //offset adjusts for the current outer square's start position
			int r=0;//r,c are locations relative to the top-left cell of the outer square
			
			for (int c=0;c<squareSize-1;c++){ //step through each cell on one side of the  square 
				int nr,nc,pr,save,save2;
				//rotate each value to the position 90 degrees on, CW 
				
				nr=c; nc=squareSize-1-r; //next (second)  position (row, column )
				save=in[nr+offset][nc+offset];
				in[nr+offset][nc+offset]=in[r+offset][c+offset]; //
				 pr=nr;
				
				nr=nc; nc=squareSize-1-pr; //third cell position
				save2=in[nr+offset][nc+offset];
				in[nr+offset][nc+offset]=save; //
				 pr=nr;
				 
				nr=nc; nc=squareSize-1-pr; //fourth 
				save=in[nr+offset][nc+offset];
				in[nr+offset][nc+offset]=save2; //
				 pr=nr;
				 
				 //back to the start
				in[r+offset][c+offset]=save; //
				
			}
			 
		} 
		 return in;
	}
	
	/**
	 * Debug printer
	 * @param a
	 */
	static void printAr(int[][] a){
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				System.out.print (a[i][j]+" ");
			}
			System.out.println();
		}
	}
}
