package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.junit.Test;
import java.nio.file.attribute.FileTime;

public class archivers_zip_ZipArchiveEntry_setExtraTimeFields__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testSetExtraTimeFields() {
        try {
            // Create an instance of ZipArchiveEntry using reflection
            ZipArchiveEntry zipEntry = ZipArchiveEntry.class.getDeclaredConstructor().newInstance();

            // Set up the times
            FileTime lastModifiedTime = FileTime.fromMillis(123456789);
            FileTime lastAccessTime = FileTime.fromMillis(123456789); // Set to a valid FileTime
            FileTime creationTime = FileTime.fromMillis(987654321);

            // Call the public method that should internally call the private methods
            zipEntry.setLastModifiedTime(lastModifiedTime);
            zipEntry.setLastAccessTime(lastAccessTime); // Ensure this is not null
            zipEntry.setCreationTime(creationTime);

            // Verify the expected behavior through public methods
            // (You would need to implement checks based on the expected state of zipEntry)

        } catch (Exception e) {
            e.printStackTrace();
            // Handling the exception as required by the rules
        }
    }


}