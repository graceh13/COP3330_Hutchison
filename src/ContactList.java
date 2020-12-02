import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class ContactList {

    public static ArrayList<String>  contacts;

    ContactItem ci = new ContactItem();
    int list;

    public void createList()
    {
        contacts = new ArrayList<String>();
    }

    public void viewList() {
        if (contacts.isEmpty()) {
            System.out.println("Contact list is empty.");
            return;
        }
        System.out.println("Current Contacts\n" +
                "-------------\n");
        int taskNum = 0;
        for (int i = 0; i < contacts.size(); i++) {
            taskNum++;
            System.out.print(taskNum + ") ");
            System.out.print("Name: "+ contacts.get(i++) + " "); // mark
            System.out.print(contacts.get(i++) + "\n"); // date
            System.out.print("Phone: " + contacts.get(i++) + "\n"); // title
            System.out.print("Email: " + contacts.get(i) + "\n"); // description

        }
    }

    public void getTask() {
        ContactItem ci = new ContactItem();

        String first = ci.getFirstN();
        String last = ci.getLastN();
        String phone = ci.getPhone();
        String email = ci.getEmail();

        addTask(first);
        addTask(last);
        addTask(phone);
        addTask(email);

    }

    public void addTask(String task) {
        contacts.add(task);
    }

    public void removeTask() {
        viewList();
        System.out.print("What contact would you like to remove? : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ContactApp a = new ContactApp();
        int max = contacts.size() / 4;
        if(n >0 && n <= max)
        {
            remove(n);
        }
        else
        {
            System.out.print("WARNING: contact entered does not exist.");
            a.listOperation();
        }
    }

    public void remove(int task) {
        int x = task - 1;
        int index = x * 4;

        contacts.remove(index); // mark
        contacts.remove(index); // date
        contacts.remove(index); // title
        contacts.remove(index); // desc
    }

    public void removeOne(String task) {
        contacts.remove(task);
    }

    public void editTask() {
        viewList();
        System.out.print("What contact would you like to edit? : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ContactApp a = new ContactApp();
        int max = contacts.size() / 4;
        if(n >0 && n <= max)
        {
            edit(n);
        }
        else
        {
            System.out.print("WARNING: contact entered does not exist.");
            a.listOperation();
        }
    }


    public void edit(int task) {
        int x = task - 1;
        int index = x * 4;
        int i = 0;

        String first = ci.getFirstN();
        if(first == null)
        {
            i++;
        }
        String last = ci.getLastN();
        if(last == null)
        {
            i++;
        }
        String phone = ci.getPhone();
        if(phone == null)
        {
            i++;
        }
        String email = ci.getEmail();
        if(email == null)
        {
            i++;
        }

        if( i > 3)
        {
            System.out.println("All contact values cannot be blank; Contact not created");
            ContactApp ca = new ContactApp();
            ca.listOperation();
        }


        contacts.set(index , first); // first name
        contacts.set(index + 1, last ); // last name
        contacts.set(index + 2, phone); // phone
        contacts.set(index + 3, email); // email
    }

    public String editAll(String x, int i)
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

    public boolean validIndex(int n)
    {
        ContactApp a = new ContactApp();

        int max = 16 / 4;
        if(n > 0 && n <= max)
        {
            return true;
        }
        else
        {
            System.out.print("WARNING: contact entered does not exist.");
            return false;
        }

    }

    public void saveList() {
        if (contacts.isEmpty()) {
            System.out.println("Contact list is empty.");
            ContactApp c = new ContactApp();
            c.listOperation();
        }
        try (Formatter output = new Formatter("ContactList.txt")) {
            int taskNum = 0;
            for (int i = 0; i < contacts.size(); i++) {
                taskNum++;
                output.format("%d) Name: %s %s%nPhone: %s%nEmail: %s%n", taskNum, contacts.get(i++), contacts.get(i++), contacts.get(i++), contacts.get(i));

            }
            System.out.print("Contact list saved successfully");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.print("File could not be saved");
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
            ContactApp ca = new ContactApp();
            ca.mainMenu();
        }
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()){
            list.add(s.nextLine());
        }
        s.close();




        //int i = list.size();
        //System.out.println("List size = " + i + "\n");


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
}

/*

ContactItem ci = new ContactItem();
        int i= 0;

        String first = ci.getFirstN();
        if(first.isEmpty())
        {
            i++;
        }
        String last = ci.getLastN();
        if(last.isEmpty())
        {
            i++;
            if(i == 2)
            {
                first = "N/A";
            }
        }
        String phone = ci.getPhone();
        if(phone.isEmpty())
        {
            i++;
            phone = "N/A";
        }
        String email = ci.getEmail();
        if(email.isEmpty())
        {
            i++;
            email = "N/A";
        }

        if( i > 3)
        {
            System.out.println("All contact values cannot be blank; Contact not created");
            ContactApp ca = new ContactApp();
            ca.listOperation();
        }
 */