package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ResourceAlignmentExtraField;
import org.junit.Test;

public class archivers_zip_ResourceAlignmentExtraField__init__int_boolean_int_cfg_path_1_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorAlignmentTooLow() {
        try {
            new ResourceAlignmentExtraField(-1, true, 0);
        } catch (IllegalArgumentException e) {
            // Exception is expected
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorAlignmentTooHigh() {
        try {
            new ResourceAlignmentExtraField(0x8000, true, 0);
        } catch (IllegalArgumentException e) {
            // Exception is expected
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorPaddingNegative() {
        try {
            new ResourceAlignmentExtraField(100, true, -1);
        } catch (IllegalArgumentException e) {
            // Exception is expected
        }
    }

}