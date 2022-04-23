import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.IOException;
abstract class CompanyEmployee
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String Emp_name;
    int Emp_id;
    String Mail_id;
    String Mobile_no;
    String Address;
    public CompanyEmployee(float BP)
    {
        this.BP = BP;
    }
    float BP, netSalary;
    private float DA, HRA, PF, IT_tax;
    private void getValues()
    {
        this.DA = this.BP * (float)0.97;
        this.HRA = this.BP * (float)0.1;
        this.PF = this.BP * (float)0.12;
        this.IT_tax = this.BP * (float)0.001;
    }
    private boolean isValidPhoneNumber(String num)
    {
        int i = 0;
        char c;
        try
        {
            while(true)
                if((c = num.charAt(i++)) < '0' || c > '9')
                    return false;
        }
        catch(StringIndexOutOfBoundsException e)
        {
            return true;
        }
    }
    public float inputFloat(String message) throws IOException
    {
        float n = 0;
        while(true)
        {
            try
            {
                System.out.print(message);
                n = Float.parseFloat(br.readLine());
                return n;
            }
            catch(NumberFormatException e)
            {
                System.out.println("ERROR: Not a valid number");
            }
        }
    }
    public int inputInt(String message) throws IOException
    {
        int n = 0;
        while(true)
        {
            try
            {
                System.out.print(message);
                n = Integer.parseInt(br.readLine());
                return n;
            }
            catch(NumberFormatException e)
            {
                System.out.println("ERROR: Not a valid number");
            }
        }
    }
    public String inputPhoneNo(String message) throws IOException
    {
        String str = new String();
        while(true)
        {
            System.out.print(message);
            if(isValidPhoneNumber(str = br.readLine()))
                return str;
            else
                System.out.println("ERROR: Invalid mobile number");
        }
    }
    public void inputDetails() throws IOException
    {
        char c, tmp;
        
        System.out.print("Enter name: ");
        this.Emp_name = br.readLine();
        
        this.Emp_id = inputInt("Enter ID: ");
        
        System.out.print("Enter mail ID: ");
        this.Mail_id = br.readLine();

        this.Mobile_no = inputPhoneNo("Enter mobile no.: ");

        System.out.println("------\nEnter address:");
        this.Address = br.readLine();

        System.out.print("------\nStandard basic pay? (y/n) ");
        while((c = (char)br.read()) == ' ' || c == '\t');
        while((tmp = (char)br.read()) == ' ' || tmp == '\t');
        if(c == 'n' && tmp == '\n')
            this.BP = inputFloat("Enter basic pay: ");
        else
            System.out.println("Defaulting to standard basic pay $" + this.BP);
        getValues();
    }
    public float netSalary()
    {
        this.netSalary = this.BP + this.DA + this.HRA - (this.PF + this.IT_tax);
        return this.netSalary;
    }
    public void salarySlipNumericDetails()
    {
        System.out.println("Gross salary: " + this.BP);
        System.out.println("Net salary: " + this.netSalary());
        
        System.out.println("------\nNet salary breakdown:");
        System.out.println("Basic pay (BP): " + this.BP);
        System.out.println("Dearness Allowance (DA): " + this.DA);
        System.out.println("House Rent Allowance (HRA): " + this.HRA);
        System.out.println("Provident Fund (PF): " + this.PF);
        System.out.println("IT Tax (ITT): " + this.IT_tax);
        System.out.println("Net salary = BP + DA + HRA - (PF + ITT)\n------------------------\n");
    }
}
class Programmer extends CompanyEmployee
{
    public Programmer()
    {
        super((float)1000);
    }
    public void salarySlip()
    {
        System.out.println("\n------------------------\nSALARY SLIP\n");
        System.out.println("Name: " + this.Emp_name);
        System.out.println("ID: " + this.Emp_id);
        System.out.println("Occupation: Programmer");
        salarySlipNumericDetails();
    }
}
class TeamLead extends CompanyEmployee
{
    public TeamLead()
    {
        super((float)1250);
    }
    public void salarySlip()
    {
        System.out.println("\n------------------------\nSALARY SLIP\n");
        System.out.println("Name: " + this.Emp_name);
        System.out.println("ID: " + this.Emp_id);
        System.out.println("Occupation: Team Lead");
        salarySlipNumericDetails();
    }
}
class ProjectManager extends CompanyEmployee
{
    public ProjectManager()
    {
        super((float)1750);
    }
    public void salarySlip()
    {
        System.out.println("\n------------------------\nSALARY SLIP\n");
        System.out.println("Name: " + this.Emp_name);
        System.out.println("ID: " + this.Emp_id);
        System.out.println("Occupation: Project Manager");
        salarySlipNumericDetails();
    }
}
class SeniorManager extends CompanyEmployee
{
    public SeniorManager()
    {
        super((float)2750);
    }
    public void salarySlip()
    {
        System.out.println("\n------------------------\nSALARY SLIP\n");
        System.out.println("Name: " + this.Emp_name);
        System.out.println("ID: " + this.Emp_id);
        System.out.println("Occupation: Senior Manager");
        salarySlipNumericDetails();
    }
}
public class JavaProjectsDevelopers
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char c, tmp;
        System.out.println("\nSALARY SLIP GENERATOR\n");
        while(true)
        {
            System.out.println("(Enter employee details to get their salary slip)");
            System.out.println("Choose occupation...");
            System.out.println("1. Programmer\n2. Team lead\n3. Project manager\n4. Senior manager\n(x to exit)");
            while((c = (char)br.read()) == ' ' || c == '\t');
            while((tmp = (char)br.read()) == ' ' || tmp == '\t');
            if(tmp != '\n')
                c = '*';
            switch(c)
            {
                case '1':
                    Programmer pr = new Programmer();
                    pr.inputDetails();
                    pr.salarySlip();
                    break;
                case '2':
                    TeamLead tl = new TeamLead();
                    tl.inputDetails();
                    tl.salarySlip();
                    break;
                case '3':
                    ProjectManager pm = new ProjectManager();
                    pm.inputDetails();
                    pm.salarySlip();
                    break;
                case '4':
                    SeniorManager sm = new SeniorManager();
                    sm.inputDetails();
                    sm.salarySlip();
                    break;
                case 'x':
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("ERROR: Invalid option\n");
            }
        }
    }
}