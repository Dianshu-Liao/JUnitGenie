package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.io.SerializedString;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_DefaultPrettyPrinter__init__String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testConstructorWithValidString() {
        String rootSeparator = "validSeparator";
        try {
            DefaultPrettyPrinter printer = new DefaultPrettyPrinter(rootSeparator);
            // Additional assertions can be added here to verify the state of the printer if needed
            assertNotNull(printer);
        } catch (Exception e) {
            fail("Constructor threw an exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithNullString() {
        String rootSeparator = null;
        try {
            DefaultPrettyPrinter printer = new DefaultPrettyPrinter(rootSeparator);
            // Additional assertions can be added here to verify the state of the printer if needed
            assertNotNull(printer);
        } catch (Exception e) {
            fail("Constructor threw an exception: " + e.getMessage());
        }
    }

}