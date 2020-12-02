import java.util.Scanner;

public class ContactApp {

    /*public static void main(String[] args)
    {
        mainMenu();
    } */

    public static void mainMenu()
    {
        System.out.println("\n" +
                "    Main Menu\n" +
                "    ---------\n" +
                "    1) create a new list\n" +
                "    2) load an existing list\n" +
                "    3) quit\n");

        System.out.print("> ");
        Scanner sc = new Scanner(System.in);
        String x = sc.next();

        ContactList c = new ContactList();
        Main m = new Main();
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
                c.createList();
                listOperation();
                break;
            case 2:
                c.loadList();
                listOperation();
            case 3:
                m.mainMenu();
            default:
                System.out.println("Your selection does not exist please re-enter an option from the menu");
                mainMenu();

        }
    }

    public static void exit(int i) {
    }

    public static void listOperation()
    {
        System.out.println("\n" + "\n" +
                "List Operation Menu\n" +
                "    ---------\n" +
                "    1) view the list\n" +
                "    2) add an item\n" +
                "    3) edit an item\n" +
                "    4) remove an item\n" +
                "    5) save the current list\n" +
                "    6) quit to the main menu\n" );

        System.out.print("> ");
        Scanner sc = new Scanner(System.in);
        String x = sc.next();

        ContactList l = new ContactList();
        TaskList z = new TaskList();
        int option = 0;
        if(z.numberOrNot(x))
        {
            option = Integer.parseInt(x);
        }
        else
        {
            listOperation();
        }

        if(option == 1)
        {
            l.viewList();
            listOperation();
        }
        else if(option == 2)
        {
            l.getTask();
            listOperation();
        }
        else if(option == 3)
        {
            l.editTask();
            listOperation();
        }
        else if(option == 4)
        {
            l.removeTask();
            listOperation();
        }
        else if(option == 5)
        {
            l.saveList();
            listOperation();
        }
        else if(option == 6)
        {
            mainMenu();
        }
        else
        {
            System.out.println("Your selection does not exist please re-enter an option from the menu");
            listOperation();
        }


    }
}
