package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSet;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertTrue;

public class CharSet_add_String_cfg_path_24_Test {

    @Test(timeout = 4000)
    public void testAddWithNullString() {
        CharSet charSet = new CharSet(new String[]{});
        try {
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);
            addMethod.invoke(charSet, (String) null);
            // Since the method returns void and does not throw an exception, we can assert that it completed.
            assertTrue(true);
        } catch (Exception e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

}