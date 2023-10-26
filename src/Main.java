import java.util.Scanner;
/**
 *  Main method for running GradeBook
 *  It will be following questions to finish the method
 *  1. It will ask for total possible points for the assignment
 *  2. It will ask for total earned points for the assignment
 *  3. It will ask for the percentage of the assignment in the total grade
 *  4. It will display the total weighted grade of the assignment
 *  5. It will repeat the calculation all over again if they ask.
 */
public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        boolean continueCalculation = true;

        do {

            System.out.print("Enter the point total for the assignment: ");
            double pointTotal = input.nextDouble();

            System.out.print("Enter the earned points for the assignment: ");
            double earnedPoints = input.nextDouble();

            System.out.print("Enter the assignment percentage: ");
            double assignmentPercentage = input.nextDouble();

            GradeBook newCalculation = new GradeBook(pointTotal, earnedPoints, assignmentPercentage);
            newCalculation.calculateWeightedGrade();

            System.out.println("Total Weighted Grade: " + newCalculation.getTotalWeightedGrade());

            System.out.print("Do you want to perform another calculation? (yes/no): ");
            String choice = input.next().toLowerCase();

            if (!choice.equals("yes")) {
                continueCalculation = false;
            }

        } while (continueCalculation);

        input.close();
    }
}
