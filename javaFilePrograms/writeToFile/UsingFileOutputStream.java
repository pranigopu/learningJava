import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
/*
FileOutputStream is used for writing streams of raw bytes such as image data.
It’s good to use with bytes of data that can’t be represented as text such as PDF, excel documents and image files
It is a subclass of the class OutputStream.
------------
FileOutputStream opens a stream with a given file as the destination.
Hence, you output data into the file.
*/
public class UsingFileOutputStream
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char c;
        System.out.println("Enter w to write, a to append... ");
        c = (char)br.read();
        br.read();
        if(c == 'w') //To write to a file by erasing existing content and inserting new content
            FileOutputStream fos = new FileOutputStream(args[0]);
        else if(c == 'a') //To append to a file, we use another class constructor, and pass an extra boolean parameter (append = true)
            FileOutputStream fos = new FileOutputStream(args[0], true);
        while((c = (char)br.read()) != '\n')
            fos.write(c);
        fos.close();
    }
}