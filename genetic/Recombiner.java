package genetic;

import java.util.Collection;

public interface Recombiner {
    
    public Collection<Chromosome> recombine(Collection<Chromosome> mating_pool);
}