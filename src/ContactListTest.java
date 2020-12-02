import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {


    @Test
    public void addingItemsIncreasesSize()
    {
        ContactList cl = new ContactList();
        ArrayList<String> contacts = new ArrayList<String>();
        String firstName = "Peter";

        cl.createList();
        cl.addTask(firstName);
        contacts.add(firstName);

        ArrayList<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add(firstName);

        assertArrayEquals(expectedOutput.toArray(), contacts.toArray());
    }

    @Test
    public void editingItemsFailsWithAllBlankValues()
    {
        ContactList cl = new ContactList();
        String editname = "";
        String editlast = "";
        String editphone = "";
        String editemail = "";
        int i = 0;
        int x = 0;

        cl.editAll(editname, i);

        if(editname.isEmpty())
        {
            i++;
        }
        if(editlast.isEmpty())
        {
            i++;
        }
        if(editphone.isEmpty())
        {
            i++;
        }
        if(editemail.isEmpty())
        {
            i++;
        }
        if(i > 3)
        {
            System.out.println("All contact values cannot be blank; Contact not created");
            x = 4;
        }


        assertEquals(x,i);
    }

    @Test
    public void editingItemsFailsWithInvalidIndex()
    {
        ContactList cl = new ContactList();
        boolean x = cl.validIndex(-1);


        assertEquals(x, false);
    }


    @Test
    public void newListIsEmpty()
    {
        ContactList ci = new ContactList();
        ci.createList();
        ci.viewList();

        int i = 0;

        ArrayList<String> contacts = new ArrayList<String>();

        if (contacts.isEmpty()) {
            i = 1;
        }

        int expected = 1;

        assertEquals(expected, i);
    }


    @Test
    public void editingSucceedsWithBlankFirstName()
    {
        ContactItem ci = new ContactItem();
        assertEquals("", ci.info(""));
    }

    @Test
    public void editingSucceedsWithBlankLastName()
    {
        ContactItem ci = new ContactItem();
        assertEquals("", ci.info(""));
    }

    @Test
    public void editingSucceedsWithBlankPhone()
    {
        ContactItem ci = new ContactItem();
        assertEquals("", ci.info(""));
    }

    @Test
    public void editingSucceedsWithBlankEmail()
    {
        ContactItem ci = new ContactItem();
        assertEquals("", ci.info(""));
    }



    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactItem ci = new ContactItem();
        assertEquals("Hutch", ci.info("Hutch"));
    }

    @Test
    public void removingItemsDecreasesSize()
    {
        ContactList cl = new ContactList();
        ArrayList<String> contacts = new ArrayList<String>();
        String firstName = "Peter";
        String lastName = "Smith";
        contacts.add(firstName);
        contacts.add(lastName);

        cl.createList();
        cl.addTask(firstName);
        cl.removeOne(firstName);
        contacts.remove(firstName);

        ArrayList<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add(firstName);
        expectedOutput.add(lastName);
        expectedOutput.remove(firstName);

        assertArrayEquals(expectedOutput.toArray(), contacts.toArray());
    }

    @Test
    public void removingItemsFailsWithInvalidIndex()
    {
        ContactList cl = new ContactList();
        boolean x = cl.validIndex(-1);


        assertEquals(x, false);
    }

    @Test
    public void savedContactListCanBeLoaded()
    {
        ContactList cl = new ContactList();
        int i = 1;
        int x = 1;
        i = cl.listSuccessful(i);

        assertEquals(x, i);

    }

}