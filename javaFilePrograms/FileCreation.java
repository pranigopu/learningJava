import java.io.File;
import java.io.IOException;
public class FileCreation 
{
    public static void main(String args[]) throws IOException
    {
        //Declare file, but not create it yet
        File myFile = new File("test.txt");
        myFile.createNewFile();
        //Automatically creates an empty file named by the abstract pathname defined in the declaration if and only if a file with this name does not yet exist.
    }
}