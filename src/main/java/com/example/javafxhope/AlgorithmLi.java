
package com.example.javafxhope;

import java.util.*;



public class AlgorithmLi {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    public AlgorithmLi() {}



    public static List<int[]> waveAlgorithm(int[][] maze, int[] start, int[] goal, int width, int height) {
        int rows = maze.length;
        int cols = maze[0].length;

        // Матрица расстояний (инициализация значениями "бесконечности")
        int[][] distance = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        // Матрица для хранения предшественников
        int[][] parent = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(parent[i], -1); // -1 будет означать, что предшественника нет
        }

        // Начальная клетка
        distance[start[0]][start[1]] = 0;

        // Очередь для BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);

        // BFS
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // Проверка, достигли ли цели
            if (x == goal[0] && y == goal[1]) {
                return reconstructPath(parent, start, goal);  // Восстанавливаем путь
            }

            // Обработка соседей
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];




                boolean ifStepPossible = true;

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




                // Проверка границ и стен
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

        // Если путь не найден
        return null;
    }

    // Восстановление пути от цели к началу
    public static List<int[]> reconstructPath(int[][] parent, int[] start, int[] goal) {
        List<int[]> path = new ArrayList<>();
        int rows = parent.length;
        int cols = parent[0].length;

        int current = goal[0] * cols + goal[1];

        // Восстанавливаем путь, начиная с целевой клетки
        while (current != -1) {
            int x = current / cols;
            int y = current % cols;
            path.add(new int[]{x, y});
            current = parent[x][y];
        }

        // Переворачиваем путь, так как мы восстановили его в обратном порядке
        Collections.reverse(path);
        return path;
    }

    public List<int[]> find(int maze[][], int[] start, int[] goal, int width, int height) {
        List<int[]> path = waveAlgorithm(maze, start, goal, width, height);

        return path;
    }
}









