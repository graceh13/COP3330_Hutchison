import java.util.Scanner;

public class TaskApp {

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

        TaskList tl = new TaskList();
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
                tl.createList();
                listOperation();
                break;
            case 2:
                tl.loadList();
                listOperation();
            case 3:
                m.mainMenu();
            default :
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
                "    5) mark an item as completed\n" +
                "    6) unmark an item as completed\n" +
                "    7) save the current list\n" +
                "    8) quit to the main menu\n" );

        System.out.print("> ");
        Scanner sc = new Scanner(System.in);
        String x = sc.next();

        TaskList l = new TaskList();
        int option = 0;
        if(l.numberOrNot(x))
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
            l.markTaskCompleted();
            listOperation();
        }
        else if(option == 6)
        {
            l.markTaskUncompleted();
            listOperation();
        }
        else if(option == 7)
        {
            l.saveList();
            listOperation();
        }
        else if(option == 8)
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


/*
PSEUDO CODE
 function public static void main(String[] a) /
    mainMenu()
 function mainMenu
    print(
    Main Menu
    ---------
    1) create a new list
    2) load an existing list
    3) quit)
    take in user input and store in int
    if 1
        call TaskList class function createList
        listOperation()
    if 2
        call TaskList class function loadList
    if 3
        exit(0) this ends the program
    else
        println "The menu option selected does not exist."
 function listOperation
    print(
    List Operation Menu
    ---------
    1) view the list
    2) add an item
    3) edit an item
    4) remove an item
    5) mark an item as completed
    6) unmark an item as completed
    7) save the current list
    8) quit to the main menu)
    take in user input and store in int
    if 1
        call TaskList class function viewList
    if 2
        call TaskList class function addTask
    if 3
        call TaskList class function editTask
    if 4
        call TaskList class function removeTask
    if 5
        call TaskList class function completed
    if 6
        call TaskList class function uncompleted
    if 7
        call TaskList class function saveList
    if 8
        mainMenu()
    else
        println "The menu option selected does not exist."
 */