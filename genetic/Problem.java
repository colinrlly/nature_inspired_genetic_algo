package genetic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem {
    private int numMachines;
    private int numJobs;
    private int[] data;

    public Problem(int numMachines, int numJobs, String path) {
        this.numMachines = numMachines;
        this.numJobs = numJobs;

        this.parseCSV(path);
    }

    /***
     * Returns an array representing the data held in a csv file.
     * 
     * @param path - Path of the csv file to load data from.
     * @return 2D arrayList representing the data held in the csv file.
     */
    private void parseCSV(String path) {
        List<Integer> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                records.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            throw new java.lang.RuntimeException("Could not parse " + path);
        }

        // Convert array list of Integer objects to array of int.
        this.data = new int[records.size()];
        for (int i=0; i < this.data.length; i++) {
            this.data[i] = records.get(i).intValue();
        }
    }

    /**
     * Accessors
     */

    /**
     * Get the number of machines for this problem.
     *
     * @return Number of machines.
     */
    public int getNumMachines() {
        return this.numMachines;
    }

    /**
     * Get the number of jobs for this problem.
     * 
     * @return Number of jobs.
     */
    public int getNumJobs() {
        return this.numJobs;
    }

    /**
     * Access the data for this problem.
     * 
     * @param index Index in the data to access.
     * @return Time to complete the job at the specified index.
     */
    public int getData(int index) {
        return this.data[index];
    }

    /**
     * Overrides the builtin toString method.
     * 
     * @return Problem represented as a string.
     */
    public String toString() {
        return "Problem("
            + this.numMachines + ", "
            + this.numJobs + ", "
            + Arrays.toString(this.data) + ")";
    }
}
