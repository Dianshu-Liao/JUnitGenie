package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarFile;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveStructSparse;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class archivers_tar_TarFile_buildSparseInputStreams__cfg_path_5_Test {

    private TarFile tarFile;

    @Before
    public void setUp() throws Exception {
        // Create a temporary file for testing
        File tempFile = File.createTempFile("test", ".tar");
        tempFile.deleteOnExit(); // Ensure the file is deleted after the test

        // Initialize TarFile with the temporary file
        tarFile = new TarFile(tempFile);
        
        // Set private member 'currEntry' using reflection
        Method setCurrEntryMethod = TarFile.class.getDeclaredMethod("setCurrEntry", TarArchiveEntry.class);
        setCurrEntryMethod.setAccessible(true);

        TarArchiveEntry entry = new TarArchiveEntry("testEntry");
        // Create a sparse header instance using a constructor
        TarArchiveStructSparse sparseHeader = new TarArchiveStructSparse(100L, 10L); // Mock offset and number of bytes
        
        // Simulate the scenario where sparseHeaders are not empty
        List<TarArchiveStructSparse> sparseHeaders = new ArrayList<>();
        sparseHeaders.add(sparseHeader);
        entry.setSparseHeaders(sparseHeaders);
        
        setCurrEntryMethod.invoke(tarFile, entry);
    }

    @Test(timeout = 4000)
    public void testBuildSparseInputStreams() {
        try {
            // Access the private method buildSparseInputStreams() via reflection
            Method buildSparseInputStreamsMethod = TarFile.class.getDeclaredMethod("buildSparseInputStreams");
            buildSparseInputStreamsMethod.setAccessible(true);
            // This should execute without throwing an exception
            buildSparseInputStreamsMethod.invoke(tarFile);
        } catch (Exception e) {
            fail("An unexpected exception was thrown: " + e.getMessage());
        }
    }


}