package genetic;

import java.util.Arrays;
import java.util.ArrayList;

/**
 * A Chromosome holds the data to calculate a solution to the makespan problem. The function
 * getFitness returns the "fitness" of a chromosome instance - that is it returns the max
 * time one machine takes to complete.
 * 
 * After a chromosome has been initialized the user can call the solutionToString() method
 * to print the "solution", that is the final assignment of jobs to machines.
 * 
 * The private chromosomeArr array is structure as an int[m][n] array of permutations, where
 * each element in the array represents an index in the data array or semantically the time
 * it takes one job to finish.
 * 
 * Example of chromosome structure:
 * 
 * 3 machines
 * 4 jobs
 *              "j0 j1 j2 j3"
 * chromosome = [[0, 1, 2, 3], "m1"
 * 
 *              "j2 j1 j3 j0"
 *               [2, 1, 3, 0], "m2"
 * 
 *              "j3 j2 j0 j1"
 *               [3, 2, 0, 1]] "m3"
 */
public class Chromosome {
    // Has this chromosome been initialized by an Initializer?
    private boolean initialized;

    // Private array of size m*n to store the chromosome data.
    private int[][] chromosomeArr;

    // Stores the final solution for this chromosome, i.e. which jobs are assigned to which machines.
    private ArrayList<ArrayList<Integer>> solution;

    // Has the solution been calculated?
    private boolean solutionCalculated;

    // Stores a Problem instance.
    private Problem problem;

    /**
     * Initializes the chromosomeArr array.
     * 
     * @param problem An instance of the makespan problem.
     */
    public Chromosome(Problem problem) {
        int numMachines;
        int numJobs;

        this.problem = problem;

        numMachines = problem.getNumMachines();
        numJobs = problem.getNumJobs();

        this.chromosomeArr = new int[numMachines][numJobs];

        this.initialized = false;
        this.solutionCalculated = false;
    }

    /**
     * Calculates the final solution for this given Chromosome.
     * 
     * For each job in each machine, if that job hasn't been taken by another machine
     * assign it to this machine.
     */
    private void calculateSolution() {

        if (!this.initialized) {
            throw new java.lang.RuntimeException("Chromosome is not initialized with data.");
        }

        int m = this.problem.getNumMachines();
        int n = this.problem.getNumJobs();
        int[] jobs = new int[n];
        this.solution = new ArrayList<ArrayList<Integer>>();

        // Initialize all jobs to 1 to signify no jobs are "taken".
        for (int i = 0; i < n; i++) {
            jobs[i] = 1;
        }

        // Initialeze solution to m machines.
        for (int i = 0; i < m; i++) {
            this.solution.add(new ArrayList<Integer>());
        }

        // Add the first available job in each machine in the chromosome to that machine in the solution.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ; j++) {
                if (jobs[this.chromosomeArr[j][i]] == 1) {
                    this.solution.get(j).add(this.chromosomeArr[j][i]);
                    jobs[this.chromosomeArr[j][i]] = 0;
                }
            }
        }

        this.solutionCalculated = true;
    }

    /**
     * Mutators
     */

    /**
     * Modify the Chromosome.
     * 
     * @param m Machine index.
     * @param n Job index.
     * @param value Value to assign the index to.
     */
    public void setElement(int m, int n, int value) {
        this.chromosomeArr[m][n] = value;
        this.solutionCalculated = false;
    }

    /**
     * Signals this chromosome has been initialized.
     */
    public void setInitialized() {
        this.initialized = true;
    }

    /**
     * Accessors
     */

    /**
     * Get an element at a certain index of the Chromosome.
     * 
     * @param m Machine index.
     * @param n Job index.
     * @return Value at the given index in the Chromosome.
     */
    public int getElement(int m, int n) {
        return this.chromosomeArr[m][n];
    }

    /**
     * Returns the fitness of this chromosome.
     * 
     * Fitness is max(time to complete a machine).
     */
    public int getFitness() {
        int longestTime = 0;
        int currentTime;

        if (!solutionCalculated) {
            calculateSolution();
        }

        for (int i = 0; i < this.problem.getNumMachines(); i++) {
            currentTime = 0;

            for (int j = 0; j < this.solution.get(i).size(); j++) {
                currentTime += problem.getData(this.solution.get(i).get(j));
            }

            if (currentTime > longestTime) {
                longestTime = currentTime;
            }
        }

        return longestTime;
    }

    /**
     * Printing methods.
     */

    /**
     * Convert the Solution array to a string.
     */
    public String solutionToString() {
        if (!solutionCalculated) {
            calculateSolution();
        }

        String s = "Solution:\n";
        s += "\t[" + Arrays.toString(this.solution.get(0).toArray()) + ",\n";

        for (int i = 1; i < this.solution.size(); i++) {
            s += "\t " + Arrays.toString(this.solution.get(i).toArray()) + ",\n";
        }

        return s.substring(0, s.length() - 2) + "]";
    }

    /**
     * Convert the Chromosome object to a string.
     */
    public String toString() {
        String s = "Chromosome:\n";
        s += "\t[" + Arrays.toString(this.chromosomeArr[0]) + ",\n";

        for (int i = 1; i < this.chromosomeArr.length; i++) {
            s += "\t " + Arrays.toString(this.chromosomeArr[i]) + ",\n";
        }

        return s.substring(0, s.length() - 2) + "]";
    }
}
