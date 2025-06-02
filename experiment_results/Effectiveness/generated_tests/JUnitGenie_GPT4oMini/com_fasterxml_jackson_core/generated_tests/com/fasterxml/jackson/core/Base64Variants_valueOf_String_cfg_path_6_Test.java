package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import org.junit.Test;
import static org.junit.Assert.*;

public class Base64Variants_valueOf_String_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testValueOfMIME() {
        try {
            Base64Variant result = Base64Variants.valueOf("MIME");
            assertEquals(Base64Variants.MIME, result);
        } catch (IllegalArgumentException e) {
            fail("Should not have thrown an exception for valid name 'MIME'");
        }
    }

    @Test(timeout = 4000)
    public void testValueOfMIME_NO_LINEFEEDS() {
        try {
            Base64Variant result = Base64Variants.valueOf("MIME_NO_LINEFEEDS");
            assertEquals(Base64Variants.MIME_NO_LINEFEEDS, result);
        } catch (IllegalArgumentException e) {
            fail("Should not have thrown an exception for valid name 'MIME_NO_LINEFEEDS'");
        }
    }

    @Test(timeout = 4000)
    public void testValueOfPEM() {
        try {
            Base64Variant result = Base64Variants.valueOf("PEM");
            assertEquals(Base64Variants.PEM, result);
        } catch (IllegalArgumentException e) {
            fail("Should not have thrown an exception for valid name 'PEM'");
        }
    }

    @Test(timeout = 4000)
    public void testValueOfMODIFIED_FOR_URL() {
        try {
            Base64Variant result = Base64Variants.valueOf("MODIFIED_FOR_URL");
            assertEquals(Base64Variants.MODIFIED_FOR_URL, result);
        } catch (IllegalArgumentException e) {
            fail("Should not have thrown an exception for valid name 'MODIFIED_FOR_URL'");
        }
    }

    @Test(timeout = 4000)
    public void testValueOfInvalidName() {
        try {
            Base64Variants.valueOf("INVALID_NAME");
            fail("Should have thrown an IllegalArgumentException for invalid name");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testValueOfNullName() {
        try {
            Base64Variants.valueOf(null);
            fail("Should have thrown an IllegalArgumentException for null name");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

}