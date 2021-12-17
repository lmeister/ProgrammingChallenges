package advprog.tisch.evolution.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Get all configuration data from the spinners
                // Call the optimizer
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new MainWindow("Genetically Evolving the Perfect Table");
        frame.setVisible(true);
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
}
