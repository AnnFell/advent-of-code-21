package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static utils.MatrixUtils.getDiagonalValues;

class MatrixUtilsTest {
    @Test
    void testGetDiagonalValues() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[] resultDescending = getDiagonalValues(matrix, true);
        assertArrayEquals(new int[]{1, 5, 9}, resultDescending);

        int[] resultAscending = getDiagonalValues(matrix, false);
        assertArrayEquals(new int[]{3, 5, 7}, resultAscending);
    }
}