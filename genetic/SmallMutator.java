package genetic;

import java.util.Collection;

/**
 * Small modification of chromosomes
 */
public class SmallMutator implements Mutator {

  public Collection<Chromesome> mutate(Collection<Chromosome> mating_pool) {
    // Helper array to get two random, distinct, indexes
    ArrayList<Integer> randIdxs = new ArrayList<>();
    for (int i = 0; i < mating_pool[0].getProblem().getNumJobs(); i++) {
      randIdxs.add(new Integer(i));
    }

    // Loop through all chromosomes
    for (Chromesome chromosome : mating_pool) {
      int m = chromosome.getProblem().getNumMachines();
      int n = chromosome.getProblem().getNumJobs();

      // Small modification to each machine in each chromosome
      for (int i = 0; i < n; i++) {
        Collection.shuffle(randIdxs);
        int firstSwap = chromosome.getElement(i, randIdxs[0]);
        int secondSwap = chromosome.getElement(i, randIdxs[1]);
        chromosome.setElement(i, randIdxs[0], secondSwap);
        chromosome.setElement(i, randIdxs[1], firstSwap);
      }
    }

    return mating_pool;
  }
}
