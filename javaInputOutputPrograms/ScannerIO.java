import java.util.Scanner;
public class ScannerIO 
{
    public static void main(String[] args)
    {
        //Creating new object "in" of class Scanner
        Scanner in = new Scanner(System.in);
        
        //String input using method nextLine
        System.out.print("Enter a string: ");
        String s = in.nextLine();
        System.out.println("Your string: " + s);

        //Integer input using method nextInt
        System.out.print("Enter an integer: ");
        int i = in.nextInt();
        System.out.println("Your integer: " + i);

        //Floating point value input using method nextFloat
        System.out.print("Enter a number: ");
        float f = in.nextFloat();
        System.out.println("Your number: " + f);
    }
}