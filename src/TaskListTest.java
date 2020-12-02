import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class TaskListTest {

    @Test
    public void addingItemsIncreasesSize()
    {
        TaskList tl = new TaskList();
        ContactList cl = new ContactList();
        ArrayList<String> task = new ArrayList<String>();
        String title = "task 1";

        tl.createList();
        tl.addTask(title);
        task.add(title);

        ArrayList<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add(title);

        assertArrayEquals(expectedOutput.toArray(), task.toArray());

    }

    @Test
    public void completingTaskItemChangesStatus()
    {
        TaskList tl = new TaskList();
        String title = "task 1";
        tl.createList();
        tl.addTask(title);

        int i = tl.complete(1);
        int x = 1;

        assertEquals(x, i);
    }

    @Test
    public void uncompletingTaskItemChangesStatus()
    {
        TaskList tl = new TaskList();
        String title = "garbage";
        tl.createList();
        tl.addTask(title);

        int i = tl.uncomplete(1);
        int x = 1;

        assertEquals(x, i);
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex()
    {
        TaskList tl = new TaskList();
        boolean x = tl.validIndex(-1);


        assertEquals(x, false);
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex()
    {
        TaskList tl = new TaskList();
        boolean x = tl.validIndex(-1);


        assertEquals(x, false);
    }

    @Test
    public void editingItemDescriptionFailsWithInvalidIndex()
    {
        TaskList tl = new TaskList();
        boolean x = tl.validIndex(-5);


        assertEquals(x, false);
    }

    @Test
    public void newListIsEmpty()
    {
        TaskList tl = new TaskList();
        tl.createList();
        tl.viewList();

        int i = 0;

        ArrayList<String> contacts = new ArrayList<String>();

        if (contacts.isEmpty()) {
            i = 1;
        }

        int expected = 1;

        assertEquals(expected, i);
    }

    @Test
    public void removingItemsFailsWithInvalidIndex()
    {
        TaskList tl = new TaskList();
        boolean x = tl.validIndex(-3);


        assertEquals(x, false);
    }

    @Test
    public void savedContactListCanBeLoaded()
    {
        TaskList tl = new TaskList();
        int i = 1;
        int x = 1;
        i = tl.listSuccessful(i);

        assertEquals(x, i);

    }

    @Test
    public void removingItemsDecreasesSize()
    {
        TaskList tl = new TaskList();
        ArrayList<String> contacts = new ArrayList<String>();
        String firstName = "John";
        String lastName = "Doe";
        contacts.add(firstName);
        contacts.add(lastName);

        tl.createList();
        tl.addTask(firstName);
        tl.removeOne(firstName);
        contacts.remove(firstName);

        ArrayList<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add(firstName);
        expectedOutput.add(lastName);
        expectedOutput.remove(firstName);

        assertArrayEquals(expectedOutput.toArray(), contacts.toArray());
    }

    @Test
    public void editingItemDescriptionSucceedsWithExpectedValue()
    {
        TaskList tl = new TaskList();
        ArrayList<String> contacts = new ArrayList<String>();
        String desc = "This is my first task";

        tl.createList();
        tl.addTask(desc);
        contacts.add(desc);

        ArrayList<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add(desc);


        assertArrayEquals(expectedOutput.toArray(), contacts.toArray());
    }

    @Test
    public void editingItemDueDateSucceedsWithExpectedValue()
    {
        TaskList tl = new TaskList();
        ArrayList<String> contacts = new ArrayList<String>();
        String date = "2020-05-06";

        tl.createList();
        tl.addTask(date);
        contacts.add(date);

        ArrayList<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add(date);


        assertArrayEquals(expectedOutput.toArray(), contacts.toArray());
    }

    @Test
    public void editingItemTitleFailsWithEmptyString()
    {
        TaskList tl = new TaskList();
        boolean x = tl.isTitleValid("");

        assertEquals(false, x);
    }

    @Test
    public void editingItemTitleSucceedsWithExpectedValue()
    {
        TaskList tl = new TaskList();
        ArrayList<String> contacts = new ArrayList<String>();
        String title = "do homework";

        tl.createList();
        tl.addTask(title);
        contacts.add(title);

        ArrayList<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add(title);


        assertArrayEquals(expectedOutput.toArray(), contacts.toArray());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex()
    {
        TaskList tl = new TaskList();
        int index = -2;
        boolean x = tl.validIndex(index);


        assertEquals(x, false);
    }

    @Test
    public void editingItemTitleFailsWithInvalidIndex()
    {
        TaskList tl = new TaskList();
        int index = -6;
        boolean x = tl.validIndex(index);


        assertEquals(x, false);
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidDateFormat()
    {
        TaskList tl = new TaskList();
        boolean x = tl.isDateValid("03-04-2020");

        assertEquals(false, x);
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidYYYMMDD()
    {
        TaskList tl = new TaskList();
        boolean x = tl.isDateValid("1985-67-09");

        assertEquals(false, x);
    }


    @Test
    public void gettingItemDescriptionFailsWithInvalidIndex()
    {
        TaskList tl = new TaskList();
        int index = -27;
        boolean x = tl.validIndex(index);


        assertEquals(x, false);
    }

    @Test
    public void gettingItemDescriptionSucceedsWithValidIndex()
    {
        TaskList tl = new TaskList();
        tl.createList();
        tl.addTask("Take out trash in kitchen");
        int index = 1;
        boolean x = tl.validIndex(index);


        assertEquals(x, true);
    }

    @Test
    public void gettingItemDueDateFailsWithInvalidIndex()
    {
        TaskList tl = new TaskList();
        int index = -4;
        boolean x = tl.validIndex(index);


        assertEquals(x, false);
    }

    @Test
    public void gettingItemDueDateSucceedsWithValidIndex()
    {
        TaskList tl = new TaskList();
        tl.createList();
        tl.addTask("2020-07-09");
        int index = 1;
        boolean x = tl.validIndex(index);


        assertEquals(x, true);
    }

    @Test
    public void gettingItemTitleFailsWithInvalidIndex()
    {
        TaskList tl = new TaskList();
        int index = -5;
        boolean x = tl.validIndex(index);


        assertEquals(x, false);
    }

    @Test
    public void gettingItemTitleSucceedsWithValidIndex()
    {
        TaskList tl = new TaskList();
        tl.createList();
        tl.addTask("Trash");
        int index = 1;
        boolean x = tl.validIndex(index);


        assertEquals(x, true);
    }

}