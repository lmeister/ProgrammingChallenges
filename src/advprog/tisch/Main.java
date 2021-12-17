package advprog.tisch;

import advprog.tisch.evolution.Configuration;
import advprog.tisch.evolution.Optimizer;
import advprog.tisch.evolution.crossover.AbstractCrossOverer;
import advprog.tisch.evolution.crossover.LegCombinationCrossOverer;
import advprog.tisch.evolution.evaluation.AbstractEvaluator;
import advprog.tisch.evolution.evaluation.WobblynessEvaluator;
import advprog.tisch.evolution.gui.MainWindow;
import advprog.tisch.evolution.mutation.AbstractMutator;
import advprog.tisch.evolution.mutation.LegMutator;
import advprog.tisch.evolution.population.Table;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Create Gui
        MainWindow mainWindow = new MainWindow("Genetically evolving the Perfect Table");
        mainWindow.setVisible(true);



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
