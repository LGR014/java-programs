public class GradeCalculator {
    public static void main(String[] args) {
        
    
    int grade1 = 86;
    int grade2 = 84;
    int grade3 = 44;

    double totalGrade = (grade1 + grade2 + grade3);
    double averageGrade = (totalGrade/3);

    System.out.println(averageGrade);

    if (averageGrade >= 90) {
        System.out.println("A");
    } else if (averageGrade >= 80) {
        System.out.println("B"); 
    } else if (averageGrade >= 70) {
        System.out.println("C");
    } else if (averageGrade >= 60) {
        System.out.println("D"); 
    } else {
        System.out.println("F");
    }
        
    }
        }
    
        

    



        



