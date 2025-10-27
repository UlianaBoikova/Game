
package com.example.javafxhope;

import java.util.*;


/**
 Algorithm for finding the shortest path.
 */
public class AlgorithmLi {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    /**
     Default constructor.
     */
    public AlgorithmLi() {}


    /**
     Finds the shortest way for the object to the needed goal.
      @param maze the table of obstacles
      @param start the start position
      @param goal the goal position
      @param width width of object
      @param height height of object
      @return list of needed shortest way
     */
    public static List<int[]> find(int[][] maze, int[] start, int[] goal, int width, int height) {
        int rows = maze.length;
        int cols = maze[0].length;

        // Distance matrix
        int[][] distance = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        // Matrix for storing precursors
        int[][] parent = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(parent[i], -1);
        }

        distance[start[0]][start[1]] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // Checking whether the goals have been achieved
            if (x == goal[0] && y == goal[1]) {
                return reconstructPath(parent, goal);  // Recovering the path
            }

            // Processing neighbors
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];




                boolean ifStepPossible = true;

                /*
                if (nx + width - 1 < rows && nx >= 0 && ny >= 0 && ny + height - 1 < cols) {
                    for (int k = ny + height - 1; k >= ny; k -= 3) {

                        if (maze[nx][k] == 1) {
                            ifStepPossible = false;
                            break;
                        }
                        if (maze[nx + width - 1][k] == 1) {
                            ifStepPossible = false;
                            break;
                        }
                    }

                    if (ifStepPossible) {
                        for (int l = nx + width - 1; l >= nx; l -= 3) {
                                if (maze[l][ny] == 1) {
                                    ifStepPossible = false;
                                    break;
                                }
                                if (maze[l][ny + height - 1] == 1) {
                                    ifStepPossible = false;
                                    break;
                                }
                        }
                    }
                } else ifStepPossible = false;




                 */

                // Checking boundaries and walls
                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && ny + height - 1 < cols && nx + width - 1 < rows &&
                        maze[nx][ny] == 0 && maze[nx][ny + height - 1] != 1 && maze[nx + width - 1][ny] != 1 &&
                        maze[nx + width - 1][ny + height - 1] != 1 && ifStepPossible &&
                        distance[nx][ny] == Integer.MAX_VALUE) {
                    distance[nx][ny] = distance[x][y] + 1;
                    parent[nx][ny] = x * cols + y;  // Запоминаем, откуда пришли
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        // If the path is not found
        return null;
    }

    /**
     Retracing the path from the goal to the start
      @param parent start point
      @param goal goal point
      @return the shortest way
     */
    public static List<int[]> reconstructPath(int[][] parent, int[] goal) {
        List<int[]> path = new ArrayList<>();
        int cols = parent[0].length;

        int current = goal[0] * cols + goal[1];

        // Retracing the path starting from the target cell
        while (current != -1) {
            int x = current / cols;
            int y = current % cols;
            path.add(new int[]{x, y});
            current = parent[x][y];
        }

        // We reverse the path, as we have restored it in reverse order.
        Collections.reverse(path);
        return path;
    }


}









