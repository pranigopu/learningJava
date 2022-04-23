import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
abstract class Basics
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int inputWithinLimits(String message, int lower, int upper, String error) throws IOException
    {
        int n = 0;
        while(true)
        {
            try
            {
                while(true)
                {
                    System.out.print(message);
                    n = Integer.parseInt(br.readLine());
                    if(n < lower || n > upper)
                        System.out.println(error);
                    else
                        return n;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Not an integer!");
            }
        }
    }
    static float inputWithinLimits(String message, float lower, float upper, String error) throws IOException
    {
        float n = 0;
        while(true)
        {
            try
            {
                while(true)
                {
                    System.out.print(message);
                    n = Integer.parseInt(br.readLine());
                    if(n < lower || n > upper)
                        System.out.println(error);
                    else
                        return n;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Not a number!");
            }
        }
    }
}
abstract class CoffeeMachine
{
    String types[] = new String[]{"coffee", "expresso", "cappuccino"};
    Float prices[] = new Float[]{(float)20, (float)30, (float)35};
    int type = 0;
    public CoffeeMachine(String type)
    {   
        int typeIndex = getType(type);
        if(typeIndex < 0 || typeIndex > types.length - 1)
            System.out.println("Invalid type, defaulting to 0");
        else
            this.type = typeIndex;
    }
    public int getType(String str)
    {
        if(str.equals("coffee"))
            return 0;
        else if(str.equals("expresso"))
            return 1;
        else if(str.equals("cappuccino"))
            return 2;
        return 0;
    }
}
class SubOrder extends CoffeeMachine
{
    int quantity = 1;
    public SubOrder(String type, int quantity)
    {
        super(type);
        if(this.quantity < 1)
            System.out.println("Invalid quantity, defaulting to 1");
        else
            this.quantity = quantity;
    }
}
class Order extends Basics
{
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    SubOrder myOrder[] = new SubOrder[1];
    private int items = 1;
    public Order() throws IOException
    {
        int items = inputWithinLimits("Enter number of items in your order: ", 1, 10, "Enter items from 1 to 10!")
        this.items = items;
        myOrder = new SubOrder[this.items];
        getSubOrders();
    }
    private void getSubOrders() throws IOException
    {
        String type;
        int quantity;
        for(int i = 0; i < this.items; i++)
        {
            System.out.println("Enter item " + (i + 1) + " details...");
            System.out.print("Enter type: ");
            type = br.readLine();
            quantity = inputWithinLimits("Enter quantity: ", 1, 10, "Enter quantity from 1 to 10!");
            myOrder[i] = new SubOrder(type, quantity);
        }
    }
    public float getBill()
    {
        float total = 0;
        for(int i = 0; i < this.items; i++)
            total += myOrder[i].prices[myOrder[i].type];
        return total;
    }
    public void displayOrder()
    {
        int tmp;
        for(int i = 0; i < this.items; i++)
        {
            tmp = this.myOrder[i].type;
            System.out.println("Item " + (i + 1) + ":");
            System.out.println("Type: " + this.myOrder[i].types[tmp]);
            System.out.println("Quantity: " + this.myOrder[i].quantity);
            System.out.println("Total price: " + this.myOrder[i].quantity * this.myOrder[i].prices[tmp]);
            System.out.println("\n");
        }
    }
}
public class CoffeeMachineUsage extends Basics
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException
    {
        Order myOrder[] = new Order[10];
        char c;
        int last = 0;
        System.out.println("\nCOFFEE MACHINE USAGE\n");
        while(true)
        {
            System.out.println("\nEnter + to place an order");
            System.out.println("Enter $ to get bill");
            System.out.println("Enter v to see orders");
            System.out.println("Enter x to exit");
            c = (char)br.read();
            br.read();
            switch(c)
            {
                case '+':
                    if(last < 10)
                        myOrder[last++] = new Order();
                    else
                    {
                        System.out.println("Can enter no more!");
                    }
                    break;
                case '$':
                    myOrder[inputWithinLimits("Enter order number: ", 0, 9, "Enter from 0 to 9!")].getBill();
                    break;
                case 'v':
                    for(int i = 0; i < last; i++)
                    {
                        System.out.println("ORDER " + (i + 1));
                        myOrder[i].displayOrder();
                        System.out.println();
                    }
                    break;
                case 'x':
                    System.out.println("Goodbye!");
                    return;
            }
        }
    }
}