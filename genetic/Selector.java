package genetic;

//import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Random;

public interface Selector {
    
    public Collection<Chromosome> select(Problem p, Collection<Chromosome> population, int pool_size);
}

/****
public class Selection implements Selector
{
    @java.lang.Override
    public Collection<Chromosome> select(Collection<Chromosome> mating_pool)
    {
        int selection_size = 1; //number of fit individuals to return

        Chromosome[] input = mating_pool.toArray(Chromosome); //the chromosomes as an array

        //total fitness in th group
        int totalFitness = 0;

        for(Chromosome c : mating_pool)
        {
            totalFitness+= c.getFitness();
        }

        Chromosome chosen[selection_size]; // the chosen chromosomes

        //choose chromosomes fitness proportionally
        for(int i = 0; i < selection_size; i++)
        {
            //choose a random fitness
            Random chooser = new Random();
            int current = chooser.nextInt(totalFitness);

            //go through the chromosomes until you reach that fitness total
            int currentFitness = 0;
            for(int j = 0; j < Array.getLength(input); j++)
            {
                currentFitness+= input[j].getFitness();
                if(currentFitness > current)
                {
                    //add the chromosomes to the answer
                    chosen[i] = input[j];

                    //then remove them from further consideration
                    totalFitness-= chosen[i].getFitness();
                    mating_pool = mating_pool.remove(chosen[i]);
                    input[] = mating_pool.toArray();

                    //then end the loop
                    break;
                }
            }
        }

        return chosen;
    }

    /**
     @java.lang.Override
     public Collection<Chromosome> select(Collection<Chromosome> mating_pool)
     {
     int selection_size = 1; //number of fit individuals to return

     int input[] = mating_pool.toArray(); //the chromosomes as an array

     Chromosome chosen[selection_size]; // the chosen chromosomes

     int size = Array.getLength(input);

     //sort the input by size
     for(int i = 0; i < size; i++)
     {
     for(int j = 0; j < size; j++)
     {
     if(input[j].getFitness() > input[i].getFitness())
     {
     Chromosome move = input[i];
     input[i] = input[j];
     input[j] = move;
     }
     }
     }

     //pick the first elements to return
     for(int i = 0; i < selection_size; i++)
     {
     chosen[i] = input[i];
     }
     return chosen;

     }
     **/
//}