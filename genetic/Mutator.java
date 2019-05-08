package genetic;

import java.util.Collection;

public interface Mutator {
    
    public Collection<Chromosome> mutate(Collection<Chromosome> mating_pool);
}
