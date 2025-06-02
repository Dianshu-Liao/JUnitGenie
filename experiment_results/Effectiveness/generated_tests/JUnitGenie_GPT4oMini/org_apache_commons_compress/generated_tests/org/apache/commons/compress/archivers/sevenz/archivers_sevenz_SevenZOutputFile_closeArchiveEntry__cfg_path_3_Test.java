package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.io.output.CountingOutputStream;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.zip.CRC32;
import static org.mockito.Mockito.*;

public class archivers_sevenz_SevenZOutputFile_closeArchiveEntry__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testCloseArchiveEntry_withNonEmptyStream() throws Exception {
        // Arrange
        CountingOutputStream outputStreamMock = mock(CountingOutputStream.class);
        when(outputStreamMock.getByteCount()).thenReturn(100L);

        CRC32 crc32Mock = mock(CRC32.class);
        when(crc32Mock.getValue()).thenReturn(12345L);

        CRC32 compressedCrc32Mock = mock(CRC32.class);
        when(compressedCrc32Mock.getValue()).thenReturn(54321L);
        
        SevenZArchiveEntry entryMock = mock(SevenZArchiveEntry.class);
        List<SevenZArchiveEntry> filesListMock = mock(List.class);
        when(filesListMock.size()).thenReturn(1);
        when(filesListMock.get(0)).thenReturn(entryMock);

        // Use a real instance of SevenZOutputFile instead of mocking it
        SevenZOutputFile sevenZOutputFile = new SevenZOutputFile(new File("dummy.7z")); 

        // Set up the private field access through reflection
        setPrivateField(sevenZOutputFile, "numNonEmptyStreams", 1); // Changed from 0 to 1
        setPrivateField(sevenZOutputFile, "currentOutputStream", outputStreamMock);

        // Act
        try {
            sevenZOutputFile.closeArchiveEntry();
        } catch (IOException e) {
            // Handle IOException for test
        }

        // Assert
        verify(entryMock).setHasStream(true);
        verify(entryMock).setSize(100L);
        verify(entryMock).setCompressedSize(100L);
        verify(entryMock).setCrcValue(12345L);
        verify(entryMock).setCompressedCrcValue(54321L);
        verify(entryMock).setHasCrc(true);
    }

    private void setPrivateField(SevenZOutputFile instance, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = instance.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(instance, value);
    }


}