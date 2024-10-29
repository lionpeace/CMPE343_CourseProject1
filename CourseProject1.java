// COURSE PROJECT #1 - GROUP 6

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


public class CourseProject1 {

    /* Statistical Information About an Array Starts Here */

    public static double FindMedian(double[] array)
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

    public static double FindArithmeticMean(double[] array)
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

    public static double FindGeometricMean(double[] array)
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

    public static double FindHarmonicMean(double[] array, int i)
    {
        if(i == 0)
        {
            return 1 / array[0];
        }

        return (1 / array[i]) + FindHarmonicMean(array, i - 1);
    }

    public static void StatInfoAboutArray(Scanner input)
    {
        ClearTheTerminal();

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

        for(int a = 0; a < sizeOfArray; a++)
        {
            System.out.printf("\nYour number %d is %.2f.", a + 1, array[a]);
        }

        double median = FindMedian(array);
        double arithmeticMean = FindArithmeticMean(array);
        double geometricMean = FindGeometricMean(array);
        double harmonicMean = sizeOfArray / FindHarmonicMean(array, sizeOfArray - 1);

        System.out.printf("\n\nThe median of the array is: %.2f", median);
        System.out.printf("\n\nThe arithmetic mean of the array is: %.2f", arithmeticMean);
        System.out.printf("\n\nThe geometric mean of the array is: %.2f", geometricMean);
        System.out.printf("\n\nThe harmonic mean of the array is: %.2f\n\n", harmonicMean);
    }

    /* Statistical Information About an Array Ends Here */


    /* Matrix Operations Starts Here */
    
