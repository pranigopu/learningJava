import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
public class IsFileCreated 
{
    public static void main(String args[]) throws IOException
    {
        File myFile = new File(args[0]);
        //Declare file, but not create it yet
        if(myFile.createNewFile() == true)
        {
            System.out.println(myFile.getName() + " has been created");
        }
        else
        {
            System.out.println(myFile.getName() + " already exists");
        }
        //Atomically creates an empty file named by the abstract pathname defined in the declaration if and only if a file with this name does not yet exist.
    }
}