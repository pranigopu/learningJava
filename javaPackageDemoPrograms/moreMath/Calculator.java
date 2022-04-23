package moreMath;
import java.io.*;
public class Calculator
{
    public Calculator(){}
    public int factorial(int n)
    {
        int fac = 1;
        if(n < 0)
        {
            System.out.println("ERROR: Cannot find factorial of a negative integer.");
            return 0;
        }
        for(int i = 1; i <= n; i++)
            fac *= i;
        return fac;
    }
    public int power(int n, int power)
    {
        int start = n;
        if(power == 0)
            return 1;
        for(int i = 1; i < power; i++)
            start *= n;
        return start;
    }
}