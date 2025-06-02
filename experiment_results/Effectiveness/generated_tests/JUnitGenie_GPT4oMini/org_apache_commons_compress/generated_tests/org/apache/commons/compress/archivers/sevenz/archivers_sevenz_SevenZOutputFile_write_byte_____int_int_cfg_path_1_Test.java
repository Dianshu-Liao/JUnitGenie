package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class archivers_sevenz_SevenZOutputFile_write_byte_____int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWriteMethod() {
        // Arrange
        File testFile = new File("test.7z");
        SevenZOutputFile sevenZOutputFile = null;
        try {
            sevenZOutputFile = new SevenZOutputFile(testFile);
            byte[] data = new byte[]{1, 2, 3, 4, 5};
            int off = 0;
            int len = data.length;

            // Act
            sevenZOutputFile.write(data, off, len);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        } finally {
            // Clean up
            if (sevenZOutputFile != null) {
                try {
                    sevenZOutputFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}