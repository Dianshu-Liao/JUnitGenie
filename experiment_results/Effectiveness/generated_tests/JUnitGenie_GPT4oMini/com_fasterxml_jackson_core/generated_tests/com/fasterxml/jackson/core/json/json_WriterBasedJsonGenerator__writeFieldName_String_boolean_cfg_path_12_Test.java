package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.WriterBasedJsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import java.io.StringWriter;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

public class json_WriterBasedJsonGenerator__writeFieldName_String_boolean_cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testWriteFieldName() {
        try {
            StringWriter writer = new StringWriter();
            // Create a valid ObjectCodec instance (can be null if not needed)
            ObjectCodec codec = null; 
            IOContext context = new IOContext(null, writer, false); // Pass writer instead of null
            WriterBasedJsonGenerator generator = new WriterBasedJsonGenerator(context, 0, codec, writer);
            generator._outputTail = 1; // Set _outputTail for testing
            generator._outputEnd = 10; // Set _outputEnd for testing
            generator._cfgUnqNames = false; // Setting it to false for testing

            generator._writeFieldName("testName", true); // Calling the focal method with test parameters

            String output = writer.toString();
            assertTrue(output.contains("testName")); // Checking if the output contains the expected field name
            assertTrue(output.startsWith("\"")); // Checking if it starts with quote as _cfgUnqNames is false
            assertTrue(output.endsWith("\"")); // Checking if it ends with quote as _cfgUnqNames is false
        } catch (IOException e) {
            fail("IOException should not have been thrown: " + e.getMessage());
        }
    }


}