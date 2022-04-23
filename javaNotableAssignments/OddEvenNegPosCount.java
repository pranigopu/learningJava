import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
class MyArray
{
    int A[]= new int[0];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int size = 0;
    int evens = 0;
    int negs = 0;
    int pos = 0;
    private int inputInt(String message) throws IOException
    {
        int n = 0;
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
    public MyArray(){};
    public MyArray(String message) throws IOException
    {
        int n = 0;
        while(true)
        {
            n = inputInt(message);
            if(n < 2)
                System.out.print("Too few! Re-enter: ");
            else
                break;
        }
        this.size = n;
        this.A = new int[n];
    }
    public void enterElements() throws IOException
    {
        System.out.println("Enter elements...");
        for(int i = 0; i < this.size; i++)
            this.A[i] = inputInt("Enter element " + (i + 1) + ": ");
    }
    public void counter()
    {
        this.evens = 0;
        this.negs = 0;
        this.pos = 0;
        for(int i = 0; i < this.size; i++)
        {
            if(this.A[i] % 2 == 0)
                this.evens++;
            if(this.A[i] < 0)
                this.negs++;
            else if(this.A[i] > 0)
                this.pos++;
        }
    }
}
public class OddEvenNegPosCount
{
    public static void main(String args[]) throws IOException
    {
        MyArray array = new MyArray();
        char option = 'r';
        System.out.println("\nODD-EVEN-NEGATIVE-POSITIVE COUNTER");
        while(true)
        {    
            if(option == 'r')
                array = new MyArray("\nEnter desired no. of elements: ");
            array.enterElements();
            array.counter();
            System.out.println("\nHere are the frequencies of different kinds of numbers...");
            System.out.println("Even: " + array.evens);
            System.out.println("Odd: " + (array.size - array.evens));
            System.out.println("Negative: " + array.negs);
            System.out.println("Positive: " + array.pos);
            System.out.println("Zero: " + (array.size - array.negs - array.pos));
            System.out.println("\nEnter r to repeat with a different array");
            System.out.println("Enter x to exit");
            if((option = (char)array.br.read()) == 'x')
                break;
            array.br.read();
        }
        System.out.println("Goodbye!\n");
    }
}