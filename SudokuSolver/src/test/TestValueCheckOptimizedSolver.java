package test;

import java.util.Iterator;
import java.util.LinkedList;

public class TestValueCheckOptimizedSolver {
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
	static Square[][] squares;

	public static void main(String[] args) {
		squares = new Square[9][9];
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i < 10; i++){
			list.add(i);
		}
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				squares[y][x] = new Square(table[y][x], (LinkedList<Integer>) list.clone());
			}
		}
		print();
		
		int[] index = {1,0};
		int x = 6;
		int y = 6;
		
		System.out.println(squares[y][x].solved());
		System.out.println(squares[y][x].toString());
		System.out.println(squares[y][x].list.toString());
		
		checkToBox(x, y);
		
		System.out.println(squares[y][x].solved());
		System.out.println(squares[y][x].toString());
		System.out.println(squares[y][x].list.toString());
//		
//		checkToXRow(index);
//		
//		System.out.println(squares[y][x].solved());
//		System.out.println(squares[y][x].toString());
//		System.out.println(squares[y][x].list.toString());
		
	}
	
	/**
	 * Checks current square on sudoku board towards its horizontal row
	 * eliminating all nonpossible alternatives form the squares list.
	 * 
	 * @param x 
	 * @param y
	 */
	private static void checkToXRow(int[] index) {
		if (!squares[index[1]][index[0]].solved()) {
			Iterator<Integer> itr = squares[index[1]][index[0]].list.iterator();
			while (itr.hasNext()) {
				int val = itr.next();
				for (int xIndex = 0; xIndex < 9; xIndex++) {
					int x = (int) index[0];
					if (index[0] != xIndex) {
						if (val == squares[index[1]][xIndex].value) {
							itr.remove();
						}
					}
				}
			}
		}
	}
	
	/**
	 * Checks current square on sudoku board towards its vertical row
	 * eliminating all nonpossible alternatives form the squares list.
	 * 
	 * @param i
	 * @param j
	 */
	private static void checkToYRow(int x, int y) {
		if (!squares[y][x].solved()) {
			Iterator<Integer> itr = squares[y][x].list.iterator();
			while (itr.hasNext()) {
				int val = itr.next();
				for (int index = 0; index < 9; index++) {
					if (y != index) {
						if (val == squares[index][x].value) {
							itr.remove();
						}
					}
				}
			}
		}
	}
	
	/**
	 * Checks current square on sudoku board towards its own 3x3 square
	 * eliminating all nonpossible alternatives form the squares list.
	 * 
	 * @param i
	 * @param j
	 */
	private static void checkToBox(int x, int y) {
		if (!squares[y][x].solved()) {
			Iterator<Integer> itr = squares[y][x].list.iterator();
			int xStart = ((x / 3) * 3);
			int yStart = ((y / 3) * 3);
			while (itr.hasNext()) {
				int val = itr.next();
				for (int yIndex = yStart; yIndex < yStart + 3; yIndex++) {
					for (int xIndex = xStart; xIndex < xStart + 3; xIndex++) {
						if (x == xIndex && y == yIndex) {
							// Don't want to check vs own square
						} else {
							if (val == squares[yIndex][xIndex].value) {
								itr.remove();
							}
						}
					}
				}
			}
		}
	}
	
	public static void print(){
		for(int y = 0; y < 9; y ++){
			System.out.print("[");
			for(int x = 0; x < 9; x++){
				System.out.print(squares[y][x].toString() +", ");
			}
			System.out.print("],");
			System.out.println();
		}
	}


	public static class Square {
		private int value;
		private LinkedList<Integer> list;

		public Square(int value, LinkedList<Integer> list) {
			this.value = value;
			this.list = list;
			if(value > 0){
				list.clear();
				list.add(value);
			}
		}
		
		public void fillValue() throws Exception{
			if(solved()){
				value = list.getFirst();				
			} else {
				throw new Exception("There should only be 1 item in this list if we get here!");
			}
		}

		public boolean solved() {
			if(list.size() == 1){
				value = list.getFirst();
				return true;
			}
			return false;
		}
		
		public String toString(){
			return String.valueOf(value);
		}
	}

}
