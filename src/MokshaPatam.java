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
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{1, 0});
        boolean[] visited = new boolean[boardsize + 1];
        int[] snl = new int[boardsize + 1];
        for (int i = 0; i < snakes.length; i++) {
            for (int j = 0; j < snakes[0].length; j++) {
                snl[i] = j;
            }
        }
        for (int i = 0; i < ladders.length; i++) {
            for (int j = 0; j < ladders[0].length; j++) {
                snl[i] = j;
            }
        }

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
            if (currentNode == boardsize) {
                return rolls;
            }
            for (int i = 1; i < 7; i++) {
                node = currentNode + i;
                if (node > boardsize) {
                    break;
                }
                if (snl[node] != 0) {
                    node = snl[node];
                }
                if (!visited[node]) {
                    visited[node] = true;
                    q.add(new int[] {node, rolls + 1});
                }
            }
        }

        return -1;
    }
}
