package path;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FindPath {
		
		public static int[][] createMaze(String file)  
		{  
		try  
		{  
		FileInputStream fis=new FileInputStream(file);       
		Scanner sc=new Scanner(fis);
		ArrayList<String> mapSetup = new ArrayList<String>();

		while(sc.hasNextLine())  
		{  
		String line = sc.nextLine();
		mapSetup.add(line);
		}  

		sc.close(); 

		int[][] map = new int[mapSetup.size()][mapSetup.get(0).length()];
		//int[][] memoryMap = new int[mapSetup.size()][mapSetup.get(0).length()];
		for(int i = 0; i < map.length; i++) {
			System.out.println(" ");
			for(int j = 0 ;j < map[0].length; j++) {
				map[i][j] = Character.getNumericValue(mapSetup.get(i).charAt(j));
				
			}
		}
		
		return map;
		}  
		catch(IOException e)  
		{  
		e.printStackTrace();  
		}  
		return null;
		} 
		public static int findPath(int sVertical, int sHorizontal, int[][] map, int[][] memoryMap) {

			if (sVertical == map.length-1 && sHorizontal == map[0].length-1) {
				return map[sVertical][sHorizontal];
			}
			if(memoryMap[sVertical][sHorizontal] != 0) {
				return memoryMap[sVertical][sHorizontal];
			}
			int result = 0;
			if (sVertical < map.length-1) {
				result = Math.max(findPath(sVertical+1, sHorizontal, map, memoryMap), result);
			}
			if (sHorizontal < map[0].length-1) {
				result = Math.max(findPath(sVertical, sHorizontal+1, map, memoryMap), result);
			}
			memoryMap[sVertical][sHorizontal] = result + map[sVertical][sHorizontal];
			return memoryMap[sVertical][sHorizontal];
		}
		
		
		
		
}
