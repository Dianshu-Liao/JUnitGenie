package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.io.NumberOutput;
import org.junit.Test;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class json_UTF8JsonGenerator_writeNumber_double_cfg_path_3_Test {
    private UTF8JsonGenerator generator;
    private ByteArrayOutputStream outputStream;


    @Test(timeout = 4000)
    public void testWriteNumberWithNotFiniteValue() {
        double notFiniteValue = Double.NaN; // Example of a not finite value

        try {
            // Set the necessary conditions for the test
            generator.configure(UTF8JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, false); // Use the public method to set the feature

            // Call the focal method
            generator.writeNumber(notFiniteValue);

            // Verify the output
            String expectedOutput = NumberOutput.toString(notFiniteValue, false);
            assertEquals(expectedOutput, outputStream.toString());
        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumberWithFiniteValue() {
        double finiteValue = 123.456; // Example of a finite value

        try {
            // Set the necessary conditions for the test
            generator.configure(UTF8JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, false); // Use the public method to set the feature

            // Call the focal method
            generator.writeNumber(finiteValue);

            // Verify the output
            String expectedOutput = NumberOutput.toString(finiteValue, false);
            assertEquals(expectedOutput, outputStream.toString());
        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

}
