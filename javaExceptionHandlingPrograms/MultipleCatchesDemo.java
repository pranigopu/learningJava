public class MultipleCatchesDemo 
{ 
    public static void main(String[] args) 
    { 
        try
        { 
            System.out.print("1"); 
            int sum = 1 / 0; 
            System.out.print("2"); 
        } 
        catch(ArithmeticException e) 
        { 
            System.out.print("3"); 
        }
        catch(Exception e) 
        { 
            System.out.print("4"); 
        }
        finally
        { 
            System.out.print("5"); 
        } 
        System.out.println(); 
    } 
}
/*
NOTE: 
If you try catching multiple exceptions of the same kind, there will be an error.
The multiple catch statements look for different exceptions
------------
NOTE:
If an exception exists in the try block, only statements upto the exception will be executed.
Statements after the execution will not be executed.
*/