import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
public class LinearSearch
{
    public static int linSearch(int A[], int searchVal)
    {
        int i = 0;
        try
        {
            for(i = 0; true; i++)
            {
                if(A[i] == searchVal)
                    return i;
                i++;
            }
        }
        catch (ArrayIndexOutOfBoundsException e) 
        {
            return -1;
        }
    }
    public static void display(int A[])
    {
        int i = 0;
        try
        {
            for(i = 0; true; i++)
            {
                System.out.println("Element " + (i + 1) + ": " + A[i]);
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            if(i == 0)
                System.out.println("Array not created!");
        }
    }
    public static int intInput(String message) throws IOException
    {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        while(true)
        {
            try
            {
                System.out.print(message);
                n = Integer.parseInt(br.readLine());
                return n;
            }
            catch(NumberFormatException e)
            {
                System.out.println("Not an integer!");
            }
        }
    }
    public static void main(String args[]) throws IOException
    {
        int A[] = new int[0];
        int n = 0;
        int m = 0;
        //INITIAL DISPLAY
        System.out.println();
        System.out.println("LINEAR SEARCH IMPLEMENTATION");
        //MAIN PORTION
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        while(true)
        {
            System.out.println("OPTIONS...");
            System.out.println("Enter + to create a new array");
            System.out.println("Enter v to view to array");
            System.out.println("Enter ? to search value in array");
            System.out.println("Enter x to exit");
            System.out.print(">> ");
            switch((char)br.read())
            {
                case '+':
                    br.read();
                    A = new int[(n = intInput("How many elements to enter? "))];
                    for(int i = 0; i < n; i++)
                    {
                        A[i] = intInput("Element " + (i + 1) + ": ");
                    }
                    break;
                case 'v':
                    br.read();
                    display(A);
                    break;
                case '?':
                    br.read();
                    n = intInput("Enter search value: ");
                    if((m = linSearch(A, n)) > -1)
                        System.out.println(n + " was found in index " + m);
                    else
                        System.out.println(n + " was not found in the array.");
                    break;
                case 'x':
                    return;
                default:
                    br.read();
                    System.out.println("Invlaid option!");
            }
            System.out.println();
        }
    }
}