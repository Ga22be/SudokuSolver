package test;

public class TestIndexGenerator {
	static int[][] table = { 
			{ 9, 0, 6, 8, 1, 3, 5, 4, 0 },
			{ 2, 0, 1, 0, 4, 5, 0, 6, 3 }, 
			{ 0, 4, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 6, 2, 0, 0, 0, 9 }, 
			{ 0, 0, 9, 0, 0, 0, 2, 0, 0 },
			{ 7, 0, 0, 0, 3, 4, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 9, 0 },
			{ 5, 9, 0, 3, 6, 0, 1, 0, 4 }, 
			{ 0, 2, 7, 4, 5, 9, 3, 0, 6 }};

	
	public static void main(String[] args){
		int[] index = {0,0};
		
		
		for(int i = 0; i < 81; i++){
			System.out.println("x: " + index[0] + " y: " + index[1]);
			System.out.println(table[index[1]][index[0]]);
			nextIndex(index);
		}
		
	}
	
	private static void nextIndex(int[] index) {
		index[0] += 1;
		if (index[0] == 9) {
			index[0] = 0;
			index[1] += 1;
			if (index[1] == 9) {
				index[1] = 0;
			}
		}
	}

}
