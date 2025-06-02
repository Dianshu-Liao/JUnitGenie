package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.X000A_NTFS;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Date;
import static org.junit.Assert.assertNotNull;

public class archivers_zip_X000A_NTFS_dateToZip_Date_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testDateToZip() {
        try {
            // Create an instance of the class to access the private static method
            X000A_NTFS instance = new X000A_NTFS();

            // Prepare a valid Date object
            Date validDate = new Date();

            // Access the private method using reflection
            Method method = X000A_NTFS.class.getDeclaredMethod("dateToZip", Date.class);
            method.setAccessible(true); // Make the method accessible

            // Invoke the method
            ZipEightByteInteger result = (ZipEightByteInteger) method.invoke(null, validDate);

            // Assert that the result is not null
            assertNotNull(result);

        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception as per rule 4
        }
    }

}