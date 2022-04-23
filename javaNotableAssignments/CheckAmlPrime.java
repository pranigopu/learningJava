import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
abstract class AmlPrime
{
    AmlPrime(){};
    abstract boolean isPrime(int n);
    public int getValue(String str)
    {
        char c;
        int n = 0;
        for(int i = 0; i < str.length(); i++)
        {
            if((c = str.charAt(i)) >= 'a' && c <= 'z')
                n += c - 'a' + 1;
            else if(c >= 'A' && c <= 'Z')
                n += c - 'A' + 1;
            else if(c >= '0' && c <= '9')
                n += c - '0';
        }
        return n;
    }
    public String isSentencePrime(String str)
    {
        str = str + '\n';
        if(isPrime(getValue(str)))
            return "Prime Sentence";
        else
        {
            char c;
            int i, j, k = 0, wordCount = 0;
            for(i = 0; i < str.length(); i++)
            {
                if((c = str.charAt(i)) == ' ' || c == '\t' || c == '\n')
                    wordCount++;
            }
            String words[] = new String[wordCount];
            for(i = 0, j = 0; i < wordCount; i++, j++)
            {
                words[i] = " ";
                while(j < str.length())
                {
                    if((c = str.charAt(j)) == ' ' || c == '\t' || c == '\n')
                        break;
                    else
                        words[i] = words[i] + str.charAt(j++);
                }
            }
            for(i = 0; i < wordCount; i++)
            {
                for(j = 0; j < wordCount; j++)
                {
                    if(j == i)
                        continue;
                    else
                        k += getValue(words[j]);
                }
                if(isPrime(k))
                    return "Almost Prime (remove the word" + words[i] + " to make it prime)";
            }
            return "Not a Prime Sentence, so Composite";
        }
    }
}
public class CheckAmlPrime extends AmlPrime
{
    CheckAmlPrime()
    {
        super();
    }
    boolean isPrime(int n)
    {
        if(n == 0 || n == 1)
            return false;
        if(n < 0)
            n = -n;
        for(int i = 2; i * i <= n; i++)
            if(n % i == 0)
                return false;
        return true;
    }
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CheckAmlPrime k = new CheckAmlPrime();
        System.out.println("\nSTRINGS & PRIMES");
        char c, option;
        while(true)
        {
            System.out.println("\nEnter 1 to check for prime");
            System.out.println("Enter 2 to get string value");
            System.out.println("Enter 3 to check if string is prime");
            System.out.println("Enter x exit");
            option = (char)br.read();
            while((c = (char)br.read()) == ' ' || c == '\t');
            if(c != '\n')
            {
                System.out.println("Invalid option!");
                while((c = (char)br.read()) != '\n');
                continue;
            }
            switch(option)
            {
                case '1':
                    while(true)
                    {
                        System.out.print("Enter integer: ");
                        try
                        {
                            if(k.isPrime(Integer.parseInt(br.readLine())) == true)
                                System.out.println("The number is prime");
                            else
                                System.out.println("The number not is prime");
                            break;
                        }
                        catch(NumberFormatException e)
                        {
                            System.out.println("Not an integer!");
                        }
                    }
                    break;
                case '2':
                    System.out.print("Enter string: ");
                    System.out.println("The value of the string is " + k.getValue(br.readLine()));
                    break;
                case '3':
                    System.out.print("Enter sentence: ");
                    System.out.println(k.isSentencePrime(br.readLine()));
                    break;
                case 'x':
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}