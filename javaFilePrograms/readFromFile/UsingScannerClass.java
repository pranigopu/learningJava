import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class UsingScannerClass 
{
    public static void main(String args[]) throws FileNotFoundException
    {
        File myFile = new File(args[0]);
        Scanner fileReader = new Scanner(myFile);
        while(fileReader.hasNextLine() == true)
        {
            String data = fileReader.nextLine();
            System.out.println(data);
        }
        fileReader.close();
    }
}