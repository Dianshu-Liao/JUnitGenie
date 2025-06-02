package org.apache.commons.compress.archivers.arj;
import org.apache.commons.compress.archivers.ArchiveException;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.Assert.assertTrue;

public class archivers_arj_ArjArchiveInputStream__init__InputStream_String_cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testConstructorThrowsMultiVolumeException() {
        String testInput = "test data"; // Sample input data
        InputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
        String charsetName = "UTF-8"; // Sample charset

        try {
            // Create an instance of ArjArchiveInputStream which should throw an exception
            ArjArchiveInputStream arjArchiveInputStream = new ArjArchiveInputStream(inputStream, charsetName);
        } catch (ArchiveException e) {
            // Verify that the exception message is as expected
            assertTrue(e.getMessage().equals("Multi-volume ARJ files are unsupported"));
            return; // Exit the method after handling the expected exception
        } catch (Exception e) {
            // Handle any other exceptions that may occur
            e.printStackTrace();
            throw new RuntimeException("Unexpected exception thrown", e);
        }
        // If no exception was thrown, fail the test
        throw new AssertionError("Expected ArchiveException was not thrown");
    }

}