    // Satır ve sütun boyutları positive integer olmalı. Kullanıcıdan dimension alırken bu kontrolü yapması için metod:
    private static int getValidIntegerInput(String text) {
        Scanner scanner = new Scanner(System.in);
        int input = -1; 
        while (true) {
            System.out.print("(positive integer): ");
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input > 0) {
                    break;
                } else {
                    ClearTheTerminal();
                    System.out.println("Error!! Number of "+ text +" must be bigger than zero. Please re-enter "+text+".");
                }
            } else {
                ClearTheTerminal();
                System.out.println("Error!! Number of "+ text +" must be an integer and a numeric value. Please re-enter "+text+".");
                scanner.next(); 
            }
        }
        return input;
    }

    // Matrix elementleri double değer veya numeric bir değer olmalı. Bu kontrolü sağlaması için metod:
    private static double getValidDoubleInput(int i, int j) {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextDouble()) {
            ClearTheTerminal();
            System.out.println("Error!! Input must be a numeric value (use comma for double values).");
            Delay();
            System.out.println("\nPlease re-enter the value for element ["+i+"]["+j+"]:");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    // Rows, columns değerlerini parametre olarak alır. Ardından matris elementlerini getValidDoubleInput metodunu çağırarak alır.
    private static double[][] getMatrixElements(int rows, int columns) {

        double[][] matrix = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.println("Enter element for [" + i + "][" + j + "]:");
                matrix[i][j] = getValidDoubleInput(i, j);
            }
        }
        return matrix;
    }

    // Singularity kontrolü yapar (determinant == 0) (Inverse işlemi için gerekli)
    private static boolean isSingular(double[][] matrix) {
        double determinant = calculateDeterminant(matrix);
        return determinant == 0;
    }

    private static double[][] minor(double[][] matrix, int row, int column) {
        int n = matrix.length;
        double[][] minor = new double[n - 1][n - 1];
        
        int minorRow = 0;
        int minorCol = 0;
        for (int i = 0; i < n; i++) {
            if (i == row) continue;
            minorCol = 0;
            for (int j = 0; j < n; j++) {
                if (j == column) continue;
                minor[minorRow][minorCol] = matrix[i][j];
                minorCol++;
            }
            minorRow++;
        }
        return minor;
    }

    public static double calculateCofactor(double[][] matrix, int row, int col) {
        double signCheck = Math.pow(-1, (row+col));
        return signCheck * calculateDeterminant( minor(matrix, row, col) );
    }

    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%.2f ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void pressAnyKeyToContinue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPress enter to continue...");
        scanner.nextLine();
        ClearTheTerminal();
    }


    // Main operations:
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

    private static double calculateDeterminant(double[][] matrix) {
        int n = matrix.length;

        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        double det = 0;
        for (int i = 0; i < n; i++) {
            det += Math.pow(-1, i) * matrix[0][i] * calculateDeterminant(minor(matrix, 0, i));
        }
        return det;
    }
    
    private static double[][] calculateInverse(double[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        double[][] inverseMatrix = new double[columns][rows];

        double det = calculateDeterminant(matrix);
        //double[][] adj = matrixAdjoint(matrix);
        double scalar = (1/det);
        //inverseMatrix = scalarMultiplication(adj, scalar);

        return inverseMatrix;
    }

    private static double[][] multiplyMatrices() {

        while(true){
            System.out.println("Please enter dimensions for the first matrix.");
            System.out.print("Enter number of rows for the first matrix ");
            int rows1 = getValidIntegerInput("rows");

            System.out.print("Enter number of columns for the first matrix ");
            int cols1 = getValidIntegerInput("columns");

            ClearTheTerminal();

            System.out.println("Dimensions for the first matrix is ("+rows1+"x"+cols1+"). Please enter dimensions for the second matrix. ");
            System.out.print("Enter number of rows for the second matrix ");
            int rows2 = getValidIntegerInput("rows");

            System.out.print("Enter number of columns for the second matrix ");
            int cols2 = getValidIntegerInput("columns");

            ClearTheTerminal();
            if (cols1 == rows2){
                double[][] matrix1 = new double[rows1][cols1];
                System.out.println("Enter elements for the first matrix :");
                for (int i = 0; i < rows1; i++) {
                    for (int j = 0; j < cols1; j++) {
                        System.out.println("Enter element for [" + i + "][" + j + "]");
                        matrix1[i][j] = getValidDoubleInput(i,j);
                    }
                }

                ClearTheTerminal();
                double[][] matrix2 = new double[rows2][cols2];
                System.out.println("Enter elements for the second matrix :");
                for (int i = 0; i < rows2; i++) {
                    for (int j = 0; j < cols2; j++) {
                        System.out.println("Enter element for [" + i + "][" + j + "]");
                        matrix2[i][j] = getValidDoubleInput(i,j);
                    }
                }
                
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
                ClearTheTerminal();
                System.out.println("Matrix dimensions do not match for multiplication.\nColumn size of the first matrix and row size of the second matrix should be same. \n");
            }
        }
    }

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

        
    public static void matrixOperations(Scanner var0) {

        ClearTheTerminal();
        String[] var1 = new String[]{
                "_  _ ____ ___ ____ _ _  _    ____ ___  ____ ____ ____ ___ _ ____ _  _ ____ ",
                "|\\/| |__|  |  |__/ |  \\/     |  | |__] |___ |__/ |__|  |  | |  | |\\ | [__  ",
                "|  | |  |  |  |  \\ | _/\\_    |__| |    |___ |  \\ |  |  |  | |__| | \\| ___] "
        };

        for (String line : var1) {
            System.out.println(line);
        }

        System.out.println("\n\nWith this application you can use some matrix operations.");

        while (true) {
            int operationSelection = 0;

            // Seçim Menüsü
            System.out.println("\n1 - Transpose");
            System.out.println("2 - Determinant");
            System.out.println("3 - Inverse");
            System.out.println("4 - Matrix Multiplication");
            System.out.println("5 - Element-wise Multiplication");
            System.out.println("6 - Return to the Main Menu\n");
            System.out.print("Please choose an application: ");

            try {
                operationSelection = var0.nextInt();
            } catch (InputMismatchException e) {
                ClearTheTerminal();
                System.out.println("Error! Please enter a valid number (1-6).");
                var0.next(); 
                continue;
            }

            ClearTheTerminal();

            double[][] matrix;
            double[][] matrix1;
            double[][] matrix2;
            double[][] result;
            int rows;
            int columns;

            switch (operationSelection) {
                case 1:
                    // TRANSPOSE

                    System.out.println("The transpose of a matrix is formed by swapping its rows and columns, turning row indices into column indices and vice versa.");
                    System.out.println("First, we will ask for the dimensions of the matrix you want to transpose. Then, we will request the elements of the matrix with the dimensions you provided.\n\n");

                    Delay();

                    System.out.print("Enter number of rows ");
                    rows = getValidIntegerInput("rows");
                    System.out.print("Enter number of columns ");
                    columns = getValidIntegerInput("columns");

                    ClearTheTerminal();
                    System.out.print("The dimensions of the matrix are ("+rows+" x "+ columns +").\n\n");

                    matrix = getMatrixElements(rows, columns);
                    double[][] transposed = transpose(matrix);

                    ClearTheTerminal();

                    System.out.println("Transpose of the given matrix is ... \n");
                    Delay();

                    printMatrix(transposed);
                    pressAnyKeyToContinue();
                
                    break;
                case 2:
                    // DETERMINANT

                    double determinant;

                    System.out.println("The determinant is a scalar value that is a function of a square matrix, providing important information about the matrix, such as whether it is invertible.");
                    System.out.println("First, we will ask for the dimensions of the matrix you want to transpose. Then, we will request the elements of the matrix with the dimensions you provided.\n\n");
                    System.out.println("Note that, a square matrix is a matrix that has the same number of rows and columns, meaning it has the dimensions nxn for some integer n.\n\n");

                    Delay();

                    while(true){
                        System.out.print("Enter number of rows ");
                        rows = getValidIntegerInput("rows");
                        System.out.print("Enter number of columns ");
                        columns = getValidIntegerInput("columns");
                        if (rows == columns){
                            ClearTheTerminal();
                            System.out.print("The dimensions of the matrix are ("+rows+" x "+ columns +").\n\n");
                            matrix = getMatrixElements(rows, columns);
                            determinant = calculateDeterminant(matrix);
                            break;
                        }
                        else{
                            ClearTheTerminal();
                            System.out.println("Error!! Number of rows and columns should be same in order matrix to be square matrix. Please re-enter sizes.\n");
                        }
                    }

                    ClearTheTerminal();

                    System.out.println("Determinant of the given matrix is ... \n");
                    Delay();

                    System.out.println(determinant);
                    pressAnyKeyToContinue();

                    break;
                case 3:
                    // INVERSE

                    double[][] inverse;
                    while(true){
                        System.out.print("Enter number of rows ");
                        rows = getValidIntegerInput("rows");
                        System.out.print("Enter number of columns ");
                        columns = getValidIntegerInput("columns");
                        if (rows == columns){
                            matrix = getMatrixElements(rows, columns);
                            inverse = calculateInverse(matrix);
                            break;
                        }
                        else{
                            ClearTheTerminal();
                            System.out.println("rows and columns should be same in order matrix to be square matrix. Please re-enter sizes");
                        }
                    }
                    ClearTheTerminal();

                    System.out.println("Inverse of the given matrix is ... \n");
                    Delay();

                    printMatrix(inverse);
                    pressAnyKeyToContinue();

                    break;
                case 4:
                    // MULTIPLICATION
                
                    System.out.println("Matrix multiplication is an operation that takes two matrices and produces a new matrix by multiplying the rows of the first matrix by the columns of the second matrix,\nfollowing specific rules of alignment.");
                    System.out.println("First, we will ask for the dimensions of each matrix, and then we will request the elements within each matrix.\n");
                    System.out.println("Note that, for matrix multiplication to be valid, the number of columns in the first matrix must equal the number of rows in the second matrix.\n\n");
                    Delay();

                    result = multiplyMatrices();

                    ClearTheTerminal();

                    System.out.println("Performing multiplication. Resulting matrix is ... \n");
                    Delay();

                    printMatrix(result);
                    pressAnyKeyToContinue();

                    break;
                case 5:
                    // ELEMENT-WISE MULTIPLICATION

                    System.out.println("Element-wise multiplication is the operation of multiplying each element of two matrices or arrays of the same size by the corresponding element in the other.");
                    System.out.println("First, we will ask for the dimensions of each matrix, and then we will request the elements within each matrix.\n\n");
                    Delay();
                    int rows1;
                    int rows2;
                    int cols1;
                    int cols2;

                    while(true){
                        System.out.print("Enter number of rows for the first matrix\n");
                        rows1 = getValidIntegerInput("rows");
                        System.out.print("Enter number of columns for the second matrix:\n");
                        cols1 = getValidIntegerInput("columns");
    
                        System.out.print("\nEnter number of rows for the second matrix\n");
                        rows2 = getValidIntegerInput("rows");
                        System.out.print("Enter number of rows for the second matrix\n");
                        cols2 = getValidIntegerInput("columns");

                        ClearTheTerminal();

                        if(rows1 == rows2 && cols1 == cols2){
                            System.out.print("Dimensions for both matrices are ("+rows1+" x "+ cols1 +")\n");
                            System.out.println("Please enter corresponding elements for the first matrix.\n\n");
                            matrix1 = getMatrixElements(rows1, cols1);

                            ClearTheTerminal();
                            System.out.println("Please enter corresponding elements for the second matrix.\n\n");
                            matrix2 = getMatrixElements(rows2, cols2);
                            result = elementWiseMultiplication(matrix1, matrix2);
                            break;
                        } else{
                            ClearTheTerminal();
                            System.out.println("Matrices must have the same size to operate element wise multiplication.\nPlease re-enter dimensions.\n");
                        }
                    }
                
                    ClearTheTerminal();
                    System.out.println("Performing element-wise multiplication...\n\n");
                    Delay();

                    printMatrix(result);
                    pressAnyKeyToContinue();

                    break;
                case 6:
                    System.out.println("Returning to the Main Menu...");

                    return; 
                default:
                    System.out.println("Please enter a valid number (1-6).");
            }
        }
    }



    
    /* Matrix Operations Ends Here */


    public static void TextEncryptionDescription(Scanner input)
    {
        ClearTheTerminal();
        
        System.out.println("Welcome to Text Encrytion");
    }


    /* Tic Tac Toe Starts Here */

    public static boolean CheckVerticallyAndHorizontally(int[][] matrix)
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

    public static boolean CheckDiagonally(int[][] matrix)
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

    public static boolean CheckForWin(int[][] matrix)
    {
        if(CheckVerticallyAndHorizontally(matrix) || CheckDiagonally(matrix))
        {
            return true;
        }
        return false;
    }

    public static void PrintMatrix(int[][] matrix)
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

        System.out.print("\n\n");
    }

    public static boolean FillTheMatrix(int[][] matrix, int position, int player) {
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
    
    public static void TicTacToe(Scanner input) {
        ClearTheTerminal();
    
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
        boolean gameWon = false;
    
        System.out.println("Select one of the empty positions 1 to 9 (empty positions are indicated by '.' ). X will start the game.\n");
    
        do 
        {
            System.out.println("1 2 3\n4 5 6\n7 8 9\n");
            PrintMatrix(matrix);
    
            boolean validPosition = false;
            int position = 0;
    
            do 
            {
                System.out.print("Player " + (currentPlayer == 4 ? "X" : "O") + ", choose your position: ");
    
                try 
                {
                    position = input.nextInt();
                    System.out.print("\n");
                    validPosition = FillTheMatrix(matrix, position, currentPlayer);
                } 
                catch (InputMismatchException e) 
                {
                    System.out.println("Invalid input! Please enter a number between 1 and 9.");
                    input.nextLine();
                }
            } while (!validPosition);
    
            // Check if the game is won
            gameWon = CheckForWin(matrix);
            if (gameWon) {
                System.out.println("Player " + (currentPlayer == 4 ? "X" : "O") + " wins!");
                break;
            }
    
            // Switch player
            currentPlayer = (currentPlayer == 4) ? 5 : 4;
    
        } while (!gameWon);
    
        PrintMatrix(matrix);
        System.out.println("Game over!");
    }
    
    /* Tic Tac Toe Ends Here */

    
    /* Common Methods Starts Here */

    public static void WelcomeToApp()
    {
        String[] asciiArt = AsciiArt(2);

        for (String line : asciiArt) {
            System.out.println(line);
        }

        System.out.println("THERE ARE SOME APPLICATIONS ON THIS PROGRAM. PLEASE CHOOSE AN APPLICATION THAT YOU WANT TO USE.\n");
        System.out.println("Please just enter the letters that will be accepted (A - E). Do not use any other letter, numbers or special characters.\n");
    }

    public static String[] AsciiArt(int x)
    {
        if(x == 1)
        {
            String[] asciiArt = {
                " ____                   ____     ____                    __     __ __         __         ",
                "/\\  _`\\     /'\\_/`\\    /\\  _`\\  /\\  _`\\               /'__`\\   /\\ \\ \\      /'__`\\       ",
                "\\ \\ \\/\\_\\  /\\      \\   \\ \\ \\L\\ \\ \\ \\L\\_\\             /\\_\\L\\ \\  \\ \\ \\ \\    /\\_\\L\\ \\      ",
                " \\ \\ \\_/_/ \\ \\ \\__\\ \\   \\ \\ ,__/ \\ \\  _\\L             \\/_/_\\_<_  \\ \\ \\ \\_  \\/_/_\\_<_     ",
                "  \\ \\ \\L\\ \\ \\ \\ \\_/\\ \\   \\ \\ \\/   \\ \\ \\L\\ \\             /\\ \\L\\ \\  \\ \\__ ,__\\  /\\ \\L\\ \\    ",
                "   \\ \\____/  \\ \\_\\\\ \\_\\   \\ \\_\\    \\ \\____/             \\ \\____/   \\/_/\\_\\_/  \\ \\____/    ",
                "    \\/___/    \\/_/ \\/_/    \\/_/     \\/___/               \\/___/       \\/_/     \\/___/     ",
                "                                                                                          ",
                " ____                                            __                   __ __         _     ",
                "/\\  _`\\                  __                     /\\ \\__               _\\ \\ \\__    /' \\    ",
                "\\ \\ \\L\\ \\ _ __    ___   /\\_\\       __     ___   \\ \\ ,_\\             /\\__  _  _\\  /\\_, \\   ",
                " \\ \\ ,__/\\`'__\\ / __`\\ \\/\\ \\    /'__`\\  /'___\\  \\ \\ \\/             \\/_L\\ \\ \\L_ \\/\\ \\  ",
                "  \\ \\ \\/ \\ \\ \\/ /\\ \\L\\ \\ \\ \\ \\  /\\  __/ /\\ \\__/   \\ \\ \\_              /\\_   _  _\\   \\ \\ \\ ",
                "   \\ \\_\\  \\ \\_\\ \\ \\____/ _\\ \\ \\ \\ \\____\\ \\____\\   \\ \\__\\             \\/_/\\_\\_\\/    \\ \\_\\ ",
                "    \\/_/   \\/_/  \\/___/ /\\ \\_\\ \\ \\/____/ \\/____/    \\/__/                \\/_//_/      \\/_/ ",
                "                        \\ \\____/                                                           ",
                "                         \\/___/                                                            ",

                
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
            "                                                                                                                                                                                ",
            "                                                                                                                                                                                 ",
            };

            return asciiArt;
        }
        else if(x == 2)
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

            return asciiArt;
        }

        else
        {
            String[] asciiArt = {
                " "
            };
            return asciiArt;
        } 
    }

    public static boolean ReturnMainMenu(Scanner inputMainMenu)
    {
        char mainMenuSelection = ' ';
        
        do
        {
            System.out.print("\nDo you want to return to the main menu (Y-N): ");
            String mainMenuStr = inputMainMenu.next();

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

    public static void Delay()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void ClearTheTerminal()
    {
        try {
            String operatingSystem = System.getProperty("os.name").toLowerCase();

            if (operatingSystem.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else{
                new ProcessBuilder("clear").inheritIO().start().waitFor();
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Common Methods Ends Here */

    public static void main(String[] args)
    {        
        Scanner input = new Scanner(System.in);
        char selection = ' ';

        do 
        {
            WelcomeToApp();

            System.out.println("A - Statistical Information About an Array");
            System.out.println("B - Matrix Operations");
            System.out.println("C - Text Encryption / Decryption");
            System.out.println("D - Tic-tac-toe HotSeat");
            System.out.println("E - Terminate (Quit)\n");

            System.out.print("Please choose an application: ");
            String userInput = input.next();

            if (userInput.length() == 1) 
            {
                selection = userInput.charAt(0);

                switch (selection) 
                {
                    case 'A':
                        System.out.println("\nYou are redirected to Statistical Information About an Array Application...\n");
                        Delay();
                        StatInfoAboutArray(input);
                        if(!ReturnMainMenu(input))
                        {
                            selection = 'E';
                            break;
                        }
                        else
                        {
                            ClearTheTerminal();
                            selection = ' ';
                            continue;
                        }
                    case 'B':
                        System.out.println("\nYou are redirected to Matrix Operations Application...\n");
                        Delay();
                        matrixOperations(input);
                        if(!ReturnMainMenu(input))
                        {
                            selection = 'E';
                            break;
                        }
                        else
                        {
                            ClearTheTerminal();
                            selection = ' ';
                            continue;
                        }
                    case 'C':
                        System.out.println("\nYou are redirected to Text Encryption / Decryption Application...\n");
                        Delay();
                        TextEncryptionDescription(input);
                        break;
                    case 'D':
                        System.out.println("\nYou are redirected to Tic-tac-toe HotSeat Application...\n");
                        Delay();
                        TicTacToe(input);
                        if(!ReturnMainMenu(input))
                        {
                            selection = 'E';
                            break;
                        }
                        else
                        {
                            ClearTheTerminal();
                            selection = ' ';
                            continue;
                        }
                    case 'E':
                        System.out.println("\nTerminating the application...");
                        Delay();
                        break;
                    default:
                        System.out.println("\nYou entered an unaccepted character. Please try again!\n");
                }
            } 
            else 
            {
                System.out.println("\nPlease enter only one character.\n");
                selection = ' ';
            }

        } while (selection != 'E');

        input.close();
    }
}