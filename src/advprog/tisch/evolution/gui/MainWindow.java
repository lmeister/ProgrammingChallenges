package advprog.tisch.evolution.gui;

import advprog.tisch.evolution.Configuration;
import advprog.tisch.evolution.Optimizer;
import advprog.tisch.evolution.crossover.AbstractCrossOverer;
import advprog.tisch.evolution.crossover.LegCombinationCrossOverer;
import advprog.tisch.evolution.evaluation.AbstractEvaluator;
import advprog.tisch.evolution.evaluation.WobblynessEvaluator;
import advprog.tisch.evolution.mutation.AbstractMutator;
import advprog.tisch.evolution.mutation.LegMutator;
import advprog.tisch.evolution.population.Table;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Optional;

public class MainWindow extends JFrame {
    private JTextArea outputTextArea;
    private JButton runButton;
    private JButton visualizeButton;
    private JSpinner lengthDeviationSpinner;
    private JSpinner mutationRateSpinner;
    private JSpinner tournamentSizeSpinner;
    private JSpinner generationSizeSpinner;
    private JSpinner maximumGenerationsSpinner;
    private JPanel mainPanel;
    private JLabel maxGenerationsLabel;
    private JLabel generationSizeLabel;
    private JLabel tournamentSIzeLabel;
    private JLabel mutationRateLabel;
    private JLabel lengthDeviationLabel;
    private JLabel outputLabel;

    public MainWindow(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        // This will run the optimizer
        runButton.addActionListener(getRunListener());
    }

    private ActionListener getRunListener() {
        return actionEvent -> {
            // Get config
            // Start optimizer

            int generationSize = 10;
            int maxGenerations = 20;
            double lengthDeviation = 0.1;
            double mutationRate = 0.15;

            try {
                generationSize = getGenerationSpinnerValue();
                maxGenerations = getMaximumGenerationSpinnerValue();
                lengthDeviation = getLengthDeviationSpinnerValue();
                mutationRate = getMutationRateSpinnerValue();
            } catch (ParseException e) {
                e.printStackTrace();
            }


            Configuration configuration = new Configuration(generationSize, maxGenerations, 0.0, lengthDeviation, mutationRate);
            AbstractMutator mutator = new LegMutator(configuration.getMAX_LENGTH_FACTOR());
            AbstractCrossOverer crossOverer = new LegCombinationCrossOverer(configuration.getMUTATION_RATE(), mutator);
            AbstractEvaluator evaluator = new WobblynessEvaluator();
            Optimizer optimizer = new Optimizer(evaluator, crossOverer, configuration);

            Optional<Table> result = optimizer.optimize();

            if (result.isPresent()) {
                this.setOutputTextArea("Success!\nResulting Table: " + result.get());
                System.out.println("Success! Resulting Table:" + result.get());
            } else {
                this.setOutputTextArea("No perfect table found. :-(");
                System.out.println("No perfect table found. :-(");
            }
        };
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        SpinnerNumberModel lengthDeviation = new SpinnerNumberModel(0.15, 0.0, 1.00, 0.01);
        this.lengthDeviationSpinner = new JSpinner();
        this.lengthDeviationSpinner.setModel(lengthDeviation);

        SpinnerNumberModel mutationRate = new SpinnerNumberModel(0.1, 0.0, 1.00, 0.01);
        this.mutationRateSpinner = new JSpinner();
        this.mutationRateSpinner.setModel(mutationRate);

        SpinnerNumberModel tournamentSize = new SpinnerNumberModel(0.2, 0.0, 1.00, 0.01);
        this.tournamentSizeSpinner = new JSpinner();
        this.tournamentSizeSpinner.setModel(tournamentSize);

        SpinnerNumberModel generationSize = new SpinnerNumberModel(10, 10, 500, 1);
        this.generationSizeSpinner = new JSpinner();
        this.generationSizeSpinner.setModel(generationSize);

        SpinnerNumberModel maxGenerations = new SpinnerNumberModel(5, 1, 500, 1);
        this.maximumGenerationsSpinner = new JSpinner();
        this.maximumGenerationsSpinner.setModel(maxGenerations);

    }

    public void setOutputTextArea(String text) {
        this.outputTextArea.setText(text);
    }

    public void appendOutputText(String text) {
        this.outputTextArea.append(text);
    }

    public int getGenerationSpinnerValue() throws ParseException {
        this.generationSizeSpinner.commitEdit();
        return (int) this.generationSizeSpinner.getValue();
    }

    public int getMaximumGenerationSpinnerValue() throws ParseException {
        this.maximumGenerationsSpinner.commitEdit();
        return (int) this.maximumGenerationsSpinner.getValue();
    }

    public double getTournamentSizeSpinnerValue() throws ParseException {
        this.tournamentSizeSpinner.commitEdit();
        return (double) this.tournamentSizeSpinner.getValue();
    }

    public double getMutationRateSpinnerValue() throws ParseException {
        this.mutationRateSpinner.commitEdit();
        return (double) this.mutationRateSpinner.getValue();
    }

    public double getLengthDeviationSpinnerValue() throws ParseException {
        this.lengthDeviationSpinner.commitEdit();
        return (double) this.lengthDeviationSpinner.getValue();
    }
}
