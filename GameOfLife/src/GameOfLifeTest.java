import static org.junit.Assert.*;
import org.junit.Test;
public class GameOfLifeTest {
 @Test
 public void testConstructorAndGetters() {
 GameOfLife society = new GameOfLife(5, 8);
 assertEquals(5, society.numberOfRows());
 assertEquals(8, society.numberOfColumns());
 for (int r = 0; r < society.numberOfRows(); r++)
 for (int c = 0; c < society.numberOfColumns(); c++)
 assertFalse(society.cellAt(r, c));
 }
 @Test
 public void testGrowCellAtAndCellAt() {
 GameOfLife society = new GameOfLife(4, 4);
 society.growCellAt(1, 1);
 society.growCellAt(2, 2);
 society.growCellAt(3, 3);
 
 assertTrue(society.cellAt(1, 1));
 assertTrue(society.cellAt(2, 2));
 assertTrue(society.cellAt(3, 3));
 }
 
 @Test
 public void testnumberOfRows()  {
	 GameOfLife society = new GameOfLife(4, 19);
	 assertEquals(4, society.numberOfRows());
 }
 
 @Test
 public void testnumberOfColumns()  {
	 GameOfLife society = new GameOfLife(8, 8);
	 assertEquals(8, society.numberOfColumns());
 }
 
 @Test
 public void testneiborcount() {
	 GameOfLife society = new GameOfLife(4, 4);
	 society.growCellAt(3, 1);
	 society.growCellAt(3, 2);
	 society.growCellAt(3, 3);
	 assertEquals(2, society.neighborCount(3, 0));
	 assertEquals(1, society.neighborCount(3, 1));
	 assertEquals(1, society.neighborCount(3, 3));
	 assertEquals(2, society.neighborCount(3, 2));
	 
 }
 
 
 @Test
 public void testNeighborsWrapping() {
 GameOfLife society = new GameOfLife(10, 16);
 society.growCellAt(3, 3);
 society.growCellAt(3, 4);
 society.growCellAt(3, 5);
 assertEquals(0, society.neighborCount(2, 1));
 assertEquals(1, society.neighborCount(2, 2));
 assertEquals(2, society.neighborCount(2, 3));
 assertEquals(3, society.neighborCount(2, 4));
 assertEquals(1, society.neighborCount(3, 3));
 assertEquals(2, society.neighborCount(3, 4));
 assertEquals(1, society.neighborCount(3, 5));
 society.growCellAt(3, 15);
 society.growCellAt(3, 0);
 assertEquals(2, society.neighborCount(4, 0));
 assertEquals(2, society.neighborCount(4, 15));
 GameOfLife society1 = new GameOfLife(50, 16);
 society1.growCellAt(3, 3);
 society1.growCellAt(3, 4);
 society1.growCellAt(3, 5);
 assertEquals(0, society1.neighborCount(2, 1));
 assertEquals(1, society1.neighborCount(2, 2));
 assertEquals(2, society1.neighborCount(2, 3));
 assertEquals(3, society1.neighborCount(2, 4));
 society1.growCellAt(3, 15);
 society1.growCellAt(3, 0);
 assertEquals(2, society1.neighborCount(4, 0));
 assertEquals(2, society1.neighborCount(4, 15));
 GameOfLife society2 = new GameOfLife(50, 60);
 society2.growCellAt(3, 3);
 society2.growCellAt(3, 4);
 society2.growCellAt(3, 5);
 assertEquals(0, society2.neighborCount(2, 1));
 assertEquals(1, society2.neighborCount(2, 2));
 assertEquals(3, society2.neighborCount(2, 4));
 GameOfLife society6 = new GameOfLife(5, 5);
 society6.growCellAt(3, 2);
 society6.growCellAt(3, 3);
 society6.growCellAt(3, 4);
 society6.growCellAt(1, 1);
 society6.growCellAt(1, 4);
assertEquals(1, society6.neighborCount(3, 2));
assertEquals(4, society6.neighborCount(2, 3));
 
 
 // ... 6many more assertions expected
 }
 // ... Add many more @Test methods here

 

@Test
 public void testupdate(){
	 GameOfLife society = new GameOfLife(5, 5);
	 society.growCellAt(3, 2);
	 society.growCellAt(3, 3);
	 society.growCellAt(3, 4);
	 society.growCellAt(1, 1);
	 society.growCellAt(1, 4);
	 assertEquals(false,society.cellAt(4, 3));
	 assertEquals(false,society.cellAt(2, 3));
	 assertEquals(true,	society.cellAt(3, 3));
	 assertEquals(true,society.cellAt(1, 1));
	 assertEquals(true,society.cellAt(3, 2));
	 assertEquals(false,society.cellAt(2, 4));
	 assertEquals(4, society.neighborCount(2, 3));
	 assertEquals(1, society.neighborCount(3, 2));
	 society.update();
	 assertEquals(true,	society.cellAt(4, 3));
	 assertEquals(false,society.cellAt(2, 3));
	 assertEquals(true,	society.cellAt(3, 3));
	 assertEquals(false,society.cellAt(3, 2));
	 assertEquals(true,society.cellAt(2, 4));
	 
	 
	 
	 GameOfLife society1 = new GameOfLife(10, 12);
	 society1.growCellAt(0, 11);
	 society1.growCellAt(9, 11);
	 society1.update();
	 assertEquals(false,society1.cellAt(4, 3));
	 assertEquals(false,society1.cellAt(3, 4));
	 assertEquals(false,society1.cellAt(9, 11));
	 assertEquals(false,society1.cellAt(0, 11));
	 assertEquals(false,society1.cellAt(0, 0));
	 
 }

}



