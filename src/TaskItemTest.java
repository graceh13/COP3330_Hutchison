import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/*

1) creatingTaskItemFailsWithInvalidDueDate()
2) creatingTaskItemFailsWithInvalidTitle()
3) creatingTaskItemSucceedsWithValidDueDate() /
4) creatingTaskItemSucceedsWithValidTitle() /
5) settingTaskItemDueDateFailsWithInvalidDate()
6) settingTaskItemDueDateSucceedsWithValidDate() /
7) settingTaskItemTitleFailsWithInvalidTitle()
8) settingTaskItemTitleSucceedsWithValidTitle() /
 */

class TaskItemTest {
    @Test
    public void creatingTaskItemSucceedsWithValidTitle() // 4
    {
        TaskItem t = new TaskItem();
        String input = "Task 1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("Task 1", t.getTitle());

    }
    @Test
    public void creatingTaskItemFailsWithInvalidTitle() //
    {
        TaskItem t = new TaskItem();
        String input = "";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("WARNING: title must be at least 1 character long; task not created", t.getTitle());

    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() // 3
    {
        TaskItem t = new TaskItem();
        String input = "2020-01-01";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("2020-01-01", t.getDate());

    }
    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle()
    {
        TaskItem t = new TaskItem();
        String title = "Task 1";
        assertEquals(Arrays.asList("2020-01-02", "Task 1", "This is my first task."),t.getTitle());
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidDate()
    {
        TaskItem t = new TaskItem();
        String date = "2019-12-13";
        assertEquals(Arrays.asList("2019-12-13", "Task 1", "This is my first task."),t.getDate());
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle()
    {
        TaskItem t = new TaskItem();
        String title = "";
        String date = "2019-12-13";
        String description = "This is my first task.";
        //assertThrows(Arrays.asList("2019-12-13", "", "This is my first task."),() -> t.getTitle(), "WARNING: title must be at least 1 character long; task not created");
    }


    @Test
    public void settingTaskItemTitleFailsWithInvalidDate() throws IllegalAccessException {
        TaskItem t = new TaskItem();
        t.date();

        fail();
    }

}


