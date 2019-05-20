package genetic;

import java.util.Collection;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Problem problem = new Problem(20, 300, "data/benchmark1_20_300.csv");
        Initializer initializer = new InitializerRandom();
        Collection<Chromosome> population = initializer.initializePopulation(problem, 20);
        Collection<Chromosome> population2 = initializer.initializePopulation(problem, 20);





        Selector selector = new SelectorPickBest();
        Mutator mutator = new SmallMutator();
        ThreePointRecombinator recombinator = new ThreePointRecombinator();
        //SteadyStateElitist replacer = new SteadyStateElitist();
        ElitistReplacer replacer = new ElitistReplacer();
        int numberOfTrials = 10;


        //Collection<Chromosome> population3 = replacer.replace(population,population2);
        //System.out.println(population3);



        for(int x = 0; x < numberOfTrials; x++) {

            boolean terminationConditionReached = false;
            int count = 0;
            int max = 10;
            population = initializer.initializePopulation(problem, 20);

            do {
                Collection<Chromosome> mating_pool = selector.select(problem, population,20);
                Collection<Chromosome> offspring = recombinator.recombine(mating_pool);
                offspring = mutator.mutate(offspring);
                population = replacer.replace(population, offspring);
                count++;
            } while (count < max);
            Chromosome best = population.iterator().next();
            int b = best.getFitness();
            for(Chromosome i : population) {
                if (i.getFitness() < b) {
                    best = i;
                    b = i.getFitness();
                }
            }
            System.out.println("Best fitness: " + b);
        }

    }    
}
