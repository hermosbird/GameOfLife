/**
 * The model for John Conway's Game of Life.
 *
 * @author Rick Mercer
 *
 *         This class has all needed methods as stubs. Comments explain each
 *         method.
 *
 */
public class GameOfLife {

	private boolean[][] society;

	/**
	 * Write the constructor so it takes two integer arguments to represent the
	 * number of rows and columns in the game of life. The constructor creates a
	 * society with no cells but space to store rows*cols cells.
	 *
	 * @param rows
	 *            The height of the grid that shows the cells.
	 * @param cols
	 *            The width of the grid that shows the cells.
	 */
	public GameOfLife(int rows, int cols) {
		society = new boolean[rows][cols];

		// Complete this method.
	}

	/**
	 * Return the number of rows, which can be indexed from 0..numberOfRows()-1.
	 *
	 * @return The height of the society.
	 */
	public int numberOfRows() {

		int rows = society.length;
		return rows;
	}

	/**
	 * The number of columns, which can be indexed from 0..numberOfColumns()-1.
	 *
	 * @return The height of the society.
	 */
	public int numberOfColumns() {
		int cols = society[0].length;
		return cols;
	}

	/**
	 * Place a new cell in the society. Precondition: row and col are in range.
	 *
	 * @param row
	 *            The row to grow the cell.
	 * @param col
	 *            The column to grow the cell.
	 */
	public void growCellAt(int row, int col) {
		society[row][col] = true;
	}

	/**
	 * 5) Return true if there is a cell at the given row and column. Return
	 * false if there is none at the specified location.
	 *
	 * @param row
	 *            The row to check.
	 * @param col
	 *            The column to check.
	 * @return True if there is a cell at the given row or false if none
	 */
	public boolean cellAt(int row, int col) {

		return society[row][col];
	}

	/**
	 * Return one big string of cells to represent the current state of the
	 * society of cells (see output below where '.' represents an empty space
	 * and 'O' is a live cell. There is no need to test toString. Simply use it
	 * to visually inspect if needed. Here is one sample output from toString:
	 *
	 * GameOfLife society = new GameOfLife(4, 14); society.growCellAt(1, 2);
	 * society.growCellAt(2, 3); society.growCellAt(3, 4);
	 * System.out.println(society.toString());
	 *
	 * Output .............. ..O........... ...O.......... ....O.........
	 *
	 * @return A textual representation of this society of cells.
	 */
	@Override
	public String toString() {
		String result = "";
		for(int i=0;i< society.length;i++){
			for(int j=0;j<society[0].length;i++){
				if(society[i][j]==true){
					result=result+"O";
				}
				else{
					result=result+".";
				}
			}
		}

		return result;

	}

	/**
	 * Count the neighbors around the given location. Use wraparound. A cell in
	 * row 0 has neighbors in the last row if a cell is in the same column, or
	 * the column to the left or right. In this example, cell 0,5 has two
	 * neighbors in the last row, cell 2,8 has four neighbors, cell 2,0 has four
	 * neighbors, cell 1,0 has three neighbors. The cell at 3,8 has 3 neighbors.
	 * The potential location for a cell at 4,8 would have three neighbors.
	 *
	 * .....O..O O........ O.......O O.......O ....O.O..
	 *
	 *
	 * The return values should always be in the range of 0 through 8.
	 *
	 * @return The number of neighbors around any cell using wrap around.
	 */
	public int neighborCount(int row, int col) {
		int result = 0;
		int r = society.length;
		int c = society[0].length;
		boolean temp[][] = new boolean[3 * r][3 * c];
		for (int a = 0; a <= 3 * r - 1; a++) {
			for (int b = 0; b <= 3 * c - 1; b++) {
				temp[a][b] = society[a % r][b % c];
			}
		}

		temp[r + row][c + col] = true;
		for (int i = r + row - 1; i <= r + row + 1; i++) {
			for (int j = c + col - 1; j <= c + col + 1; j++) {
				if (temp[i][j] == true)
					result = result + 1;

			}
		}

		return result - 1;
	}

	/**
	 * Update the state to represent the next society. Typically, some cells
	 * will die off while others are born.
	 */
	public void update() {

		boolean temp[][] = new boolean[society.length][society[0].length];
		for (int i = 0; i < society.length; i++) {
			for (int j = 0; j < society[0].length; j++) {
				temp[i][j] = false;

				if (society[i][j] == true && neighborCount(i, j) == 2
						|| neighborCount(i, j) == 3)
					temp[i][j] = true;

				if (society[i][j] == false && neighborCount(i, j) == 3)
					temp[i][j] = true;
			}

		}
		for (int i = 0; i < society.length; i++) {
			for (int j = 0; j < society[0].length; j++) {
				society[i][j] = temp[i][j];
			}
		}

	}

	public static void main(String[] args) {
		GameOfLife society = new GameOfLife(4, 14);
		society.growCellAt(1, 2);
		society.growCellAt(2, 3);
		society.growCellAt(3, 4);
		System.out.println(society.toString());

	}
}