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

class Folder_toString_5_0_Test {

    private Folder folder;

    @BeforeEach
    void setUp() {
        folder = new Folder();
    }

    @Test
    void testToString_WithEmptyFolder() {
        folder.coders = new Coder[0];
        folder.totalInputStreams = 0;
        folder.totalOutputStreams = 0;
        folder.bindPairs = new BindPair[0];
        folder.packedStreams = new long[0];
        folder.unpackSizes = new long[0];
        folder.hasCrc = false;
        folder.crc = 0;
        folder.numUnpackSubStreams = 0;
        String expected = "Folder with 0 coders, 0 input streams, 0 output streams, 0 bind pairs, 0 packed streams, 0 unpack sizes, without CRC and 0 unpack streams";
        assertEquals(expected, folder.toString());
    }

    @Test
    void testToString_WithMultipleAttributes() {
        folder.coders = new Coder[2];
        folder.totalInputStreams = 5;
        folder.totalOutputStreams = 3;
        folder.bindPairs = new BindPair[1];
        folder.packedStreams = new long[] { 1, 2, 3 };
        folder.unpackSizes = new long[] { 10, 20 };
        folder.hasCrc = true;
        folder.crc = 123456789;
        folder.numUnpackSubStreams = 4;
        String expected = "Folder with 2 coders, 5 input streams, 3 output streams, 1 bind pairs, 3 packed streams, 2 unpack sizes, with CRC 123456789 and 4 unpack streams";
        assertEquals(expected, folder.toString());
    }

    @Test
    void testToString_WithNoCrc() {
        folder.coders = new Coder[1];
        folder.totalInputStreams = 1;
        folder.totalOutputStreams = 1;
        folder.bindPairs = new BindPair[0];
        folder.packedStreams = new long[0];
        folder.unpackSizes = new long[0];
        folder.hasCrc = false;
        folder.crc = 0;
        folder.numUnpackSubStreams = 1;
        String expected = "Folder with 1 coders, 1 input streams, 1 output streams, 0 bind pairs, 0 packed streams, 0 unpack sizes, without CRC and 1 unpack streams";
        assertEquals(expected, folder.toString());
    }
}
