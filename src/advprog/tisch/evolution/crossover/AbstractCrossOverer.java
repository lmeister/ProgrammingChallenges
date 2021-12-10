package advprog.tisch.evolution.crossover;

import advprog.tisch.evolution.mutation.AbstractMutator;
import advprog.tisch.evolution.population.Table;

import java.util.Random;

public abstract class AbstractCrossOverer {
    protected static double mutationRate;
    protected Random random = new Random();
    protected AbstractMutator mutator;

    public abstract Table generateOffspring(Table parent1, Table parent2);
}
