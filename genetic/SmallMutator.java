package genetic;

import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;

/**
 * Small modification of chromosomes
 */
public class SmallMutator implements Mutator {

  public Collection<Chromosome> mutate(Collection<Chromosome> mating_pool) {
    // Helper array to get two random, distinct, indexes
    ArrayList<Integer> randIdxs = new ArrayList<>();
    for (int i = 0; i < mating_pool.iterator().next().getProblem().getNumJobs(); i++) {
      randIdxs.add(new Integer(i));
    }

    // Loop through all chromosomes
    for (Chromosome chromosome : mating_pool) {
      int m = chromosome.getProblem().getNumMachines();
      int n = chromosome.getProblem().getNumJobs();

      // Small modification to each machine in each chromosome
      for (int i = 0; i < n; i++) {
        Collections.shuffle(randIdxs);
        int firstSwap = chromosome.getElement(i, randIdxs.get(0));
        int secondSwap = chromosome.getElement(i, randIdxs.get(1));
        chromosome.setElement(i, randIdxs.get(0), secondSwap);
        chromosome.setElement(i, randIdxs.get(1), firstSwap);
      }
    }

    return mating_pool;
  }
}
