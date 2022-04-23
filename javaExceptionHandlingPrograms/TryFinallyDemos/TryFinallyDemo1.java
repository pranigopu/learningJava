public class TryFinallyDemo1
{
    public static void main(String[] args)
    {
        try
        {
            return;
        }
        finally
        {
            System.out.println("Finally");
        }
    }
}
/*
finally block defines the last code to be executed after the try-catch structure.
If any code lies after the finally block, it will be ignored.
Also, it can only be used with a preceding try statement in the same structure.
*/