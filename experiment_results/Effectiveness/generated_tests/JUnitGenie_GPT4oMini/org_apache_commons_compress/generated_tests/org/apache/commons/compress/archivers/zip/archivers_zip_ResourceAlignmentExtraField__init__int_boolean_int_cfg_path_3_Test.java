package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ResourceAlignmentExtraField;
import org.junit.Test;

public class archivers_zip_ResourceAlignmentExtraField__init__int_boolean_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testConstructorWithInvalidAlignment() {
        try {
            new ResourceAlignmentExtraField(-1, true, 0);
        } catch (IllegalArgumentException e) {
            // Expected exception
            assert e.getMessage().equals("Alignment must be between 0 and 0x7fff, was: -1");
        }

        try {
            new ResourceAlignmentExtraField(0x8000, true, 0);
        } catch (IllegalArgumentException e) {
            // Expected exception
            assert e.getMessage().equals("Alignment must be between 0 and 0x7fff, was: 32768");
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithInvalidPadding() {
        try {
            new ResourceAlignmentExtraField(1000, true, -1);
        } catch (IllegalArgumentException e) {
            // Expected exception
            assert e.getMessage().equals("Padding must not be negative, was: -1");
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithValidParameters() {
        ResourceAlignmentExtraField resourceAlignment = new ResourceAlignmentExtraField(1000, true, 0);
        // Additional assertions can be added here to verify the state of the object if needed
    }

}