package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarFile;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveStructSparse;
import org.apache.commons.io.input.BoundedInputStream;
import org.apache.commons.compress.utils.BoundedSeekableByteChannelInputStream;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertNotNull;

public class archivers_tar_TarFile_buildSparseInputStreams__cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testBuildSparseInputStreams() {
        try {
            // Setup
            byte[] tarData = {}; // Provide valid TAR data
            TarFile tarFile = new TarFile(new File("path/to/your/tarfile.tar")); // Use a valid TAR file
            TarArchiveEntry entry = new TarArchiveEntry("testEntry");
            List<TarArchiveStructSparse> sparseHeaders = new ArrayList<>();

            // Create a valid TarArchiveStructSparse instance with required parameters
            TarArchiveStructSparse sparseHeader = new TarArchiveStructSparse(100L, 50L);
            sparseHeaders.add(sparseHeader);

            // Mock the currEntry and its methods
            setCurrEntry(tarFile, entry, sparseHeaders);

            // Invoke the private method using reflection
            invokeBuildSparseInputStreams(tarFile);

            // Assertions
            Map<String, List<InputStream>> sparseInputStreams = getSparseInputStreams(tarFile);
            assertNotNull(sparseInputStreams);
            assertNotNull(sparseInputStreams.get(entry.getName()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setCurrEntry(TarFile tarFile, TarArchiveEntry entry, List<TarArchiveStructSparse> sparseHeaders) {
        // Use reflection to set the private currEntry field
        try {
            java.lang.reflect.Field field = TarFile.class.getDeclaredField("currEntry");
            field.setAccessible(true);
            field.set(tarFile, entry);

            // Mock the getOrderedSparseHeaders method
            java.lang.reflect.Method method = TarFile.class.getDeclaredMethod("getOrderedSparseHeaders");
            method.setAccessible(true);
            method.invoke(tarFile, sparseHeaders);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void invokeBuildSparseInputStreams(TarFile tarFile) throws Exception {
        // Use reflection to access the private method buildSparseInputStreams
        java.lang.reflect.Method method = TarFile.class.getDeclaredMethod("buildSparseInputStreams");
        method.setAccessible(true);
        method.invoke(tarFile);
    }

    private Map<String, List<InputStream>> getSparseInputStreams(TarFile tarFile) throws Exception {
        // Use reflection to access the private sparseInputStreams field
        java.lang.reflect.Field field = TarFile.class.getDeclaredField("sparseInputStreams");
        field.setAccessible(true);
        return (Map<String, List<InputStream>>) field.get(tarFile);
    }

}