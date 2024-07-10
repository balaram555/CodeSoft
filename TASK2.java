import java.util.*;
public class TASK2{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter telugu marks");
        int telugu=sc.nextInt();
        System.out.println("enter hindi marks");
        int hindi=sc.nextInt();
        System.out.println("enter english marks");
        int english=sc.nextInt();
        System.out.println("enter maths marks");
        int maths=sc.nextInt();
        System.out.println("enter science marks");
        int science=sc.nextInt();
        System.out.println("enter social marks");
        int social=sc.nextInt();
        int sum=telugu+hindi+english+maths+science+social;
        int avg=sum/7;
        System.out.println("Sum of all the marks is "+sum);
        System.out.println("Average percentage is "+avg);
        if(avg>=90){
            System.out.println("Grade A");
        }
        else if(avg>=80 && avg<90){
            System.out.println("Grade B");
        }
        else if(avg>=70 && avg<80){
            System.out.println("Grade C");
        }
        else if(avg>=60 && avg<70){
            System.out.println("Grade D");
        }
        else if(avg>=50 && avg<60){
            System.out.println("Grade F");
        }
        
    }
}