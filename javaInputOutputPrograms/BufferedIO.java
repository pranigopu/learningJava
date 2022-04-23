import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class BufferedIO{
    public static void main(String[] args) throws IOException
    {
        System.out.println("Enter your name and age: ");
        //Creating new object of class BufferedReader in which an object of InputStreamReader is wrapped
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Alternate method
        /*
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(r);
        */

        //Using the method readLine to input into the object "reader" and assigning the input to the string object "name"
        String name = reader.readLine();
        
        //Using the method readLine to input into the object "reader" and assigning the input to the integer object "age"
        int age = Integer.parseInt(reader.readLine());
        /*
        parseInt method converts string to integer
        */

        System.out.println("Your name is " + name + " and your age is " + age);
    }
}