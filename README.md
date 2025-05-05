# Java 8 Puzzle Solver

**AI-powered expense 8-puzzle problem solver using modern Java.**  
Implements classic search algorithms like **BFS**, **DFS**, **UCS**, and **A\*** with clean code, modular design, and extensibility.

---

## What This Project Does

This Java application solves the **expense 8 puzzle problem**, where each tile has a cost equal to its number. It finds the optimal path from a given start state to a goal state using search algorithms.

---

## 💡 Why It’s Useful

- A hands-on learning tool to understand uninformed and informed search strategies.
- Great for showcasing your knowledge of **Java**, **AI search algorithms**, **clean code**, and **test-driven development**.
- Demonstrates practical use of `record`, `enum`, `Streams`, and other modern Java features.

---

## 🛠️ How to Get Started

### ✅ Prerequisites

- Java 17+
- Maven 3+
- Git
- IntelliJ IDEA (optional)

### 📦 Installation

```bash
git clone https://github.com/vinodpgowda/java-8-puzzle-solver.git
cd java-8-puzzle-solver
mvn clean install
```

### ▶️ Running the Solver

```bash
java -jar target/expense-8-puzzle.jar start.txt goal.txt BFS
```

Replace `start.txt`, `goal.txt`, and `BFS` with your own input files and algorithm (`DFS`, `UCS`, `A*`, etc.).  
If no algorithm is provided or an invalid one is specified, the solver defaults to `BFS`.

---

## 📂 Input File Format

Plain text file with a 3x3 grid. `0` represents the empty tile.

```
1 2 3
4 5 6
7 8 0
```

You need two files: one for the **start state**, one for the **goal**.

---

## 🤖 Supported Search Algorithms

- **BFS** – Breadth-First Search  
- **DFS** – Depth-First Search  
- **UCS** – Uniform Cost Search  
- **A\*** – Heuristic-based search *(coming soon)*  
- (Extensible to IDS, DLS, Greedy, etc.)

---

## 🧪 Running Tests

```bash
mvn test
```

- Tests located in `src/test/java`
- Built with **JUnit 5**
- Covers input parsing, state validation, and algorithm correctness

---

## 🤝 Maintainer

Developed by [Vinod Kumar](https://github.com/vinodpgowda)  
For questions, open an issue or reach me via [LinkedIn](https://www.linkedin.com/in/vinodpgowda/)

---


