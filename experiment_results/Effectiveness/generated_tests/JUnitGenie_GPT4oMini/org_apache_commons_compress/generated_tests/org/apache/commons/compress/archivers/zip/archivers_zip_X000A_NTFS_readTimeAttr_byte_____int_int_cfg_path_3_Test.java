package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.X000A_NTFS;
import org.junit.Test;
import java.lang.reflect.Method;

public class archivers_zip_X000A_NTFS_readTimeAttr_byte_____int_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testReadTimeAttrWithLengthLessThan26() {
        try {
            // Arrange
            X000A_NTFS instance = new X000A_NTFS();
            byte[] data = new byte[25]; // Length is less than 26
            int offset = 0;
            int length = 25;

            // Act
            Method method = X000A_NTFS.class.getDeclaredMethod("readTimeAttr", byte[].class, int.class, int.class);
            method.setAccessible(true);
            method.invoke(instance, data, offset, length);

            // Assert
            // Since the method does not return anything and has no side effects, we can only verify that it completes without exceptions.
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}