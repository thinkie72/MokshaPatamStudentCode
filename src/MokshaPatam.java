import java.util.LinkedList;
import java.util.Queue;

/**
 * Moksha Patam
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: Tyler Hinkie
 *
 */

public class MokshaPatam {

    /**
     * TODO: Complete this function, fewestMoves(), to return the minimum number of moves
     *  to reach the final square on a board with the given size, ladders, and snakes.
     */
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {
//        Add the first node, 1, to the queue
//        While there are still nodes left in the queue:
//        Pop off the node at the front and visit it.
//        If we are at the end of the graph, then we are done!
//                Check all of the edges that extend out of this node:
//        If any of them are unvisited, add them to the back of the queue
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        int[] numRolls = new int[boardsize];
        for (int i = 0; i < boardsize; i++) {
            numRolls[i] = -1;
        }
        int node;
        int row;
        int col;
        int temp;
        // Continues to add nodes onto the queue until one path reaches the end
        while (!q.isEmpty()) {
            node = q.remove();
            if (node == boardsize + 1) {
                return moves;
            }
            // North
            if (isInBounds(row - 1, col) && maze.isValidCell(row - 1, col)) {
                temp = maze.getCell(row - 1, col);
                temp.setExplored(true);
                temp.setParent(cell);
                q.add(temp);
            }
            // East
            if (isInBounds(row, col + 1) && maze.isValidCell(row, col + 1)) {
                temp = maze.getCell(row, col + 1);
                temp.setExplored(true);
                temp.setParent(cell);
                q.add(temp);
            }
            // South
            if (isInBounds(row + 1, col) && maze.isValidCell(row + 1, col)) {
                temp = maze.getCell(row + 1, col);
                temp.setExplored(true);
                temp.setParent(cell);
                q.add(temp);
            }
            // West
            if (isInBounds(row, col - 1) && maze.isValidCell(row, col - 1)) {
                temp = maze.getCell(row, col - 1);
                temp.setExplored(true);
                temp.setParent(cell);
                q.add(temp);
            }
        }
        return getSolution();
    }
}
