package genetic;

import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class InitializerRandom implements Initializer {

    public Collection<Chromosome> initializePopulation(Problem problem, int pop_size) {
        Collection<Chromosome> population = new ArrayList<>();

        // Create pop_size number of Chromosomes.
        for (int i = 0; i < pop_size; i++) {
            Chromosome chromosome = new Chromosome(problem);
            int numJobs = problem.getNumJobs();
            int numMachines = problem.getNumMachines();

            // Set a random jobs permutation for each machine in the Chromosome.
            for (int j = 0; j < numMachines; j++) {
                List<Integer> jobs = new ArrayList<>();

                for (int k = 0; k < numJobs; k++) {
                    jobs.add(k);
                }

                Collections.shuffle(jobs);

                for (int k = 0; k < numJobs; k++) {
                    chromosome.setElement(j, k, jobs.get(k));
                }
            }
            
            chromosome.setInitialized();
            population.add(chromosome);
        }

        return population;
    }
}
