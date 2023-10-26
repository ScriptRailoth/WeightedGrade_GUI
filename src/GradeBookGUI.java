import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeBookGUI extends JFrame {
    private JTextField totalPointsField;
    private JTextField earnedPointsField;
    private JTextField percentageField;
    private JLabel resultLabel;

    public GradeBookGUI(double pointTotal, double earnedPoints, double assignmentPercentage) {
        setTitle("GradeBook Calculator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Total Points:"));
        totalPointsField = new JTextField();
        panel.add(totalPointsField);

        panel.add(new JLabel("Earned Points:"));
        earnedPointsField = new JTextField();
        panel.add(earnedPointsField);

        panel.add(new JLabel("Percentage:"));
        percentageField = new JTextField();
        panel.add(percentageField);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateGrade();
            }
        });
        panel.add(calculateButton);

        resultLabel = new JLabel("Result: ");
        panel.add(resultLabel);

        add(panel);
    }

    private void calculateGrade() {
        try {
            double totalPoints = Double.parseDouble(totalPointsField.getText());
            double earnedPoints = Double.parseDouble(earnedPointsField.getText());
            double percentage = Double.parseDouble(percentageField.getText());

            GradeBook gradeBook = new GradeBook(totalPoints, earnedPoints, percentage);
            gradeBook.calculateWeightedGrade();

            double result = gradeBook.getTotalWeightedGrade();
            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                double pointTotal = 0;
                double earnedPoints = 0;
                double assignmentPercentage = 0;
                new GradeBookGUI(pointTotal, earnedPoints, assignmentPercentage).setVisible(true);
            }
        });
    }
}
