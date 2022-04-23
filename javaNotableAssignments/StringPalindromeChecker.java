import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.IOException;
public class StringPalindromeChecker
{
    static int lastIndex(String str)
    {
        int n = 0;
        try 
        {
            while(true)
            {
                str.charAt(n);
                n++;
            }
        }
        catch(StringIndexOutOfBoundsException e)
        {
            n--;
        }
        return n;
    }
    static void isPalindrome(String str)
    {
        int i = 0;
        int j = lastIndex(str);
        while(i < j)
        {
            if(str.charAt(i) != str.charAt(j))
                break;
            i++;
            j--;
        }
        if(i < j)
            System.out.println("The string " + str + " is not a palindrome.");
        else
            System.out.println("The string " + str + " is a palindrome.");
    }
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println();
        System.out.println("PALINDROME CHECKER");
        while(true)
        {
            System.out.println("Enter a string to check if it is a palindrome...");
            StringBuffer tmp = new StringBuffer();
            tmp = tmp.append(str = br.readLine());
            System.out.println("Enter 1 to use built-in methods");
            System.out.println("Enter 2 to use user-defined methods");
            System.out.println("Enter x to exit");
            switch(br.read())
            {
                case '1':
                    if(str.equals(tmp.reverse().toString()))
                        System.out.println("The string " + str + " is a palindrome.");
                    else
                    System.out.println("The string " + str + " is not a palindrome.");
                    break;
                case '2':
                    isPalindrome(str);
                    break;
                case 'x':
                    System.out.println("Goodbye.");
                    return;
            }
            br.read();
            System.out.println();
        }
    }
}