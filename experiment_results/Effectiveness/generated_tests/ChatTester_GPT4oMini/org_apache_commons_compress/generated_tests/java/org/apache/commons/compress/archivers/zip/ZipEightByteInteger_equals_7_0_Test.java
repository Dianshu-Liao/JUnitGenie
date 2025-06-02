package org.apache.commons.compress.archivers.zip;

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

public class ZipEightByteInteger_equals_7_0_Test {

    private ZipEightByteInteger zip1;

    private ZipEightByteInteger zip2;

    private ZipEightByteInteger zip3;

    private ZipEightByteInteger zipZero;

    @BeforeEach
    public void setUp() {
        zip1 = new ZipEightByteInteger(10L);
        zip2 = new ZipEightByteInteger(10L);
        zip3 = new ZipEightByteInteger(20L);
        zipZero = ZipEightByteInteger.ZERO;
    }

    @Test
    public void testEquals_SameValue() {
        assertTrue(zip1.equals(zip2), "zip1 should be equal to zip2 with the same value.");
    }

    @Test
    public void testEquals_DifferentValue() {
        assertFalse(zip1.equals(zip3), "zip1 should not be equal to zip3 with different values.");
    }

    @Test
    public void testEquals_NonZipEightByteInteger() {
        assertFalse(zip1.equals("not a ZipEightByteInteger"), "zip1 should not be equal to a non-ZipEightByteInteger object.");
    }

    @Test
    public void testEquals_SameInstance() {
        assertTrue(zip1.equals(zip1), "zip1 should be equal to itself.");
    }

    @Test
    public void testEquals_ZeroInstance() {
        assertFalse(zip1.equals(zipZero), "zip1 should not be equal to the ZERO instance.");
    }

    @Test
    public void testEquals_Null() {
        assertFalse(zip1.equals(null), "zip1 should not be equal to null.");
    }

    @Test
    public void testEquals_DifferentClass() {
        assertFalse(zip1.equals(new Object()), "zip1 should not be equal to an object of a different class.");
    }
}
