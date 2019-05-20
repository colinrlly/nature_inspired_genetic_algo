package genetic;

import java.util.Collection;
import java.util.ArrayList;

public class Main {

    public int bestInPopulation(Collection<Chromosome> population){
        Chromosome best = population.iterator().next();
        int b = best.getFitness();
        for(Chromosome i : population) {
            if (i.getFitness() < b) {
                best = i;
                b = i.getFitness();
            }
        }
        return b;
    }

    public static void main(String[] args) {
        Problem problem = new Problem(20, 300, "data/benchmark1_20_300.csv");
        Initializer initializer = new InitializerRandom();
        //Collection<Chromosome> population = initializer.initializePopulation(problem, 20);
        //Collection<Chromosome> population2 = initializer.initializePopulation(problem, 20);





        //Selector selector = new SelectorPickBest();
        //Mutator mutator = new SmallMutator();
        //ThreePointRecombinator recombinator = new ThreePointRecombinator();
        //SteadyStateElitist replacer = new SteadyStateElitist();
        //ElitistReplacer replacer = new ElitistReplacer();
        int numberOfTrials = 25;


        //Collection<Chromosome> population3 = replacer.replace(population,population2);
        //System.out.println(population3);


        long start = System.nanoTime();
        for(int x = 0; x < numberOfTrials; x++) {
            Selector selector = new SelectorPickBest();
            Mutator mutator = new SmallMutator();
            Recombiner recombinator = new ThreePointRecombinator();
            Replacer replacer = new ElitistReplacer();

            boolean terminationConditionReached = false;
            int count = 0;
            int max = 20;
            Collection<Chromosome> population = initializer.initializePopulation(problem, 20);
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
            long end = System.nanoTime();
            System.out.println(b);
        }
        long end = System.nanoTime();
        System.out.println((end-start)/(numberOfTrials*1000000000.0));

        //System.out.println("\n\n\n");
/*
        for(int x = 0; x < numberOfTrials; x++) {
            Selector selector = new SelectorPickBest();
            Mutator mutator = new SmallMutator();
            ThreePointRecombinator recombinator = new ThreePointRecombinator();
            SteadyStateElitist replacer = new SteadyStateElitist();

            boolean terminationConditionReached = false;
            int count = 0;
            int max = 10;
            Collection<Chromosome> population = initializer.initializePopulation(problem, 20);
            long start = System.nanoTime();
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
            long end = System.nanoTime();
            System.out.println("Best fitness: " + b + " in time: " + (end-start)/1000000000.0);
        }

        System.out.println("\n\n\n");

        for(int x = 0; x < numberOfTrials; x++) {
            Selector selector = new SelectorPickBest();
            Mutator mutator = new SmallMutator();
            UniformRecombinator recombinator = new UniformRecombinator();
            ElitistReplacer replacer = new ElitistReplacer();

            boolean terminationConditionReached = false;
            int count = 0;
            int max = 10;
            Collection<Chromosome> population = initializer.initializePopulation(problem, 20);
            long start = System.nanoTime();
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
            long end = System.nanoTime();
            System.out.println("Best fitness: " + b + " in time: " + (end-start)/1000000000.0);
        }

        System.out.println("\n\n\n");

        for(int x = 0; x < numberOfTrials; x++) {
            Selector selector = new SelectorPickBest();
            Mutator mutator = new SmallMutator();
            UniformRecombinator recombinator = new UniformRecombinator();
            SteadyStateElitist replacer = new SteadyStateElitist();

            boolean terminationConditionReached = false;
            int count = 0;
            int max = 10;
            Collection<Chromosome> population = initializer.initializePopulation(problem, 20);
            long start = System.nanoTime();
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
            long end = System.nanoTime();
            System.out.println("Best fitness: " + b + " in time: " + (end-start)/1000000000.0);
        }

        System.out.println("\n\n\n");

        for(int x = 0; x < numberOfTrials; x++) {
            Selector selector = new SelectorPickBest();
            Mutator mutator = new LargeMutator();
            ThreePointRecombinator recombinator = new ThreePointRecombinator();
            ElitistReplacer replacer = new ElitistReplacer();

            boolean terminationConditionReached = false;
            int count = 0;
            int max = 10;
            Collection<Chromosome> population = initializer.initializePopulation(problem, 20);
            long start = System.nanoTime();
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
            long end = System.nanoTime();
            System.out.println("Best fitness: " + b + " in time: " + (end-start)/1000000000.0);
        }

        System.out.println("\n\n\n");

        for(int x = 0; x < numberOfTrials; x++) {
            Selector selector = new SelectorPickBest();
            Mutator mutator = new LargeMutator();
            ThreePointRecombinator recombinator = new ThreePointRecombinator();
            SteadyStateElitist replacer = new SteadyStateElitist();

            boolean terminationConditionReached = false;
            int count = 0;
            int max = 10;
            Collection<Chromosome> population = initializer.initializePopulation(problem, 20);
            long start = System.nanoTime();
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
            long end = System.nanoTime();
            System.out.println("Best fitness: " + b + " in time: " + (end-start)/1000000000.0);
        }

        System.out.println("\n\n\n");

        for(int x = 0; x < numberOfTrials; x++) {
            Selector selector = new SelectorPickBest();
            Mutator mutator = new LargeMutator();
            UniformRecombinator recombinator = new UniformRecombinator();
            ElitistReplacer replacer = new ElitistReplacer();

            boolean terminationConditionReached = false;
            int count = 0;
            int max = 10;
            Collection<Chromosome> population = initializer.initializePopulation(problem, 20);
            long start = System.nanoTime();
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
            long end = System.nanoTime();
            System.out.println("Best fitness: " + b + " in time: " + (end-start)/1000000000.0);
        }

        System.out.println("\n\n\n");

        for(int x = 0; x < numberOfTrials; x++) {
            Selector selector = new SelectorPickBest();
            Mutator mutator = new LargeMutator();
            UniformRecombinator recombinator = new UniformRecombinator();
            SteadyStateElitist replacer = new SteadyStateElitist();

            boolean terminationConditionReached = false;
            int count = 0;
            int max = 10;
            Collection<Chromosome> population = initializer.initializePopulation(problem, 20);
            long start = System.nanoTime();
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
            long end = System.nanoTime();
            System.out.println("Best fitness: " + b + " in time: " + (end-start)/1000000000.0);
        }

        System.out.println("\n\n\n");

        */

    }    
}
