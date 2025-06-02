package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertNotNull;

public class archivers_sevenz_SevenZOutputFile_writeFileMTimes_DataOutput_cfg_path_26_Test {

    @Test(timeout = 4000)
    public void testWriteFileMTimes() {
        try {
            // Create a mock DataOutput
            DataOutput header = Mockito.mock(DataOutput.class);
            
            // Create an instance of SevenZOutputFile
            SevenZOutputFile sevenZOutputFile = new SevenZOutputFile(new File("test.7z"));
            
            // Prepare the files list with mock entries
            List<SevenZArchiveEntry> entries = new ArrayList<>();
            SevenZArchiveEntry entry1 = Mockito.mock(SevenZArchiveEntry.class);
            Mockito.when(entry1.getHasLastModifiedDate()).thenReturn(true);
            Mockito.when(entry1.getLastModifiedTime()).thenReturn(FileTime.fromMillis(System.currentTimeMillis()));
            entries.add(entry1);
            
            SevenZArchiveEntry entry2 = Mockito.mock(SevenZArchiveEntry.class);
            Mockito.when(entry2.getHasLastModifiedDate()).thenReturn(false);
            entries.add(entry2);
            
            // Use reflection to set the private 'files' field
            java.lang.reflect.Field filesField = SevenZOutputFile.class.getDeclaredField("files");
            filesField.setAccessible(true);
            filesField.set(sevenZOutputFile, entries);
            
            // Access the private method using reflection
            Method method = SevenZOutputFile.class.getDeclaredMethod("writeFileMTimes", DataOutput.class);
            method.setAccessible(true);
            
            // Invoke the method
            method.invoke(sevenZOutputFile, header);
            
            // Verify that the header write method was called
            Mockito.verify(header, Mockito.atLeastOnce()).write(Mockito.any(byte[].class));
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}