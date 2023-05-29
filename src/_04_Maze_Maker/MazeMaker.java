package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MazeMaker {

    private static int rows;
    private static int cols;

    private static Maze maze;

    private static Random randGen = new Random();
    private static Stack<Cell> uncheckedCells = new Stack<Cell>();

    public static Maze generateMaze(int r, int c) {
        rows = r;
        cols = c;
        maze = new Maze(rows, cols);
        int ranrow;
        int rancol;
        int ranerow;
        int ranecol;
        // 1. Pick a random cell along the border and remove its exterior wall.
        //    This will be the starting point. Then select a random cell along
        //    the opposite wall and remove its exterior wall. This will be the
        //    finish line.
    if(randGen.nextInt(1)==0){
    	  if (randGen.nextInt(1)==0) {
			 ranrow = 0;
			rancol = randGen.nextInt(4);
			ranerow = 4;
			ranecol = randGen.nextInt(4);
		}
    	  else {
    		  ranrow = 4;
    		  rancol = randGen.nextInt(4);
    		  ranerow = 0;
  			ranecol = randGen.nextInt(4);
    	  }
      }
    else {
    	 if (randGen.nextInt(1)==0) {
 			 rancol = 0;
 			 ranrow = randGen.nextInt(4);
 			 ranecol = 4;
 			 ranerow = randGen.nextInt(4);
 		}
     	  else {
     		  rancol = 4;
     		  ranrow = randGen.nextInt(4);
     		 ranecol = 0;
 			 ranerow = randGen.nextInt(4);
	}
    }
    Cell start = new Cell(ranrow,rancol);
    Cell end = new Cell(ranerow,ranecol);
    if (ranrow==0) {
		start.setNorthWall(false);
	}
    if (ranrow==4) {
		start.setSouthWall(false);
	}
    if (rancol==0) {
		start.setWestWall(false);
	}
    if (rancol==4) {
		start.setEastWall(false);
	}
    if (ranerow==0) {
		start.setNorthWall(false);
	}
    if (ranerow==4) {
		start.setSouthWall(false);
	}
    if (ranecol==0) {
		start.setWestWall(false);
	}
    if (ranecol==4) {
		start.setEastWall(false);
	}
        // 2. select a random cell in the maze to start 
        int randcr = randGen.nextInt(4);
        int randcc = randGen.nextInt(4);
        // 3. call the selectNextPath method with the randomly selected cell
        Cell randcell = new Cell(randcr,randcc);
        selectNextPath(randcell);
        return maze;
    }

    // 4. Complete the selectNextPathMethod
    private static void selectNextPath(Cell currentCell) {
    	
    	
        // A. SET currentCell as visited
    	currentCell.setBeenVisited(true);
        // B. check for unvisited neighbors using the cell
   if (getUnvisitedNeighbors(currentCell).size()>=1) {
	   int randunvis =randGen.nextInt(getUnvisitedNeighbors(currentCell).size());
		Cell unvis = getUnvisitedNeighbors(currentCell).get(randunvis);
		uncheckedCells.push(unvis);
		removeWalls(currentCell, unvis);
		currentCell = unvis;
		currentCell.setBeenVisited(true);
		selectNextPath(currentCell);
   } 
        // C. if has unvisited neighbors,
    	
        // C1. select one at random.

        // C2. push it to the stack

        // C3. remove the wall between the two cells

        // C4. make the new cell the current cell and SET it as visited

        // C5. call the selectNextPath method with the current cell


        // D. if all neighbors are visited

        // D1. if the stack is not empty

        // D1a. pop a cell from the stack

        // D1b. make that the current cell

        // D1c. call the selectNextPath method with the current cell

    }

    // This method will check if c1 and c2 are adjacent.
    // If they are, the walls between them are removed.
    private static void removeWalls(Cell c1, Cell c2) {
        if (c1.getRow() == c2.getRow()) {
            if (c1.getCol() > c2.getCol()) {
                c1.setWestWall(false);
                c2.setEastWall(false);
            } else {
                c1.setEastWall(false);
                c2.setWestWall(false);
            }
        } else {
            if (c1.getRow() > c2.getRow()) {
                c1.setNorthWall(false);
                c2.setSouthWall(false);
            } else {
                c1.setSouthWall(false);
                c2.setNorthWall(false);
            }
        }
    }

    // This method returns a list of all the neighbors around the specified
    // cell that have not been visited. There are up to 4 neighbors per cell.
    //          1
    //       2 cell 3
    //          4
    private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
        int row = c.getRow();
        int col = c.getCol();

        ArrayList<Cell> unvisitedNeighbors = new ArrayList<Cell>();

        if (row > 0 && !maze.getCell(row - 1, col).hasBeenVisited()) {
            unvisitedNeighbors.add(maze.getCell(row - 1, col));
        }

        if (col > 0 && !maze.getCell(row, col - 1).hasBeenVisited()) {
            unvisitedNeighbors.add(maze.getCell(row, col - 1));
        }

        if (row < rows - 1 && !maze.getCell(row + 1, col).hasBeenVisited()) {
            unvisitedNeighbors.add(maze.getCell(row + 1, col));
        }

        if (col < cols - 1 && !maze.getCell(row, col + 1).hasBeenVisited()) {
            unvisitedNeighbors.add(maze.getCell(row, col + 1));
        }

        return unvisitedNeighbors;
    }
}
