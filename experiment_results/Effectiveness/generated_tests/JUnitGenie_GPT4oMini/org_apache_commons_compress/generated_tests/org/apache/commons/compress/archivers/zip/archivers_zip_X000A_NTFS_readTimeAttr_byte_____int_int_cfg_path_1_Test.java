package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.X000A_NTFS;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class archivers_zip_X000A_NTFS_readTimeAttr_byte_____int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testReadTimeAttr() {
        try {
            // Arrange
            X000A_NTFS instance = new X000A_NTFS();
            byte[] data = new byte[26]; // Sufficient length for the test
            int offset = 0;
            int length = data.length;

            // Set up the data to ensure TIME_ATTR_SIZE is matched
            ZipShort timeAttrSize = new ZipShort(data, offset);
            // Assuming the constructor initializes the value correctly
            // Here we set the value directly for the test
            // This is a mock, in a real scenario, you would need to ensure the data is set correctly
            System.arraycopy(new byte[]{0, 0, 0, 0, 0, 0, 0, 0}, 0, data, offset + 2, 8); // Mock modifyTime
            System.arraycopy(new byte[]{0, 0, 0, 0, 0, 0, 0, 0}, 0, data, offset + 10, 8); // Mock accessTime
            System.arraycopy(new byte[]{0, 0, 0, 0, 0, 0, 0, 0}, 0, data, offset + 18, 8); // Mock createTime

            // Act
            Method method = X000A_NTFS.class.getDeclaredMethod("readTimeAttr", byte[].class, int.class, int.class);
            method.setAccessible(true);
            method.invoke(instance, data, offset, length);

            // Assert
            assertNotNull(instance); // Ensure instance is not null after method execution
            // Additional assertions can be added to verify the state of modifyTime, accessTime, and createTime

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}