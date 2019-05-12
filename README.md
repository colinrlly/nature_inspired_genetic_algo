# nature_inspired_genetic_algo
Homework for nature inspired algorithms course. Assignment is to solve the minimum
make-span problem using a genetic algorithm.

# How to Build and Run
To compile the code, when in the nature_inspired_genetic_algo directory run

```
javac genetic/*.java
```

# Parts of a genetic algorithm
1) Initializer
2) selecter
3) recombiner
4) mutater
5) replacer

# Structure of Project
There are 5 interfaces, each representing a step in the genetic algorithm. There are also 3 classes. The
chromosome class, the Problem class, and the GeneticAlgorithm class. The chromosome class
explains itself. The Problem class is used to hold the problem parameters like num machines and
num jobs. The GeneticAlgorithm class is constructed with implementations of the 5 interfaces, and
is used to actually run the genetic algorithm.

# Structure of the Data
Data files are structured as following..

benchark3_50_101.csv

50 Machines
101 Jobs

Each line in the file is 1 jobs time to completion.

# Colin Didn't Know How To Do Inheritance in Java...
...So he made a folder called InheritanceExample which successfully implements inheritance. Feel
free to use it to remind yourself how inheritance works if you're into that sort of thing.
