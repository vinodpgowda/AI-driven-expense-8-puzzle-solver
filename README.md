# Expense 8 Puzzle Solver

## Project Overview

This project implements a solver for a modified version of the classic 8-puzzle problem, called the Expense 8 Puzzle problem. In this version, the number on each tile represents the cost of moving that tile. The solver supports multiple search algorithms to find the optimal solution to reach the desired configuration of the puzzle.

The supported search methods include:
- **Breadth-First Search (BFS)**
- **Uniform Cost Search (UCS)**
- **Depth-First Search (DFS)** 
- **Depth-Limited Search (DLS)** 
- **Iterative Deepening Search (IDS)** 
- **Greedy Search**
- **A\*** (default option if no method is provided)

The project is built using **Java** and **Maven** and can be developed using **IntelliJ IDEA**.

## Project Structure

The project follows a standard Maven structure.

### Technologies Used

- **Java**
- **Maven**: For dependency management and building the project.
- **JUnit**: For testing.

## Installation and Setup

### Prerequisites

- [Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) (version 8 or above)
- [Maven](https://maven.apache.org/download.cgi)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)

### Steps

1. **Clone the repository**:
    ```bash
    git clone https://github.com/your-username/expense-8-puzzle.git
    cd expense-8-puzzle
    ```

2. **Open the project in IntelliJ IDEA**:
    - Open IntelliJ IDEA and click on `File > Open`.
    - Select the `expense-8-puzzle` directory and open it.

3. **Set up Maven**:
    - IntelliJ IDEA should automatically detect the `pom.xml` file and set up Maven dependencies.
    - If needed, reload Maven by clicking the `Maven` tab and selecting `Reload All Maven Projects`.

4. **Run the Project**:
    - You can now run the solver by invoking the main class `Expense8PuzzleSolver` and providing the appropriate arguments.

## Usage

The program is executed from the command line. The format is as follows:

```bash
java -jar expense-8-puzzle.jar <start-file> <goal-file> <method> <dump-flag>
```

## Search Methods

Each search method is implemented in its own class. Below is a brief description of each:

- **Breadth-First Search (BFS)**: Explores all nodes at the present depth level before moving on to the next level.
- **Uniform Cost Search (UCS)**: A priority queue-based search where the lowest cost path is explored first.
- **Depth-First Search (DFS)**: Explores as far as possible along each branch before backtracking.
- **Depth-Limited Search (DLS)**: Similar to DFS but limits the depth to a specified value.
- **Iterative Deepening Search (IDS)**: A combination of depth-first and breadth-first, increasing the depth limit progressively.
- **Greedy Search**: Chooses the next node based on a heuristic.
- **A\***: Chooses the next node based on both the cost so far and a heuristic.

## File Format

The start and goal files should be plain text files following the format:

1 2 3  
4 5 6  
7 8 0  

Where `0` represents the empty space.