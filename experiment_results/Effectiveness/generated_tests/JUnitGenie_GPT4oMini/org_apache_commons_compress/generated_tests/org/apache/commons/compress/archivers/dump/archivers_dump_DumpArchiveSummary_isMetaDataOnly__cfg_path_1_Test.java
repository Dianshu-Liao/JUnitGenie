package org.apache.commons.compress.archivers.dump;
import org.apache.commons.compress.archivers.dump.DumpArchiveSummary;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import java.io.IOException;

public class archivers_dump_DumpArchiveSummary_isMetaDataOnly__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsMetaDataOnly() {
        // Create an instance of DumpArchiveSummary with valid data
        byte[] dummyData = new byte[8]; // Adjusted size to avoid ArrayIndexOutOfBoundsException
        DumpArchiveSummary summary = null;

        // Handle the IOException that may be thrown by the constructor
        try {
            summary = new DumpArchiveSummary(dummyData, null);
        } catch (IOException e) {
            e.printStackTrace();
            // Optionally, fail the test if the exception occurs
            assertFalse("IOException occurred while creating DumpArchiveSummary", true);
        }

        // Access the private field 'flags' using reflection to set it to 0
        try {
            java.lang.reflect.Field flagsField = DumpArchiveSummary.class.getDeclaredField("flags");
            flagsField.setAccessible(true);
            flagsField.setInt(summary, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Call the method and assert the expected result
        boolean result = summary.isMetaDataOnly();
        assertFalse(result);
    }

}