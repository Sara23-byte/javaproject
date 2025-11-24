package com.healthdiet;

import java.util.Scanner;

/**
 * Main entry point.
 * Short, friendly CLI so someone in a hostel can quickly log meals and get a score.
 *
 * Author: Gaurav Bhardwaj (GAURAV-SSD)
 * Notes:
 * - Keep the menu small and obvious.
 * - Use plain language in prompts so non-developers can try the app.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Analyzer analyzer = new Analyzer();

        System.out.println("Health & Diet Analyzer — quick console tool");
        System.out.println("Tip: enter a few meals and press 's' to see today's summary.\n");

        while (true) {
            System.out.println("Menu: (a)dd meal  (l)oad sample  (s)ummary  (q)uit");
            System.out.print("> ");
            String cmd = scanner.nextLine().trim().toLowerCase();

            if (cmd.equals("a") || cmd.equals("add")) {
                System.out.print("Meal name: ");
                String mealName = scanner.nextLine().trim();
                // In this toy app we ask for a few main nutrients; real apps would parse portion sizes.
                System.out.print("Calories (kcal): ");
                double cal = parseDoubleOrZero(scanner.nextLine());
                System.out.print("Protein (g): ");
                double protein = parseDoubleOrZero(scanner.nextLine());
                System.out.print("Fiber (g): ");
                double fiber = parseDoubleOrZero(scanner.nextLine());
                System.out.print("Added sugar (g): ");
                double sugar = parseDoubleOrZero(scanner.nextLine());

                analyzer.addMeal(mealName, cal, protein, fiber, sugar);
                System.out.println("Added. You can add more or view summary.\n");

            } else if (cmd.equals("l") || cmd.equals("load")) {
                // For a simple demo we load bundled sample data if available.
                analyzer.loadSampleData();
                System.out.println("Sample data loaded.\n");

            } else if (cmd.equals("s") || cmd.equals("summary")) {
                String report = analyzer.summaryReport();
                System.out.println(report);
                System.out.println();

            } else if (cmd.equals("q") || cmd.equals("quit")) {
                System.out.println("Thanks for using Health & Diet Analyzer. Take care!");
                break;

            } else {
                System.out.println("Unknown command. Try a, l, s, or q.\n");
            }
        }

        scanner.close();
    }

    private static double parseDoubleOrZero(String s) {
        try {
            return Double.parseDouble(s.trim());
        } catch (Exception e) {
            return 0.0;
        }
    }
}