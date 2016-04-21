import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Triangle {
	public static void main(String[] args) throws IOException  {
	    
		String InputFile = new File("").getAbsolutePath()+"/triangle.txt";
		
		//assume input file is error free
		//(i.e. no strings or characters, right amount of integers per line, etc.)
		FileReader fileReader = new FileReader (InputFile);
		BufferedReader txtReader = new BufferedReader(fileReader);
		
		ArrayList<int[]> triangle = buildTriangle(txtReader);
		
		txtReader.close();
		fileReader.close();
		
		addGreaterOfLowerPair(triangle);

		System.out.println("Greatest Sum = "+ triangle.get(0)[0]);
	}
	
	static ArrayList<int[]> buildTriangle(BufferedReader txtReader)
	throws IOException{
		
		ArrayList<int[]> triangle = new ArrayList<int[]>();
		
		for(String line; (line = txtReader.readLine()) != null;) {
			
			String[] stringRow = line.split(" ");
			int[] row = new int[stringRow.length];

			for (int i = 0; i < row.length; i++)
				row[i] =  Integer.parseInt(stringRow[i]);
			
			triangle.add(row);
		}
		return triangle;
	}
	
	
	static void addGreaterOfLowerPair(ArrayList<int[]> triangle){
		
		for(int row = triangle.size()-2 ; row >= 0 ; row--) {

			int[] currentRow = triangle.get(row);
			int[] lowerRow = triangle.get(row+1);
			
			for (int i = 0; i < currentRow.length; i++){
				int left = lowerRow[i];
				int right = lowerRow[i+1];
				currentRow[i] += left > right ? left:right;
			} 
		}
	}
}
