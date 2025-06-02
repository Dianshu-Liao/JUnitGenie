package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

public class archivers_tar_TarArchiveOutputStream_finish__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testFinishThrowsIOExceptionWhenHaveUnclosedEntry() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        TarArchiveOutputStream tarOutputStream = new TarArchiveOutputStream(baos);
        
        // Set the private field `haveUnclosedEntry` to true using reflection
        try {
            Field field = TarArchiveOutputStream.class.getDeclaredField("haveUnclosedEntry");
            field.setAccessible(true);
            field.setBoolean(tarOutputStream, true);
            try {
                tarOutputStream.finish();
            } catch (IOException e) {
                // Expected exception
                return; // Exit the test successfully if the exception is caught
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        
        // If we reach this point, the exception was not thrown as expected
        throw new AssertionError("IOException was not thrown as expected");
    }


}