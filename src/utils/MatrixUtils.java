package utils;

public class MatrixUtils {

    public static int[] getDiagonalValues(int[][] matrix, boolean descending) {
        int[] values = new int[matrix.length];
        if (descending) {
            for (int x = 0; x < matrix.length; x++) {
                values[x] = matrix[x][x];
            }
        } else {
            for (int x = 0, y = matrix.length - 1; x < matrix.length; x++, y--) {
                values[x] = matrix[x][y];
            }
        }
        return values;
    }
}
