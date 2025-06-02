package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import static org.junit.Assert.fail;

public class archivers_cpio_CpioArchiveOutputStream_close__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testClose() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        CpioArchiveOutputStream cpioArchiveOutputStream = new CpioArchiveOutputStream(baos);

        try {
            // At this point, the stream is not finished, hence we can call close.
            cpioArchiveOutputStream.close();
        } catch (IOException e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }

        // Further assertions can be added to check the state of baos or any other post-conditions if necessary
    }

}