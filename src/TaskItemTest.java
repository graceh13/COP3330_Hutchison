import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class TaskItemTest {

    @Test
    public void constructorFailsWithInvalidDueDate()
    {
        TaskItem ti = new TaskItem();
        boolean x = ti.isDateValid("34");

        assertEquals(false, x);
    }

    @Test
    public void constructorFailsWithInvalidTitle()
    {
        TaskItem ti = new TaskItem();
        boolean x = ti.isTitleValid("");

        assertEquals(false, x);
    }

    @Test
    public void constructorSucceedsWithValidTitle()
    {
        TaskItem ti = new TaskItem();
        boolean x = ti.isTitleValid("Task");

        assertEquals(true, x);
    }

    @Test
    public void constructorSucceedsWithValidTDudeDate()
    {
        TaskItem ti = new TaskItem();
        boolean x = ti.isDateValid("2020-04-07");

        assertEquals(true, x);
    }

    @Test
    public void editingDescriptionSucceedsWithExpectedValue()
    {
        TaskItem ti = new TaskItem();
        String y = "My first task";
        String x = ti.DescInfo(y);

        assertEquals(y,x);
    }

    @Test
    public void editingDueDateFailsWithInvalidDateFormat()
    {
        TaskItem ti = new TaskItem();
        boolean x = ti.isDateValid("03-04-2020");

        assertEquals(false, x);
    }

    @Test
    public void editingDueDateFailsWithInvalidYYYMMDD()
    {
        TaskItem ti = new TaskItem();
        boolean x = ti.isDateValid("1985-67-09");

        assertEquals(false, x);
    }

    @Test
    public void editingDueDateSucceedsWithExpectedValue()
    {
        TaskItem ti = new TaskItem();
        boolean x = ti.isDateValid("2019-12-01");

        assertEquals(true, x);
    }

    @Test
    public void editingTitleFailsWithEmptyString()
    {
        TaskItem ti = new TaskItem();
        boolean x = ti.isTitleValid("");

        assertEquals(false, x);
    }

    @Test
    public void editingTitleSucceedsWithExpectedValue()
    {
        TaskItem ti = new TaskItem();
        boolean x = ti.isTitleValid("Wash car");

        assertEquals(true, x);
    }



}