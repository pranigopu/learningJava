import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class ArrayInsertDelete
{
    public static void displayArray(int A[], int max)
    {
        System.out.println();
        for(int i = 0; i < max; i++)
        {
            System.out.println("Element " + (i + 1) + ": " + A[i]);
            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException
    {
        //Preparing objects to allow buffered reading of the input stream
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);
        char c;
        int i = 0, j = 0, tmp = 0;
        int max = 80;
        int A[] = new int[max]; 
        do
        {
            System.out.println();
            System.out.println("ARRAY INPUT, DELETE AND VIEW");
            System.out.println("Enter i to insert");
            System.out.println("Enter d to delete");
            System.out.println("Enter v to simply view");
            c = (char)reader.read();
            /*
            It so turns out that
            reader.read() reads characters as integers (according to ASCII values),
            reader.readLine() inputs strings.
            Hence, we need to typecast the input as char.
            */
            switch(c)
            {
                case 'i':
                    if(i < 80)
                    {
                        reader.read();
                        /*
                        The above line is written for the following reason:
                        - A string is read from the buffer file until a newline character is encountered.
                        - The last input was of the character c, but a newline character was also added to the buffer file, since "enter" is pressed to finish an input.
                        - When a string is read, the file pointer moves after the newline, but not so for a character input.
                        - Hence, when the program reads a character or string from the buffer, it encounters the newline and immediately stops reading the string, without accepting from the user.
                        - Hence, the above line reads the newline character from the buffer file and moves the file pointer ahead of it, readying the program for the next input.
                        */
                        System.out.println();

                        System.out.print("Enter element: ");
                        A[i] = Integer.parseInt(reader.readLine());
                        i++;
                    }
                    else
                    {
                        System.out.println();
                        System.out.println("Oopsie! The array is full!");
                        reader.read();
                        //This line is explained above in a big comment above
                    }
                    break;
                case 'd':
                    if(i > 0)
                    {
                        reader.read();
                        //This line is explained above in a big comment above

                        System.out.println();
                        System.out.print("Enter position: ");
                        tmp = Integer.parseInt(reader.readLine());
                        tmp--;
                        for(j = tmp; j < i - 1; j++)
                        {
                            A[j] = A[j + 1];
                        }
                        i--;
                        System.out.println("Deleted record at position " + (tmp + 1));
                    }
                    else
                    {
                        System.out.println();
                        System.out.println("Oopsie! Array is empty!");
                        reader.read();
                        //This line is explained above in a big comment above
                    }
                    break;
                case 'v':
                    if(i > 0)
                    {
                        displayArray(A, i);
                    }
                    else
                    {
                        System.out.println();
                        System.out.println("Nothing to view!");
                    }
                    reader.read();
                    //This line is explained above in a big comment above
                    break;
                case 'x':
                    break;
                default:
                    System.out.println();
                    System.out.println("Not an option!");
                    reader.read();
                    //This line is explained above in a big comment above
            }
        } while(c != 'x');
    }
}