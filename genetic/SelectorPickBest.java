package genetic;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Simple implementation of the selector interface. Returns the pool_size Chromosomes with the highest fitness.
 */
public class SelectorPickBest implements Selector {
    
    /**
     * Loop through population and return the pool_size most fit Chromosomes.
     */
    public Collection<Chromosome> select(Problem problem, Collection<Chromosome> population, int pool_size) {
        ArrayList<Chromosome> pop_copy = new ArrayList<>(population);
        Collection<Chromosome> mating_pool = new ArrayList<>();
        int pool_size_copy = pool_size;
        int highest_fitness;
        int current_fitness;
        Chromosome current_chromosome;
        Chromosome most_fit = new Chromosome(problem);
        int most_fit_index;

        // loop pool_size times
        while (pool_size_copy > 0) {
            most_fit_index = 0;
            highest_fitness = -1;

            // Loop through the population
            for (int i = 0; i < pop_copy.size(); i++) {
                current_chromosome = pop_copy.get(i);
                current_fitness = current_chromosome.getFitness();

                // If we found a new highest fitness chromosome
                if (current_fitness > highest_fitness) {
                    most_fit_index = i;
                    highest_fitness = current_fitness;
                    most_fit = current_chromosome;
                }
            }

            mating_pool.add(most_fit); // Add the most fit Chromosome to the mating pool

            // Remove the most fit Chromosome so we
            // don't keep selecting it over and over agian.
            pop_copy.remove(most_fit_index);
            pool_size_copy--;
        }

        return mating_pool;
    }
}
