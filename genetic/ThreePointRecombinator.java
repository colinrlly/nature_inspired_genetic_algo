package genetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

/***
 * Recombination method that utilizes a 3 point crossover method
 */
public class ThreePointRecombinator implements Recombiner {

    @Override
    public Collection<Chromosome> recombine(Collection<Chromosome> mating_pool) {

        // Collection that holds all of the offspring generated from the mating_pool
        Collection<Chromosome> offspring = new ArrayList<>();
        Collection<Chromosome> crossoffspring;

        // nested for loop, every chromosome is recombined with every other one, except itself
        // leading to n^2 offspring
        for (Chromosome chr1 : mating_pool){
            for (Chromosome chr2 : mating_pool){
                if(chr1.equals(chr2)){
                    continue;
                }
                crossoffspring = threepointCrossover(chr1, chr2);
                Chromosome first = crossoffspring.iterator().next();
                crossoffspring.remove(first);
                offspring.add(first);
                first = crossoffspring.iterator().next();
                offspring.add(first);
            }
        }
        return offspring;
    }

    /***
     * Function that utilizes a 3 point crossover method to generate offspring from the given Chromosomes
     * @param parent1 first input Chromosome
     * @param parent2 second input Chromosome
     * @return a Collection of Offspring Chromosomes generated
     */
    public Collection<Chromosome> threepointCrossover(Chromosome parent1, Chromosome parent2){
        int row = parent1.getProblem().getNumMachines();
        int col = parent1.getProblem().getNumJobs();

        // Collection that holds the offspring of the two given parent Chromosomes
        Collection<Chromosome> offspring = new ArrayList<>();
        Chromosome offspring1 = null;
        Chromosome offspring2 = null;

        // this block generates three random points within the bounds of the array size
        // and sorts them in ascending order to facilitate iteration though the chromosomes
        Random randGen = new Random();
        int[] threepoints = new int[3];
        threepoints[0] = randGen.nextInt(col);
        threepoints[1] = randGen.nextInt(col);
        threepoints[2] = randGen.nextInt(col);
        Arrays.sort(threepoints);
        int point1 = threepoints[0];
        int point2 = threepoints[1];
        int point3 = threepoints[2];


        // three separate for loops that iterate through all of the rows of the parent
        // Chromosomes, each one alternating placement of genes to the offsrping

        for (int i = 0; i < point1; i++) {
            for (int j = 0; j < col; j++) {
                offspring1.setElement(i, j, parent1.getElement(i, j));
                offspring2.setElement(i, j, parent2.getElement(i, j));
            }
        }

        for (int i = point1; i < point2; i++){
            for (int j = 0; j < col; j++){
                offspring1.setElement(i, j, parent2.getElement(i,j));
                offspring2.setElement(i, j, parent1.getElement(i,j));
            }
        }

        for (int i = point2; i < point3; i++){
            for (int j = 0; j < col; j++){
                offspring1.setElement(i, j, parent1.getElement(i,j));
                offspring2.setElement(i, j, parent2.getElement(i,j));
            }
        }

        // add resulting offspring of parents into a collection and return it
        offspring.add(offspring1);
        offspring.add(offspring2);

        return offspring;
    }
}
