package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.Archive;
import org.apache.commons.compress.harmony.pack200.Archive.PackingFile;
import org.junit.Test;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class harmony_pack200_Archive_estimateSize_PackingFile_cfg_path_3_Test {

    private void createDummyJar() throws IOException {
        File jarFile = new File("dummy.jar");
        if (!jarFile.exists()) {
            try (FileOutputStream fos = new FileOutputStream(jarFile)) {
                // Create a simple empty JAR file
                fos.write(new byte[0]);
            }
        }
    }

    @Test(timeout = 4000)
    public void testEstimateSizeWithMetaInf() {
        try {
            createDummyJar(); // Ensure the dummy.jar file exists

            // Create an instance of Archive
            Archive archive = new Archive(new java.util.jar.JarFile("dummy.jar"), new java.io.ByteArrayOutputStream(), new org.apache.commons.compress.harmony.pack200.PackingOptions());

            // Create a PackingFile instance with name starting with "META-INF"
            PackingFile packingFile = new PackingFile("META-INF/somefile.txt", new byte[0], 0L); // Corrected constructor usage

            // Access the private method estimateSize using reflection
            Method method = Archive.class.getDeclaredMethod("estimateSize", PackingFile.class);
            method.setAccessible(true);

            // Invoke the method and assert the result
            long result = (long) method.invoke(archive, packingFile);
            assertEquals(0L, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEstimateSizeWithNonMetaInf() {
        try {
            createDummyJar(); // Ensure the dummy.jar file exists

            // Create an instance of Archive
            Archive archive = new Archive(new java.util.jar.JarFile("dummy.jar"), new java.io.ByteArrayOutputStream(), new org.apache.commons.compress.harmony.pack200.PackingOptions());

            // Create a PackingFile instance with name not starting with "META-INF"
            PackingFile packingFile = new PackingFile("somefile.txt", new byte[100], 100L); // Corrected constructor usage

            // Access the private method estimateSize using reflection
            Method method = Archive.class.getDeclaredMethod("estimateSize", PackingFile.class);
            method.setAccessible(true);

            // Invoke the method and assert the result
            long result = (long) method.invoke(archive, packingFile);
            assertEquals(100 + "somefile.txt".length() + 5, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}