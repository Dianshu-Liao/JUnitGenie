package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class archivers_zip_ZipArchiveInputStream_skipRemainderOfArchive__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSkipRemainderOfArchive() {
        // Prepare the input stream with dummy data
        ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[100]);
        ZipArchiveInputStream zipArchiveInputStream = new ZipArchiveInputStream(inputStream);

        // Set the private field 'entriesRead' using reflection
        try {
            java.lang.reflect.Field entriesReadField = ZipArchiveInputStream.class.getDeclaredField("entriesRead");
            entriesReadField.setAccessible(true);
            entriesReadField.setInt(zipArchiveInputStream, 1); // Set to a positive value to cover the path

            // Invoke the private method 'skipRemainderOfArchive' using reflection
            Method skipRemainderOfArchiveMethod = ZipArchiveInputStream.class.getDeclaredMethod("skipRemainderOfArchive");
            skipRemainderOfArchiveMethod.setAccessible(true);

            // Call the method and expect it to complete without throwing an exception
            skipRemainderOfArchiveMethod.invoke(zipArchiveInputStream);
        } catch (Exception e) {
            fail("An unexpected exception occurred: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSkipRemainderOfArchiveThrowsException() {
        // Prepare the input stream with dummy data
        ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[100]);
        ZipArchiveInputStream zipArchiveInputStream = new ZipArchiveInputStream(inputStream);

        // Set the private field 'entriesRead' to 0 to trigger the exception
        try {
            java.lang.reflect.Field entriesReadField = ZipArchiveInputStream.class.getDeclaredField("entriesRead");
            entriesReadField.setAccessible(true);
            entriesReadField.setInt(zipArchiveInputStream, 0); // Set to 0 to cover the exception path

            // Invoke the private method 'skipRemainderOfArchive' using reflection
            Method skipRemainderOfArchiveMethod = ZipArchiveInputStream.class.getDeclaredMethod("skipRemainderOfArchive");
            skipRemainderOfArchiveMethod.setAccessible(true);

            // Call the method and expect it to throw an exception
            skipRemainderOfArchiveMethod.invoke(zipArchiveInputStream);
            fail("Expected exception was not thrown.");
        } catch (IllegalArgumentException e) {
            // Expected exception, test passes
        } catch (Exception e) {
            fail("An unexpected exception occurred: " + e.getMessage());
        }
    }


}