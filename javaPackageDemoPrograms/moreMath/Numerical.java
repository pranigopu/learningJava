package moreMath;
public class Numerical
{
    public String val;
    public int base = 10;
    private int getInt(char c)
    {
        if(c >= 'A' && c <= 'Z')
            return 10 + c - 'A';
        if(c >= 'a' && c <= 'z')
            return 10 + c - 'A';
        if(c >= '0' && c <= '9')
            return c - '0';
        return '*';
    }
    private char getChar(int i)
    {
        if(i >= 10 && i <= 26)
            return (char)(i - 10 + 'A');
        else if(i >= 0 && i <= 9)
            return (char)(i + '0');
        return '*';
    }
    private String reverse(String str)
    {
        String tmp = new String();
        for(int i = str.length() - 1; i > -1; i--)
        {
            tmp += str.charAt(i);
        }
        return tmp;
    }
    private int checkBase(int base)
    {
        if(base < 0)
        {
            System.out.println("WARNING: Ignoring -ve sign in given base.");
            return -base;
        }
        else if(base == 0)
        {
            System.out.println("WARNING: Base cannot be 0. Defaulting to decimal.");
            return 10;
        }
        return base;
    }
    private String checkVal(String val)
    {
        int len = val.length();
        int b = this.base;
        for(int i = 0; i < len; i++)
        {
            if(getInt(val.charAt(i)) >= b && val.charAt(i) != '-')
            {
                System.out.println("WARNING: Value does not match the given base. Defaulting to 0.");
                return "0";
            }
        }
        return val;
    }
    public void assignBase(int base)
    {
        this.base = checkBase(base);
    }
    public void assignVal(String val)
    {
        this.val = checkVal(val);
    }
    public Numerical(int base, String val)
    {
        this.base = checkBase(base);
        this.val = checkVal(val);
    }
    public Numerical(){};
    public void convert(int newBase)
    {
        int dec = 0;
        int i = 0;
        int factor = 1;
        char sign;
        String newVal = new String();
        newBase = checkBase(newBase);
        this.base = checkBase(this.base);
        this.val = checkVal(this.val);
        if(this.val.charAt(i) == '-')
        {
            sign = '-';
            factor = 1;
        }
        else
        {
            sign = '+';
            dec = getInt(this.val.charAt(this.val.length() - 1));
            factor = this.base;
        }
        for(i = this.val.length() - 2; i > -1; i--)
        {
            dec += getInt(this.val.charAt(i)) * factor;
            factor *= this.base;
        }
        while(dec != 0)
        {
            newVal += getChar(dec % newBase);
            dec /= newBase;
        }
        if(sign == '-')
            newVal += sign;
        newVal = reverse(newVal);
        this.val = newVal;
        this.base = newBase;
    }
    public int getDecimalValue(int newBase)
    {
        int dec = 0;
        int i = 0;
        int factor = 1;
        char sign;
        String newVal = "\n";
        newBase = checkBase(newBase);
        this.base = checkBase(this.base);
        this.val = checkVal(this.val);
        if(this.val.charAt(i) == '-')
        {
            sign = '-';
            factor = 1;
        }
        else
        {
            sign = '+';
            dec = getInt(this.val.charAt(i));
            factor = this.base;
        }
        for(i = this.val.length() - 2; i > -1; i--)
        {
            dec += getInt(this.val.charAt(i)) * factor;
            factor *= this.base;
        }
        if(sign == '-')
            dec = -dec;
        return dec;
    }
}