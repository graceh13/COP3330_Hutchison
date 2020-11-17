import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class TaskList {

    public static ArrayList<String> tasks;

    TaskItem ti = new TaskItem();
    int list;

    public void createList() // what to put here?
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

    public void removeTask() {
        viewList();
        System.out.print("What task would you like to remove? : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        App a = new App();
        int max = tasks.size() / 4;
        if (n < 0 || n > max)
        {
            System.out.print("WARNING: task entered does not exist.");
            a.listOperation();
        }

        remove(n);
    }

    public void remove(int task) {
        int x = task - 1;
        int index = x * 4;

        tasks.remove(index); // mark
        tasks.remove(index); // date
        tasks.remove(index); // title
        tasks.remove(index); // desc
    }

    public void editTask() {
        viewList();
        System.out.print("What task would you like to edit? : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        App a = new App();
        int max = tasks.size() / 4;
        if (n < 0 || n > max)
        {
            System.out.print("WARNING: task entered does not exist.");
            a.listOperation();
        }

        edit(n);
    }

    public void markTaskCompleted() {
        viewList();
        System.out.print("What task would you like to mark completed? : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        App a = new App();
        int max = tasks.size() / 4;
        if (n < 0 || n > max)
        {
            System.out.print("WARNING: task entered does not exist.");
            a.listOperation();
        }

        complete(n);
    }

    public void complete(int task) {
        int x = task - 1;
        int index = x * 4;

        tasks.set(index, "***"); // mark
    }

    public void markTaskUncompleted() {
        viewList();
        System.out.print("What task would you like to mark uncompleted? : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        App a = new App();
        int max = tasks.size() / 4;
        if (n < 0 || n > max)
        {
            System.out.print("WARNING: task entered does not exist.");
            a.listOperation();
        }

        uncomplete(n);
    }

    public void uncomplete(int task) {
        int x = task - 1;
        int index = x * 4;

        tasks.set(index, ""); // mark
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

    public void saveList() {
        try (Formatter output = new Formatter("TaskList.txt")) {
            int taskNum = 0;
            for (int i = 0; i < tasks.size(); i++) {
                taskNum++;
                output.format("%d) %s [%s] %s %s%n", taskNum, tasks.get(i++), tasks.get(i++), tasks.get(i++), tasks.get(i));

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void loadList ()
    {
        return;
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