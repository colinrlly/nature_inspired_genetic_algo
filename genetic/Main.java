package genetic;

import java.util.Collection;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Problem problem = new Problem(3, 6, "data/test3_6.csv");
        System.out.println(problem);
        Chromosome chromosome = new Chromosome(problem);
        System.out.println(chromosome.getProblem());

        chromosome.setElement(0, 0, 0);
        chromosome.setElement(0, 1, 2);
        chromosome.setElement(0, 2, 1);
        chromosome.setElement(0, 3, 5);
        chromosome.setElement(0, 4, 3);
        chromosome.setElement(0, 5, 4);

        chromosome.setElement(1, 0, 2);
        chromosome.setElement(1, 1, 1);
        chromosome.setElement(1, 2, 4);
        chromosome.setElement(1, 3, 5);
        chromosome.setElement(1, 4, 3);
        chromosome.setElement(1, 5, 0);

        chromosome.setElement(2, 0, 5);
        chromosome.setElement(2, 1, 2);
        chromosome.setElement(2, 2, 3);
        chromosome.setElement(2, 3, 4);
        chromosome.setElement(2, 4, 0);
        chromosome.setElement(2, 5, 1);

        chromosome.setInitialized();

        System.out.println(chromosome);
        System.out.println(chromosome.solutionToString());

        System.out.println("fitness is " + chromosome.getFitness());

        // Mutator testing
        Collection<Chromosome> mating_pool = new ArrayList<>();
        mating_pool.add(chromosome);
        System.out.println("-- OG Pool --");
        System.out.println(mating_pool);
        System.out.println("-- Small Mutator Pool --");
        Mutator mutator = new SmallMutator();
        mutator.mutate(mating_pool);
        System.out.println(mating_pool);
        System.out.println("-- Large Mutator Pool --");
        mutator = new LargeMutator();
        mutator.mutate(mating_pool);
        System.out.println(mating_pool);
    }    
}
