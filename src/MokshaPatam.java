import java.util.Arrays;
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
        boolean[] visited = new boolean[boardsize + 1];
        int[] rolls = new int[boardsize];
        int[] snl = new int[boardsize + 1];
        Arrays.fill(rolls, -1);
        for (int i = 0; i < snakes[0].length; i++) {
            for (int j = 0; j < snakes.length; j++) {
                snl[i] = j;
            }
        }
        for (int i = 0; i < ladders[0].length; i++) {
            for (int j = 0; j < ladders.length; j++) {
                snl[i] = j;
            }
        }

        int currentNode;
        int node;
        int moves = 1;
        // Continues to add nodes onto the queue until one path reaches the end
        while (!q.isEmpty()) {
            currentNode = q.remove();
            visited[currentNode] = true;
            if (currentNode == boardsize) {
                return rolls[0];
            }
            for (int i = 1; i < 7; i++) {
                node = currentNode + i;
                if (snl[node] != 0) {
                    node = snl[node];
                }
                if (!visited[node]) {
                    // save rolls
                    q.add(node);
                }
            }
        }
        return 0;
    }
}
