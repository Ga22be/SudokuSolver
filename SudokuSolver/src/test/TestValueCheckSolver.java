package test;

public class TestValueCheckSolver {
	static int[][] table = {
			{ 1, 4, 0, 0, 7, 0, 0, 0, 0 },
			{ 0, 6, 0, 4, 0, 0, 7, 0, 1 }, 
			{ 0, 0, 2, 0, 1, 0, 5, 9, 0 },
			{ 0, 0, 3, 2, 0, 0, 0, 6, 0 }, 
			{ 7, 0, 0, 5, 0, 9, 0, 0, 3 },
			{ 0, 8, 0, 0, 0, 7, 1, 0, 0 }, 
			{ 0, 4, 5, 0, 9, 0, 6, 0, 0 },
			{ 9, 0, 1, 0, 0, 4, 0, 7, 0 }, 
			{ 0, 0, 0, 0, 2, 0, 0, 0, 4 }
	};

	public static void main(String[] args) {
		System.out.println(checkToYRow(1, 0));
		
		
	}
	
	private static boolean checkToYRow(int x, int y) {
		for (int yIndex = 0; yIndex < 9; yIndex++) {
			if (y != yIndex) {
				if (table[y][x] == table[yIndex][x]) {
					return false;
				}
			}
		}
	return true;
}

}
