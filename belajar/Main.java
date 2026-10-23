package belajar;
import java.util.Locale;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // 1. Array e of type long: even numbers 16, 14, ..., 2 (descending)
        long[] e = new long[8];
        for (int i = 0; i < e.length; i++) {
            e[i] = 16 - 2L * i;
        }

        // 2. Array x of type double: 15 random numbers in [-2.0; 5.0]
        double[] x = new double[15];
        Random random = new Random();
        for (int j = 0; j < x.length; j++) {
            x[j] = -2.0 + random.nextDouble() * (5.0 - (-2.0));
        }

        // 3. 2D array e1 (8x15). Name "e1" because "e" is already taken
        double[][] e1 = new double[8][15];
        for (int i = 0; i < e1.length; i++) {
            for (int j = 0; j < e1[i].length; j++) {
                e1[i][j] = calculate(e[i], x[j]);
            }
        }

        // 4. Print the result
        printMatrix(e1);
    }

    // Computes ONE element of the matrix by the formula from the task
    public static double calculate(long ei, double x) {
        if (ei == 16) {
            // arctan(cos(sin(x)))
            return Math.atan(Math.cos(Math.sin(x)));
        } else if (ei == 2 || ei == 6 || ei == 12 || ei == 14) {
            // cbrt( ( arcsin((x+1.5)/7) / (1/4 - tan(x)) ) ^ cbrt(x) )
            double base = Math.asin((x + 1.5) / 7) / (1.0 / 4 - Math.tan(x));
            return Math.cbrt(Math.pow(base, Math.cbrt(x)));
        } else {
            // ( A / B ) ^ C
            double a = Math.pow(
                    Math.pow(Math.sin(x), 3.0 / 4) / Math.pow(x / 2.0, x),
                    2 * Math.atan(Math.cos(x)));
            double b = 1 - Math.atan(Math.sin(
                    Math.pow(Math.PI / (Math.PI + Math.tan(x)), Math.pow(2 * x, 2))));
            double c = Math.sin(Math.pow(
                    (0.5 + Math.pow(x, x - (x - 3))) / Math.pow(x, x / 2.0), 2));
            return Math.pow(a / b, c);
        }
    }

    // Prints the matrix, 5 digits after the decimal point
    public static void printMatrix(double[][] m) {
        for (double[] row : m) {
            for (double value : row) {
                System.out.print(String.format(Locale.US, "%.5f ", value));
            }
            System.out.println();
        }
    }
}