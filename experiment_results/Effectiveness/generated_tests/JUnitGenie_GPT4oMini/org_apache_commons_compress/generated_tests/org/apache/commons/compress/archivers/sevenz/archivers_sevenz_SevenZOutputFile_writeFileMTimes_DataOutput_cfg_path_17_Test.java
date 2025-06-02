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
import static org.mockito.Mockito.*;

public class archivers_sevenz_SevenZOutputFile_writeFileMTimes_DataOutput_cfg_path_17_Test {

    @Test(timeout = 4000)
    public void testWriteFileMTimes() {
        // Arrange
        SevenZOutputFile sevenZOutputFile = null;
        try {
            sevenZOutputFile = new SevenZOutputFile(new File("test.7z"));
        } catch (IOException e) {
            e.printStackTrace();
            return; // Exit method if IOException occurs
        }
        
        List<SevenZArchiveEntry> entries = new ArrayList<>();
        
        // Create a mock entry with last modified date
        SevenZArchiveEntry entryWithDate = mock(SevenZArchiveEntry.class);
        when(entryWithDate.getHasLastModifiedDate()).thenReturn(true);
        when(entryWithDate.getLastModifiedTime()).thenReturn(FileTime.fromMillis(System.currentTimeMillis()));
        entries.add(entryWithDate);
        
        // Create a mock entry without last modified date
        SevenZArchiveEntry entryWithoutDate = mock(SevenZArchiveEntry.class);
        when(entryWithoutDate.getHasLastModifiedDate()).thenReturn(false);
        entries.add(entryWithoutDate);
        
        // Use reflection to set the private 'files' field
        try {
            java.lang.reflect.Field filesField = SevenZOutputFile.class.getDeclaredField("files");
            filesField.setAccessible(true);
            filesField.set(sevenZOutputFile, entries);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Create a mock DataOutput
        DataOutput header = mock(DataOutput.class);
        
        // Act
        try {
            // Invoke the private method using reflection
            java.lang.reflect.Method method = SevenZOutputFile.class.getDeclaredMethod("writeFileMTimes", DataOutput.class);
            method.setAccessible(true);
            method.invoke(sevenZOutputFile, header);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Assert
        // Verify that the header.write method was called with the expected values
        try {
            verify(header, atLeastOnce()).write(any(byte[].class));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the SevenZOutputFile if it was opened
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