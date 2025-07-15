// Class to represent each cell along with its current minimum effort (difference)

import java.util.PriorityQueue;

class Element {
    int difference; // Maximum absolute difference of heights along the path to this cell
    int row;        // Row index of the cell
    int col;        // Column index of the cell

    // Constructor to initialize the cell details
    Element(int d, int r, int c) {
        this.difference = d;
        this.row = r;
        this.col = c;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;    // Number of rows
        int m = heights[0].length; // Number of columns

        // Priority queue (min-heap) based on the 'difference' (minimum effort so far)
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> a.difference - b.difference);

        // Matrix to store the minimum effort required to reach each cell
        int[][] distance = new int[n][m];

        // Initialize all distances to a large number (infinity)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                distance[i][j] = (int) 1e9;
            }
        }

        // Starting point (0,0) has effort 0
        distance[0][0] = 0;
        pq.add(new Element(0, 0, 0));

        // Arrays to help move in 4 possible directions (up, right, down, left)
        int[] delrow = { -1, 0, +1, 0 };
        int[] delcol = { 0, +1, 0, -1 };

        // Dijkstra’s algorithm to minimize maximum effort path
        while (!pq.isEmpty()) {
            Element curr = pq.poll(); // Get cell with current least effort
            int diff = curr.difference;
            int row = curr.row;
            int col = curr.col;

            // If we have reached the destination cell (bottom-right), return the effort
            if (row == n - 1 && col == m - 1)
                return diff;

            // Explore all 4 adjacent cells
            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                // Check for valid cell boundaries
                if (nrow < n && nrow >= 0 && ncol < m && ncol >= 0) {
                    // Calculate effort to move to the neighboring cell
                    int newEffort = Math.max(Math.abs(heights[row][col] - heights[nrow][ncol]), diff);

                    // If the new effort is less than the currently stored effort for (nrow, ncol)
                    if (newEffort < distance[nrow][ncol]) {
                        distance[nrow][ncol] = newEffort; // Update with smaller effort
                        pq.add(new Element(newEffort, nrow, ncol)); // Push neighbor to priority queue
                    }
                }
            }
        }

        // If somehow destination is unreachable (theoretically won't happen), return 0
        return 0;
    }
}