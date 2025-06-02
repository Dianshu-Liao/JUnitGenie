package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ResourceAlignmentExtraField;
import org.junit.Test;
import static org.junit.Assert.*;

public class archivers_zip_ResourceAlignmentExtraField__init__int_boolean_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testConstructorValidParameters() {
        ResourceAlignmentExtraField resourceAlignment = new ResourceAlignmentExtraField(1000, true, 10);
        // Assuming there are getter methods to validate the state
        // assertEquals(1000, resourceAlignment.getAlignment());
        // assertTrue(resourceAlignment.isAllowMethodChange());
        // assertEquals(10, resourceAlignment.getPadding());
    }

    @Test(timeout = 4000)
    public void testConstructorAlignmentTooLow() {
        try {
            new ResourceAlignmentExtraField(-1, true, 10);
            fail("Expected IllegalArgumentException for alignment < 0");
        } catch (IllegalArgumentException e) {
            assertEquals("Alignment must be between 0 and 0x7fff, was: -1", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testConstructorAlignmentTooHigh() {
        try {
            new ResourceAlignmentExtraField(0x8000, true, 10);
            fail("Expected IllegalArgumentException for alignment > 0x7fff");
        } catch (IllegalArgumentException e) {
            assertEquals("Alignment must be between 0 and 0x7fff, was: 32768", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testConstructorPaddingNegative() {
        try {
            new ResourceAlignmentExtraField(1000, true, -1);
            fail("Expected IllegalArgumentException for padding < 0");
        } catch (IllegalArgumentException e) {
            assertEquals("Padding must not be negative, was: -1", e.getMessage());
        }
    }

}