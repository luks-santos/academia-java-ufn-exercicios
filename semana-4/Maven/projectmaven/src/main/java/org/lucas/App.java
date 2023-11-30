package org.lucas;
import org.apache.commons.math3.*;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        double[][] matrixData = { {1d, 2d, 3d}, {2d, 5d, 3d} };
        double[][] matrixData2 = { {1d,2d}, {2d,5d}, {1d, 7d} };

        Array2DRowRealMatrix matrix = MathMatrix.multiplyMN(matrixData, matrixData2);
        System.out.println(matrix);
    }
}
