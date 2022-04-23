import moreMath.*;
import java.io.*;
public class Math
{
    public static void main(String args[]) throws IOException
    {
        while(true)
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Numerical num = new Numerical();
            Calculator cal = new Calculator();
            char option;
            int n, m;
            System.out.println();
            System.out.println("SOME NUMERICAL FUNCTIONS");
            System.out.println();
            System.out.println("Enter 1 for number system conversion");
            System.out.println("Enter 2 for factorial");
            System.out.println("Enter 3 for power function");
            System.out.println("Enter x for exiting");
            option = (char)br.read();
            br.read();
            switch(option)
            {
                case '1':
                System.out.println("Enter your number system base: ");
                n = Integer.parseInt(br.readLine());
                num.assignBase(n);
                System.out.println("Enter your number according to your number system: ");
                num.assignVal(br.readLine());
                System.out.println("Enter the number system base you want to convert to: ");
                n =  Integer.parseInt(br.readLine());
                num.convert(n);
                System.out.println("New base: " + n);
                System.out.println("New value: " + num.val);           
                break;

                case '2':
                System.out.println("Enter a number: ");
                n = Integer.parseInt(br.readLine());
                m = cal.factorial(n);
                if(m > 0)
                    System.out.println(n + "! = " + m);
                break;

                case '3':
                System.out.println("Enter a number: ");
                n = Integer.parseInt(br.readLine());
                System.out.println("Enter an exponent: ");
                m = Integer.parseInt(br.readLine());
                if(m < 0)
                    System.out.println("ERROR: I am not capable of finding negative powers.");
                else
                    System.out.println(n + "^" + m + " = " + cal.power(n, m));
                break;

                case 'x':
                System.out.println("Goodbye!");
                return;
            }
        }
    }
}