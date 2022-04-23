class Department
{
    String depCode;
    String depName;
    Department(String depCode, String depName)
    {
        this.depCode = depCode;
        this.depName = depName;
    }
    protected void display(String subCode, String subName)
    {
        System.out.println("Subject code: " + this.depCode.concat(subCode));
        System.out.println("Subject name: " + subName);
    }
}
class Subject extends Department
{
    String subCode;
    String subName;
    Subject(String depCode, String depName, String subCode, String subName)
    {
        super(depCode, depName);
        this.subCode = subCode;
        this.subName = subName;
    }
    public static void main(String args[])
    {
        Subject sub1 = new Subject("0001", "Math", "M001", "Differential calculus");
        System.out.println("Dep. Code.: " +  sub1.depCode);
        System.out.println("Dep. Name.: " +  sub1.depName);
        System.out.println("Sub. Code.: " +  sub1.subCode);
        System.out.println("Sub. Name.: " +  sub1.subName);
    }
}