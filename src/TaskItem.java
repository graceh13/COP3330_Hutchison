import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TaskItem {


    public String title() {
        String t;
        t = getTitle();
        if (!isTitleValid(t)) {
            System.out.println("WARNING: title must be at least 1 character long; task not created");
            TaskApp app = new TaskApp();
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

    public String date() // gets user input and checks if it's valid
    {
        String d;
        d = getDate();
        int i = 0;
        if(isDateValid(d))
        {
            i = 1;
        }
        if(i != 1)
        {
            TaskApp app = new TaskApp();
            app.listOperation();
        }

        return d;

    }



    public static boolean isDateValid(String date) // returns true if user date is valid
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

    public String DescInfo(String x)
    {
        return x;
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