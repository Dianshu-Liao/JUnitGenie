package org.apache.commons.compress.archivers.sevenz;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.File;
import java.nio.channels.SeekableByteChannel;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;

public class archivers_sevenz_SevenZOutputFile_writeFileMTimes_DataOutput_cfg_path_14_Test {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(timeout = 4000)
    public void testWriteFileMTimes() {
        // Arrange
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            // Create a temporary file to use with SevenZOutputFile
            File tempFile = File.createTempFile("test", ".7z");
            tempFile.deleteOnExit(); // Ensure the file is deleted on exit

            SevenZOutputFile sevenZOutputFile = new SevenZOutputFile(tempFile);
            List<SevenZArchiveEntry> entries = new ArrayList<>();

            // Create a mock entry with getHasLastModifiedDate() returning false
            SevenZArchiveEntry entry = new SevenZArchiveEntry() {
                @Override
                public boolean getHasLastModifiedDate() {
                    return false; // Ensure it returns false
                }

                @Override
                public java.nio.file.attribute.FileTime getLastModifiedTime() {
                    return null; // Return null as getHasLastModifiedDate must be false
                }
            };

            entries.add(entry);
            // Use reflection to set the private 'files' field
            try {
                java.lang.reflect.Field filesField = SevenZOutputFile.class.getDeclaredField("files");
                filesField.setAccessible(true);
                filesField.set(sevenZOutputFile, entries);

                // Prepare to invoke the private method
                Method method = SevenZOutputFile.class.getDeclaredMethod("writeFileMTimes", DataOutput.class);
                method.setAccessible(true);

                // Act
                method.invoke(sevenZOutputFile, new DataOutputStream(baos));

            } catch (ReflectiveOperationException e) {
                // Handle the exception
                e.printStackTrace();
            } finally {
                sevenZOutputFile.close(); // Ensure the output file is closed
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}