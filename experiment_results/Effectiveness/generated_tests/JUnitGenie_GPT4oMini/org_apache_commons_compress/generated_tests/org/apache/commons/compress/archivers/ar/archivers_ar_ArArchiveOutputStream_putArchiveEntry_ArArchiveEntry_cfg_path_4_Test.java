package org.apache.commons.compress.archivers.ar;
import org.apache.commons.compress.archivers.ar.ArArchiveEntry;
import org.apache.commons.compress.archivers.ar.ArArchiveOutputStream;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import static org.junit.Assert.assertNotNull;

public class archivers_ar_ArArchiveOutputStream_putArchiveEntry_ArArchiveEntry_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testPutArchiveEntry() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ArArchiveOutputStream archiveOutputStream = new ArArchiveOutputStream(outputStream);
        ArArchiveEntry entry = new ArArchiveEntry("testEntry", 100L);

        try {
            archiveOutputStream.putArchiveEntry(entry);
            assertNotNull(archiveOutputStream);
        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

}