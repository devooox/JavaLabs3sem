import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Matrix {
    public static double[][] readMatrix(String filePath) throws InputMismatchException, FileNotFoundException, NoSuchElementException, AmountException {
        Scanner scanner = new Scanner(new File(filePath));
        int n = scanner.nextInt();
        if (n <= 0) {
            throw new ArithmeticException("Size is wrong");
        }
        double[][] a = new double[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                a[i][j] = scanner.nextInt();
            }
        }
        if (scanner.hasNextInt()) {
            throw new AmountException("Wrong amount of elements");
        }
        ArrayList<Integer> b = new ArrayList<Integer>();
        
        return a;
    }

    private static void addRow(double[][] matrix, int a, int b) {
        for (int i = 0; i < matrix.length; ++i) {
            matrix[a][i] += matrix[b][i];
        }
    }

    public static double[][] getInverseMatrix(double[][] matrix) {
        int n = matrix.length;
        double[][] result = new double[n][n];
        for (int i = 0; i < n; ++i) {
            result[i][i] = 1;
        }

        for (int i = 0; i < n; ++i) {
            //check if colomn consists only 0
            if (matrix[i][i] == 0) {
                if (i == n - 1) {
                    throw new ArithmeticException("Determinant is zero");
                }
                for (int k = i + 1; k < n; ++k) {
                    if (matrix[k][i] != 0) {
                        addRow(matrix, i, k);
                        addRow(result, i, k);
                        break;
                    }
                    if (k == n - 1) {
                        throw new ArithmeticException("Determinant is zero");
                    }
                }
            }

            //pryamoi hod
            for (int j = i + 1; j < n; ++j) {
                double coef = (-matrix[j][i]) / matrix[i][i];
                for (int k = 0; k < n; ++k) {
                    matrix[j][k] += matrix[i][k] * coef;
                    result[j][k] +=result[i][k] * coef;
                }
            }
        }

        //obratniy hod
        for (int i = n-1; i >=0; --i) {
            double coef = matrix[i][i];
            for (int j = 0; j < n; ++j) {
                matrix[i][j] /= coef;
                result[i][j] /= coef;
            }
            for (int j = i - 1; j >= 0; --j) {
                coef = -matrix[j][i];
                for (int k = 0; k < n; ++k) {
                    matrix[j][k] += matrix[i][k] * coef;
                    result[j][k] +=result[i][k] * coef;
                }
            }
        }
        return result;
    }

    public static int[][] getTrianglePascal(int n) {
        int[][] a = new int[n][];
        for (int i = 0; i < n; ++i) {
            a[i] = new int[i + 1];
            a[i][0] = 1;
            a[i][i] = 1;
        }
        for (int i = 2; i < n; ++i) {
            for (int j = 1; j < i; ++i) {
                a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
            }
        }
        return a;
    }
}

public class Main {

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new AmountException("Enter a file path");
            }
            double[][] starterMatrix = Matrix.readMatrix(args[0]);
            double[][] inverseMatrix = Matrix.getInverseMatrix(starterMatrix);
//            for (int i = 0; i < starterMatrix.length; ++i) {
//                String str = "";
//                for (int j = 0; j < starterMatrix.length; ++j) {
//                    str += starterMatrix[i][j] + " ";
//                }
//                System.out.println(str);
//            }
            for (int i = 0; i < starterMatrix.length; ++i) {
                String str = "";
                for (int j = 0; j < starterMatrix.length; ++j) {
                    str += inverseMatrix[i][j] + " ";
                }
                System.out.println(str);
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Error data");
        }
        catch (NoSuchElementException e) {
            System.out.println("Not enough elements");
        }
        catch ( ArithmeticException | FileNotFoundException | AmountException e) {
            System.out.println(e.getMessage());
        }

    }
}

class AmountException extends Exception {
    public AmountException(String message) {
        super(message);
    }
}