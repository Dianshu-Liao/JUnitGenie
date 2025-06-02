package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class archivers_cpio_CpioArchiveOutputStream_write_byte_____int_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testWrite_NoCurrentCpioEntry() {
        // Arrange
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CpioArchiveOutputStream cpioOutputStream = new CpioArchiveOutputStream(outputStream);
        byte[] data = new byte[]{1, 2, 3, 4, 5};
        int off = 0;
        int len = data.length;

        // Act & Assert
        try {
            cpioOutputStream.write(data, off, len);
        } catch (IOException e) {
            // Expected exception
            assert e.getMessage().equals("No current CPIO entry");
            return; // Exit the test successfully
        }
        // If no exception was thrown, fail the test
        assert false : "Expected IOException was not thrown";
    }

}