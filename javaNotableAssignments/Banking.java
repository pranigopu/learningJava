public class Account
{
    String AccNo;
    String AccType;
    double Amount = 0;
    public Account(){}
    public Account(String AccNo, String AccType)
    {
        this.AccNo = AccNo;
        this.AccType = AccType;
    }
}
public class Customer extends Account
{
    String CustNo;
    String CustName;
    String CustType;
    public Customer(){};
    public Customer(String AccNo, String AccType, String CustNo, String CustName, String CustType)
    {
        if(AccNo == "" || AccNo == null)
            Account();
        else
            Account(AccNo, AccType);
        if(CustNo != "" && CustNo != null))
        {
            this.CustNo = CustNo;
            this.CustName = CustName;
            this.CustType = CustType;
        }
    }
    public String getAccDetails()
    {
        try 
        {
            System.out.println("Acc. No.: " + this.AccNo);
            System.out.println("Acc. Type: " + this.AccType);
            System.out.println("Acc. Amount: " + this.Amount);

        } catch (Exception e) 
        {
            System.out.println("All account details do not exist for this customer.");
        }
    }
    public String getCustDetails()
    {
        try 
        {
            System.out.println("Cust. No.: " + this.CustNo);
            System.out.println("Cust. Name: " + this.CustName);
            System.out.println("Cust. Type: " + this.CustType);

        } catch (Exception e) 
        {
            System.out.println("All customer details do not exist for this customer.");
        }
    }
    public void addAmt(double x)
    {
        this.Amount += x;
    }
    public void remAmt(double x)
    {
        if(this.Amount - x < 0)
            System.out.println("Sorry, amount too less.")
        else
            this.Amount -= x;
    }
}
public class Banking
{
    public static void main(String args[]){}
}