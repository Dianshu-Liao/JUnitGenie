package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class archivers_tar_TarArchiveOutputStream_finish__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testFinishWithUnclosedEntry() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        TarArchiveOutputStream tarOutputStream = new TarArchiveOutputStream(outputStream);
        
        // Set the private field 'haveUnclosedEntry' to true to simulate unclosed entries
        try {
            java.lang.reflect.Field field = TarArchiveOutputStream.class.getDeclaredField("haveUnclosedEntry");
            field.setAccessible(true);
            field.set(tarOutputStream, true);
            
            // Call the finish method and expect an IOException
            try {
                tarOutputStream.finish();
            } catch (IOException e) {
                // Expected exception
                return;
            }
        } catch (Exception e) {
            // Handle any reflection exceptions
            e.printStackTrace();
        }
        
        // If we reach here, the exception was not thrown as expected
        throw new AssertionError("Expected IOException was not thrown.");
    }

    @Test(timeout = 4000)
    public void testFinishWithoutUnclosedEntry() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        TarArchiveOutputStream tarOutputStream = new TarArchiveOutputStream(outputStream);
        
        // Set the private field 'haveUnclosedEntry' to false to simulate no unclosed entries
        try {
            java.lang.reflect.Field field = TarArchiveOutputStream.class.getDeclaredField("haveUnclosedEntry");
            field.setAccessible(true);
            field.set(tarOutputStream, false);
            
            // Call the finish method, expecting no exceptions
            tarOutputStream.finish();
        } catch (Exception e) {
            // Handle any exceptions that should not occur
            e.printStackTrace();
            throw new AssertionError("Unexpected exception thrown: " + e.getMessage());
        }
    }

}