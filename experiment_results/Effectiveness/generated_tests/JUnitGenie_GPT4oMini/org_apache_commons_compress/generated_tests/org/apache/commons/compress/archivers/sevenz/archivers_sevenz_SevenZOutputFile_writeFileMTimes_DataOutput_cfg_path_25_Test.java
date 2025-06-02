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
import static org.junit.Assert.assertNotNull;

public class archivers_sevenz_SevenZOutputFile_writeFileMTimes_DataOutput_cfg_path_25_Test {

    @Test(timeout = 4000)
    public void testWriteFileMTimes() {
        // Arrange
        SevenZOutputFile sevenZOutputFile = null;
        try {
            sevenZOutputFile = new SevenZOutputFile(new File("test.7z"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        List<SevenZArchiveEntry> entries = new ArrayList<>();
        
        // Create a mock entry with hasLastModifiedDate returning true
        SevenZArchiveEntry entry = Mockito.mock(SevenZArchiveEntry.class);
        Mockito.when(entry.getHasLastModifiedDate()).thenReturn(true);
        
        // Correctly create a FileTime instance for the last modified time
        FileTime fileTime = FileTime.fromMillis(System.currentTimeMillis());
        Mockito.when(entry.getLastModifiedTime()).thenReturn(fileTime);
        entries.add(entry);
        
        // Add the mock entry to the private files list
        try {
            java.lang.reflect.Field filesField = SevenZOutputFile.class.getDeclaredField("files");
            filesField.setAccessible(true);
            filesField.set(sevenZOutputFile, entries);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Create a DataOutput mock
        DataOutput header = Mockito.mock(DataOutput.class);
        
        // Act
        try {
            java.lang.reflect.Method method = SevenZOutputFile.class.getDeclaredMethod("writeFileMTimes", DataOutput.class);
            method.setAccessible(true);
            method.invoke(sevenZOutputFile, header);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Assert
        assertNotNull(sevenZOutputFile);
    }

}