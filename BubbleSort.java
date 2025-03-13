import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;

public class BubbleSort {

public static void main(String[] args) {
    String filename = "storearray.txt";
    String filename2 = "sortarray.txt";
    boolean run = true;
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("\nWelcome to the BubbleSort Machine!");

    while (run) {

    System.out.println("\nEnter any integer between 0 and 100 (inclusive).");
    System.out.println("\nThe integer you enter will be the number of numbers in your array. (Ex: entering '9' generates 9 an array of numbers).");
    System.out.println("These numbers will be randomly generated and then sorted from smallest to largest.");
    System.out.println("\nNote that your unsorted array will be printed to the 'storearray.txt' file and the sorted one will be stored to the 'sortarray.txt file.'");
    System.out.println("\nEnter '-1' to exit.\n");

    int arraySize = scanner.nextInt();

    if ((arraySize < 0 || arraySize > 100) && (arraySize != -1)) {
        System.out.println("\nPlease enter a valid input between 0 and 100 (inclusive).\n");
    }
    else if (arraySize == -1) {
        System.out.println("\nExit successful.\n");
        run = false;
    }
    else if ((arraySize >= 0 || arraySize <= 100)) {

    
    int[] randomArray = createRandomArray(arraySize);

    writeArrayToFile(randomArray, filename);
        System.out.println("\nHere is your unsorted array with " + arraySize + " numbers in it:\n");
        for (int i = 0; i < randomArray.length; i++) {
            System.out.println(randomArray[i]);
        }


    int[] inputToArray = readFileToArray(filename);
    bubbleSort(inputToArray);

    writeArrayToFile(inputToArray, filename2);

    System.out.println("\nHere is your sorted array:\n");
        for (int i = 0; i < inputToArray.length; i++) {
            System.out.println(inputToArray[i]);
        }

    }
    }

        scanner.close();

}

public static int[] createRandomArray(int arraySize) {
    Random random = new Random();
    int[] array = new int[arraySize];
    for (int i = 0; i < arraySize; i++) {
        array[i] = random.nextInt(101);
    }

    return array;
}


public static void writeArrayToFile(int[] array, String filename) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
        for (int i = 0; i < array.length; i++) {
        writer.write(Integer.toString(array[i]));
        writer.newLine();
        }
    }
    catch (IOException e) {
        System.out.println(e.getMessage());
    }

}

public static int[] readFileToArray(String filename) {
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
        int[] array = new int[100];
        int increment = 0;
        String forLine;
        while ((forLine = reader.readLine()) != null) {
            array[increment] = Integer.parseInt(forLine);
            increment++;
        }
        return Arrays.copyOf(array, increment);
        }
    catch (IOException e) {
        System.out.println(e.getMessage());
        return new int[0];

    }
    }

public static void bubbleSort(int[] array) {
    int m = array.length;
    for (int i = 0; i < m - 1; i++) {
        for (int j = 0; j < m - 1 - i; j++) {
            if (array[j] > array[j + 1]) {
                int swap = array[j];
                array[j] = array[j + 1];
                array[j + 1] = swap;
            }
        }
        boolean ordered = true;
        for (int n = 0; n < m - 1 - i; n++) {
            if (array[n] > array[n + 1]) {
                ordered = false;
                break;
            }
        }
        if (ordered) break;

    }

}

}
