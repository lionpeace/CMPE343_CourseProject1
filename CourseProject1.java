/** CMPE343 COURSE PROJECT #1 - GROUP 6 */ 

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CourseProject1 {

    /* Statistical Information About an Array Starts Here */

    /**
     * This method first sorts the array using the sort method found in the java.util.Arrays library.
     * Then, by finding the length of the array, it checks whether this length is odd or even.
     * If it is even, it adds the two numbers in the middle of the array and divides them by two. It sets it equal to the median variable.
     * If it is odd, it sets the middle number of the array equal to the median.
     * Returns the median variable
     * @param array it's array that user will create 
     * @return median of the array
     */

    public static double findMedian(double[] array)
    {
        Arrays.sort(array);
        double median = 0;

        int lengthOfArray = array.length;
        int halfOfLength = lengthOfArray / 2;

        if(lengthOfArray % 2 == 0)
        {
            median = (array[halfOfLength] + array[halfOfLength - 1]) / 2;
        }
        else
        {
            median = array[halfOfLength]; 
        }

        return median;
    }

    /**
     * This method calculates the arithmetic mean of the given array.
     * This method iterates through the array to sum all its elements.
     * Then, it divides the total sum by the length of the array to find the arithmetic mean.
     * Finally, it returns the arithmetic mean.
     * @param array it's array that user will create
     * @return arithmetic mean of the array
     */

    public static double findArithmeticMean(double[] array)
    {
        double arithmeticMean = 0;
        double total = 0;

        for(int i = 0; i < array.length; i++)
        {
            total += array[i];
        }

        arithmeticMean = total / array.length;

        return arithmeticMean;
    }

    /**
     * This method calculates the geometric mean of the given array.
     * This method iterates through the array, multiplying all its elements together.
     * Then, it takes the n-th root of the total product (where n is the length of the array) to find the geometric mean.
     * Finally, it returns the geometric mean.
     * @param array it's array that user will create
     * @return geometric mean of the array
     *
     */

    public static double findGeometricMean(double[] array)
    {
        double geometricMean = 0;
        double total = 1;

        for(int i = 0; i < array.length; i++)
        {
            total *= array[i];
        }

        geometricMean = Math.pow(total, 1.0 / array.length);

        return geometricMean;
    }

    /**
     * This method calculates the harmonic mean of the given array.
     * This method uses recursion to calculate the harmonic mean. It checks if i is zero,
     * and if so, returns the inverse of the first element of the array. Otherwise,
     * it adds the inverse of the current element to the result of a recursive call with i decremented by one.
     * @param array it's array that user will create
     * @param i it represents the size of the array
     * @return returns the harmonic mean of the array. If i is zero, it returns the inverse of the first element of the array.
     */

    public static double findHarmonicMean(double[] array, int i)
    {
        if(i == 0)
        {
            return 1 / array[0];
        }

        return (1 / array[i]) + findHarmonicMean(array, i - 1);
    }


    /**
     * This method created for organizing sub-methods of statistical information about an array operation.
     * When this method executed terminal will be cleared with clearTheTerminal method.
     * Then ascii art will be printed.
     * After the necessary explanations about the operation are made to the user, the user is asked for the size of the array that will be created.
     * Then, validation check is provided for this array size (Temporarily limited to 20).
     * The user is asked to enter a value into the double array created with this array size, and control is provided for this double value.
     * After the sub-methods are called, the user is shown the results of the mathematical operations he/she wanted to be calculated.
     * @param input scanner variable from main to receive user input
     */

    public static void statInfoAboutArray(Scanner input)
    {
        clearTheTerminal();

        String[] asciiArt = {
            "                                                                                                                                                                            ",
            "____ ___ ____ ___ _ ____ ___ _ ____ ____ _       _ _  _ ____ ____ ____ _  _ ____ ___ _ ____ _  _    ____ ___  ____ _  _ ___    ____ _  _    ____ ____ ____ ____ _   _       ",
            "[__   |  |__|  |  | [__   |  | |    |__| |       | |\\ | |___ |  | |__/ |\\/| |__|  |  | |  | |\\ |    |__| |__] |  | |  |  |     |__| |\\ |    |__| |__/ |__/ |__|  \\_/   ",
            "___]  |  |  |  |  | ___]  |  | |___ |  | |___    | | \\| |    |__| |  \\ |  | |  |  |  | |__| | \\|    |  | |__] |__| |__|  |     |  | | \\|    |  | |  \\ |  \\ |  |   |   ",
            "                                                                                                                                                                            ",
        };

        for (String line : asciiArt) {
            System.out.println(line);
        }

        System.out.println("\n\nWith this application you can find a median, arithmetic mean, geometric mean, and harmonic mean of array that you created. ");
        System.out.println("You will define the size of array that you want to create and fill it with the double numbers.");

        int sizeOfArray = 0;
        boolean validSize = false;

        while (!validSize) 
        {
            try {
                System.out.print("\nPlease enter the size of array that you want to create (maximum 20 elements will be accepted): ");
                sizeOfArray = input.nextInt();
                
                if (sizeOfArray > 0 && sizeOfArray <= 20) {
                    validSize = true;
                } else {
                    System.out.println("Please enter a number between 1 and 20.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                input.next();
            }
        }

        System.out.printf("\n\nSize of array: %d\n\n",sizeOfArray);

        double[] array = new double[sizeOfArray];
        boolean validNumber = false;
        double number = 0;
        int i = 0;

        while(!validNumber)
        {
            try {
                System.out.printf("\nPlease enter the number #%d: ", i + 1);
                number = input.nextDouble();
                System.out.printf("\nNumber %.2f added.\n", number);
                array[i] = number;
                i++;
                if(i == sizeOfArray)
                {
                    validNumber = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid double.");
                input.next();
            }
        }

        clearTheTerminal();

        for(int a = 0; a < sizeOfArray; a++)
        {
            System.out.printf("\nYour number %d is %.2f.", a + 1, array[a]);
        }

        double median = findMedian(array);
        double arithmeticMean = findArithmeticMean(array);
        double geometricMean = findGeometricMean(array);
        double harmonicMean = sizeOfArray / findHarmonicMean(array, sizeOfArray - 1);

        System.out.print("\n\nTHE RESULTS:");
        System.out.printf("\n\nThe median of the array is: %.2f", median);
        System.out.printf("\n\nThe arithmetic mean of the array is: %.2f", arithmeticMean);
        System.out.printf("\n\nThe harmonic mean of the array is: %.2f", harmonicMean);

        if(Double.isNaN(geometricMean))
        {
            System.out.printf("\n\nThe geometric mean of the array is: NaN (Not a Number). \n\nBecause:\n\n");
            System.out.println
            (
                "The complexity of negative numbers in geometric mean calculations is indeed interesting. "
                + "\nThe geometric mean is the root of the product of numbers, and when negative numbers are included, the product becomes negative."
                + "\nWhen taking the root of negative products, the results involve complex numbers, which are not valid real numbers.\n\n"
                + "If you receive NaN (Not a Number) when using negative numbers, it indicates that the mathematical operation is undefined or invalid."
                + "\nHowever, in some cases where the number set includes a mix of positive and negative numbers, the geometric mean may still be calculated if the numbers are made positive (e.g., by taking the absolute value of negative numbers).\n\n"
                + "Thus, the role and result of negative numbers in geometric mean calculations can vary depending on the combination and total count of numbers."
                + "\nNevertheless, the presence of negative numbers generally invalidates the geometric mean calculation.\n\n"
            );
        }
        else
        {
            System.out.printf("\n\nThe geometric mean of the array is: %.2f\n\n", geometricMean);
        }

    }

    /* Statistical Information About an Array Ends Here */


    /* Matrix Operations Starts Here */

    /**
     * Prompts the user for a positive integer input, validating the input as needed.
     * @param text Description of the required input (e.g., "rows" or "columns").
     * @param scanner Scanner object for reading user input.
     * @return A positive integer input from the user.
     */

    private static int getValidIntegerInput(String text, Scanner scanner) {
        int input = -1; 
        while (true) {
            System.out.print("(positive integer): ");
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input > 0) {
                    break;
                } else {
                    System.out.println("\nError!! Number of "+ text +" must be bigger than zero. Please re-enter "+text+".");
                }
            } else {
                System.out.println("\nError!! Number of "+ text +" must be an integer and a numeric value. Please re-enter "+text+".");
                scanner.next(); 
            }
        }
        return input;
    }

    /**
     * Prompts the user for a valid pair of inputs for a matrix element and checks the input format.
     * @param i The row index of the matrix element.
     * @param j The column index of the matrix element.
     * @param scanner Scanner object for reading user input.
     * @return A valid double input from the user for the specified element.
     */

    private static double getValidDoubleInput(int i, int j, Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("\nError!! Input must be a numeric value (use comma for double values).");
            System.out.print("Please re-enter the value for element ["+i+"]["+j+"]: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    /**
     * Collects elements from the user to populate a matrix with specified dimensions.
     * @param rows Number of rows in the matrix.
     * @param columns Number of columns in the matrix.
     * @param scanner Scanner object for reading user input.
     * @return A 2D array (matrix) filled with user-provided elements.
     */

    private static double[][] getMatrixElements(int rows, int columns, Scanner scanner) {
        double[][] matrix = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element for [" + i + "][" + j + "]: ");
                matrix[i][j] = getValidDoubleInput(i, j, scanner);
            }
        }
        return matrix;
    }

    /**
     * Prints the elements of the given matrix in a formatted manner.
     * Each element is displayed with two decimal places.
     * @param matrix a 2D array representing the matrix to be printed.
     */

    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%.2f\t", matrix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Waits for the user to press the Enter key before returning to the operation menu.
     * This method is useful for pausing the program and allowing the user to read the output.
     * @param scanner Scanner object for reading user input.
     */

    private static void pressAnyKeyToContinue(Scanner scanner) {
        System.out.println("\nPress enter to return the menu of operation...");
        scanner.nextLine();
        scanner.nextLine();
    }

    /**
     * Computes the minor of a given matrix by removing the specified row and column.
     * The minor is a smaller matrix formed by eliminating the specified row and column
     * from the original matrix.
     * @param matrix The original matrix from which the minor will be calculated.
     * @param row The row index to be removed.
     * @param column The column index to be removed.
     * @return A new matrix representing the minor after removing the specified row and column.
     */

    private static double[][] minor(double[][] matrix, int row, int column) {
        int n = matrix.length; 
        double[][] minor = new double[n - 1][n - 1];
    
        int minorRow = 0; 
        for (int i = 0; i < n; i++) {
            if (i == row) continue;
            int minorCol = 0; 
            for (int j = 0; j < n; j++) {
                if (j == column) continue; 
                if (minorRow < n - 1 && minorCol < n - 1) {
                    minor[minorRow][minorCol] = matrix[i][j]; 
                }
                minorCol++; 
            }
            minorRow++; 
        }
        return minor;
    }

    /**
     * Calculates the cofactor of a specific element in the given matrix.
     * The cofactor is calculated by multiplying the determinant of the minor matrix
     * with a sign determined by the position of the element.
     * @param matrix The original matrix from which the cofactor will be calculated.
     * @param row The row index of the element for which the cofactor is to be calculated.
     * @param col The column index of the element for which the cofactor is to be calculated.
     * @return The cofactor value for the specified element in the matrix.
     */

    public static double calculateCofactor(double[][] matrix, int row, int col) {
        double signCheck = Math.pow(-1, (row+col));
        return signCheck * calculateDeterminant(minor(matrix, row, col));
    }

    // Transpose

    /**
     * Computes the transpose of the given matrix, swapping its rows and columns.
     * In the transposed matrix, the element at position (i, j) in the original matrix
     * becomes the element at position (j, i).
     * @param matrix The original matrix to be transposed.
     * @return A new matrix representing the transposed version of the original matrix.
     */

    private static double[][] transpose(double[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        double[][] transposed = new double[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    // Determinant

    /**
     * Calculates the determinant of the given square matrix using recursion.
     * The determinant is computed based on the size of the matrix:
     * - For a 1x1 matrix, it returns the single element.
     * - For a 2x2 matrix, it calculates the determinant using the formula: ad - bc.
     * - For larger matrices, it uses cofactor expansion along the first row.
     * @param matrix The square matrix for which the determinant is to be calculated.
     * @return The determinant value of the specified matrix.
     */

    private static double calculateDeterminant(double[][] matrix) {
        int n = matrix.length;

        if (n == 1) {
            return matrix[0][0];
        }

        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        double det = 0;
        for (int i = 0; i < n; i++) {
            det += Math.pow(-1, i) * matrix[0][i] * calculateDeterminant(minor(matrix, 0, i));
        }
        return det;
    }

    // Inverse
    
    /**
     * Calculates the inverse of a given square matrix using its determinant.
     * The inverse of a matrix exists only if its determinant is non-zero.
     * For a 1x1 matrix, it returns the reciprocal of the element if it's not zero.
     * For larger matrices, it will typically require further computations 
     * (which may include finding the cofactor matrix and dividing by the determinant).
     * @param matrix The square matrix to be inverted.
     * @param det The determinant of the matrix, used to determine the existence of the inverse.
     * @return The inverse of the specified matrix, or a zero matrix if the inverse does not exist.
     */

    public static double[][] calculateInverse(double[][] matrix, double det) {
        int n = matrix.length;
        double[][] inverseMatrix = new double[n][n];

        if(n==1 && matrix[0][0] != 0) {
            inverseMatrix[0][0] = 1 / matrix[0][0];
            return inverseMatrix;
        }
        
        double[][] cofactorMatrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cofactorMatrix[i][j] = calculateCofactor(matrix, i, j);
            }
        }
    
        double[][] adjoint = transpose(cofactorMatrix);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverseMatrix[i][j] = adjoint[i][j] / det;
            }
        }
    
        return inverseMatrix;
    }

    // Matrix Multiplication

    /**
     * Multiplies two matrices provided by the user through the console.
     * This method prompts the user to enter the dimensions and elements of two matrices,
     * then calculates and returns their product if the matrices are compatible for multiplication.
     * This method continuously prompts the user to enter the dimensions and elements
     * of two matrices until the dimensions are compatible for multiplication.
     * If the number of columns in the first matrix matches the number of rows in the second matrix,
     * it proceeds to perform matrix multiplication.
     * The resulting matrix is then returned. If the dimensions do not match, it informs the user
     * and prompts again until valid dimensions are provided.
     * @param input Scanner object to read user input
     * @return A matrix representing the product of the two input matrices.
     */

    private static double[][] multiplyMatrices(Scanner input) {
        while(true){
            System.out.println("Please enter dimensions for the first matrix.");
            System.out.print("Enter number of rows for the first matrix ");
            int rows1 = getValidIntegerInput("rows", input);

            System.out.print("Enter number of columns for the first matrix ");
            int cols1 = getValidIntegerInput("columns", input);

            clearTheTerminal();

            System.out.println("Dimensions for the first matrix is ("+rows1+"x"+cols1+"). Please enter dimensions for the second matrix. ");
            System.out.print("Enter number of rows for the second matrix ");
            int rows2 = getValidIntegerInput("rows", input);

            System.out.print("Enter number of columns for the second matrix ");
            int cols2 = getValidIntegerInput("columns", input);

            clearTheTerminal();
            if (cols1 == rows2){
                double[][] matrix1 = new double[rows1][cols1];
                System.out.println("Enter elements for the first matrix:\n");
                for (int i = 0; i < rows1; i++) {
                    for (int j = 0; j < cols1; j++) {
                        System.out.print("Enter element for [" + i + "][" + j + "]: ");
                        matrix1[i][j] = getValidDoubleInput(i,j, input);
                    }
                }

                clearTheTerminal();
                double[][] matrix2 = new double[rows2][cols2];
                System.out.println("Enter elements for the second matrix:\n");
                for (int i = 0; i < rows2; i++) {
                    for (int j = 0; j < cols2; j++) {
                        System.out.print("Enter element for [" + i + "][" + j + "]: ");
                        matrix2[i][j] = getValidDoubleInput(i,j, input);
                    }
                }

                clearTheTerminal();
                System.out.println("First matrix: \n");
                printMatrix(matrix1);
                System.out.println("\nSecond matrix: \n");
                printMatrix(matrix2);

                double[][] result = new double[rows1][cols2];
        
                for (int i = 0; i < rows1; i++) {
                    for (int j = 0; j < cols2; j++) {
                        for (int k = 0; k < cols1; k++) {
                            result[i][j] += matrix1[i][k] * matrix2[k][j];
                        }
                    }
                }
                return result;

            } else{
                clearTheTerminal();
                System.out.println("Matrix dimensions do not match for multiplication.\nColumn size of the first matrix and row size of the second matrix should be same. \n");
            }
        }
    }

    // Element Wise Multiplication

    /**
     * Performs element-wise multiplication of two matrices.
     * This method multiplies each element of the first matrix with the corresponding element of the second matrix.
     * This method iterates over each element in the matrices, multiplies the corresponding elements,
     * and stores the result in a new matrix. The dimensions of the input matrices must be the same.
     * If the dimensions do not match, the behavior is undefined.
     * After multiplication, it prints both input matrices for reference.
     * @param matrix1 The first matrix for element-wise multiplication.
     * @param matrix2 The second matrix for element-wise multiplication.
     * @return A new matrix containing the product of corresponding elements of the input matrices.
     */

    private static double[][] elementWiseMultiplication(double[][] matrix1, double[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        double[][] result = new double[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] * matrix2[i][j];
            }
        }

        return result;
    }

    /**
     * Manages the matrix operations menu and prompts the user for input.
     * This method repeatedly displays a menu for various matrix operations,
     * allowing the user to choose an operation, such as addition, subtraction,
     * multiplication, or finding the determinant. Based on the user's choice,
     * it calls the appropriate methods to perform the operation.
     * The loop continues until the user decides to exit the operations menu.
     * @param input The Scanner object used for user input.
     */

    public static void matrixOperations(Scanner input) {

        while (true) {
            clearTheTerminal();
            String[] asciiArt = new String[]{
                    "_  _ ____ ___ ____ _ _  _    ____ ___  ____ ____ ____ ___ _ ____ _  _ ____ ",
                    "|\\/| |__|  |  |__/ |  \\/     |  | |__] |___ |__/ |__|  |  | |  | |\\ | [__  ",
                    "|  | |  |  |  |  \\ | _/\\_    |__| |    |___ |  \\ |  |  |  | |__| | \\| ___] "
            };
    
            for (String line : asciiArt) {
                System.out.println(line);
            }
    
            System.out.println("\n\nWith this application you can use some matrix operations.");
            int operationSelection = 0;

            System.out.println("\n1 - Transpose");
            System.out.println("2 - Determinant");
            System.out.println("3 - Inverse");
            System.out.println("4 - Matrix Multiplication");
            System.out.println("5 - Element-wise Multiplication");
            System.out.println("6 - Return to the Main Menu\n");
            System.out.print("Please choose an application: ");

            try {
                operationSelection = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error! Please enter a valid number (1-6).");
                input.next(); 
                continue;
            }

            clearTheTerminal();

            double[][] matrix;
            double[][] matrix1;
            double[][] matrix2;
            double[][] result;
            int rows;
            int columns;

            switch (operationSelection) {
                case 1:
                    // TRANSPOSE
                    System.out.println("The transpose of a matrix is formed by swapping its rows and columns, turning row indices into column indices and vice versa.\n");
                    System.out.println("==> First, we will ask for the dimensions of the matrix you want to transpose. Then, we will request the elements of the matrix with the dimensions you provided.\n\n");

                    delay();

                    System.out.print("Enter number of rows ");
                    rows = getValidIntegerInput("rows", input);
                    System.out.print("Enter number of columns ");
                    columns = getValidIntegerInput("columns", input);

                    clearTheTerminal();
                    System.out.print("The dimensions of the matrix are ("+rows+" x "+ columns +").\n\n");

                    matrix = getMatrixElements(rows, columns, input);

                    System.out.println("\nThe matrix before the transpose: \n");
                    printMatrix(matrix);

                    double[][] transposed = transpose(matrix);

                    System.out.println("\nThe matrix after the transpose: \n");
                    printMatrix(transposed);
                    pressAnyKeyToContinue(input);
                
                    break;
                case 2:
                    // DETERMINANT

                    double determinant;
                    System.out.println("The determinant is a scalar value that is a function of a square matrix, providing important information about the matrix, such as whether it is invertible.\n");
                    System.out.println("==> First, we will ask for the dimensions of the matrix. Then, we will request the elements of the matrix with the dimensions you provided.\n");
                    System.out.println("==> Note that, a square matrix is a matrix that has the same number of rows and columns, meaning it has the dimensions nxn for some integer n.\n\n");

                    delay();

                    while(true){
                        System.out.print("Enter number of rows & columns ");
                        rows = getValidIntegerInput("rows & columns", input);
                        columns = rows;

                        clearTheTerminal();
                        System.out.print("The dimensions of the matrix are ("+rows+" x "+ columns +").\n\n");
                        matrix = getMatrixElements(rows, columns, input);
                        
                        determinant = calculateDeterminant(matrix);
                        break;    
                    }

                    clearTheTerminal();

                    System.out.println("The matrix: \n");

                    printMatrix(matrix);

                    System.out.println("\nDeterminant of the given matrix is ... \n");
                    delay();

                    System.out.println(determinant);
                    pressAnyKeyToContinue(input);

                    break;
                case 3:
                    // INVERSE

                    System.out.println("The inverse of a matrix is a matrix that produces the identity matrix when multiplied with the original.\n");
                    System.out.println("==> First, we will ask for the dimensions of the matrix. Then, we will request the elements of the matrix with the dimensions you provided.\n");
                    System.out.println("==> Note that, the matrix must be square (same number of rows and columns) and have a non-zero determinant; otherwise, it is called a singular matrix, which has no inverse.\n\n");
                    double[][] inverse;

                    while(true){
                        System.out.print("Enter number of rows & columns ");
                        rows = getValidIntegerInput("rows & columns", input);
                        columns = rows;
                        clearTheTerminal();
                        System.out.print("The dimensions of the matrix are ("+rows+" x "+ columns +").\n\n");
                        matrix = getMatrixElements(rows, columns, input);
                        double det = calculateDeterminant(matrix);
                        clearTheTerminal();

                        if(rows==1 && matrix[0][0] == 0) 
                        {
                            System.out.println("The inverse does not exist for a 1x1 matrix with a value of zero.");
                        } 
                        else if (det != 0)
                        {
                            System.out.println("The matrix before the inverse: \n");
                            printMatrix(matrix);
                            inverse = calculateInverse(matrix ,det);
                            
                            System.out.println("\nThe matrix after the inverse: \n");
                            delay();

                            printMatrix(inverse);
                        } 
                        else
                        {
                            System.out.println("Matrix is singular, therefore not invertable (Determinant is zero).");
                        }
                        break;
                        
                    }
                    pressAnyKeyToContinue(input);
                    break;
                case 4:
                    // MULTIPLICATION
                
                    System.out.println("Matrix multiplication is an operation that takes two matrices and produces a new matrix."); 
                    System.out.println("This is done by multiplying the rows of the first matrix by the columns of the second matrix, following specific rules of alignment.\n");
                    System.out.println("==> First, we will ask for the dimensions of each matrix, and then we will request the elements within each matrix.\n");
                    System.out.println("==> Note that, for matrix multiplication to be valid, the number of columns in the first matrix must equal the number of rows in the second matrix.\n\n");
                    delay();

                    result = multiplyMatrices(input);

                    System.out.println("\nPerforming multiplication...");
                    delay();
                    
                    System.out.println("\nResulting Matrix: \n");
                    printMatrix(result);
                    pressAnyKeyToContinue(input);

                    break;
                case 5:
                    // ELEMENT-WISE MULTIPLICATION

                    System.out.println("Element-wise multiplication is the operation of multiplying each element of two matrices or arrays of the same size by the corresponding element in the other.\n");
                    System.out.println("==> First, we will ask for the dimensions of each matrix, and then we will request the elements within each matrix.\n\n");
                    delay();
                    int rows1;
                    int rows2;
                    int cols1;
                    int cols2;

                    while(true){
                        System.out.print("Enter number of rows for the matrices ");
                        rows1 = getValidIntegerInput("rows", input);
                        System.out.print("Enter number of columns for the matrices ");
                        cols1 = getValidIntegerInput("columns", input);
    
                        rows2 = rows1;
                        cols2 = cols1;

                        clearTheTerminal();

                        System.out.print("Dimensions for both matrices are ("+rows1+" x "+ cols1 +")\n");
                        System.out.println("Please enter corresponding elements for the first matrix.\n\n");
                        matrix1 = getMatrixElements(rows1, cols1, input);

                        clearTheTerminal();
                        System.out.println("Please enter corresponding elements for the second matrix.\n\n");
                        matrix2 = getMatrixElements(rows2, cols2, input);
                        result = elementWiseMultiplication(matrix1, matrix2);
                        break;
                    }
                    
                    clearTheTerminal();
                    System.out.println("\nFirst matrix: \n");
                    printMatrix(matrix1);
                    System.out.println("\nSecond matrix: \n");
                    printMatrix(matrix2);

                    System.out.println("\nPerforming element-wise multiplication...");
                    delay();
                    System.out.println("\nResulting Matrix: \n");
                    printMatrix(result);
                    pressAnyKeyToContinue(input);

                    break;
                case 6:
                    return; 
                default:
                    System.out.println("Please enter a valid number (1-6).");
            }
        }
    }

    /* Matrix Operations Ends Here */

    
    /* Text Encryption Starts Here */

    /**
     * This method was created to give a user the option to encrypt text, decrypt text or terminate a programme.
     * When this method is executed, it lists the operations that the user can perform and tells the user to select an option.
     * The ‘a’ option specifies the text encryption process, the ‘b’ option specifies the decryption process, and the ‘c’ option gives the option to terminate the programme.
     * Using the System.out.print method, the user is prompted to enter one of the options (a, b or c) directly.
     */

    private static void listOptions() {
        System.out.println("\nSelect an operation:");
        System.out.println(" A - Encrypt the text");
        System.out.println(" B - Decrypt the text");
        System.out.println(" C - Finish the program");
        System.out.print("\nYour option (option choice is not case-sensitive): ");
    }

    /**
     * This method encrypts or decrypts a given text by shifting the letters forward or backward by a certain offset.
     * Scrolling is only performed on letters; characters other than letters remain intact.
     * @param inpuText is the input string type representing the text to be scrolled.
     * @param scroll is an integer value of type int that specifies how many units the letters will be shifted from their ASCII values.
     * The "return transformedTextResult.toString()" statement returns the characters accumulated in the "StringBuilder" object "transformedTextResult" as a String.
     */

    private static String scrollText(String inpuText, int scroll) 
    {
        StringBuilder transformedTextResult = new StringBuilder();

        for (char chr : inpuText.toCharArray()) 
        {
            if (Character.isLetter(chr)) 
            {
                int alphabetSize = 26;
                char scrolledCh = (char)(chr + scroll);

                if (Character.isUpperCase(chr)) 
                {
                    if (scrolledCh > 'Z')
                    {
                        scrolledCh -= alphabetSize;
                    }
                    else if (scrolledCh < 'A') 
                    {
                        scrolledCh += alphabetSize;
                    }
                        
                } 
                else if (Character.isLowerCase(chr)) 
                {
                    if (scrolledCh > 'z')
                    {
                        scrolledCh -= alphabetSize;
                    } 
                    else if (scrolledCh < 'a')
                    {
                        scrolledCh += alphabetSize;
                    }
                }
                transformedTextResult.append(scrolledCh);
            } 
            else 
            {
                transformedTextResult.append(chr);
            }
        }

        return transformedTextResult.toString();
    }

    /**
     * This method provides a user-interactive interface for encrypting and decrypting text on a terminal. The user is presented with a title in ASCII and then given several options and asked to encrypt or decrypt based on the user's choice.
     * The Input Scanner type is used to receive input from the user; the parameter is passed through the main programme and is used to receive text input from the user or to select their options.
     * The asciiArt array is constructed from String elements, each line of which is a line of ASCII art.
     * The listOptions method is a menu that prompts the user to select an option.
     * The usrChoice variable receives input from the user and continues until it reaches one of the options "a", "b", or "c". The check is performed after usrChoice has been converted to lowercase and all leading and trailing spaces have been removed.
     * Encryption is performed when the user selects option "a". The scrollText method encrypts each letter by shifting it five units. If the user selects option "b", decryption is performed. This time, the scrollText method is called with a negative shift value of -5, resulting in decryption. When the user selects option "c", a message appears on the screen indicating that the program is about to exit, and the loop is terminated.
     * If the user enters an invalid option, a warning message is displayed. Furthermore, if the user does not select the 'c' option, listOptions() is called again, and the menu is displayed again. Thus, if the user wants to perform another operation, the options are easily accessible.
     * @param input scanner variable from main to receive user input
     */
    
    public static void textEncryptionDescription(Scanner input)
    {
        clearTheTerminal();

        String[] asciiArt = new String[]{
            "___ ____ _  _ ___    ____ _  _ ____ ____ _   _ ___  ___ _ ____ _  _",
            "|  |___  \\/   |     |___ |\\ | |    |__/  \\_/  |__]  |  | |  | |\\ |",
            "|  |___ _/\\_  |     |___ | \\| |___ |  \\   |   |     |  | |__| | \\|",
            "___  ____ ____ ____ _   _ ___  ___ _ ____ _  _",
            "|  \\ |___ |    |__/  \\_/  |__]  |  | |  | |\\ |",
            "|__/ |___ |___ |  \\   |   |     |  | |__| | \\|",
            };
            for (String line : asciiArt) {
                System.out.println(line);
            }

        listOptions();

        if (input.hasNextLine()) 
        {
            input.nextLine();
        }

        String usrChoice;

        do {
            usrChoice = input.nextLine().trim().toLowerCase();
            if(usrChoice.equals("a"))
            {
                System.out.println("\nText for encryption: ");
                String encryptedText = scrollText(input.nextLine(), 5);
                System.out.println("After encryption, the output is: " + encryptedText);
            }
            
            else if(usrChoice.equals("b")) 
            {
                System.out.println("\nText for decryption: ");
                String decryptedText = scrollText(input.nextLine(), -5);
                System.out.println("After decryption, the output is: " + decryptedText);
            }

            else if(usrChoice.equals("c")) 
            { 
                System.out.println("Program is coming to a close...");
            }

            else
            { 
                System.out.println("Please select again because your previous selection was invalid.");
            }

            if (!usrChoice.equals("c"))
            {
                listOptions();
            }
        } while (!usrChoice.equals("c"));
    }
    

    /* Text Encryption Ends Here */

    /* Tic Tac Toe Starts Here */

    /**
     * Checks the tic-tac-toe board matrix for a winning condition both vertically and horizontally.
     * Iterates through the columns and rows of the given matrix to calculate the sum of elements
     * vertically and horizontally. If the sum matches a specific winning condition (12 or 15),
     * returns true. Otherwise, returns false.
     * @param matrix it's an integer matrix created for the tic-tac-toe game
     * @return returns boolean value after checking matrix vertically and horizontally
     */

    public static boolean checkVerticallyAndHorizontally(int[][] matrix)
    {
        for (int col = 0; col < 3; col++) 
        {
            int verticalTotal = 0;
            int horizontalTotal = 0;

            for (int row = 0; row < 3; row++) 
            {
                verticalTotal += matrix[row][col];
                horizontalTotal += matrix[col][row];
            }

            if (verticalTotal == 12 || verticalTotal == 15 || horizontalTotal == 12 || verticalTotal == 15) 
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks the tic-tac-toe board matrix for a winning condition diagonally.
     * Iterates through the diagonals of the given matrix to calculate the sum of elements.
     * If the sum matches a specific winning condition (12 or 15), returns true. 
     * Otherwise, returns false.
     * @param matrix it's an integer matrix created for the tic-tac-toe game
     * @return returns boolean value after checking matrix diagonally
     */
    
    public static boolean checkDiagonally(int[][] matrix)
    {
        int diagonalOne = 0;
        int diagonalTwo = 0;

        for(int i = 0; i < 3; i++)
        {
            diagonalOne += matrix[i][i];
        }

        for(int j = 0; j < 3; j++)
        {
            diagonalTwo += matrix[j][2 - j];
        }

        if(diagonalOne == 12 || diagonalOne == 15 || diagonalTwo == 12 || diagonalTwo == 15)
        {
            return true;
        }

        return false;
    }

    /**
     * If returns true, one of the player won the game.
     * @param matrix it's an integer matrix created for the tictactoe game
     * @return returns boolean value after checking matrix vertically and horizontally and diagonally with if condition and methods
     */

    public static boolean checkForWin(int[][] matrix)
    {
        return checkVerticallyAndHorizontally(matrix) || checkDiagonally(matrix);
    }

    /**
     * Prints the tic-tac-toe board matrix to the console.
     * Iterates through the given matrix and prints different symbols based on the cell value:
     * '.' for 0, 'X' for 4, and 'O' for 5.
     * @param matrix it's an integer matrix created for the tic-tac-toe game
     */

    public static void printMatrix(int[][] matrix)
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(matrix[i][j] == 0)
                {
                    System.out.print(". ");
                }
                else if(matrix[i][j] == 4)
                {
                    System.out.print("X ");
                }
                else if(matrix[i][j] == 5)
                {
                    System.out.print("O ");
                }
            }
            System.out.print("\n");
        }

        System.out.print("\n");
    }

    /**
     * Fills the tic-tac-toe board matrix at the specified position for a given player.
     * Checks the specified position in the matrix to see if it is empty (0). If empty, 
     * fills it with the player's value (4 or 5) and returns true. If the position is not 
     * empty, prints an error message and returns false.
     * @param matrix it's an integer matrix created for the tic-tac-toe game
     * @param position it's the position where the user wants to make a move (1-9)
     * @param player it's the integer variable representing the player who will make the move (4 or 5)
     * @return returns a boolean value indicating whether the move was successful
     */

    public static boolean fillTheMatrix(int[][] matrix, int position, int player) {
        switch (position) {
            case 1:
                if (matrix[0][0] == 0) {
                    matrix[0][0] = player;
                    return true;
                }
                break;
            case 2:
                if (matrix[0][1] == 0) {
                    matrix[0][1] = player;
                    return true;
                }
                break;
            case 3:
                if (matrix[0][2] == 0) {
                    matrix[0][2] = player;
                    return true;
                }
                break;
            case 4:
                if (matrix[1][0] == 0) {
                    matrix[1][0] = player;
                    return true;
                }
                break;
            case 5:
                if (matrix[1][1] == 0) {
                    matrix[1][1] = player;
                    return true;
                }
                break;
            case 6:
                if (matrix[1][2] == 0) {
                    matrix[1][2] = player;
                    return true;
                }
                break;
            case 7:
                if (matrix[2][0] == 0) {
                    matrix[2][0] = player;
                    return true;
                }
                break;
            case 8:
                if (matrix[2][1] == 0) {
                    matrix[2][1] = player;
                    return true;
                }
                break;
            case 9:
                if (matrix[2][2] == 0) {
                    matrix[2][2] = player;
                    return true;
                }
                break;
            default:
                System.out.println("Invalid position. Please choose a number between 1 and 9.");
                return false;
        }
    
        System.out.println("The position is not empty. Please choose another position!");
        return false;
    }

    /**
     * LOGIC OF OUR TICTACTOE:
     * The player X represents integer 4. And player O represents integer 5.
     * We wanted to mathematically calculate the winning control of the game by filling the 3x3 matrix we created with 0s.
     * If you place the values ​​4 and 5 in an integer 3x3 matrix, in the checks made for tictactoe (which is done by adding the horizontal, vertical or diagonal elements); 
     * if a player has won, you will not find any other value than 12 for X (i.e. 4) and 15 for O (i.e. 5).
     * This game was created using this logic.
     * Within the method, after the game is presented with ASCII Art, a 3x3 int matrix is ​​created, which is filled with 0s.
     * Then, the 4 integers representing player X are defined with the variable named currentPlayer.
     * The user is asked to select a position and the valid position check is done in the loop.
     * If the user has chosen a valid position, the winner is checked after each loop with the checkForWin method, and if there is no winner, the currentPlayer changes (if it is 4 it becomes 5, if it is 5 it becomes 4).
     * At each stage the matrix is ​​suppressed and if there is a winner the game ends with the winner being announced on the console.
     * @param input scanner variable from main to receive user input
     */
    
    public static void ticTacToe(Scanner input) {
        clearTheTerminal();
    
        String[] asciiArt = {
            "                                                ",
            "___ _ ____    ___ ____ ____    ___ ____ ____    ",
            " |  | |    __  |  |__| |    __  |  |  | |___    ",
            " |  | |___     |  |  | |___     |  |__| |___    ",
            "                                                ",
        };
    
        for (String line : asciiArt) {
            System.out.println(line);
        }
    
        System.out.println("\n\nIt's a classical Tic-Tac-Toe game.");
        System.out.println("\nHow to play Tic-Tac-Toe?");
        System.out.println("Tic-Tac-Toe is a simple two-player game played on a 3x3 grid. \nThe players take turns marking a cell in the grid with their symbol: \"X\" for one player and \"O\" for the other. \nThe goal is to be the first player to get three of their symbols in a row, either horizontally, vertically, or diagonally.\n");
    
        int[][] matrix = new int[3][3];
    
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                matrix[i][j] = 0;
            }
        }
    
        int currentPlayer = 4; // Start with player X
        int drawControl = 0;
        boolean gameWon = false;
    
        System.out.println("Select one of the empty positions 1 to 9 (empty positions are indicated by '.' ). X will start the game.\n");
    
        do 
        {
            System.out.println("1 2 3\n4 5 6\n7 8 9\n");
            printMatrix(matrix);
    
            boolean validPosition = false;
            int position = 0;
    
            do 
            {
                System.out.print("Player " + (currentPlayer == 4 ? "X" : "O") + ", choose your position: ");
    
                try 
                {
                    position = input.nextInt();
                    System.out.print("\n");
                    validPosition = fillTheMatrix(matrix, position, currentPlayer);
                    if(validPosition)
                    {
                        drawControl++;
                    }
                } 
                catch (InputMismatchException e) 
                {
                    System.out.println("\nInvalid input! Please enter a number between 1 and 9.");
                    input.nextLine();
                }
            } while (!validPosition);
    
            // Check if the game is won
            gameWon = checkForWin(matrix);

            if (gameWon) {
                System.out.println("Player " + (currentPlayer == 4 ? "X" : "O") + " wins!\n");
                break;
            }

            if(!gameWon && drawControl == 9)
            {
                System.out.println("Draw!\n");
                break;
            }
    
            // Switch player
            currentPlayer = (currentPlayer == 4) ? 5 : 4;
    
        } while (!gameWon);
    
        printMatrix(matrix);
        System.out.print("Game over!\n");
    }
    
    /* Tic Tac Toe Ends Here */

    
    /* Common Methods Starts Here */

    /**
     * Shows the user the application's welcome message and instructions.
     * This method calls a method using ASCII art.
     * Shows a message explaining which applications the user can use.
     */

    public static void welcomeToApp()
    {
        asciiArt();

        System.out.println("THERE ARE SOME APPLICATIONS ON THIS PROGRAM. PLEASE CHOOSE AN APPLICATION THAT YOU WANT TO USE.\n");
        System.out.println("Please just enter the letters that will be accepted (A - E / a - e). Do not use any other letter, numbers or special characters.\n");
    }

    /**
     * Prints an ASCII art to the console.
     * 
     * The method contains a string array with multiple lines of ASCII art and 
     * iterates through the array to print each line to the console.
     */

    public static void asciiArt()
    {
        String[] asciiArt = {
                "                                                                                                                                                                                  ",
                "                                                                                                                                                                                  ",
                "                                                                                                                                                                                  ",
                " ██████╗███╗   ███╗██████╗ ███████╗    ██████╗ ██╗  ██╗██████╗             ",
                "██╔════╝████╗ ████║██╔══██╗██╔════╝    ╚════██╗██║  ██║╚════██╗            ",
                "██║     ██╔████╔██║██████╔╝█████╗       █████╔╝███████║ █████╔╝            ",
                "██║     ██║╚██╔╝██║██╔═══╝ ██╔══╝       ╚═══██╗╚════██║ ╚═══██╗            ",
                "╚██████╗██║ ╚═╝ ██║██║     ███████╗    ██████╔╝     ██║██████╔╝            ",
                " ╚═════╝╚═╝     ╚═╝╚═╝     ╚══════╝    ╚═════╝      ╚═╝╚═════╝             ",
                "                                                                            ",
                "██████╗ ██████╗  ██████╗      ██╗███████╗ ██████╗████████╗     ██╗ ██╗  ██╗",
                "██╔══██╗██╔══██╗██╔═══██╗     ██║██╔════╝██╔════╝╚══██╔══╝    ████████╗███║",
                "██████╔╝██████╔╝██║   ██║     ██║█████╗  ██║        ██║       ╚██╔═██╔╝╚██║",
                "██╔═══╝ ██╔══██╗██║   ██║██   ██║██╔══╝  ██║        ██║       ████████╗ ██║",
                "██║     ██║  ██║╚██████╔╝╚█████╔╝███████╗╚██████╗   ██║       ╚██╔═██╔╝ ██║",
                "╚═╝     ╚═╝  ╚═╝ ╚═════╝  ╚════╝ ╚══════╝ ╚═════╝   ╚═╝        ╚═╝ ╚═╝  ╚═╝",

            "    _                                          ___                 _            _  _                       _  _   _                _                _                  __  _     __  ",
            "   /_\\    ___  _  _   _ __    __ _   _ _      / __|  __ _   __ _  | |  __ _    | || |  ___   _ __   _  _  (_)(_) | |__  ___  ___  | |  ___   _ _   | |  ___   _ _     / / | |    \\ \\ ",
            "  / _ \\  (_-< | || | | '  \\  / _` | | ' \\    | (__  / _` | / _` | | | / _` |   | __ | / -_) | '_ \\ | || | | || | | / / (_-< / -_) | | / -_) | ' \\  | | / -_) | '_|   | |  | |__   | |",
            " /_/ \\_\\ /__/  \\_,_| |_|_|_| \\__,_| |_|_||_|  \\___| \\__,_| \\__, | |_| \\__,_|   |_||_| \\___| | .__/  \\_, | \\_,_| |_/\\_\\ /__/ \\___| |_| \\___| |_||_| |_| \\___| |_|     | |  |____|  | |",
            " | _ )  __ _   _ _  (_)  ___    / __|  __ _   _ _       /_\\|___/__ | |  __ _   _ _          |_|     |__/                                                              \\_\\        /_/ ",
            " | _ \\ / _` | | '_| | | (_-<   | (__  / _` | | ' \\     / _ \\  (_-< | | / _` | | ' \\                                                                                                 ",
            " |___/ \\__,_| |_|   |_| /__/    \\___| \\__,_| |_||_|   /_/ \\_\\ /__/ |_| \\__,_| |_||_|                                                                                                 ",
            " | __| (_)  __ _   ___   _ _     |   \\   ___   _ __   (_)  _ _                                                                                                                        ",
            " | _|  | | / _` | / -_) | ' \\    | |) | / -_) | '  \\  | | | '_|                                                                                                                       ",
            " |_| _ |_| \\__, | \\___| |_||_|   |___/__\\___| |_|_|_| |_| |_|              ___          _          _                                                                                 ",
            " | || |  __|___/ |_  (_)  __   ___    \\ \\ / /  __ _   _ _   ___   _ _     | _ )  _  _  | |  _  _  | |_                                                                                ",
            " | __ | / _` | |  _| | | / _| / -_)    \\ V /  / _` | | '_| / -_) | ' \\    | _ \\ | || | | | | || | |  _|                                                                              ",
            " |_||_| \\__,_|  \\__| |_| \\__| \\___|  __ |_|   \\__,_|_|_|   \\___| |_||_|   |___/  \\_,_| |_|  \\_,_|  \\__|_         _            _                                                       ",
            " |  \\/  |  _  _   ___ | |_   __ _   / _|  __ _     / _ \\   __ _   _  _   ___ | |_    __ _   _ _     | __|  _ _  | |__  _  _  | |_                                                     ",
            " | |\\/| | | || | (_-< |  _| / _` | |  _| / _` |   | (_) | / _` | | || | |_ / | ' \\  / _` | | ' \\    | _|  | '_| | / / | || | |  _|                                                    ",
            " |_|__|_|  \\_,_| /__/  \\__| \\__,_|_|_|   \\__,_|    \\___/  \\__, |  \\_,_| /__| |_||_| \\__,_| |_||_|   |___| |_|   |_/\\_\\ \\_,_|  \\__|                                                    ",
            " |_  / (_)  ___  __ _   _ _     |_   _|  _  _   _ _    __ | ___/ | | (_)                                                                                                              ",
            "  / /  | | (_-< / _` | | ' \\      | |   | || | | ' \\  / _| / -_) | | | |                                                                                                              ",
            " /___| |_| /__/ \\__,_| |_||_|     |_|    \\_,_| |_||_| \\__| \\___| |_| |_|                                                                                                              ",
            "                                                                                                                                                                                  ",
            "                                                                                                                                                                                  ",
            "                                                                                                                                                                                 ",
        };

        for (String line : asciiArt) {
            System.out.println(line);
        }
    }

    /**
     * Prompts the user to decide whether to return to the main menu or not.
     * Continuously asks the user for input until a valid response ('Y' or 'N') is provided.
     * If the user selects 'Y', the method calls the welcomeToApp() method to return to the main menu 
     * and returns true. If the user selects 'N', the method returns false. For any other input, 
     * an error message is displayed and the user is prompted again.
     * @param input scanner variable from main to receive user input
     * @return boolean value indicating whether the user wants to return to the main menu
     */

    public static boolean returnMainMenu(Scanner input)
    {
        char mainMenuSelection = ' ';
        
        do
        {
            System.out.print("\nDo you want to return to the main menu (Y-N): ");
            String mainMenuStr = input.next();

            if(mainMenuStr.length() == 1)
            {
                mainMenuSelection = mainMenuStr.charAt(0);

                switch(mainMenuSelection)
                {
                    case 'Y':
                        return true;
                    case 'N':
                        return false;
                    default:
                        System.out.println("\nInvalid input. Please enter a valid character (Y or N).\n");
                }
            }
            else
            {
                System.out.println("\nInvalid input. Please enter a valid character (Y or N).\n");
                mainMenuSelection = ' ';
            }

        } while(mainMenuSelection != 'Y' || mainMenuSelection == 'N');

        return false; // Dummy
    }

    /**
     * Pauses the execution of the current thread for a specified duration.
     * 
     * This method puts the current thread to sleep for 2000 milliseconds (2 seconds).
     * If the thread is interrupted during sleep, it catches the InterruptedException
     * and prints the stack trace.
     */

    public static void delay()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Clears the terminal screen based on the operating system.
     * 
     * This method checks the operating system and uses the appropriate command 
     * to clear the terminal screen. For Windows, it uses "cls", and for other 
     * operating systems (assumed to be Unix-like), it uses "clear". If an 
     * exception occurs during this process, the stack trace is printed.
     */

    public static void clearTheTerminal()
    {
        try 
        {
            String operatingSystem = System.getProperty("os.name").toLowerCase();

            if (operatingSystem.contains("win")) 
            {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else
            {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    /* Common Methods Ends Here */

    /**
     * The main method that serves as the entry point for the application.
     * This method initializes a Scanner object for user input and presents a menu with 
     * several application options:
     * - A: Statistical Information About an Array
     * - B: Matrix Operations
     * - C: Text Encryption / Decryption
     * - D: Tic-tac-toe HotSeat
     * - E: Terminate (Quit)
     * Based on the user's selection, the corresponding application is executed, and the 
     * user is asked if they want to return to the main menu after each operation. The 
     * application runs in a loop until the user chooses to terminate (option E).
     * @param args the command line arguments
     */

    public static void main(String[] args)
    {        
        Scanner input = new Scanner(System.in);
        char selection = ' ';
        
        do 
        {
            welcomeToApp();
            System.out.println("A - Statistical Information About an Array");
            System.out.println("B - Matrix Operations");
            System.out.println("C - Text Encryption / Decryption");
            System.out.println("D - Tic-tac-toe HotSeat");
            System.out.println("E - Terminate (Quit)\n");

            System.out.print("Please choose an operation (operation choice is not case-sensitive): ");
            String userInput = input.next();

            if (userInput.length() == 1) 
            {
                selection = userInput.charAt(0);

                switch (selection) 
                {
                    case 'A':
                    case 'a':
                        System.out.println("\nYou are redirected to Statistical Information About an Array Operation...\n");
                        delay();
                        statInfoAboutArray(input);
                        if(!returnMainMenu(input))
                        {
                            selection = 'E';
                            break;
                        }
                        else
                        {
                            clearTheTerminal();
                            selection = ' ';
                            continue;
                        }
                    case 'B':
                    case 'b':
                        System.out.println("\nYou are redirected to Matrix Operations...\n");
                        delay();
                        matrixOperations(input);
                        if(!returnMainMenu(input))
                        {
                            selection = 'E';
                            break;
                        }
                        else
                        {
                            clearTheTerminal();
                            selection = ' ';
                            continue;
                        }
                    case 'C':
                    case 'c':
                        System.out.println("\nYou are redirected to Text Encryption / Decryption Operation...\n");
                        delay();
                        textEncryptionDescription(input);
                        if(!returnMainMenu(input))
                        {
                            selection = 'E';
                            break;
                        }
                        else
                        {
                            clearTheTerminal();
                            selection = ' ';
                            continue;
                        }
                    case 'D':
                    case 'd':
                        System.out.println("\nYou are redirected to Tic-tac-toe HotSeat Operation...\n");
                        delay();
                        ticTacToe(input);
                        if(!returnMainMenu(input))
                        {
                            selection = 'E';
                            break;
                        }
                        else
                        {
                            clearTheTerminal();
                            selection = ' ';
                            continue;
                        }
                    case 'E':
                    case 'e':
                        System.out.println("\nTerminating the application...");
                        delay();
                        break;
                    default:
                        System.out.println("\nYou entered an unaccepted character. Please try again!\n");
                        delay();
                }
            } 
            else 
            {
                System.out.println("\nPlease enter only one character.\n");
                selection = ' ';
            }

        } while (selection != 'E' && selection != 'e');

        input.close();
    }
}
