package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import org.junit.Test;
import static org.junit.Assert.*;

public class Base64Variants_valueOf_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testValueOfWithValidMIME() {
        try {
            Base64Variant result = Base64Variants.valueOf("MIME");
            assertEquals(Base64Variants.MIME, result);
        } catch (IllegalArgumentException e) {
            fail("Expected valid Base64Variant not to throw exception.");
        }
    }

    @Test(timeout = 4000)
    public void testValueOfWithValidMIME_NO_LINEFEEDS() {
        try {
            Base64Variant result = Base64Variants.valueOf("MIME_NO_LINEFEEDS");
            assertEquals(Base64Variants.MIME_NO_LINEFEEDS, result);
        } catch (IllegalArgumentException e) {
            fail("Expected valid Base64Variant not to throw exception.");
        }
    }

    @Test(timeout = 4000)
    public void testValueOfWithValidPEM() {
        try {
            Base64Variant result = Base64Variants.valueOf("PEM");
            assertEquals(Base64Variants.PEM, result);
        } catch (IllegalArgumentException e) {
            fail("Expected valid Base64Variant not to throw exception.");
        }
    }

    @Test(timeout = 4000)
    public void testValueOfWithValidMODIFIED_FOR_URL() {
        try {
            Base64Variant result = Base64Variants.valueOf("MODIFIED_FOR_URL");
            assertEquals(Base64Variants.MODIFIED_FOR_URL, result);
        } catch (IllegalArgumentException e) {
            fail("Expected valid Base64Variant not to throw exception.");
        }
    }

    @Test(timeout = 4000)
    public void testValueOfWithInvalidName() {
        try {
            Base64Variants.valueOf("INVALID_NAME");
            fail("Expected IllegalArgumentException for invalid name.");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testValueOfWithNullName() {
        try {
            Base64Variants.valueOf(null);
            fail("Expected IllegalArgumentException for null name.");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

}