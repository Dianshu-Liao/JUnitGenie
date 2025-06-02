package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.Base64Variant;
import org.junit.Test;
import static org.junit.Assert.*;

public class Base64Variants_valueOf_String_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testValueOfWithMIME() {
        Base64Variant result = Base64Variants.valueOf("MIME");
        assertEquals(Base64Variants.MIME, result);
    }

    @Test(timeout = 4000)
    public void testValueOfWithMIME_NO_LINEFEEDS() {
        Base64Variant result = Base64Variants.valueOf("MIME_NO_LINEFEEDS");
        assertEquals(Base64Variants.MIME_NO_LINEFEEDS, result);
    }

    @Test(timeout = 4000)
    public void testValueOfWithPEM() {
        Base64Variant result = Base64Variants.valueOf("PEM");
        assertEquals(Base64Variants.PEM, result);
    }

    @Test(timeout = 4000)
    public void testValueOfWithMODIFIED_FOR_URL() {
        Base64Variant result = Base64Variants.valueOf("MODIFIED_FOR_URL");
        assertEquals(Base64Variants.MODIFIED_FOR_URL, result);
    }

    @Test(timeout = 4000)
    public void testValueOfWithNull() {
        try {
            Base64Variants.valueOf(null);
            fail("Expected IllegalArgumentException for null input");
        } catch (IllegalArgumentException e) {
            assertEquals("No Base64Variant with name 'null'", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testValueOfWithInvalidName() {
        try {
            Base64Variants.valueOf("INVALID_NAME");
            fail("Expected IllegalArgumentException for invalid name");
        } catch (IllegalArgumentException e) {
            assertEquals("No Base64Variant with name 'INVALID_NAME'", e.getMessage());
        }
    }


}