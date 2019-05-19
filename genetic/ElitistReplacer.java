package genetic;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ElitistReplacer implements Replacer{

    //number of chromosomes kept
    private int n = 50;
    //random comment to commit change

    @Override
    public Collection<Chromosome> replace(Collection<Chromosome> population, Collection<Chromosome> offspring) {
        ArrayList<Chromosome> populations = new ArrayList<>(population);
        ArrayList<Chromosome> offsprings = new ArrayList<>(offspring);
        Collection<Chromosome> nextGeneration = new ArrayList<Chromosome>();
        for(int x = 0; x < n; x++){
            int maxpop = 0;
            int maxpos = 0;
            int count = 0;
            boolean first = true;
            for(Chromosome c : populations){
                int cFit = c.getFitness();
                if(cFit > maxpop) {
                    maxpop = cFit;
                    maxpos = count;
                }
                count++;
            }
            count = 0;
            for (Chromosome c: offsprings){
                int cFit = c.getFitness();
                if(cFit > maxpop) {
                    maxpop = cFit;
                    maxpos = count;
                    first = false;
                }
                count++;
            }
            if (first) {
                Chromosome best = populations.get(maxpos);
                nextGeneration.add(best);
                populations.remove(best);
            } else {
                Chromosome best = offsprings.get(maxpos);
                nextGeneration.add(best);
                offsprings.remove(best);
            }
        }

        return nextGeneration;
    }


}
