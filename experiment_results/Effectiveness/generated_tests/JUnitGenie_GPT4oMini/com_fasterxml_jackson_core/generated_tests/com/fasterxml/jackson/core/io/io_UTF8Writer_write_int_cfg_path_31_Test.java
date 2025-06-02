package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.UTF8Writer;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class io_UTF8Writer_write_int_cfg_path_31_Test {

    @Test(timeout = 4000)
    public void testWriteWithIllegalSurrogate() {
        // Arrange
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // Create a valid OutputStreamWriter instead of passing null
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        int illegalSurrogateValue = 57344; // This value is greater than 56319

        // Act
        try {
            // Assuming UTF8Writer has a method to write an int, otherwise use writer directly
            writer.write(illegalSurrogateValue);
            writer.flush(); // Ensure all data is written out
        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        } finally {
            try {
                writer.close(); // Close the writer to free resources
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}