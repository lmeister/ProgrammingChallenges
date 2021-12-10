package advprog.tisch;

import advprog.tisch.evolution.Configuration;
import advprog.tisch.evolution.Optimizer;
import advprog.tisch.evolution.crossover.AbstractCrossOverer;
import advprog.tisch.evolution.crossover.LegCombinationCrossOverer;
import advprog.tisch.evolution.evaluation.AbstractEvaluator;
import advprog.tisch.evolution.evaluation.WobblynessEvaluator;
import advprog.tisch.evolution.mutation.AbstractMutator;
import advprog.tisch.evolution.mutation.LegMutator;
import advprog.tisch.evolution.population.Table;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Configuration configuration = new Configuration(500, 200, 0.0, 0.05, 0.3);
        AbstractMutator mutator = new LegMutator(configuration.getMAX_LENGTH_FACTOR());
        AbstractCrossOverer crossOverer = new LegCombinationCrossOverer(configuration.getMUTATION_RATE(), mutator);
        AbstractEvaluator evaluator = new WobblynessEvaluator();
        Optimizer optimizer = new Optimizer(evaluator, crossOverer, configuration);

        Optional<Table> result = optimizer.optimize();
        if (result.isPresent()) {
            System.out.println("Success! Resulting Table:" + result.get());
        } else {
            System.out.println("No perfect table found. :-(");
        }


//        //Optimizer optimizer = new Optimizer();
//        Random random = new Random();
//
//        Map<Integer, Integer> frequencyMap = new HashMap<>();
//        for (int i = 0; i < 10000; i++) {
//            int value = (int) Math.round(random.nextGaussian() * Math.sqrt(10)) + 100;
//            //double value = random.nextGaussian();
//            //System.out.println(value);
//            frequencyMap.merge(value, 1, Integer::sum);
//        }
//
//        for (int i = 80; i <= 120; i++) {
//            System.out.println("Key: " + i + ", Frequency: " + frequencyMap.get(i));
//        }
    }
}
