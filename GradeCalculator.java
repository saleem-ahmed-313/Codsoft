import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

     
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        int[] marksArray = new int[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            marksArray[i] = scanner.nextInt();
        }

       
        int totalMarks = 0;
        for (int marks : marksArray) {
            totalMarks += marks;
        }

       
        double averagePercentage =  totalMarks*1.0 / numSubjects;

        
        char grade = calculateGrade(averagePercentage);

        
        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
