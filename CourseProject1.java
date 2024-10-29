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

        for(int a = 0; a < sizeOfArray; a++)
        {
            System.out.printf("\nYour number %d is %.2f.", a + 1, array[a]);
        }

        double median = findMedian(array);
        double arithmeticMean = findArithmeticMean(array);
        double geometricMean = findGeometricMean(array);
        double harmonicMean = sizeOfArray / findHarmonicMean(array, sizeOfArray - 1);

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
                + "\nNevertheless, the presence of negative numbers generally invalidates the geometric mean calculation."
            );
        }
        else
        {
            System.out.printf("\n\nThe geometric mean of the array is: %.2f", geometricMean);
        }

    }

    /* Statistical Information About an Array Ends Here */


    /* Matrix Operations Starts Here */

    /*
    public static void matrixOperations(Scanner input)
    {
        clearTheTerminal();

        String[] asciiArt = {
            "_  _ ____ ___ ____ _ _  _    ____ ___  ____ ____ ____ ___ _ ____ _  _ ____ ",
            "|\\/| |__|  |  |__/ |  \\/     |  | |__] |___ |__/ |__|  |  | |  | |\\ | [__  ",
            "|  | |  |  |  |  \\ | _/\\_    |__| |    |___ |  \\ |  |  |  | |__| | \\| ___] "
        };

        for (String line : asciiArt) {
            System.out.println(line);
        }
    }
    */

    /* Matrix Operations Ends Here */

    
    /* Text Encryption Starts Here */

    /*
    public static void textEncryptionDescription(Scanner input)
    {
        clearTheTerminal();
        
        System.out.println("Welcome to Text Encrytion");
    }
    */

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

        System.out.print("\n\n");
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
     * <ul>
     * <li> The player X represents integer 4. And player O represents integer 5.
     * <li> We wanted to mathematically calculate the winning control of the game by filling the 3x3 matrix we created with 0s.
     * <li> If you place the values ​​4 and 5 in an integer 3x3 matrix, in the checks made for tictactoe (which is done by adding the horizontal, vertical or diagonal elements); 
     * <li> if a player has won, you will not find any other value than 12 for X (i.e. 4) and 15 for O (i.e. 5).
     * <li> This game was created using this logic.
     * </ul>
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
                } 
                catch (InputMismatchException e) 
                {
                    System.out.println("Invalid input! Please enter a number between 1 and 9.");
                    input.nextLine();
                }
            } while (!validPosition);
    
            // Check if the game is won
            gameWon = checkForWin(matrix);
            if (gameWon) {
                System.out.println("Player " + (currentPlayer == 4 ? "X" : "O") + " wins!");
                break;
            }
    
            // Switch player
            currentPlayer = (currentPlayer == 4) ? 5 : 4;
    
        } while (!gameWon);
    
        printMatrix(matrix);
        System.out.println("Game over!");
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
        System.out.println("Please just enter the letters that will be accepted (A - E). Do not use any other letter, numbers or special characters.\n");
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
     * @param inputMainMenu scanner variable from main to receive user input
     * @return boolean value indicating whether the user wants to return to the main menu
     */

    public static boolean returnMainMenu(Scanner inputMainMenu)
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
                        welcomeToApp();
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
        welcomeToApp();

        do 
        {
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
                        System.out.println("\nYou are redirected to Matrix Operations Application...\n");
                        delay();
                        //matrixOperations(input);
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
                        System.out.println("\nYou are redirected to Text Encryption / Decryption Application...\n");
                        delay();
                        //textEncryptionDescription(input);
                        break;
                    case 'D':
                        System.out.println("\nYou are redirected to Tic-tac-toe HotSeat Application...\n");
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
                        System.out.println("\nTerminating the application...");
                        delay();
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