package genetic;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Recombination method that utilizes Uniform Crossover
 */
public class UniformRecombinator implements Recombiner {

    @Override
    public Collection<Chromosome> recombine(Collection<Chromosome> mating_pool) {

        // Collection that holds all of the offspring generated from the mating_pool
        Collection<Chromosome> offspring = new ArrayList<>();
        Collection<Chromosome> crossoffspring;

        // nested for loop, every chromosome is recombined with every other one, except itself
        // leading to n^2 offspring
        int num_of_iters = 0;
        for (Chromosome chr1 : mating_pool){
            for (Chromosome chr2 : mating_pool){
                num_of_iters++;
                if(chr1.toString().equals(chr2.toString())){
                    continue;
                }
                crossoffspring = uniformCrossover(chr1, chr2);
                Chromosome first = crossoffspring.iterator().next();
                crossoffspring.remove(first);
                offspring.add(first);
                first = crossoffspring.iterator().next();
                offspring.add(first);
            }
            if(num_of_iters == mating_pool.size()){
                break;
            }
        }
        return offspring;
    }

    /**
     * Function that implements uniform crossover recombinations, accepts two Chromosomes as input,
     * iterates through every single row from both Chromosomes, and uses a random number generator
     * to determine from which parent do the offspring receive a gene
     * @param parent1 first input Chromosome
     * @param parent2 second input Chromosome
     * @return a collection of Offspring Chromosomes generated
     */
    public Collection<Chromosome> uniformCrossover(Chromosome parent1, Chromosome parent2){
        // initialization of the probability used to determine from what parent does the offspring
        // recieve genes from
        double prob;

        int row = parent1.getProblem().getNumMachines();
        int col = parent1.getProblem().getNumJobs();

        Collection<Chromosome> offspring = new ArrayList<>();
        Chromosome offspring1 = new Chromosome(parent1.getProblem());
        Chromosome offspring2 = new Chromosome(parent2.getProblem());

        // nested for loop that iterates through the rows of the parents
        for (int i = 0; i < row; i++){
            // generates a random real number from 0 to 1
            prob = Math.random();

            // if the number generated is larger than 0.5, the first offspring receives gene from the
            // first parent, and second offspring recieves gene from second parent
            if(prob > 0.5){
                for (int j = 0; j < col; j++){
                    offspring1.setElement(i, j, parent1.getElement(i, j));
                    offspring2.setElement(i, j, parent2.getElement(i, j));
                }
            }else{
                for (int j = 0; j < col; j++){
                    offspring1.setElement(i, j, parent2.getElement(i, j));
                    offspring2.setElement(i, j, parent1.getElement(i, j));
                }

            }
        }
        offspring1.setInitialized();
        offspring.add(offspring1);
        offspring2.setInitialized();
        offspring.add(offspring2);

        return offspring;
    }
}
