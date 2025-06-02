package org.apache.commons.compress.archivers.sevenz;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

final class Folder_toString_5_0_Test {

    private Folder folder;

    @BeforeEach
    void setUp() {
        folder = new Folder();
        folder.coders = new Coder[0];
        folder.totalInputStreams = 0;
        folder.totalOutputStreams = 0;
        folder.bindPairs = new BindPair[0];
        folder.packedStreams = new long[0];
        folder.unpackSizes = new long[0];
        folder.hasCrc = false;
        folder.crc = 0;
        folder.numUnpackSubStreams = 0;
    }

    @Test
    void testToString_NoCodersNoCRC() {
        String expected = "Folder with 0 coders, 0 input streams, 0 output streams, " + "0 bind pairs, 0 packed streams, 0 unpack sizes, without CRC and 0 unpack streams";
        assertEquals(expected, folder.toString());
    }

    @Test
    void testToString_WithCodersAndCRC() {
        folder.coders = new Coder[1];
        folder.totalInputStreams = 5;
        folder.totalOutputStreams = 3;
        folder.bindPairs = new BindPair[2];
        folder.packedStreams = new long[] { 1, 2, 3 };
        folder.unpackSizes = new long[] { 4, 5 };
        folder.hasCrc = true;
        folder.crc = 123456;
        folder.numUnpackSubStreams = 1;
        String expected = "Folder with 1 coders, 5 input streams, 3 output streams, " + "2 bind pairs, 3 packed streams, 2 unpack sizes, with CRC 123456 and 1 unpack streams";
        assertEquals(expected, folder.toString());
    }

    @Test
    void testToString_WithNoCodersWithCRC() {
        folder.coders = new Coder[0];
        folder.totalInputStreams = 0;
        folder.totalOutputStreams = 0;
        folder.bindPairs = new BindPair[0];
        folder.packedStreams = new long[0];
        folder.unpackSizes = new long[0];
        folder.hasCrc = true;
        folder.crc = 654321;
        folder.numUnpackSubStreams = 0;
        String expected = "Folder with 0 coders, 0 input streams, 0 output streams, " + "0 bind pairs, 0 packed streams, 0 unpack sizes, with CRC 654321 and 0 unpack streams";
        assertEquals(expected, folder.toString());
    }

    @Test
    void testToString_WithMultipleCodersAndStreams() {
        folder.coders = new Coder[3];
        folder.totalInputStreams = 10;
        folder.totalOutputStreams = 7;
        folder.bindPairs = new BindPair[4];
        folder.packedStreams = new long[] { 1, 2, 3, 4 };
        folder.unpackSizes = new long[] { 5, 6, 7 };
        folder.hasCrc = true;
        folder.crc = 987654;
        folder.numUnpackSubStreams = 2;
        String expected = "Folder with 3 coders, 10 input streams, 7 output streams, " + "4 bind pairs, 4 packed streams, 3 unpack sizes, with CRC 987654 and 2 unpack streams";
        assertEquals(expected, folder.toString());
    }
}
