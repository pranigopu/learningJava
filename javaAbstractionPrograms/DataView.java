//IMPLEMENTATION OF MULTIPLE INHERITANCE
/*
The following program defines various data types using classes.
All data types are inherited from the class Data.
Some data types are inherited from other data types, ex. Integer is inherited from RealNumber
*/
package DataView;
abstract class Data
{
    String name;
    String scale;
    String type;
    String unit;
    String value;
    Data(String name, String scale, String type, String unit, String value)
    {
        this.name = name;
        this.scale = scale;
        this.type = type;
        this.unit = unit;
        this.value = value;
    }
    void dataInfo()
    {
        System.out.println("Name:\t" + this.name);
        System.out.println("Scale:\t" + this.scale);
        System.out.println("Type:\t" + this.type);
        System.out.println("Unit:\t" + this.unit);
        System.out.println("Value:\t" + this.value);
    }
    boolean isCommensurableTo(Data data)
    {
        boolean flag = true;
        if(this.scale != data.scale)
        {
            System.out.println("- Scales are not matching");
            flag = false;
        }
        if (this.type != data.type)
        {
            System.out.println("- Types are not matching");
            flag = false;
        }
        if(this.unit != data.unit)
        {
            System.out.println("- Units are not matching");
            flag = false;
        }
        if(flag == true)
            System.out.println("- They are commensurable");
        System.out.println();
        return flag;
    }
    boolean equals(String data)
    {
        if(this.value == data)
            return true;
        else return false;
    }
}
class RealNumber extends Data
{
    double val;
    RealNumber(double val)
    {
        super("real number", "ratio", "quantitative", "1", Double.toString(val));
        this.val = val;
    }
    RealNumber(double val, String name)
    {
        super(name, "ratio", "quantitative", "1", Double.toString(val));
        this.val = val;
    }
    double calculate(double operand, char operator)
    {
        switch(operator)
        {
            case '+':
            return this.val + operand;

            case '-':
            return this.val - operand;

            case '*':
            return this.val * operand;

            case '/':
            if(operand != 0)
                return this.val / operand;
        }
        return 0;
    }
}
class IntegerNumber extends RealNumber
{
    int val;
    IntegerNumber(int val)
    {
        super(val, "integer");
        this.val = val;
    }
}
class TimeElapsed extends Data
{
    double val;
    TimeElapsed(double val)
    {
        super("time elapsed", "ratio", "quantitative", "1 second", Double.toString(val));
        this.val = val;
    }
}
class Binary extends Data
{
    boolean val;
    static private boolean stringToBool(String str)
    {
        if(str == "true" || str == "True" || str == "1")
            return true;
        if(str == "false" || str == "False" || str == "0");
            return false;
    }
    Binary(String val)
    {
        super("binary", "nominal", "qualitative", "{true, false}", val);
        this.val = stringToBool(val);
    }
}
class DataView
{
    public static void main(String args[])
    {
        Binary bin = new Binary("false");
        IntegerNumber num = new IntegerNumber(3);
        RealNumber real1 = new RealNumber(7.6);
        RealNumber real2 = new RealNumber(3);
        /*---*/
        System.out.println("------------");
        System.out.println("Information about the data... ");
        System.out.println();
        bin.dataInfo();
        System.out.println();
        num.dataInfo();
        System.out.println();
        real1.dataInfo();
        System.out.println();
        num.dataInfo();      
        /*---*/
        System.out.println("------------");
        System.out.println("Commesurability... ");
        System.out.println();
        System.out.println("Binary to integer: ");
        bin.isCommensurableTo(num);
        System.out.println("Integer to real number: ");
        num.isCommensurableTo(real1);
        /*---*/
        System.out.println("------------");
        System.out.println("Equality... ");
        System.out.println("bin = num: " + bin.equals(num));
        System.out.println("num = real2: " + num.equals(real2));
        System.out.println();
    }
}