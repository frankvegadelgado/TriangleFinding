import java.util.*;

public class MatrixLibrary {

    public static int getRows(boolean[][] matrix) {
        return matrix.length;
    }

    public static int getCols(boolean[][] matrix) {
        return matrix[0].length;
    }

    public static boolean isTrivial(boolean[][] matrix) {
        return getRows(matrix) < 3 || getCols(matrix) < 3;
    }

    public static Map<Integer, List<Integer>> getAdjacencyList(boolean[][] matrix) {
        int rows = getRows(matrix);
        int cols = getCols(matrix);
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            adjList.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j]) {
                    adjList.get(i).add(j);
                }
            }
        }
        return adjList;
    }

    // Tests have shown that it's quite a bit faster to compute the adjacency list
    // of the transpose directly rather than computing the transpose matrix and
    // then computing the adjacency list.
    public static Map<Integer, List<Integer>> getAdjacencyListOfTranspose(boolean[][] matrix) {
        int rows = getRows(matrix);
        int cols = getCols(matrix);
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int j = 0; j < cols; j++) {
            adjList.put(j, new ArrayList<Integer>());
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j]) {
                    adjList.get(j).add(i);
                }
            }
        }
        return adjList;
    }

    // Create a matrix with random entries
    private static boolean[][] createRandomMatrix(int rows, int cols, double thresh) {
        boolean[][] matrix = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Math.random() >= thresh;
            }
        }
        return matrix;
    }

    // Create an adjacency matrix with random entries
    public static boolean[][] createRandomAdjacencyMatrix(int n, double thresh) {
        boolean[][] matrix = createRandomMatrix(n, n, thresh);

        // Guarantee the symmetry and the main diagonal filled only with zeroes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) matrix[i][j] = false;
                if (matrix[i][j]) matrix[j][i] = matrix[i][j];
            }
        }


        return matrix;
    }
    // Print the entries of a matrix
    public static void printMatrix(boolean[][] matrix) {
        int rows = getRows(matrix);
        int cols = getCols(matrix);
        System.out.println(rows + " by " + cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j]) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
                if (j < cols - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
