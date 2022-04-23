class PrimitiveWrapperImmutability
{
    static void modify(Integer n)
    {
        n++;
    }
    public static void main(String args[])
    {
        Integer n = 3;
        System.out.println("n before modification:\t" + n);
        modify(n);
        System.out.println("n after modification:\t" + n);
    }
}