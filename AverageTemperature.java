//  Calculate the avarage temperature, and give how many days are above the avarage temperature
//  1. Take an input from the user (eg. 5)
//  2. Prompt the user to enter all the 5 numbers (temperature values)
//  3. Calculate the avarage temperature
//  4. Given the avarage temperature, how many of the numbers in the line 2 are above the avarage temperature?

import java.util.Scanner;

public class AverageTemperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Take input from the user for the number of temperatures
        System.out.print("Enter the number of days (e.g., 5): ");
        int numDays = scanner.nextInt();

        // Step 2: Prompt the user to enter all temperature values
        double[] temperatures = new double[numDays];
        System.out.println("Enter the temperatures for " + numDays + " days:");
        for (int i = 0; i < numDays; i++) {
            System.out.print("Day " + (i + 1) + ": ");
            temperatures[i] = scanner.nextDouble();
        }

        // Step 3: Calculate the average temperature
        double total = 0;
        for (double temp : temperatures) {
            total += temp;
        }
        double averageTemperature = total / numDays;
        System.out.println("Average temperature: " + averageTemperature);

        // Step 4: Count how many temperatures are above the average
        int aboveAverageCount = 0;
        for (double temp : temperatures) {
            if (temp > averageTemperature) {
                aboveAverageCount++;
            }
        }
        System.out.println("Number of days above average temperature: " + aboveAverageCount);

        scanner.close();
    }
}