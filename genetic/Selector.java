package genetic;

import java.util.Collection;

public interface Selector {
    
    public Collection<Chromosome> select(Problem p, Collection<Chromosome> population, int pool_size);
}
