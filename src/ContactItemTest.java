import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest {


    @Test
    public void creationSucceedsWithBlankEmail()
    {
        ContactItem ci = new ContactItem();
        assertEquals("", ci.info(""));
    }

    @Test
    public void creationSucceedsWithBlankFirstName()
    {
        ContactItem ci = new ContactItem();
        assertEquals("", ci.info(""));
    }

    @Test
    public void creationSucceedsWithBlankLastName()
    {
        ContactItem ci = new ContactItem();
        assertEquals("", ci.info(""));
    }

    @Test
    public void creationSucceedsWithBlankPhone()
    {
        ContactItem ci = new ContactItem();
        assertEquals("", ci.info(""));
    }

    @Test
    public void creationSucceedsWithNonBlankValues()
    {
        ContactItem ci = new ContactItem();
        assertEquals("John", ci.info("John"));
    }


    @Test
    public void creationFailsWithAllBlankValues()
    {
        ContactItem ci = new ContactItem();
        String name = "";
        String last = "";
        String phone = "";
        String email = "";
        int i = 0;
        int x = 0;

        if(name.isEmpty())
        {
            i++;
        }
        if(last.isEmpty())
        {
            i++;
        }
        if(phone.isEmpty())
        {
            i++;
        }
        if(email.isEmpty())
        {
            i++;
        }
        if(i > 3)
        {
            System.out.println("All contact values cannot be blank; Contact not created");
             x = 4;
        }

        ci.info(last);

        assertEquals(x,i);
    }

    @Test
    public void editingFailsWithAllBlankValues()
    {
        ContactItem ci = new ContactItem();
        String editname = "";
        String editlast = "";
        String editphone = "";
        String editemail = "";
        int i = 0;
        int x = 0;

        ci.info(editname);

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
    public void editingSucceedsWithBlankEmail()
    {
        ContactItem ci = new ContactItem();
        assertEquals("", ci.info(""));
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
    public void editingSucceedsWithNonBlankValues() {
        ContactItem ci = new ContactItem();
        assertEquals("Smith", ci.info("Smith"));
    }

    @Test
    public void testToString()
    {
        ContactItem ci = new ContactItem();
        assertEquals("test", ci.info("test"));
    }
}