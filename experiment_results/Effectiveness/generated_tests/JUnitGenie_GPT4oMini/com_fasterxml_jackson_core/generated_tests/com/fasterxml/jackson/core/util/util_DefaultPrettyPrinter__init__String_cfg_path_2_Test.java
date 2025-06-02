package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.SerializableString;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_DefaultPrettyPrinter__init__String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testConstructorWithNull() {
        try {
            // Explicitly specify the constructor to avoid ambiguity
            DefaultPrettyPrinter printer = new DefaultPrettyPrinter((String) null);
            assertNotNull(printer);
            // Further assertions can be added if needed
        } catch (Exception e) {
            fail("Exception should not have been thrown for null input");
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithValidString() {
        String validSeparator = "validSeparator";
        try {
            // Explicitly specify the constructor to avoid ambiguity
            DefaultPrettyPrinter printer = new DefaultPrettyPrinter(validSeparator);
            assertNotNull(printer);
            // Further assertions can be added if needed
        } catch (Exception e) {
            fail("Exception should not have been thrown for valid input");
        }
    }


}