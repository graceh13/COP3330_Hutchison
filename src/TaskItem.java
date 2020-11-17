import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TaskItem {


    public String title() {
        String t;
        t = getTitle();
        if (!isTitleValid(t)) {
            System.out.println("WARNING: title must be at least 1 character long; task not created");
            App app = new App();
            app.listOperation();
        }

        return t;
    }

   /* public void titleChecker(String name)
    {
        if(isTitleValid(name))
        {
            TaskList l = new TaskList()
        }
        else
        {
            throw new IllegalAccessException()
        }
    } */

    public boolean isTitleValid(String title) {
        return title.length() > 0;
    }

    public String date() {
        String d;
        d = getDate();
        if (d.length() != 10) {
            System.out.println("WARNING: invalid due date; task not created");
            App app = new App();
            app.listOperation();
        }

        return d;
    }

    public boolean isDateValid(String dat) {
        DateFormat df = new SimpleDateFormat("YYYY-MM-DD");
        Date s = null;
        df.setLenient(false);

        try {
            s = df.parse(dat);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public String getTitle() {
        System.out.print("Task title: ");
        Scanner sc = new Scanner(System.in);
        String tempTitle = sc.nextLine();

        return tempTitle;
    }

    public String getDescription() {
        System.out.print("Task description: ");
        Scanner sc = new Scanner(System.in);
        String tempDescription = sc.nextLine();

        return tempDescription;
    }

    public String getDate() {
        System.out.print("Task due date (YYYY-MM-DD): ");
        Scanner sc = new Scanner(System.in);
        String tempDate = sc.nextLine();

        return tempDate;
    }

}

/* PSEUDO CODE

 String title
 String date
 String description

 Function getTitle
   Ask user for name of task "Task Title:"
   store input in tempTitle
   If tempTitle is less than 1 character (2)
      Warn user "WARNING: title must be at least 1 character long; task not created"
   Else (4)
      title = tempTitle

 Function getDescription
   Ask user for description of task "Task Description:"
   store input in description

 Function getDate
   Ask user for name of Date "Task due date (YYYY-MM-DD):"
   store input in tempDate
   If tempDate does not equal local date (1)
      Warn user "WARNING: invalid due date; task not created"
   Else (3)
      date = tempDate

*/


/*  public ArrayList getItems(String date, String title, String description) {
        items = new ArrayList();
        boolean iTitle = false;
        boolean invalidDate = false;

        // Date parameters
        if(date.isEmpty()) // change to check tie
        {
            invalidDate = true;
        }
        else
        {
            items.add(date);
        }

        // Title parameters
        if(title.isEmpty())
        {
            iTitle = true;
        }
        else
        {
            items.add(title);
        }

        items.add(description);

        if(iTitle == true)
            invalidTitle();
        if(invalidDate == true)
            System.out.println("WARNING: invalid due date; task not created");

        return items;
    }

   */