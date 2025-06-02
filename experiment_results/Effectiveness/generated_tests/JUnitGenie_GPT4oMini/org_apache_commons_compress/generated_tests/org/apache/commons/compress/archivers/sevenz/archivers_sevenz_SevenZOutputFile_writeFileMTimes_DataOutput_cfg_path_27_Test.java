package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.fail;

public class archivers_sevenz_SevenZOutputFile_writeFileMTimes_DataOutput_cfg_path_27_Test {

    @Test(timeout = 4000)
    public void testWriteFileMTimes() {
        // Arrange
        SevenZOutputFile sevenZOutputFile = null;
        try {
            sevenZOutputFile = new SevenZOutputFile(new File("test.7z"));
        } catch (IOException e) {
            fail("IOException was thrown while creating SevenZOutputFile: " + e.getMessage());
        }

        DataOutput header = Mockito.mock(DataOutput.class);

        // Create a mock for SevenZArchiveEntry
        SevenZArchiveEntry entry = Mockito.mock(SevenZArchiveEntry.class);
        Mockito.when(entry.getHasLastModifiedDate()).thenReturn(false); // Ensure it returns false
        Mockito.when(entry.getLastModifiedTime()).thenReturn(FileTime.fromMillis(System.currentTimeMillis())); // Valid FileTime

        // Add the entry to the files list
        List<SevenZArchiveEntry> files = new ArrayList<>();
        files.add(entry);

        // Use reflection to set the private 'files' field
        try {
            java.lang.reflect.Field filesField = SevenZOutputFile.class.getDeclaredField("files");
            filesField.setAccessible(true);
            filesField.set(sevenZOutputFile, files);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to set the private field: " + e.getMessage());
        }

        // Act
        try {
            // Use reflection to access the private method
            java.lang.reflect.Method writeFileMTimesMethod = SevenZOutputFile.class.getDeclaredMethod("writeFileMTimes", DataOutput.class);
            writeFileMTimesMethod.setAccessible(true);
            writeFileMTimesMethod.invoke(sevenZOutputFile, header);
        } catch (Exception e) {
            fail("Failed to invoke writeFileMTimes: " + e.getMessage());
        }

        // Assert
        // Verify that the header.write method was called with the expected parameters
        try {
            Mockito.verify(header).write(Mockito.any(byte[].class));
        } catch (IOException e) {
            fail("IOException was thrown during verification: " + e.getMessage());
        }
    }

}