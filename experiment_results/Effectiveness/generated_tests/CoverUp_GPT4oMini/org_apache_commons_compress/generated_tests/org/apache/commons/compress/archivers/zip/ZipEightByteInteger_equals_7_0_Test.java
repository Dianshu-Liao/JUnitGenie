package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class ZipEightByteInteger_equals_7_0_Test {

    @Test
    void testEqualsWithSameObject() {
        ZipEightByteInteger zipInt = new ZipEightByteInteger(5);
        assertTrue(zipInt.equals(zipInt), "An object should equal itself.");
    }

    @Test
    void testEqualsWithEqualValue() {
        ZipEightByteInteger zipInt1 = new ZipEightByteInteger(10);
        ZipEightByteInteger zipInt2 = new ZipEightByteInteger(10);
        assertTrue(zipInt1.equals(zipInt2), "Two ZipEightByteInteger objects with the same value should be equal.");
    }

    @Test
    void testEqualsWithDifferentValue() {
        ZipEightByteInteger zipInt1 = new ZipEightByteInteger(15);
        ZipEightByteInteger zipInt2 = new ZipEightByteInteger(20);
        assertFalse(zipInt1.equals(zipInt2), "Two ZipEightByteInteger objects with different values should not be equal.");
    }

    @Test
    void testEqualsWithDifferentType() {
        ZipEightByteInteger zipInt = new ZipEightByteInteger(25);
        assertFalse(zipInt.equals("Not a ZipEightByteInteger"), "A ZipEightByteInteger should not equal an object of a different type.");
    }

    @Test
    void testEqualsWithNull() {
        ZipEightByteInteger zipInt = new ZipEightByteInteger(30);
        assertFalse(zipInt.equals(null), "A ZipEightByteInteger should not equal null.");
    }

    @Test
    void testEqualsWithZero() {
        ZipEightByteInteger zipInt1 = new ZipEightByteInteger(0);
        ZipEightByteInteger zipInt2 = ZipEightByteInteger.ZERO;
        assertTrue(zipInt1.equals(zipInt2), "A ZipEightByteInteger with value 0 should be equal to ZipEightByteInteger.ZERO.");
    }

    @Test
    void testEqualsWithDifferentInstancesSameValue() {
        ZipEightByteInteger zipInt1 = new ZipEightByteInteger(100);
        ZipEightByteInteger zipInt2 = new ZipEightByteInteger(new BigInteger("100"));
        assertTrue(zipInt1.equals(zipInt2), "Different instances with the same value should be equal.");
    }
}
