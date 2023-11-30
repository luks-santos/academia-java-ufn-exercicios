package org.lucas;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;

public class MathMatrix {

    public static Array2DRowRealMatrix multiplyMN(double[][] matrix1, double[][] matrix2) {
        Array2DRowRealMatrix m = new Array2DRowRealMatrix(matrix1);
        Array2DRowRealMatrix n = new Array2DRowRealMatrix(matrix2);

        return m.multiply(n);
    }
}
