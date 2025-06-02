package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ResourceAlignmentExtraField;
import org.junit.Test;

public class archivers_zip_ResourceAlignmentExtraField__init__int_boolean_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testConstructorWithInvalidAlignment() {
        try {
            new ResourceAlignmentExtraField(-1, true, 0);
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        try {
            new ResourceAlignmentExtraField(32768, true, 0);
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithInvalidPadding() {
        try {
            new ResourceAlignmentExtraField(1000, true, -1);
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithValidParameters() {
        ResourceAlignmentExtraField resourceAlignment = new ResourceAlignmentExtraField(1000, true, 0);
        // Additional assertions can be added here to verify the state of the object if needed
    }

}