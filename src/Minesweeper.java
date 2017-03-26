import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

class Point {
	Integer row, col;
	Point(int r, int c) { row = r; col = c;}
	
	@Override
	public int hashCode() {
		return Objects.hash(row, col);
	}
	@Override
	public  boolean equals(Object o){
		 Point p = (Point)o;
		return (this.row == p.row) && (this.col == p.col);
	}
}

public class Minesweeper {

	int openMaze[][];
	int[][] maze ;
	HashSet<Point> bombs;
	Minesweeper(int row, int col) {
		maze = new int[row][col];
		openMaze = new int[row][col];
	}
	public void fillBombs(HashSet<Point> bombs) {
		this.bombs = bombs;
		fillOpenMaze();
	}
	private boolean isBomb(int r, int c) {
		Point p = new Point(r,c);
		return bombs.contains(p);
	}
	private void fillOpenMaze() {
		for(int i=0;i<openMaze.length;i++) {
			for(int j=0;j<openMaze[0].length;j++) {
				if(isBomb(i,j)){
					openMaze[i][j] = -1;
				}
				else {
				openMaze[i][j] = getSurroundingBombs(i, j);
				}
			}
		}
	}
	private int getSurroundingBombs(int r, int c) {
		int numBombs = 0;
		for(int i=-1;i<2;i++) {
			if(isValidRow(r+i)) {
				for(int j=-1;j<2;j++){
					if(isValidCol(c)) {
						if(isBomb(r+i,c+j)) {
							numBombs++;
						}
					}
				}
			}
		}
		return numBombs;
	}
	private boolean isValidRow(int r) {
		return r >=0 && r< maze.length;
	}
	private boolean isValidCol(int c){
		return c>=0 && c <maze[0].length;
	}
	public void display(int[][] mat) {
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[0].length;j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Minesweeper m = new Minesweeper(7,7);
		HashSet bombs = new HashSet();
		bombs.add(new Point(1,2));
		bombs.add(new Point(3,2));
		bombs.add(new Point(6,4));
		m.fillBombs(bombs);
		m.display(m.openMaze);
	}
}