import java.io.File;
public class DirectoryListing {

    public static void main(String[] args) 
    {
        String dirName = "./";
        File curDir = new File(dirName);
        //Yes, directories are also files, a special kind of files containing the addresses of other files.
        File[] fileList = curDir.listFiles();
        /*
        The listFile method returns an array containing the file paths of the files in the directory
        */
        try 
        {
            int i = 0;
            while(true) 
                System.out.println(fileList[i++]);
            /*
            NOTE
            The elements of fileList may appear as strings, but they are of the type File.
            ------------
            The following would cause an error due incompatible data types...
            int i = 0;
            String fileName;
            while(true) 
            {
                fileName = fileList[i++];
                System.out.println(fileName);
            }
            ------------
            The following would be fine...
            int i = 0;
            File fileName;
            while(true) 
            {
                fileName = fileList[i++];
                System.out.println(fileName);
            }
            */
        } catch (Exception e) 
        {
            System.out.println("--END OF DIRECTORY--");
        }
        //You could use a for loop with the condition i < fileList.length, but this is more interesting to me.
    }
}