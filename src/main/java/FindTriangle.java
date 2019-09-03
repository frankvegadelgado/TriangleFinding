
// Author: Frank Vega
// Description: This class finds a triangle in an adjacency matrix of n vertices in O(n^2) time
// just assuming the Binary AND Operation can be done in constant time.
// This algorithm is based on the finding of a rectangle whose corners are 1's.

import java.util.*;

public class FindTriangle {

    // Runs in O(n^2) time assuming the Binary AND Operation can be done in constant time
    public static boolean fastSearch(boolean[][] matrix) {
        int n = MatrixLibrary.getRows(matrix);

        if (n > 63)
            throw new OutOfMemoryError("Data type long integer required at most 64 bits");

        long[] numbers = new long[n];

        long[] power = new long[n + 1];

        power[0] = 1;

        for(int i = 1; i < n + 1; i++){
            power[i] = 2 * power[i - 1];
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                if (i == j || matrix[i][j])
                    numbers[i] +=  power[j];
            }
        }

        for (int i = 1; i < n; i++){
            long all = power[i + 1] - 1;
            long rhs = power[i];
            for (int j = i + 1; j < n; j++){
                long lhs = (numbers[j] & all) & numbers[i];
                if (lhs > rhs)
                    return true;
            }
        }

        return false;
    }


    // Runs in O(n^3) time
    public static boolean naiveSearch(boolean[][] matrix) {
        int n = MatrixLibrary.getRows(matrix);
        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                for (int c = b + 1; c < n; c++) {
                    if (matrix[a][b] && matrix[b][c] && matrix[c][a]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
