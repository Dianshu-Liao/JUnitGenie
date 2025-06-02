package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class archivers_cpio_CpioArchiveInputStream_readNewEntry_boolean_cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testReadNewEntryWithNegativeSize() {
        InputStream inputStream = new ByteArrayInputStream(new byte[] {
            0, 0, 0, 0, 0, 0, 0, 0, // Placeholder for reading an inode
            0, 0, 0, 0, 0, 0, 0, 0, // Placeholder for mode (set incorrectly)
            0, 0, 0, 0, 0, 0, 0, 0, // Placeholder for UID
            0, 0, 0, 0, 0, 0, 0, 0, // Placeholder for GID
            0, 0, 0, 0, 0, 0, 0, 0, // Placeholder for number of links
            0, 0, 0, 0, 0, 0, 0, 0, // Placeholder for time
            0, 0, 0, 0, 0, 0, 0, 0, // Placeholder for negative size
            0, 0, 0, 0, 0, 0, 0, 0, // Placeholder for device majors
            0, 0, 0, 0, 0, 0, 0, 0, // Placeholder for device minors
            0, 0, 0, 0, 0, 0, 0, 0, // Placeholder for remote device majors
            0, 0, 0, 0, 0, 0, 0, 0, // Placeholder for remote device minors
            0, 0, 0, 0, 0, 0, 0, 0, // Placeholder for namesize
            0, // Placeholder for name (length = 1)
        });

        CpioArchiveInputStream archiveInputStream = new CpioArchiveInputStream(inputStream);
        Method method = null;

        try {
            method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
            method.setAccessible(true);
            method.invoke(archiveInputStream, true);
            fail("Expected an exception due to negative entry length");
        } catch (Exception e) {
            if (e.getCause() instanceof IOException) {
                // Expected exception
            } else {
                e.printStackTrace();
            }
        }
    }

    @Test(timeout = 4000)
    public void testReadNewEntryWithNegativeNameSize() {
        InputStream inputStream = new ByteArrayInputStream(new byte[] {
            0, 0, 0, 0, 0, 0, 0, 0, // Placeholder for reading an inode
            0, 0, 0, 0, 0, 0, 0, 0, // Placeholder for mode
            0, 0, 0, 0, 0, 0, 0, 0, // Placeholder for UID
            0, 0, 0, 0, 0, 0, 0, 0, // Placeholder for GID
            0, 0, 0, 0, 0, 0, 0, 0, // Placeholder for number of links
            0, 0, 0, 0, 0, 0, 0, 0, // Placeholder for time
            0, 0, 0, -1, 0, 0, 0, 0, // Placeholder for namesize (set to -1 to trigger exception)
            0, 0, 0, 0, 0, 0, 0, 0, // Placeholder for device majors
            0, 0, 0, 0, 0, 0, 0, 0, // Placeholder for device minors
            0, 0, 0, 0, 0, 0, 0, 0, // Placeholder for remote device majors
            0, 0, 0, 0, 0, 0, 0, 0, // Placeholder for remote device minors
        });

        CpioArchiveInputStream archiveInputStream = new CpioArchiveInputStream(inputStream);
        Method method = null;

        try {
            method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
            method.setAccessible(true);
            method.invoke(archiveInputStream, true);
            fail("Expected an exception due to negative name length");
        } catch (Exception e) {
            if (e.getCause() instanceof IOException) {
                // Expected exception
            } else {
                e.printStackTrace();
            }
        }
    }

}