# Health \& Diet Analyzer, Java

This is a small console Java app that helps hostel students, or anyone, quickly assess their daily diet quality and receive simple suggestions for improvement. I started it as a course project and kept the code simple, making it easy to read and expand.

Why I made this

* I wanted a local, easy-to-use tool to test diet scoring rules without depending on outside services.
* I built this during college to help friends in hostels easily identify nutrient gaps.

Quick summary

* Input: simple CSV or sample JSON data describing meals and food items.
* Output: daily nutrient totals, a simple score, and clear suggestions.
* Not medical advice, it’s meant for prototyping and learning.

What’s new in this version

* A more user-friendly README and usage examples.
* Short explanations of the scoring rationale rather than dry statements.
* Code comments focus on why decisions were made, not just what the code does.
* Small TODOs and realistic limitations are listed.

Quick start (Maven)

1. Requirements: Java 17+ and Maven.
2. Build:
   mvn clean package
3. Run (example):
   mvn exec:java -Dexec.mainClass=com.healthdiet.Main
   or
   java -cp target/classes com.healthdiet.Main

Simple run example (what you’ll see)

* "Welcome, enter today's meals or load sample\_data/meals.csv"
* "Today's score: 68/100, good job! Try adding more vegetables for fiber."

Project layout (where to look)

* src/main/java/com/healthdiet — core code (Main, Analyzer, models)
* data/ — sample inputs
* tests/ — unit checks (small set)

Design notes and limitations

* Scoring is simple and rule-based so you can change it quickly.
* Edge cases, like allergic information and portion-size normalization, are not included for now.
* If you want clinical-grade advice, integrate a nutrition database and consult experts.

How to help / Contributing

* Report issues by describing a use case or providing sample input.
* Pull requests are welcome; aim for small, focused changes and include a note about why the change is beneficial.
* When adding rules, provide example input and expected output.

Author / Contact

* Sara Manocha — creator of this college project. If you want me to continue developing this for a specific use, like vegetarian hostel meal plans, let me know, and I’ll add a small config and examples.

Changelog (short)

* 0.1.0 — initial prototype (CSV input, scoring, console output)
* 0.1.1 — README and code comments revised for clarity, added outlines for CONTRIBUTING and CHANGELOG

License

* Add your preferred license file, such as MIT, in the repo root to clarify reuse.
