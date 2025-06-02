package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import org.junit.Test;
import static org.junit.Assert.*;

public class Base64Variants_valueOf_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testValueOf_MIME() {
        try {
            Base64Variant result = Base64Variants.valueOf("MIME");
            assertEquals(Base64Variants.MIME, result);
        } catch (IllegalArgumentException e) {
            fail("Should not have thrown an exception for valid name 'MIME'");
        }
    }

    @Test(timeout = 4000)
    public void testValueOf_MIME_NO_LINEFEEDS() {
        try {
            Base64Variant result = Base64Variants.valueOf("MIME_NO_LINEFEEDS");
            assertEquals(Base64Variants.MIME_NO_LINEFEEDS, result);
        } catch (IllegalArgumentException e) {
            fail("Should not have thrown an exception for valid name 'MIME_NO_LINEFEEDS'");
        }
    }

    @Test(timeout = 4000)
    public void testValueOf_PEM() {
        try {
            Base64Variant result = Base64Variants.valueOf("PEM");
            assertEquals(Base64Variants.PEM, result);
        } catch (IllegalArgumentException e) {
            fail("Should not have thrown an exception for valid name 'PEM'");
        }
    }

    @Test(timeout = 4000)
    public void testValueOf_MODIFIED_FOR_URL() {
        try {
            Base64Variant result = Base64Variants.valueOf("MODIFIED_FOR_URL");
            assertEquals(Base64Variants.MODIFIED_FOR_URL, result);
        } catch (IllegalArgumentException e) {
            fail("Should not have thrown an exception for valid name 'MODIFIED_FOR_URL'");
        }
    }

    @Test(timeout = 4000)
    public void testValueOf_InvalidName() {
        try {
            Base64Variants.valueOf("INVALID_NAME");
            fail("Should have thrown IllegalArgumentException for invalid name");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testValueOf_NullName() {
        try {
            Base64Variants.valueOf(null);
            fail("Should have thrown IllegalArgumentException for null name");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

}