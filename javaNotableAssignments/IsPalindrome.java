import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.IOException;
public class IsPalindrome
{
    public static void main(String args[]) throws IOException
    {
        //Creating buffered reader object
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i = 0, j = 0;
        char str[] = new char[30];
        char c;
        System.out.println("PALINDROME CHECKER");
        System.out.print("Enter string: ");
        //Enters string into character array format
        while((c = (char)reader.read()) != '\n' && i < 30)
        {
            str[i++] = c;
        }
        //Checks if character array is palidrome
        while(i >= j && str[j++] == str[i-- - 1]);
        if(j > i)
            System.out.println("You string is a palindrome");
        else
            System.out.println("You string is not a palindrome");
    }
}