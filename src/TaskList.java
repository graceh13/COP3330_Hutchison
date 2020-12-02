import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TaskList {

    public static ArrayList<String> tasks;

    TaskItem ti = new TaskItem();
    int list;

    public void createList()
    {
        tasks = new ArrayList<String>();
    }

    public void viewList() {
        if (tasks.isEmpty()) {
            System.out.println("Task list is empty.");
            return;
        }

        int taskNum = 0;
        for (int i = 0; i < tasks.size(); i++) {
            taskNum++;
            System.out.print(taskNum + ") ");
            System.out.print(tasks.get(i++) + " "); // mark
            System.out.print(tasks.get(i++) + " "); // date
            System.out.print(tasks.get(i++) + ": "); // title
            System.out.print(tasks.get(i) + "\n"); // description

        }
    }

    public void getTask() {
        TaskItem ti = new TaskItem();
        String title = ti.title();
        String date = ti.date();
        String description = ti.getDescription();

        addTask("");
        addTask(date);
        addTask(title);
        addTask(description);


    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public boolean isTitleValid(String title) {
        return title.length() > 0;
    }

    public static boolean isDateValid(String date) // extra check returns true if user date is valid
    {
        if (date.trim().equals(""))
        {
            System.out.println("WARNING: invalid date format; task not created");
            return false;
        }
        else if (date.length() < 10)
        {
            System.out.println("WARNING: invalid date format; task not created");
            return false;
        }

        else
        {

            SimpleDateFormat correct = new SimpleDateFormat("yyyy-MM-dd");
            correct.setLenient(false);

            try
            {
                Date d = correct.parse(date);
            }
            catch (ParseException e)
            {
                System.out.println("WARNING: invalid due date; task not created");
                return false;
            }

            return true;
        }
    }

    public void removeTask() {
        viewList();
        System.out.print("What task would you like to remove? : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        TaskApp a = new TaskApp();
        int max = tasks.size() / 4;
        if(n >0 && n <= max)
        {
            remove(n);
        }
        else
        {
            System.out.print("WARNING: task entered does not exist.");
            a.listOperation();
        }

    }

    public void remove(int task) {
        int x = task - 1;
        int index = x * 4;

        tasks.remove(index); // mark
        tasks.remove(index); // date
        tasks.remove(index); // title
        tasks.remove(index); // desc
    }


    public void markTaskCompleted() {
        viewList();
        System.out.print("What task would you like to mark completed? : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        TaskApp a = new TaskApp();
        int max = tasks.size() / 4;
        if(n >0 && n <= max)
        {
            complete(n);
        }
        else
        {
            System.out.print("WARNING: task entered does not exist.");
            a.listOperation();
        }

    }

    public int complete(int task) {
        int x = task - 1;
        int index = x * 4;
        int y = 1;

        tasks.set(index, "***"); // mark

        return y;
    }

    public void markTaskUncompleted() {
        viewList();
        System.out.print("What task would you like to mark uncompleted? : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        TaskApp a = new TaskApp();
        int max = tasks.size() / 4;
        if(n >0 && n <= max)
        {
            uncomplete(n);
        }
        else
        {
            System.out.print("WARNING: task entered does not exist.");
            a.listOperation();
        }
    }

    public int uncomplete(int task) {
        int x = task - 1;
        int index = x * 4;
        int y = 1;

        tasks.set(index, ""); // mark

        return y;
    }

    public boolean validIndex(int n)
    {

        int max = 16 / 4;
        if(n > 0 && n <= max)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    public void removeOne(String task) {
        tasks.remove(task);
    }

    public void edit(int task) {
        int x = task - 1;
        int index = x * 4;

        String title = ti.title();
        String date = ti.date();
        String description = ti.getDescription();


        tasks.set(index + 1, date); // date
        tasks.set(index + 2, title); // title
        tasks.set(index + 3, description); // desc
    }

    public void editTask() {
        viewList();
        System.out.print("What task would you like to edit? : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        TaskApp a = new TaskApp();
        int max = tasks.size() / 4;
        if(n >0 && n <= max)
        {
            edit(n);
        }
        else
        {
            System.out.print("WARNING: task entered does not exist.");
            a.listOperation();
        }

    }

    public void saveList() {
        try (Formatter output = new Formatter("TaskList.txt")) {
            int taskNum = 0;
            for (int i = 0; i < tasks.size(); i++) {
                taskNum++;
                output.format("%d %s %s %s %s%n", taskNum, tasks.get(i++), tasks.get(i++), tasks.get(i++), tasks.get(i));

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void loadList()
    {
        System.out.print("Place your file in the project folder of this program\n");
        System.out.print("Enter the filename to load: ");
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();

        Scanner s = null;
        try {
            s = new Scanner(new File(fileName));
            System.out.print("File has been loaded");
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.print("File was not found please check that your file is in the correct folder and spelled correctly\n");
            TaskApp ta = new TaskApp();
            ta.listOperation();
        }
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()){
            list.add(s.nextLine());
        }
        s.close();




        createList();
        copyList(list);


    }

    public int listSuccessful (int i)
    {
        System.out.print("File has been loaded");
        return i++;
    }


    public void copyList(ArrayList<String> file)
    {
        for (int i = 0; i < file.size();i++) // print list array
        {
            String temp = file.get(i);
            addTask(temp);

        }

    }

    boolean numberOrNot(String input)
    {
        try
        {
            Integer.parseInt(input);
        }
        catch(NumberFormatException ex)
        {
            System.out.println("Your selection does not exist please re-enter an option from the menu");
            return false;

        }
        return true;
    }

}


/*
PSEUDO CODE
 function createList /
    make ArrayList
 function viewList /
    println "Current Tasks"
    println "---------------"
    print contents of currentList ArrayList
 function saveList
    - save ArrayList to txt file in computer
 function addTask
    create new row in currentList ArrayList 4 columns wide
    set currentList ArrayList [][0] to null
    call taskList.getTitle
     store title in currentList ArrayList [][2]
    call taskList.getDescription
     store description in currentList ArrayList [][3]
    call taskList.getDate
     store date in currentList ArrayList [][1]
 function editTask
    viewList() to show user current tasks
    ask user what task they would like to edit and store in int n
    ArrayList[n] = null to empty task they chose
    call taskList.getTitle
     store title in currentList ArrayList [n][2]
    call taskList.getDescription
     store description in currentList ArrayList [n][3]
    call taskList.getDate
     store date in currentList ArrayList [n][1]
 function removeTask
    ask user what task they want to remove
    find task in currentList ArrayList by matching number the user inputs
    currentList.remove(user input);
 function completed /
    println "*** = completed"
    viewList() to show user current tasks
    ask user what task they would like to mark completed
    inside currentList ArrayList set user specified task [n][0] = "***"
 function uncompleted /
    println "*** = completed"
    viewList() to show user current tasks
    ask user what task they would like to mark uncompleted
    inside currentList ArrayList set user specified task [n][0] = null
 */