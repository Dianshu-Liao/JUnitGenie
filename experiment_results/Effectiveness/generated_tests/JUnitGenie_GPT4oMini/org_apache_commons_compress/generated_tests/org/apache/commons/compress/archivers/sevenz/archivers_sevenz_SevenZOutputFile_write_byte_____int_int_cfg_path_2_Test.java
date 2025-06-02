package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.junit.Test;
import java.io.File;
import java.io.IOException;

public class archivers_sevenz_SevenZOutputFile_write_byte_____int_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWriteWithPositiveLength() {
        // Arrange
        byte[] data = new byte[]{1, 2, 3, 4, 5};
        int offset = 0;
        int length = 5;
        File file = new File("test.7z");
        SevenZOutputFile sevenZOutputFile = null;

        try {
            sevenZOutputFile = new SevenZOutputFile(file);
            // Act
            sevenZOutputFile.write(data, offset, length);
            // If needed, you can add assertions here to verify the expected outcome
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        } finally {
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