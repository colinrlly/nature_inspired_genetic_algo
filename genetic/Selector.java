package genetic;

import java.util.Collection;

public interface Selector {
    
    public Collection<Chromosome> select(Collection<Chromosome> mating_pool);
}
