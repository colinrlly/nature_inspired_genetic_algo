package genetic;

public class GeneticAlgorithm {

    private Initializer initializer;
    private Selector selector;
    private Recombiner recombiner;
    private Mutator mutator;
    private Replacer replacer;

    public GeneticAlgorithm(Initializer initializer, Selector selector, Recombiner recombiner, Mutator mutator, Replacer replacer) {
        this.initializer = initializer;
        this.selector = selector;
        this.recombiner = recombiner;
        this.mutator = mutator;
        this.replacer = replacer;
    }
}
