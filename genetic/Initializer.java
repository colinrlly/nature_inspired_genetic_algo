package genetic;

import java.util.Collection;

public interface Initializer {

    public Collection<Chromosome> initializePopulation(Problem p, int pop_size);
}
