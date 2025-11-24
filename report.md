# Project Report - Health & Diet Analyzer for Hostel Students (Java)

## Introduction
This Java console application allows students to log their meals, calculate daily nutrition totals, and spot possible deficiencies using simple rules.

## Architecture
- `Main` - console interface
- `Database` - JSON file read and write
- `MealService` - meal management (CRUD)
- `NutritionAnalyzer` - aggregation and risk evaluation
- `models` - User, FoodItem, Meal

## How to run
See README.md

## Future enhancements
- Convert to Spring Boot and add a REST API
- Add JavaFX GUI
- Replace the JSON file storage with an embedded database (H2)
- Add unit tests using JUnit
