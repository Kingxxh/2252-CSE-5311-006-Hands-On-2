# Sorting Algorithm Benchmark with Chart
This project benchmarks the performance of three sorting algorithms: **Insertion Sort** , **Selection Sort** , and **Bubble Sort** . The program generates random arrays of varying sizes, measures the runtime of each sorting algorithm, and visualizes the results using **JFreeChart** .

---


## Overview

1. **Benchmarking** :
- Measures the runtime of:
    - Insertion Sort

    - Selection Sort

    - Bubble Sort

2. **Console Output** :
- Displays runtime results for each sorting algorithm with varying input sizes.

3. **Visualization** :
- Visualizes performance with a line chart where:
    - X-axis represents the input size.

    - Y-axis represents the runtime (seconds).

4. **Correctness Argument** :
- Includes a formal proof of the correctness of the Selection Sort algorithm.


---

**How to Run**
1. Clone the repository or copy the source code to your local machine.

2. Ensure you have JFreeChart added to your project dependencies (via Gradle or another method).

3. Compile and run the `2252-CSE-5311-006-Hands-On-2\src\main\java\SortingBenchmarkWithChart.java` class.


---

## System Information

- **CPU** : amd64

- **RAM** : 8124 MB

- **Java Version** : 17.0.12


---


## Console Output

After running the program, the console displays runtime results for each sorting algorithm as follows:

**Runtime for insertion_sort:**
- Input size 5: 0.000494 seconds

- Input size 10: 0.000001 seconds

- Input size 20: 0.000002 seconds

- Input size 50: 0.000008 seconds

- Input size 100: 0.000026 seconds

- Input size 200: 0.000108 seconds

- Input size 500: 0.000624 seconds

- Input size 1000: 0.000379 seconds

- Input size 2000: 0.000896 seconds

- Input size 5000: 0.002442 seconds

- Input size 10000: 0.010166 seconds



  **Runtime for selection_sort:**
- Input size 5: 0.000002 seconds

- Input size 10: 0.000001 seconds

- Input size 20: 0.000003 seconds

- Input size 50: 0.000012 seconds

- Input size 100: 0.000036 seconds

- Input size 200: 0.000124 seconds

- Input size 500: 0.000423 seconds

- Input size 1000: 0.000605 seconds

- Input size 2000: 0.001434 seconds

- Input size 5000: 0.006932 seconds

- Input size 10000: 0.012959 seconds


  **Runtime for bubble_sort:**
- Input size 5: 0.000003 seconds

- Input size 10: 0.000002 seconds

- Input size 20: 0.000004 seconds

- Input size 50: 0.000023 seconds

- Input size 100: 0.000094 seconds

- Input size 200: 0.000352 seconds

- Input size 500: 0.001145 seconds

- Input size 1000: 0.000791 seconds

- Input size 2000: 0.001699 seconds

- Input size 5000: 0.009616 seconds

- Input size 10000: 0.060450 seconds


---


## Chart Visualization

The program generates the following chart comparing the performance of the sorting algorithms:


- **X-axis** : Input size

- **Y-axis** : Runtime in seconds

- Each algorithm is represented by:
    - Insertion Sort (Red)

    - Selection Sort (Blue)

    - Bubble Sort (Green)

![Sorting Algorithm Performance.png](Sorting%20Algorithm%20Performance.png)
---

## Selection Sort Correctness
The correctness of **Selection Sort**  can be argued as follows:
1. **Invariant** :
- At the end of the `i-th` iteration, the first `i` elements of the array are sorted and contain the `i` smallest elements.

2. **Proof** :
- **Base Case** : At `i = 0`, no elements are processed, so the array is trivially sorted.

- **Inductive Step** : Assuming the first `i` elements are sorted after the `i-th` iteration, the algorithm ensures the next smallest element is placed in the correct position at iteration `i+1`.

3. **Termination** :
- Once all iterations are complete, the entire array is sorted.
  Thus, **Selection Sort**  guarantees a correct result for all valid inputs.

---
