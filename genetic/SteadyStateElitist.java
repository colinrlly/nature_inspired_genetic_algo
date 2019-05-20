package genetic;

import java.util.ArrayList;
import java.util.Collection;

public class SteadyStateElitist implements Replacer {

    //number of chromosomes to switch
    private int n = 5;
    //random comment to commit change

    @Override
    public Collection<Chromosome> replace(Collection<Chromosome> population, Collection<Chromosome> offspring) {
        ArrayList<Chromosome> populations = new ArrayList<>(population);
        ArrayList<Chromosome> offsprings = new ArrayList<>(offspring);
        Collection<Chromosome> toAdd = new ArrayList<Chromosome>();
        //find n to add
        for(int x = 0; x < n; x++){
            int maxpop = populations.get(0).getFitness();
            int maxpos = 0;
            int count = 0;
            for(Chromosome c : offsprings){
                int cFit = c.getFitness();
                if(cFit < maxpop) {
                    maxpop = cFit;
                    maxpos = count;
                }
                count++;
            }
            Chromosome best = offsprings.get(maxpos);
            toAdd.add(best);
            offsprings.remove(best);
        }
        //delete n from population
        for(int x = 0; x < n; x++){
            int minpop = populations.get(0).getFitness();
            int minpos = 0;
            int count = 0;
            for(Chromosome c : populations){
                int cFit = c.getFitness();
                if(cFit > minpop) {
                    minpop = cFit;
                    minpos = count;
                }
                count++;
            }
            Chromosome best = populations.get(minpos);
            populations.remove(best);
        }
        //add n to population
        for (Chromosome c : toAdd)
            populations.add(c);

        return populations;

    }
}
