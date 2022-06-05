package ActionItems;

public class AI02_conditional {
    public static void main(String[] args) {
        //declare integer with value
        int grade = 69;

        if (grade >= 90 && grade <= 100) {
            System.out.println("Grade is A");
        } else if (grade < 90 && grade >= 80) {
            System.out.println("Grade is B");
        } else if (grade < 80 && grade >= 70) {
            System.out.println("Grade is C");
        } else if (grade < 70 && grade >= 60) {
            System.out.println("Grade is D");
        } else if (grade < 60) {
            System.out.println("Grade is F");
        }//end of conditions

    }//end of main method

}//end of java class
