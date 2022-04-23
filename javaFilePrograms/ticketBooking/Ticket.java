import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Date;
public class Ticket
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String args[]) throws IOException
	{
		char c;
        int i;
        boolean isCreated;
        File pngrdata = new File("passenger.txt");
        isCreated = pngrdata.createNewFile();
        FileWriter fwriter = new FileWriter("passenger.txt", true);
        FileReader freader = new FileReader("passenger.txt");
        System.out.println("\nTICKET GENERATOR");
        if(isCreated == true)
        {
            fwriter.write("PNRNO          FROM           DESTINATION    DATE           PNRNAME        TRAINNO\n");
            fwriter.close(); //To commit this change to the file immediately
            fwriter = new FileWriter("passenger.txt", true);
        }
		while(true)
		{
			System.out.println("------------------------\nEnter details...");
            enterDetails("passenger.txt");
			System.out.println("Input another? (y/n)");
			if((c = (char)br.read()) != 'y')
                break;
            br.read();
		}
		fwriter = new FileWriter("ticket.txt");
		while((i = freader.read()) != -1)
		{
			fwriter.write((char)i);
        }
        fwriter.close();
        freader.close();
        freader = new FileReader("ticket.txt");
        System.out.println("========================\nTicket...");
        while((i = freader.read()) != -1)
		{
			System.out.print((char)i);
        }
        freader.close();
    }
    static String space(int stringLength, int maxLength)
    {
        String str = new String();
        str = " ";
        for(int i = 0; i < maxLength - stringLength; i++)
            str += " ";
        return str;
    }
	static void enterDetails(String fileName) throws IOException
	{
        FileWriter fwriter = new FileWriter(fileName, true);
        String tmp;
		//INPUTTING ALL DETAILS AS STRINGS AND STORE INTO THE FILE
        System.out.print("Passenger number: ");
        fwriter.write((tmp = br.readLine()) + space(tmp.length(), 14));
        System.out.print("From station: ");
        fwriter.write((tmp = br.readLine()) + space(tmp.length(), 14));
        System.out.print("To station: ");
        fwriter.write((tmp = br.readLine()) + space(tmp.length(), 14));
        System.out.print("Date: ");
        fwriter.write((tmp = br.readLine()) + space(tmp.length(), 14));
        System.out.print("Passenger name: ");
        fwriter.write((tmp = br.readLine()) + space(tmp.length(), 14));
        System.out.print("Train number: ");
        fwriter.write((tmp = br.readLine()) + "\n");
        fwriter.close();
	}
}