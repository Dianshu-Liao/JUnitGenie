package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class archivers_zip_ZipArchiveInputStream_skipRemainderOfArchive__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testSkipRemainderOfArchiveThrowsIOException() {
        // Setup: Create an instance of ZipArchiveInputStream with a ByteArrayInputStream that simulates end of stream
        ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[]{});
        ZipArchiveInputStream zipArchiveInputStream = new ZipArchiveInputStream(inputStream);

        // Use reflection to access the private method
        try {
            // Force the entriesRead field to be 0 to simulate the condition in CFGPath
            setPrivateField(zipArchiveInputStream, "entriesRead", 0);

            // Invoke the private method skipRemainderOfArchive
            Method method = ZipArchiveInputStream.class.getDeclaredMethod("skipRemainderOfArchive");
            method.setAccessible(true);
            method.invoke(zipArchiveInputStream);

            // If we reach this point, the test should fail since we expected an IOException
            fail("Expected IOException not thrown");
        } catch (IOException e) {
            // Expected exception
        } catch (Exception e) {
            e.printStackTrace();
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    private void setPrivateField(Object obj, String fieldName, int value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.setInt(obj, value);
    }

}