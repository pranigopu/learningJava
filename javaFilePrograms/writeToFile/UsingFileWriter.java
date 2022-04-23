import java.io.IOException;
import java.io.FileWriter;
public class UsingFileWriter
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char c;
        System.out.println("Enter w to write, a to append... ");
        c = (char)br.read();
        br.read();
        if(c == 'w') //To write to a file by erasing existing content and inserting new content
            FileWriter fwriter = new FileWriter(args[0]);
        else if(c == 'a') //To append to a file, we use another class constructor, and pass an extra boolean parameter (append = true)
            fwriter = new FileWriter(args[0], true);
        while((c = (char)br.read()) != '\n')
            fwriter.write(c);
        fwriter.close();
    }    
}