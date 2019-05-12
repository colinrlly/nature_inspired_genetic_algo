package genetic;

import java.util.Collection;
import java.util.Random;

/**
 * Large modification of chromosomes
 */
public class LargeMutator implements Mutator {

  Random rand = new Random();

  public Collection<Chromesome> mutate(Collection<Chromosome> mating_pool) {
    // Loop through all chromosomes
    for (Chromesome chromosome : mating_pool) {
      int m = chromosome.getProblem().getNumMachines();
      int n = chromosome.getProblem().getNumJobs();

      ArrayList<Integer> machineRow = new ArrayList<>();

      // Shuffle a random machine in each chromosome
      int machineIdx = rand.nextInt(m);
      for (int i = 0; i < n; i++) {
        machineRow.add(chromosome.getElement(machineIdx, i));
      }
      Collection.shuffle(machineRow);
      for (int i = 0; i < n; i++) {
        chromosome.setElement(machineIdx, i, machineRow[i]);
      }
    }

    return mating_pool;
  }
}
