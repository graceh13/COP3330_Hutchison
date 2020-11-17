import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {


    @Test
    public void completingTaskItemFailsWithInvalidIndex()
    {
        TaskList l = new TaskList();
        String input = "100";
        int x = 1;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //assertEquals(l.complete(x));
    }

    @Test
    public void addingTaskItemsIncreasesSize()
    {
        TaskList l = new TaskList();
        String input = "task1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //assertEquals("task1", l.addTask());
    }


    /*
    @Test
    public void completingTaskItemChangesStatus()
    {
        TaskList l = new TaskList();
        int input = 0;
        String x = "***";
        InputStream in = new ByteArrayInputStream(x.getBytes());
        System.setIn(in);

        //assertEquals(0, l.complete());

    }

    @Test
    public void completingTaskItemChangesStatus()
    {
        TaskList l = new TaskList();
        int input = 0;

        assertAll();

    }
     */
}