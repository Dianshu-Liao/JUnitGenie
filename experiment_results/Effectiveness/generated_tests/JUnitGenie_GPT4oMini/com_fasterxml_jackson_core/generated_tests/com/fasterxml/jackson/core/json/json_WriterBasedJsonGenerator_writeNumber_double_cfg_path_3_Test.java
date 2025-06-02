package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import org.junit.Test;
import java.io.StringWriter;
import java.io.IOException;
import static org.junit.Assert.*;

public class json_WriterBasedJsonGenerator_writeNumber_double_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testWriteNumberWithNotFiniteValue() {
        // Arrange
        StringWriter stringWriter = new StringWriter();
        WriterBasedJsonGenerator generator = new WriterBasedJsonGenerator(null, 0, null, stringWriter);
        generator.configure(Feature.WRITE_NUMBERS_AS_STRINGS, false); // Set to false to ensure we go through the not finite check

        double notFiniteValue = Double.NaN; // Example of a not finite value

        // Act
        try {
            generator.writeNumber(notFiniteValue);
            String result = stringWriter.toString();

            // Assert
            assertNotNull(result);
            assertTrue(result.length() > 0); // Ensure that something was written
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumberWithValidFiniteValue() {
        // Arrange
        StringWriter stringWriter = new StringWriter();
        WriterBasedJsonGenerator generator = new WriterBasedJsonGenerator(null, 0, null, stringWriter);
        generator.configure(Feature.WRITE_NUMBERS_AS_STRINGS, false); // Set to false to ensure we go through the not finite check

        double finiteValue = 123.456; // Example of a finite value

        // Act
        try {
            generator.writeNumber(finiteValue);
            String result = stringWriter.toString();

            // Assert
            assertNotNull(result);
            assertTrue(result.length() > 0); // Ensure that something was written
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

}