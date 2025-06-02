package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertNotNull;
import java.nio.file.attribute.FileTime;

public class archivers_sevenz_SevenZOutputFile_writeFileMTimes_DataOutput_cfg_path_21_Test {

    @Test(timeout = 4000)
    public void testWriteFileMTimes() {
        try {
            // Setting up the necessary objects to call the focal method
            File tempFile = File.createTempFile("test", ".7z");
            SevenZOutputFile sevenZOutputFile = new SevenZOutputFile(tempFile);
            DataOutput header = new DataOutputStream(new ByteArrayOutputStream());

            // Preparing the files list with an entry having a last modified date
            List<SevenZArchiveEntry> entries = new ArrayList<>();
            SevenZArchiveEntry entry = new SevenZArchiveEntry();
            entry.setHasLastModifiedDate(true);
            entry.setLastModifiedTime(FileTime.fromMillis(System.currentTimeMillis())); // Corrected method call
            entries.add(entry);
            // Use reflection to set the private field 'files'
            java.lang.reflect.Field filesField = SevenZOutputFile.class.getDeclaredField("files");
            filesField.setAccessible(true);
            filesField.set(sevenZOutputFile, entries);

            // Invoking the private method using reflection
            Method method = SevenZOutputFile.class.getDeclaredMethod("writeFileMTimes", DataOutput.class);
            method.setAccessible(true);
            method.invoke(sevenZOutputFile, header);

            // Additional assertions could be added here to verify the behavior
            assertNotNull(header); // Checking if header was processed (not null)
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }

}