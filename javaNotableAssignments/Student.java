/*
NAME: Pranav Gopalkrishna
REGISTER NUMBER: 1940223
*/
import java.util.Date;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.IOException;
public class Student
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int StudentId;
    String StudentName;
    String SchoolName;
    int TuitionFees = 50000;
    float ExtracurricularFees;
    Date CollegeJoiningDate;
    public Student(){}
    public Student(boolean inputs) throws IOException
    {
        if(inputs = true)
        {
            System.out.print("Enter ID: ");
            this.StudentId = Integer.parseInt(br.readLine());
            System.out.print("Enter name: ");
            this.StudentName = br.readLine();
            System.out.print("Enter school name: ");
            this.SchoolName = br.readLine();
            System.out.print("Enter extracurricular fees: ");
            this.ExtracurricularFees= Float.parseFloat(br.readLine());
            System.out.print("Enter joining date: ");
            this.CollegeJoiningDate = new Date(br.readLine());
        }
    }
    public float FinalBill()
    {
        return (float)this.TuitionFees + this.ExtracurricularFees;
    }
    public static void main(String args[]) throws IOException
    {
        Student std[] = new Student[10];
        int last = 0;
        int i;
        int option = 0;
        System.out.println("\nSTUDENT ENTRY AND FEES VIEW");
        while(true)
        {
            System.out.println("\nEnter 1 to enter student");
            System.out.println("Enter 2 to view students");
            System.out.println("Enter 3 to calculate final fees for student");
            System.out.println("Enter 0 to exit");
            option = Integer.parseInt(br.readLine());
            switch(option)
            {
                case 1:
                    std[last++] = new Student(true);
                    break;
                case 2:
                    for(i = 0; i < last; i++)
                    {
                        System.out.println("STUDENT " + (i + 1));
                        System.out.println("ID: " + std[i].StudentId);
                        System.out.println("Name: " + std[i].StudentName);
                        System.out.println("School: " + std[i].SchoolName);
                        System.out.println("Tuition: " + std[i].TuitionFees);
                        System.out.println("Extra fees: " + std[i].ExtracurricularFees);
                        System.out.println("Joined on: " + std[i].CollegeJoiningDate);
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.println("Enter student ID: ");
                    option = Integer.parseInt(br.readLine());
                    for(i = 0; i < 10; i++)
                    {
                        if(std[i].StudentId == option)
                            break;
                    }
                    if(i >= 10)
                        System.out.println("Student not found!");
                    else
                        System.out.println("The final fees of this student is " + std[i].FinalBill());
                    break;
                case 0:
                    return;
            }   
        }
    }
}