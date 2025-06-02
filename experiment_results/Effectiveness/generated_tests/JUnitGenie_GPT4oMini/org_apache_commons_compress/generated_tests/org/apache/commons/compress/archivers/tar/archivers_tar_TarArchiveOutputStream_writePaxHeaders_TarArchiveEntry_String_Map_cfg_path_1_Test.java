package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class archivers_tar_TarArchiveOutputStream_writePaxHeaders_TarArchiveEntry_String_Map_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWritePaxHeaders() {
        // Arrange
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        TarArchiveOutputStream tarOutputStream = new TarArchiveOutputStream(outputStream);
        
        TarArchiveEntry entry = new TarArchiveEntry("testEntry");
        String entryName = "validEntryName";
        Map<String, String> headers = new HashMap<>();
        headers.put("key1", "value1");
        headers.put("key2", "value2");

        // Act
        try {
            tarOutputStream.writePaxHeaders(entry, entryName, headers);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        } finally {
            // Clean up
            try {
                tarOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}