package org.apache.commons.compress.archivers.jar;
import org.apache.commons.compress.archivers.jar.JarArchiveEntry;
import org.apache.commons.compress.archivers.jar.JarArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import static org.junit.Assert.assertNull;

public class archivers_jar_JarArchiveInputStream_getNextJarEntry__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetNextJarEntryReturnsNull() {
        // Arrange
        InputStream inputStream = new ByteArrayInputStream(new byte[0]); // empty input stream
        JarArchiveInputStream jarArchiveInputStream = new JarArchiveInputStream(inputStream);

        try {
            // Act
            JarArchiveEntry result = jarArchiveInputStream.getNextJarEntry();

            // Assert
            assertNull(result);
        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

}