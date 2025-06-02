package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSet;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;

public class CharSet_add_String_cfg_path_23_Test {

    @Test(timeout = 4000)
    public void testAddWithNullString() {
        CharSet charSet = new CharSet();
        try {
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);
            addMethod.invoke(charSet, (String) null);
            // Check if nothing has been added, if needed
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

}