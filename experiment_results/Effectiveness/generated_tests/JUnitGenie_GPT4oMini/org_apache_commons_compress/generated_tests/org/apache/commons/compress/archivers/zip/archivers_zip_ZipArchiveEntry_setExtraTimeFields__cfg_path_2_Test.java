package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipExtraField;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.file.attribute.FileTime;
import java.util.Arrays;
import static org.junit.Assert.*;

public class archivers_zip_ZipArchiveEntry_setExtraTimeFields__cfg_path_2_Test {
    private ZipArchiveEntry zipArchiveEntry;

    @Before
    public void setUp() {
        // Initialize the ZipArchiveEntry instance using reflection
        try {
            // Access a constructor to create an instance
            Constructor<ZipArchiveEntry> constructor = ZipArchiveEntry.class.getDeclaredConstructor(File.class, String.class);
            constructor.setAccessible(true);
            zipArchiveEntry = constructor.newInstance(new File("dummy.zip"), "dummy_entry");
        } catch (Exception e) {
            fail("Failed to create ZipArchiveEntry instance: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSetExtraTimeFields() {
        try {
            // Simulate conditions to invoke the focal method
            zipArchiveEntry.getExtraField(X5455_ExtendedTimestamp.HEADER_ID); // ensuring extra field exists
            zipArchiveEntry.getExtraField(X000A_NTFS.HEADER_ID); // ensuring extra field exists
            // Mock the external behaviors if necessary
            // Set up the current object state to satisfy the external method parameters' constraints

            // Use reflection to invoke the private method
            Method setExtraTimeFieldsMethod = ZipArchiveEntry.class.getDeclaredMethod("setExtraTimeFields");
            setExtraTimeFieldsMethod.setAccessible(true);
            setExtraTimeFieldsMethod.invoke(zipArchiveEntry);

            // Since setExtraTimeFields() does not return a value, we can verify state changes or side effects
            ZipExtraField[] extraFields = zipArchiveEntry.getExtraFields();
            assertNotNull(extraFields);
            assertTrue(extraFields.length > 0);
            assertTrue(Arrays.stream(extraFields).allMatch(field -> field instanceof ZipExtraField));

        } catch (Exception e) {
            fail("setExtraTimeFields() threw an exception: " + e.getMessage());
        }
    }

}