import java.util.Scanner;

public class ContactItem {

    int i;

    public String getFirstN() {
        System.out.print("First name: ");
        Scanner sc = new Scanner(System.in);
        String tempFirst = sc.nextLine();

        return info(tempFirst);
    }

    public String getLastN() {
        System.out.print("Last name: ");
        Scanner sc = new Scanner(System.in);
        String tempLast = sc.nextLine();

        return info(tempLast);
    }

    public String getPhone() {
        System.out.print("Phone number (xxx-xxx-xxxx): ");
        Scanner sc = new Scanner(System.in);
        String tempPhone = sc.nextLine();

        return info(tempPhone);
    }

    public String getEmail() {
        System.out.print("Email address (x@y.z): ");
        Scanner sc = new Scanner(System.in);
        String tempEmail = sc.nextLine();

        return info(tempEmail);
    }

    public String info(String x)
    {
        if(x.isEmpty())
        {
            i++;
        }
        if(i > 3)
        {
            System.out.println("All contact values cannot be blank; Contact not created");
            ContactApp ca = new ContactApp();
            ca.listOperation();
        }
        return x;
    }

    public String infoB(String x, int i)
    {
        if(x.isEmpty())
        {
            i++;
        }
        if(i > 3)
        {
            System.out.println("All contact values cannot be blank; Contact not created");
        }
        return x;
    }


}
