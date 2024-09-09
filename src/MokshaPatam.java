import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Moksha Patam
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 * <p>
 * Completed by: Tyler Hinkie
 */

public class MokshaPatam {


    // Finds the fewest moves to reach the end of a snakes and ladders board
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{1, 0});
        // Array to tell whether or not a node has been visited
        boolean[] visited = new boolean[boardsize + 1];
        int[] snl = new int[boardsize + 1];
        // Initializes snakes and ladders array
        for (int i = 0; i < snakes.length; i++) {
            snl[snakes[i][0]] = snakes[i][1];
        }
        for (int i = 0; i < ladders.length; i++) {
            snl[ladders[i][0]] = ladders[i][1];
        }

        // Variables to hold the nodes and rolls for each iteration
        int[] current;
        int currentNode;
        int node;
        int rolls;
        // Continues to add nodes onto the queue until one path reaches the end
        while (!q.isEmpty()) {
            current = q.remove();
            currentNode = current[0];
            rolls = current[1];
            visited[currentNode] = true;
            // Signaling end of method by reaching the end of the board
            if (currentNode == boardsize) {
                return rolls;
            }
            // Goes backward to find the fewest number of rolls to reach the end
            for (int i = 6; i > 0; i--) {
                node = currentNode + i;
                // Resets the node to avoid going past the end of the board
                if (node > boardsize) {
                    node = currentNode;
                }
                // Checks if node is the opening to a snake or ladder
                if (snl[node] != 0) {
                    node = snl[node];
                }
                // Checks if node has been visited, then adds to queue if unvisited
                if (!visited[node]) {
                    visited[node] = true;
                    q.add(new int[]{node, rolls + 1});
                }
            }
        }

        // Only if there is no possible path to the end
        return -1;
    }
}
