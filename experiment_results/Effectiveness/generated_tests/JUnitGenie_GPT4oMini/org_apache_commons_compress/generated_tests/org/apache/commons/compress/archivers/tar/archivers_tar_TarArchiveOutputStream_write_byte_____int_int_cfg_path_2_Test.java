package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import static org.junit.Assert.fail;

public class archivers_tar_TarArchiveOutputStream_write_byte_____int_int_cfg_path_2_Test {

    private TarArchiveOutputStream tarOutputStream;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        tarOutputStream = new TarArchiveOutputStream(outputStream);
        // Set the private fields to valid states for testing
        setPrivateField(tarOutputStream, "currSize", 100); // Assuming currSize is set to 100
        setPrivateField(tarOutputStream, "haveUnclosedEntry", true); // Assuming we have an unclosed entry
        setPrivateField(tarOutputStream, "currBytes", 0); // Start with 0 bytes written
    }

    @Test(timeout = 4000)
    public void testWriteExceedsSize() {
        byte[] wBuf = new byte[50];
        int wOffset = 0;
        int numToWrite = 101; // Exceeds the currSize of 100

        try {
            tarOutputStream.write(wBuf, wOffset, numToWrite);
            fail("Expected IOException to be thrown");
        } catch (IOException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Expected IOException but got: " + e.getClass().getSimpleName());
        }
    }

    @Test(timeout = 4000)
    public void testWriteNoCurrentEntry() {
        byte[] wBuf = new byte[50];
        int wOffset = 0;
        int numToWrite = 50;

        // Set haveUnclosedEntry to false to trigger the exception
        setPrivateField(tarOutputStream, "haveUnclosedEntry", false);

        try {
            tarOutputStream.write(wBuf, wOffset, numToWrite);
            fail("Expected IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Expected IllegalStateException but got: " + e.getClass().getSimpleName());
        }
    }

    @Test(timeout = 4000)
    public void testWriteSuccess() {
        byte[] wBuf = new byte[50];
        int wOffset = 0;
        int numToWrite = 50;

        try {
            tarOutputStream.write(wBuf, wOffset, numToWrite);
        } catch (IOException e) {
            fail("Did not expect IOException to be thrown: " + e.getMessage());
        }
    }

    // Helper method to set private fields using reflection
    private void setPrivateField(TarArchiveOutputStream instance, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = TarArchiveOutputStream.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(instance, value);
        } catch (Exception e) {
            fail("Failed to set private field: " + e.getMessage());
        }
    }

}