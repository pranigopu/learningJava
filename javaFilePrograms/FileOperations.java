import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
class MyFile
{
    File file = null;
    boolean isDirectory = false;
    public MyFile(){}
    private boolean isNull()
    {
        if(file == null)
        {
            System.out.println("Enter a file name first!");
            return true;
        }
        return false;
    }
    private void list()
    {
        File files[] = this.file.listFiles();
        int i = 0;
        try
        {
            System.out.println("List of files in the directory...");
            while(true)
                System.out.println(files[i++]);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("(End of directory)");
        }
        /*
        NOTES:
        "listFiles" method is called using a "File" object.
        The "File" object in this case needs to a directory.
        The "listFiles" method returns an array "File" objects, which are the contents of the given file.
        */
    }
    private boolean confirm(String operationName) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char c, tmp; 
        System.out.println("Confirm " + operationName + "? (y/n)");
        while((c = (char)br.read()) == ' ' || c == '\t');
        while((tmp = (char)br.read()) == ' ' || tmp == '\t');
        if(tmp != '\n')
            return false;
        if(c != 'y')
        {
            System.out.println("Cancelled");
            return false;
        }
        return true;
    }
    public MyFile(String message) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(message);
        this.file = new File(br.readLine());
    }
    public void create() throws IOException
    {
        if(isNull())
            return;
        if(this.file.createNewFile() == true)
            System.out.println("File is created in this directory.");
        else
            System.out.println("File already exists in this directory.");
        /*
        NOTES:
        createNewFile is a method called using a "File" object.
        It is used to allocate secondary memory for a file with a given name, after which it returns value "true".
        If a file of the same name exists in the directory, memory is not allcoated and the return value is "false".
        */
    }
    public void createAsDir() throws IOException
    {
        if(this.file == null)
            System.out.println("Enter a directory name first.");
        else if(this.file.mkdir() == true)
            System.out.println("Directory is created in this directory.");
        else
            System.out.println("Directory already exists in this directory.");
        /*
        NOTES:
        The "mkdir" method is called by a file object.
        (Note that a directory is a kind of file itself)
        The creation of a directory is different from a normal file, hence this separate method is used to create a directory for the file object.
        It works in a manner similar to the "createNewFile".
        If a directory with the same name exists, it returns false.
        If it has created a directory, it returns true.
        */
    }
    public void writeToFile() throws IOException
    {
        if(isNull())
            return;
        String input = new String();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if(this.file.isDirectory())
        {
            System.out.println("Cannot write to a directory!");
            return;
        }
        try 
        {
            FileWriter fwriter = new FileWriter(this.file, true);
            System.out.println("(Type and enter <quit> to exit write mode)");
            System.out.println("... <started writing>");
            while(!(input = br.readLine()).equals("<quit>"))
                fwriter.write(input + '\n');
            fwriter.close();
            System.out.println("\n...<stopped writing>");
        }
        catch(FileNotFoundException e)
        {
            System.out.println("The file needs to be created!");
        }
        /*
        NOTES:
        "FileWriter" extends "OutputStreamWriter".
        "FileWriter" is a class that creates and handles a character output stream to a given file.
        Passing the "true" parameter in the class constructor opens the file stream in append mode.
        This will allow you to write to the file after the last filled byte of the file.
        Not giving this parameter will allow you to write to the file from its first byte, and cause the file's previous contents to erase. 
        (This is further explained in the "eraseContents" method defined below)
        If file does not exist...
        - If the file does not exist, the "FileWriter" class constructor will try to create it
        - If the given file also cannot be created, the "FileWriter" class constructor will throw a "FileNotFoundException".
        To pass characters or strings through the stream into the file, we use the "write" method, which is called by the "FileWriter" object.
        To close the file output stream created by the instantiation of the "FileWriter" object, we use the "close" method, which is also called by the "FileWriter" object.
        */
    }
    public void readFromFile() throws IOException
    {
        if(isNull())
            return;
        int i;
        if(this.file.isDirectory())
        {
            list();
            return;
        }
        try 
        {
            FileReader freader = new FileReader(this.file);
            System.out.println("... <start of file>");
            while((i = freader.read()) != -1)
            {
                System.out.print((char)i);
            }
            freader.close();
            System.out.println("\n...<end of file>");
        }
        catch(FileNotFoundException e)
        {
            System.out.println("The file needs to be created!");
        }
        /*
        NOTES:
        "File Reader" extends "InputStreamReader".
        "FileReader" is a class that creates and handles a byte input stream from a given file.
        If file does not exist, the "FileReader" class constructor will throw a "FileNotFoundException".
        To read bytes from the file, we use the "read" method, which is called by a "FileReader" object.
        However, the "read" method's return value is an ASCII value, hence it must be typecasted into a character to output it as a character.
        To close the file input stream created by the instantiation of the "FileReader" object, we use the "close" method, also called by the "FileReader" object.
        */
    }
    public void eraseContents() throws IOException
    {
        if(isNull())
            return;
        if(confirm("content wipe") == false)
            return;
        if(this.file.isDirectory())
        {
            File files[] = this.file.listFiles();
            int i = 0;
            try
            {
                while(true)
                    remove(files[i++]);
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Directory emptied.");
            }
            return;
        }
        try
        {
            FileWriter fwriter = new FileWriter(this.file);
            fwriter.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("The file needs to be created!");
        }
        System.out.println("Contents erased.");
        /*
        NOTES:
        To erase a file's contents, we exploit a property of the "FileWriter" class constructor.
        By default, it opens a file output stream such that the end of file character is brought to the first byte, effectively erasing the file's previous contents.
        */
    }
    private void remove(File file)
    {
        if(isNull())
            return;
        if(confirm("deletion") == false)
            return;
        if(file.delete() == false)
        {
            if(file.isDirectory())
                System.out.println("Empty the directory to delete it!");
            else
                System.out.println("The file needs to be created!");
        }
        else
            System.out.println("Deleted.");
        /*
        NOTES:
        The "delete" function is called using a "File" object.
        It is used to deallocate the memory allocated to the file (denoted by the "File" object), after which it return value "true".
        If the given file does not exist, or if the given file cannot be deleted for some other reason, the method returns value "false".
        */
    }
    public void remove()
    {
        remove(this.file);
        /*
        NOTES:
        I wanted to use the "remove" method is different ways, so I overloaded it.
        */
    }
    public void info()
    {
        if(isNull())
            return;
        System.out.println("... <start of info>");
        System.out.println("Name: " + this.file.getName());
        System.out.println("Exists: " + this.file.exists());
        if(this.file.exists())
        {
            System.out.println("Is directory: " + this.file.isDirectory());
            System.out.println("Size: " + this.file.length() + " bytes");
            System.out.println("Path: " + this.file.getPath());
            System.out.println("------\nAbsolute path:\n" + this.file.getAbsolutePath());
        }
        System.out.println("... <end of info>");
        /*
        NOTES:
        These functions are simply functions that return different information about the file.
        */
    }
}
public class FileOperations
{
    static void displayOptions()
    {
        System.out.println("Enter n to enter file name");
        System.out.println("Enter c to create file");
        System.out.println("Enter d to create directory");
        System.out.println("Enter w to write to file");
        System.out.println("Enter r to read from file");
        System.out.println("Enter e to erase file's contents");
        System.out.println("Enter - to delete file");
        System.out.println("Enter i to get info on file");
        System.out.println("Enter x to exit");        
    }
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MyFile f = new MyFile();
        char option;
        System.out.println();
        System.out.println("FILE OPERATIONS");
        System.out.println("(Enter ? to check the options)");
        while(true)
        {
            System.out.print(">> ");
            option = (char)br.read();
            if(br.read() != '\n')
            {
                option = '\0';
                while(br.read() != '\n');
            }
            switch(option)
            {
                case '?':
                    displayOptions();
                    break;
                case 'n':
                    f = new MyFile("Enter file name: ");
                    break;
                case 'c':
                    f.create();
                    break;
                case 'd':
                    f.createAsDir();
                    break;
                case 'w':
                    f.writeToFile();
                    break;
                case 'r':
                    f.readFromFile();
                    break;
                case 'e':
                    f.eraseContents();
                    break;
                case '-':
                    f.remove();
                    break;
                case 'i':
                    f.info();
                    break;
                case 'x':
                    return;
                default:
                    System.out.println("Not an option!");
            }
        }
    }
}