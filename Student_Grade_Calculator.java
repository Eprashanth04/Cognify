import java.util.Scanner;

public class Student_Grade_Calculator{

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);

        System.out.print("Enter the number of Grades:");
        int grade=s.nextInt();

        int[] gds=new int[grade];
        for(int i=0;i<grade;i++){
            System.out.print("Enter the grade " + (i+1) + ": ");
            gds[i] =s.nextInt();

        }

        int sum=0;
        for(int gd:gds){
            sum +=gd;
        }
        
        double avg=(double)sum /grade;
        System.out.println("The Average grade is:"+ avg);
    }
}
