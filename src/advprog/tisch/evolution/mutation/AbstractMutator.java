package advprog.tisch.evolution.mutation;

import advprog.tisch.evolution.population.Table;

import java.util.Random;

public abstract class AbstractMutator {

    protected final Random rnd = new Random();

    public abstract Table mutate(Table table);
}
