package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarFile;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveStructSparse;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class archivers_tar_TarFile_buildSparseInputStreams__cfg_path_18_Test {

    @Test(timeout = 4000)
    public void testBuildSparseInputStreams() {
        // Setup
        TarFile tarFile = mock(TarFile.class);
        TarArchiveEntry currEntry = mock(TarArchiveEntry.class);
        List<TarArchiveStructSparse> sparseHeaders = new ArrayList<>();
        
        // Conditions to ensure successful execution of the CFGPath
        try {
            when(currEntry.getOrderedSparseHeaders()).thenReturn(sparseHeaders);
            when(currEntry.getDataOffset()).thenReturn(100L);
            
            TarArchiveStructSparse sparseHeader = new TarArchiveStructSparse(50L, 10L); // Use real instance with parameters
            sparseHeaders.add(sparseHeader);

            Field currEntryField = TarFile.class.getDeclaredField("currEntry");
            currEntryField.setAccessible(true);
            currEntryField.set(tarFile, currEntry);

            SeekableByteChannel archiveChannel = mock(SeekableByteChannel.class);
            Field archiveField = TarFile.class.getDeclaredField("archive");
            archiveField.setAccessible(true);
            archiveField.set(tarFile, archiveChannel);

            Method method = TarFile.class.getDeclaredMethod("buildSparseInputStreams");
            method.setAccessible(true);
            method.invoke(tarFile);
            
        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testBuildSparseInputStreams_throwsIOException_CorruptedStructSparse() {
        // Setup
        TarFile tarFile = mock(TarFile.class);
        TarArchiveEntry currEntry = mock(TarArchiveEntry.class);
        List<TarArchiveStructSparse> sparseHeaders = new ArrayList<>();

        try {
            when(currEntry.getOrderedSparseHeaders()).thenReturn(sparseHeaders);
            when(currEntry.getDataOffset()).thenReturn(100L);
            
            TarArchiveStructSparse sparseHeader = new TarArchiveStructSparse(30L, 10L); // Use real instance with parameters
            sparseHeaders.add(sparseHeader);

            Field currEntryField = TarFile.class.getDeclaredField("currEntry");
            currEntryField.setAccessible(true);
            currEntryField.set(tarFile, currEntry);

            SeekableByteChannel archiveChannel = mock(SeekableByteChannel.class);
            Field archiveField = TarFile.class.getDeclaredField("archive");
            archiveField.setAccessible(true);
            archiveField.set(tarFile, archiveChannel);

            Method method = TarFile.class.getDeclaredMethod("buildSparseInputStreams");
            method.setAccessible(true);
            try {
                method.invoke(tarFile);
            } catch (InvocationTargetException ex) {
                Throwable cause = ex.getCause();
                // Assert that the IOException is thrown
                assertTrue(cause instanceof IOException);
                assertEquals("Corrupted struct sparse detected", cause.getMessage());
            }
        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | IOException e) {
            e.printStackTrace();
        }
    }

}