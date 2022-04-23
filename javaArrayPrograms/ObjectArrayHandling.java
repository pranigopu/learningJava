/*
This program stores student records in an array.
You can insert and delete records.
*/

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class ObjectArrayHandling
{
    public static class Student
    {
        String stdNo;
        String stdName;
        String stdClass;
        int stdAge;
        //Class constructor
        public Student
        (   
            String stdNo, 
            String stdName, 
            String stdClass, 
            int stdAge
        )
        {
            this.stdNo = stdNo;
            this.stdName = stdName;
            this.stdClass =stdClass;
            this.stdAge = stdAge;
        }
    }
    public static void displayArray(Student std[], int max)
    {
        System.out.println();
        for(int i = 0; i < max; i++)
        {
            System.out.println("STUDENT " + (i + 1));
            System.out.println("Register no.: " + std[i].stdNo);
            System.out.println("Name: " + std[i].stdName);
            System.out.println("Class: " + std[i].stdClass);
            System.out.println("Age: " + std[i].stdAge);
            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException
    {
        //Preparing objects to allow buffered reading of the input stream
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);
        char c;
        int i = 0, j = 0, tmp = 0;
        int max = 80;
        String str;
        Student std = new Student("x", "x", "x", 0);
        Student stdArray[] = new Student[80]; 
        do
        {
            System.out.println();
            System.out.println("STUDENT ARRAY INPUT, DELETE AND VIEW");
            System.out.println("Enter i to insert");
            System.out.println("Enter d to delete");
            System.out.println("Enter v to simply view");
            c = (char)reader.read();
            /*
            It so turns out that
            reader.read() reads characters as integers (according to ASCII values),
            reader.readLine() inputs strings.
            Hence, we need to typecast the input as char.
            */
            switch(c)
            {
                case 'i':
                    if(i < 80)
                    {
                        reader.read();
                        /*
                        The above line is written for the following reason:
                        - A string is read from the buffer file until a newline character is encountered.
                        - The last input was of the character c, but a newline character was also added to the buffer file, since "enter" is pressed to finish an input.
                        - When a string is read, the file pointer moves after the newline, but not so for a character input.
                        - Hence, when the program reads a character or string from the buffer, it encounters the newline and immediately stops reading the string, without accepting from the user.
                        - Hence, the above line reads the newline character from the buffer file and moves the file pointer ahead of it, readying the program for the next input.
                        */
                        System.out.println();

                        System.out.print("Enter student register no.: ");
                        std.stdNo = reader.readLine();

                        System.out.print("Enter student name: ");
                        std.stdName = reader.readLine();

                        System.out.print("Enter student class: ");
                        std.stdClass = reader.readLine();

                        System.out.print("Enter student age: ");
                        std.stdAge = Integer.parseInt(reader.readLine());
                        
                        stdArray[i] = new Student(std.stdNo, std.stdName, std.stdClass, std.stdAge);

                        i++;
                    }
                    else
                    {
                        System.out.println();
                        System.out.println("Oopsie! The array is full!");
                        reader.read();
                        //This line is explained above in a big comment above
                    }
                    break;
                case 'd':
                    if(i > 0)
                    {
                        reader.read();
                        //This line is explained above in a big comment above

                        System.out.println();
                        System.out.println("Enter 1 to delete by register no.");
                        System.out.println("Enter 2 to delete by name");
                        System.out.println("Enter 3 to delete by position");
                        switch((char)reader.read())
                        {
                            case '1':
                                reader.read();
                                //This line is explained above in a big comment
                                System.out.println();
                                tmp = 0;
                                System.out.print("Enter register no.: ");
                                str = reader.readLine();
                                while(tmp < i && str.equals(stdArray[tmp].stdNo) == false)
                                {
                                    tmp++;
                                }
                                if(tmp >= i)
                                {
                                    System.out.println("Given register no. not found");
                                    break;
                                }
                                for(j = tmp; j < i - 1; j++)
                                {
                                    stdArray[j] = stdArray[j + 1];
                                }
                                System.out.println("Deleted record at position " + (tmp + 1));
                                i--;
                                break;
                            case '2':
                                reader.read();
                                //This line is explained above in a big comment
                                System.out.println();
                                tmp = 0;
                                System.out.print("Enter name: ");
                                str = reader.readLine();
                                while(tmp < i && str.equals(stdArray[tmp].stdName) == false)
                                {
                                    tmp++;
                                }
                                if(tmp >= i)
                                {
                                    System.out.println("Given name not found");
                                    break;
                                }
                                for(j = tmp; j < i - 1; j++)
                                {
                                    stdArray[j] = stdArray[j + 1];
                                }
                                System.out.println("Deleted record at position " + (tmp + 1));
                                i--;
                                break;
                            case '3':
                                reader.read();
                                //This line is explained above in a big comment
                                System.out.println();
                                System.out.print("Enter position: ");
                                tmp = Integer.parseInt(reader.readLine());
                                tmp--;
                                if(tmp < 0 || tmp > max - 1)
                                {
                                    System.out.println("Enter between 1 and " + max);
                                    break; 
                                }
                                for(j = tmp; j < i - 1; j++)
                                {
                                    stdArray[j] = stdArray[j + 1];
                                }
                                System.out.println("Deleted record at position " + (tmp + 1));
                                i--;
                                break;
                        }
                    }
                    else
                    {
                        System.out.println();
                        System.out.println("Oopsie! Array is empty!");
                        reader.read();
                        //This line is explained above in a big comment above
                    }
                    break;
                case 'v':
                    if(i > 0)
                    {
                        displayArray(stdArray, i);
                    }
                    else
                    {
                        System.out.println();
                        System.out.println("Nothing to view!");
                    }
                    reader.read();
                    //This line is explained above in a big comment above
                    break;
                case 'x':
                    break;
                default:
                    System.out.println();
                    System.out.println("Not an option!");
                    reader.read();
                    //This line is explained above in a big comment above
            }
        } while(c != 'x');
    }
}