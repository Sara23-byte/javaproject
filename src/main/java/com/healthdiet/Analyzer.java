package com.healthdiet;

import java.util.ArrayList;
import java.util.List;

/**
 * Small rule-based analyzer with human-friendly comments.
 *
 * Rationale notes:
 * - Keep rules readable: a human reviewer should understand why points are added/subtracted.
 * - Example rules: reward fiber, penalize excessive added sugar, modest bonus for protein.
 *
 * TODO:
 * - Make thresholds configurable (user profile).
 * - Add CSV/JSON import code path and unit tests for edge cases.
 */
public class Analyzer {

    private static class Meal {
        String name;
        double calories, protein, fiber, addedSugar;
        Meal(String n, double c, double p, double f, double s) {
            name = n; calories = c; protein = p; fiber = f; addedSugar = s;
        }
    }

    private final List<Meal> meals = new ArrayList<>();

    public void addMeal(String name, double calories, double protein, double fiber, double sugar) {
        meals.add(new Meal(name, calories, protein, fiber, sugar));
    }

    public void loadSampleData() {
        meals.clear();
        addMeal("Breakfast - oats & banana", 350, 8, 6, 5);
        addMeal("Lunch - rice, dal, veg", 650, 18, 8, 3);
        addMeal("Snack - tea + biscuits", 200, 3, 1, 10);
        addMeal("Dinner - chapati & sabzi", 500, 12, 5, 2);
    }

    /**
     * Produce a short human-readable report.
     */
    public String summaryReport() {
        double totalCalories = 0, totalProtein = 0, totalFiber = 0, totalSugar = 0;
        for (Meal m : meals) {
            totalCalories += m.calories;
            totalProtein += m.protein;
            totalFiber += m.fiber;
            totalSugar += m.addedSugar;
        }

        int score = computeScore(totalProtein, totalFiber, totalSugar);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Today's totals — Calories: %.0f kcal, Protein: %.0fg, Fiber: %.1fg, Added sugar: %.1fg\n",
                totalCalories, totalProtein, totalFiber, totalSugar));
        sb.append(String.format("Daily score: %d/100\n", score));
        sb.append(simpleSuggestions(totalProtein, totalFiber, totalSugar));
        return sb.toString();
    }

    /**
     * Simple scoring rules:
     * - Start at 50 (neutral baseline)
     * - +5 points per 10g fiber (encourages vegetables)
     * - +4 points per 10g protein (encourages adequate protein)
     * - -5 points if added sugar > 25g (penalize high sugar)
     * - Clamp to [0,100]
     */
    private int computeScore(double protein, double fiber, double sugar) {
        double score = 50;
        score += Math.floor(fiber / 10.0) * 5;
        score += Math.floor(protein / 10.0) * 4;
        if (sugar > 25) score -= 5;
        // Minor human touch: a tiny bonus if protein and fiber are both present
        if (protein >= 20 && fiber >= 10) score += 3;
        score = Math.max(0, Math.min(100, score));
        return (int) Math.round(score);
    }

    private String simpleSuggestions(double protein, double fiber, double sugar) {
        List<String> tips = new ArrayList<>();
        if (fiber < 10) tips.add("Add more vegetables or whole grains (aim for +10g fiber).");
        if (protein < 50) tips.add("Include a protein source (eggs, dal, paneer, or legumes).");
        if (sugar > 25) tips.add("Cut down on sugary sweets and sweetened drinks.");
        if (tips.isEmpty()) return "Nice balance today — keep it up!";
        // Join suggestions in a friendly sentence style
        StringBuilder sb = new StringBuilder("Top suggestions: ");
        for (int i = 0; i < tips.size(); i++) {
            if (i > 0) sb.append(" ");
            sb.append(tips.get(i));
        }
        return sb.toString();
    }
}