import java.text.DecimalFormat;

/**
 * Represents a single calculation for the weighted grade
 * @author Jinwoo Han
 * @version 2023_09_23_V_1
 */
public class GradeBook {
    /**
     *  Total point available for an assignment
     */
    private final double pointTotal;
    /**
     *  Total point earned for an assignment
     */
    private final double earnedPoints;
    /**
     *  The percentage of assignment in the total grade.
     */
    private final double assignmentPercentage;
    /**
     *  Total point earned in the total grade.
     */
    private double totalWeightedGrade;

    /**
     * Constructor
     * @param pointTotal Total possible points
     * @param earnedPoints Total earned points
     * @param assignmentPercentage Weighted percentage in the total grade
     */
    public GradeBook(double pointTotal, double earnedPoints, double assignmentPercentage) {
        this.pointTotal = pointTotal;
        this.earnedPoints = earnedPoints;
        this.assignmentPercentage = assignmentPercentage;
        this.totalWeightedGrade = 0.0; // Reset the value each beginning step
    }

    /**
     * Calculation engine
     */
    public void calculateWeightedGrade() {
        totalWeightedGrade = (earnedPoints / pointTotal) * assignmentPercentage;
    }

    /**
     * Retrieves the total weighted points
     * Using DecimalFormat to round the total weighted grade to digit between 2 and 6
     * @return The total weighted points
     */
    public double getTotalWeightedGrade() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setMinimumFractionDigits(2);
        decimalFormat.setMaximumFractionDigits(6);
        return Double.parseDouble(decimalFormat.format(totalWeightedGrade));
    }
}
