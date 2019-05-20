package genetic;

import java.util.ArrayList;
import java.util.Collection;


/**
 *  A simple implementation of a fitness proportionate method of choosing the mating pool from a given population
 */
public class FitnessBasedSelector implements Selector {
    @Override
    public Collection<Chromosome> select(Problem p, Collection<Chromosome> population, int pool_size) {
        ArrayList<Chromosome> pop_copy = new ArrayList<>(population);
        Collection<Chromosome> mating_pool = new ArrayList<>();
        int pool_size_copy = pool_size;
        double total_fitness = 0;

        // loop through the whole population, getting the total fitness of the entire population
        for(Chromosome chr : population){
            total_fitness += chr.getFitness();
        }

        double prob;

        // loop pool_size times, to get the needed number of Chromosomes
        while (pool_size_copy > 0){

            // generate a random number from 0 to 1
            prob = Math.random();

            // loop through all of the Chromosomes
            for (Chromosome chr : pop_copy){

                // if the Chromosome had a lower proportional fitness, it gets added to the pool
                // because a lower fitness means a more efficient answer
                if((chr.getFitness()/total_fitness) < prob){
                    mating_pool.add(chr);
                    pool_size_copy--;
                }
            }
        }

        return mating_pool;
    }
}
