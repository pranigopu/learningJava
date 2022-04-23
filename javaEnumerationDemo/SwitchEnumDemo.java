enum MyConstants
{
    c1(2),
    c2(3),
    c3(5),
    c4(7);
    int n;
    private MyConstants(int n)
    {
        this.n = n;
    }
}
enum MyOtherConstants
{
    c1(2),
    c2(3),
    c3(4),
    c4(6);
    int n;
    private MyOtherConstants(int n)
    {
        this.n = n;
    }
}
class SwitchEnumDemo
{
    public static void main(String args[])
    {
        MyConstants c = MyConstants.c3;
        switch(c)
        {
            case c1:
                System.out.println(c.n);
                break;
            case c2:
                System.out.println(c.n);
                break;
            case c3:
                System.out.println(c.n);
                break;
            case c4:
                System.out.println(c.n);
                break;
        }
        switch(MyOtherConstants.c4)
        {
            case c1:
                System.out.println(MyOtherConstants.c1.n);
                break;
            case c2:
                System.out.println(MyOtherConstants.c2.n);
                break;
            case c3:
                System.out.println(MyOtherConstants.c3.n);
                break;
            case c4:
                System.out.println(MyOtherConstants.c4.n);
                break;
        }
    }
}