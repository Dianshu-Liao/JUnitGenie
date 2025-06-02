package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter.FixedSpaceIndenter;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class util_DefaultPrettyPrinter_withRootSeparator_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWithRootSeparator_NullInput() {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        try {
            DefaultPrettyPrinter result = printer.withRootSeparator((String) null); // Cast to String to resolve ambiguity
            assertNotNull(result); // Ensure that the result is not null
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }



}
