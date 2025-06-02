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
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.attribute.FileTime;

public class archivers_sevenz_SevenZOutputFile_writeFileMTimes_DataOutput_cfg_path_18_Test {

    @Test(timeout = 4000)
    public void testWriteFileMTimes() {
        // Given
        List<SevenZArchiveEntry> mockFiles = new ArrayList<>();
        SevenZArchiveEntry mockEntryWithDate = Mockito.mock(SevenZArchiveEntry.class);
        Mockito.when(mockEntryWithDate.getHasLastModifiedDate()).thenReturn(true);
        Mockito.when(mockEntryWithDate.getLastModifiedTime()).thenReturn(FileTime.fromMillis(System.currentTimeMillis()));
        mockFiles.add(mockEntryWithDate);

        SevenZArchiveEntry mockEntryWithoutDate = Mockito.mock(SevenZArchiveEntry.class);
        Mockito.when(mockEntryWithoutDate.getHasLastModifiedDate()).thenReturn(false);
        mockFiles.add(mockEntryWithoutDate);

        SevenZOutputFile sevenZOutputFile = null;
        try {
            sevenZOutputFile = new SevenZOutputFile(new File("output.7z"));
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }

        // Use reflection to access the private method
        try {
            // Prepare the DataOutput mock
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutput header = new DataOutputStream(baos);

            // Set the private "files" field in SevenZOutputFile
            java.lang.reflect.Field filesField = SevenZOutputFile.class.getDeclaredField("files");
            filesField.setAccessible(true);
            filesField.set(sevenZOutputFile, mockFiles);

            // When the method is invoked
            java.lang.reflect.Method method = SevenZOutputFile.class.getDeclaredMethod("writeFileMTimes", DataOutput.class);
            method.setAccessible(true);
            method.invoke(sevenZOutputFile, header);

            // Validate if the method executed with expected behavior
            byte[] outputContents = baos.toByteArray();
            // Assert your expectations on outputContents here for proper verification, if needed

        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            // Consider adding assertions to check if these exceptions are thrown as expected
        }
    }

}