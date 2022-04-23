public class ThrowableDemo 
{ 
    public static void main(String[] args) 
    { 
        try
        { 
            System.out.print("1"); 
            int data = 1 / 0; 
        } 
        catch(ArithmeticException e) 
        { 
            Throwable obj = new Throwable("Sample"); 
            try 
            { 
                throw obj; 
            }  
            catch(Throwable e1)  
            { 
                System.out.print("8"); 
            } 
        } 
        finally
        { 
            System.out.println("3"); 
        } 
        System.out.print("4"); 
    } 
}