# Disk Scheduling Algorithm

This repository contains implementations of various disk scheduling algorithms in Java. Disk scheduling algorithms are used by operating systems to manage the order in which disk I/O requests are processed. Efficient scheduling can significantly improve the performance of the system.

## Table of Contents

- [Overview](#overview)
- [Algorithms Implemented](#algorithms-implemented)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Overview

Disk scheduling algorithms determine the order in which disk access requests are serviced. In this project, we have implemented several well-known disk scheduling algorithms in Java.

## Algorithms Implemented

- First-Come, First-Served (FCFS)
- Shortest Seek Time First (SSTF)
- Elevator (SCAN)
- Circular SCAN (C-SCAN)
- LOOK
- C-LOOK

## Getting Started

### Prerequisites

You need to have Java installed on your machine. You can download it from [here](https://www.oracle.com/java/technologies/javase-downloads.html).

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/musab05/DiskSchedulingAlgorithm.git
    ```
2. Navigate to the project directory:
    ```sh
    cd DiskSchedulingAlgorithm
    ```
3. Compile the Java files:
    ```sh
    javac *.java
    ```

## Usage

To run a specific disk scheduling algorithm, use the following command:
```sh
java [AlgorithmName] [parameters]
