# AI-Driven Expense Puzzle Solver

## Project Overview

This project implements a solver for a modified version of the 8-puzzle problem, called the **Expense 8 Puzzle**. Each tile’s number represents the cost of moving it, and the objective is to find the sequence of moves to reach the goal state at the minimum cost.

The solver leverages **AI search algorithms** to efficiently explore the state space and supports multiple methods, including **uninformed** and **informed search techniques**.

Supported search methods:
- **Breadth-First Search (BFS)**
- **Uniform Cost Search (UCS)**
- **Depth-First Search (DFS)**
- **Depth-Limited Search (DLS)**
- **Iterative Deepening Search (IDS)**
- **Greedy Search**
- **A\*** (default option)

## Key Features

- Implements foundational **AI search algorithms** for problem-solving.
- Utilizes heuristics to improve efficiency in Greedy and A* searches.
- Tracks search performance, including nodes expanded and fringe size.
- Modular design, supporting future algorithm extensions.

## Project Structure

The project follows a standard Maven structure:
- `src/main/java`: Contains implementation classes for algorithms and utilities.
- `src/test/java`: Includes unit tests using **JUnit**.

### Technologies Used
- **Java**: Core language for implementation.
- **Maven**: For dependency management.
- **JUnit**: For testing and validation.

## Installation and Setup

### Prerequisites
- [Java JDK 8+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)

### Steps
1. Clone the repository:
    ```bash
    git clone https://github.com/vinodpgowda/AI-driven-expense-8-puzzle.git
    cd AI-driven-expense-8-puzzle
    ```

2. Open in IntelliJ IDEA:
    - Open IntelliJ and navigate to `File > Open`.
    - Select the project directory.

3. Build with Maven:
    - IntelliJ will detect the `pom.xml` and set up dependencies.
    - If needed, reload Maven projects using the Maven tab.

4. Run the solver:
    - Execute the `Expense8PuzzleSolver` class with appropriate arguments.

## Usage

Run the solver from the command line:
```bash
java -jar expense-8-puzzle.jar <start-file> <goal-file> <method> <dump-flag>
```

Example:
```bash
java -jar expense-8-puzzle.jar start.txt goal.txt a* true
```
This runs the solver using the A* algorithm with search trace dumping enabled.  

  
## Search Methods

    BFS: Explores all nodes at the current depth before moving deeper.
    UCS: Explores the lowest-cost path first.
    DFS: Explores as far as possible before backtracking.
    DLS: DFS with a depth limit.
    IDS: Gradually increases depth limits.
    Greedy Search: Prioritizes nodes based on a heuristic.
    A*: Combines path cost and heuristic for optimal results.

## Input File Format

The start and goal files are plain text with a 3x3 grid:
```bash
1 2 3  
4 5 6  
7 8 0
```
Where 0 represents the empty space.
