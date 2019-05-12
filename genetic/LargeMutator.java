package genetic;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;

/**
 * Large modification of chromosomes
 */
public class LargeMutator implements Mutator {

  Random rand = new Random();

  public Collection<Chromosome> mutate(Collection<Chromosome> mating_pool) {
    // Loop through all chromosomes
    for (Chromosome chromosome : mating_pool) {
      int m = chromosome.getProblem().getNumMachines();
      int n = chromosome.getProblem().getNumJobs();

      ArrayList<Integer> machineRow = new ArrayList<>();

      // Shuffle a random machine in each chromosome
      int machineIdx = rand.nextInt(m);
      for (int i = 0; i < n; i++) {
        machineRow.add(chromosome.getElement(machineIdx, i));
      }
      Collections.shuffle(machineRow);
      for (int i = 0; i < n; i++) {
        chromosome.setElement(machineIdx, i, machineRow.get(i));
      }
    }

    return mating_pool;
  }
}
