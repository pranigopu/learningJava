import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.IOException;
class Exam
{
    String str;
    int num;
    public Exam(){}
}
public class Test extends Exam
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public Test()
    {
        super();
    }
    public void Read() throws IOException
    {
        System.out.print("Enter string: ");
        this.str = br.readLine();
        while(true)
        {
            try
            {
                System.out.print("Enter integer: ");
                this.num = Integer.parseInt(br.readLine());
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Not an integer!");
            }
        }
    }
    public void convertCase()
    {
        String str = new String();
        int i = 0;
        char c;
        while(true)
        {
            try
            {
                if((c = this.str.charAt(i++)) >= 'a' && c <= 'z')
                    c += 'A' - 'a';
                else if(c >= 'A' && c <= 'Z')
                    c += 'a' - 'A';
                str += c;
            }
            catch(StringIndexOutOfBoundsException e)
            {
                break;
            }
        }
        this.str = str;
        System.out.println("Reversed case string: " + this.str);
    }
    public void powerDigit()
    {
        int sumOfDigits = 0, digit = 0, tmp = this.num;
        while(tmp != 0)
        {
            digit = tmp % 10;
            sumOfDigits += digit * digit * digit;
            tmp /= 10;
        }
        System.out.println("Integer digit cubes sum: " + sumOfDigits);
    }
    public void count()
    {
        int i = 0, vowelCount = 0;;
        while(true)
        {
            try
            {
                switch(this.str.charAt(i++))
                {
                    case 'a': case 'e': case 'i': case 'o': case 'u':
                    case 'A': case 'E': case 'I': case 'O': case 'U':
                        vowelCount++;
                }
            }
            catch(StringIndexOutOfBoundsException e)
            {
                break;
            }
        }
        System.out.println("Vowel count: " + vowelCount);
    }
    public static void main(String args[]) throws IOException
    {
        Test test = new Test();
        char c, tmp;
        do
        {
            System.out.println("\nASYNCHRONOUS ACTIVITY - OCTOBER 10TH\n");
            test.Read();
            System.out.println("\nString: " + test.str);
            System.out.println("Integer: " + test.num + "\n");
            
            test.convertCase();
            test.powerDigit();
            test.count();
            
            System.out.print("\nRepeat? (y/n)... ");
            while((c = (char)br.read()) == ' ' || c == '\t');
            while((tmp = (char)br.read()) == ' ' || tmp == '\t');
            if(tmp != '\n')
                c = 'n';
            System.out.println();
        } while(c == 'y');
    }
}