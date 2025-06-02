package org.apache.commons.compress.archivers.zip;

import java.math.BigInteger;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.zip.X7875_NewUnix;
import org.apache.commons.compress.archivers.zip.ZipUtil;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.compress.archivers.zip.ZipUtil.reverse;
import static org.apache.commons.compress.archivers.zip.ZipUtil.unsignedIntToSignedByte;
import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.compress.utils.ByteUtils;

class X7875_NewUnix_parseFromLocalFileData_12_0_Test {

    private X7875_NewUnix x7875NewUnix;

    @BeforeEach
    void setUp() {
        x7875NewUnix = new X7875_NewUnix();
    }

    @Test
    void testParseFromLocalFileData_ValidInput() throws ZipException {
        // version 1, uidSize 2, gidSize 0
        byte[] data = new byte[] { 1, 2, 0, 0, 0, 0 };
        x7875NewUnix.parseFromLocalFileData(data, 0, data.length);
        assertEquals(1, x7875NewUnix.getUID());
        assertEquals(0, x7875NewUnix.getGID());
    }

    @Test
    void testParseFromLocalFileData_LengthTooShort() {
        byte[] data = new byte[] { 1 };
        ZipException exception = assertThrows(ZipException.class, () -> {
            x7875NewUnix.parseFromLocalFileData(data, 0, data.length);
        });
        assertEquals("X7875_NewUnix length is too short, only 1 bytes", exception.getMessage());
    }

    @Test
    void testParseFromLocalFileData_InvalidUidSize() {
        // uidSize 5, but only 6 bytes total
        byte[] data = new byte[] { 1, 5, 0, 0, 0, 0 };
        ZipException exception = assertThrows(ZipException.class, () -> {
            x7875NewUnix.parseFromLocalFileData(data, 0, data.length);
        });
        assertEquals("X7875_NewUnix invalid: uidSize 5 doesn't fit into 6 bytes", exception.getMessage());
    }

    @Test
    void testParseFromLocalFileData_InvalidGidSize() {
        // uidSize 2, gidSize 2, but only 6 bytes total
        byte[] data = new byte[] { 1, 2, 2, 0, 0, 0 };
        ZipException exception = assertThrows(ZipException.class, () -> {
            x7875NewUnix.parseFromLocalFileData(data, 0, data.length);
        });
        assertEquals("X7875_NewUnix invalid: gidSize 2 doesn't fit into 6 bytes", exception.getMessage());
    }

    @Test
    void testParseFromLocalFileData_ValidInputWithNonZeroUidGid() throws ZipException {
        // version 1, uidSize 2, gidSize 1
        byte[] data = new byte[] { 1, 2, 1, 0, 0, 0, 2, 0 };
        x7875NewUnix.parseFromLocalFileData(data, 0, data.length);
        assertEquals(1, x7875NewUnix.getUID());
        assertEquals(2, x7875NewUnix.getGID());
    }
}
