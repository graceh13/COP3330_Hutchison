import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        System.out.println("\n" +
                "    Select Your Application\n" +
                "    -----------------------\n" +
                "    1) task list\n" +
                "    2) contact list\n" +
                "    3) quit\n");

        System.out.print("> ");
        Scanner sc = new Scanner(System.in);
        String x = sc.next();

        TaskApp t = new TaskApp();
        ContactApp c = new ContactApp();
        TaskList l = new TaskList();

        int num = 0;
        if(l.numberOrNot(x))
        {
            num = Integer.parseInt(x);
        }
        else
        {
            mainMenu();
        }



        switch (num)
        {
            case 1:
                t.mainMenu();
                break;
            case 2:
                c.mainMenu();
                break;
            case 3:
                System.exit(0);
            default :
                System.out.println("Your selection does not exist please re-enter an option from the menu");
                mainMenu();


        }
    }


}


