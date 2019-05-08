package genetic;

import java.util.Collection;

public interface Replacer {
    
    public Collection<Chromosome> replace(Collection<Chromosome> mating_pool);
}
