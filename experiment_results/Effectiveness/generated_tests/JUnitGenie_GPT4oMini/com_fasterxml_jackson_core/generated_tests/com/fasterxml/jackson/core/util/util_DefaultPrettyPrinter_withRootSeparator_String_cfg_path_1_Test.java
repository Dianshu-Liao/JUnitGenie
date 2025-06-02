package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.io.SerializedString;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_DefaultPrettyPrinter_withRootSeparator_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWithRootSeparator_NonNullString() {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        String rootSeparator = "separator";
        try {
            DefaultPrettyPrinter result = printer.withRootSeparator(rootSeparator);
            assertNotNull(result);
        } catch (Exception e) {
            fail("Exception should not be thrown for a valid non-null rootSeparator");
        }
    }

    @Test(timeout = 4000)
    public void testWithRootSeparator_NullString() {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        String rootSeparator = null;
        try {
            DefaultPrettyPrinter result = printer.withRootSeparator(rootSeparator);
            assertNotNull(result); // Check that the method still returns a DefaultPrettyPrinter object
        } catch (Exception e) {
            fail("Exception should not be thrown for a null rootSeparator");
        }
    }

}