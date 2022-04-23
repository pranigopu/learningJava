class DivisionByZero
{
    public static void main(String args[])
    {
        try
        {
            int i, num = 10;
            for(i = -1; i < 3; ++i)
            {
                num =(num /i);
                System.out.print(i);
            }
        }
        catch(ArithmeticException e)
        {	
            System.out.print("0");
        }
        System.out.println();
    }
}
