public class TryFinallyDemo3 
{ 
    public static void main(String[] args) 
    { 
        try
        { 
            System.out.println("1"); 
            int data = 1/ 0; 
        } 
        catch(ArithmeticException e) 
        { 
            System.out.println("2"); 
            System.exit(0); 
        } 
        finally
        { 
            System.out.println("3"); 
        } 
        System.out.println("4"); 
    } 
} 
/*
System.exit(0) apparently causes the program to skip the code in the finally block.
*/