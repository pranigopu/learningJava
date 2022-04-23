import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
public class OddEvenCount
{
    public static int multipleCount(int A[], int factor)
    {
        int i = 0, count = 0;
        try
        {
            for(i = 0; true; i++)
                if(A[i] % factor == 0)
                    count++;
        }
        finally
        {
            return count;
        }
    }
    public static int inputInt(String prompt) throws IOException
    {
        int i = 0, flag = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            flag = 0;
            System.out.print(prompt);
            try
            {
                i = Integer.parseInt(br.readLine());
            }
            catch(NumberFormatException e)
            {
                flag = 1;
                System.out.println("Not an integer! Enter again...");
            }
            if(flag == 0)
                break;  
        }
        return i;
    }
    public static void main(String args[]) throws IOException
    {
        int evens = 0, max = 0;
        int A[] = new int[0];
        char choice = 'x';
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println("ODD EVEN COUNTER");
        while(true)
        {
            if(choice != 'y')
            {
                System.out.println("Enter array details...");
                A = null;
                A = new int[(max = inputInt("Enter array size: "))];
                for(int i = 0; i < max; i++)
                    A[i] = inputInt("Enter element " + (i + 1) + ": ");
            }
            if(choice == 'y')
            {
                System.out.println("Your array...");
                for(int i = 0; i < max; i++)
                    System.out.println("Element " + (i + 1) + ": " + A[i]);
            }
            System.out.println();
            System.out.println("Even numbers: " + (evens = multipleCount(A, 2)));
            System.out.println("Odd numbers: " + (max - evens));
            System.out.println();
            System.out.println("Enter y to repeat using the same array");
            System.out.println("Enter x to exit");
            System.out.println("Enter anything else to repeat using a different array");
            choice = (char)br.read();
            br.read();
            if(choice == 'x')
                break;
        }
    }
} 