package org.apache.commons.compress.harmony.pack200;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.compress.utils.ExactMath;

public class BHSDCodec_calculateSmallest_1_0_Test {

    private BHSDCodec codec1;

    private BHSDCodec codec2;

    private BHSDCodec codec3;

    private BHSDCodec codec4;

    @BeforeEach
    public void setUp() {
        // cardinality = 255 + 1
        codec1 = new BHSDCodec(1, 256);
        // cardinality = calculated value
        codec2 = new BHSDCodec(5, 256);
        // signed case
        codec3 = new BHSDCodec(2, 128, 1, 1);
        // unsigned case
        codec4 = new BHSDCodec(3, 64, 0, 0);
    }

    @Test
    public void testCalculateSmallestUnsignedWithHighCardinality() {
        // cardinality >= 2^32
        codec2 = new BHSDCodec(2, 128);
        assertEquals(Integer.MIN_VALUE, codec2.cardinality());
    }

    @Test
    public void testCalculateSmallestUnsignedWithLowCardinality() {
        assertEquals(0, codec1.cardinality());
    }

    @Test
    public void testCalculateSmallestSignedWithHighCardinality() {
        // signed with high cardinality
        codec3 = new BHSDCodec(2, 128, 1, 1);
        assertEquals(Integer.MIN_VALUE, codec3.cardinality());
    }

    @Test
    public void testCalculateSmallestSignedWithLowCardinality() {
        // signed case
        codec3 = new BHSDCodec(2, 128, 1, 1);
        // cardinality is calculated accordingly
        assertEquals(-1, codec3.cardinality());
    }

    @Test
    public void testCalculateSmallestWithDifferentParameters() {
        // unsigned case
        codec4 = new BHSDCodec(3, 64, 0, 0);
        assertEquals(0, codec4.cardinality());
    }

    @Test
    public void testConstructorWithInvalidB() {
        assertThrows(IllegalArgumentException.class, () -> new BHSDCodec(0, 256));
        assertThrows(IllegalArgumentException.class, () -> new BHSDCodec(6, 256));
    }

    @Test
    public void testConstructorWithInvalidH() {
        assertThrows(IllegalArgumentException.class, () -> new BHSDCodec(1, 0));
        assertThrows(IllegalArgumentException.class, () -> new BHSDCodec(1, 257));
    }

    @Test
    public void testConstructorWithInvalidS() {
        assertThrows(IllegalArgumentException.class, () -> new BHSDCodec(1, 256, -1));
        assertThrows(IllegalArgumentException.class, () -> new BHSDCodec(1, 256, 3));
    }

    @Test
    public void testConstructorWithInvalidD() {
        assertThrows(IllegalArgumentException.class, () -> new BHSDCodec(1, 256, 0, -1));
        assertThrows(IllegalArgumentException.class, () -> new BHSDCodec(1, 256, 0, 2));
    }

    @Test
    public void testConstructorWithInvalidBAndH() {
    }
}
