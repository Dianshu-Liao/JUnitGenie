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

    @Test
    public void testEquals_SameObject() {
        ZipEightByteInteger zip1 = new ZipEightByteInteger(12345L);
        assertTrue(zip1.equals(zip1), "An object should equal itself.");
    }

    @Test
    public void testEquals_EqualValues() {
        ZipEightByteInteger zip1 = new ZipEightByteInteger(12345L);
        ZipEightByteInteger zip2 = new ZipEightByteInteger(12345L);
        assertTrue(zip1.equals(zip2), "Two ZipEightByteInteger objects with the same value should be equal.");
    }

    @Test
    public void testEquals_DifferentValues() {
        ZipEightByteInteger zip1 = new ZipEightByteInteger(12345L);
        ZipEightByteInteger zip2 = new ZipEightByteInteger(54321L);
        assertFalse(zip1.equals(zip2), "Two ZipEightByteInteger objects with different values should not be equal.");
    }

    @Test
    public void testEquals_NullObject() {
        ZipEightByteInteger zip1 = new ZipEightByteInteger(12345L);
        assertFalse(zip1.equals(null), "A ZipEightByteInteger object should not equal null.");
    }

    @Test
    public void testEquals_DifferentClass() {
        ZipEightByteInteger zip1 = new ZipEightByteInteger(12345L);
        String nonZipObject = "Not a ZipEightByteInteger";
        assertFalse(zip1.equals(nonZipObject), "A ZipEightByteInteger object should not equal an object of a different class.");
    }
}
