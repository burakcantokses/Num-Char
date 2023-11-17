import java.util.Scanner;

/**
 * This program generates a Pascal's Triangle pattern based on user input for triangle size.
 *
 * @author burakcantokses
 */
public class Main {
    public static char[] letters = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public static void main(String[] args) {
        String answer = "N";
        int triangleSize = 0;
        while (answer.equalsIgnoreCase("N")) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the triangle size: ");
            triangleSize = input.nextInt();
            createPascalTriangle(triangleSize);

            System.out.println("If you want to create a new triangle, enter 'N'.");
            System.out.println("Enter 'E' to exit.");
            answer = input.next();
            if (answer.equalsIgnoreCase("E")) {
                System.out.println("Application is closing.");
                System.exit(0);
            }
        }
    }

    public static void createSpaces(int spaceSize) {
        for (int j = 0; j < spaceSize; j++) {
            System.out.print(" ");
        }
    }

    public static void createNumberLine(int i) {
        for (int j = 1; j <= i; j++) {
            System.out.print(j);
        }
    }

    public static void createLetters(int horizontalCounter) {
        for (int j = horizontalCounter; j >= 1; j--) {
            System.out.print(letters[j]);
        }
    }

    public static boolean checkSize(int size) {
        return size >= 1 && size <= letters.length - 1;
    }

    public static void createPascalTriangle(int size) {
        if (!checkSize(size)) {
            System.out.println("Invalid length. Please enter a length between 1-" + (letters.length-1) + ".");
            return;

        }
        int space=(size-1)*2;
        int horizontalCounter = 1;

        for (int i = 1; i <= size; i++) {
            createSpaces(space);
            if (i!=size)
                space -= 1;
            createNumberLine(i);
            if (i>1) {
                createLetters(horizontalCounter);
                horizontalCounter += 1;
            }

            System.out.println();
        }

        horizontalCounter -= 2;

        for (int i = size-1; i >= 1; i--) {
            space += 1;
            createSpaces(space);
            createNumberLine(i);
            createLetters(horizontalCounter);
            horizontalCounter -= 1;
            System.out.println();
        }

    }
    
}