package org.apache.commons.compress.archivers.zip;

import java.math.BigInteger;
import java.util.zip.ZipException;
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

public class X7875_NewUnix_parseFromLocalFileData_12_0_Test {

    private X7875_NewUnix x7875NewUnix;

    @BeforeEach
    public void setUp() {
        x7875NewUnix = new X7875_NewUnix();
    }

    @Test
    public void testParseFromLocalFileData_ValidData() throws ZipException {
        byte[] data = new byte[] { // version
        // uid size
        // uid (1 in reverse)
        // uid (1 in reverse)
        1, // uid (1 in reverse)
        4, // uid (1 in reverse)
        0, // gid size
        0, // gid (2 in reverse)
        0, // gid (2 in reverse)
        1, // gid (2 in reverse)
        0, // gid (2 in reverse)
        0, 0, 0, 2 };
        x7875NewUnix.parseFromLocalFileData(data, 0, data.length);
        assertEquals(BigInteger.valueOf(1), x7875NewUnix.getUID());
        assertEquals(BigInteger.valueOf(2), x7875NewUnix.getGID());
    }

    @Test
    public void testParseFromLocalFileData_LengthTooShort() {
        byte[] data = new byte[] { 1, 1 };
        ZipException exception = assertThrows(ZipException.class, () -> {
            x7875NewUnix.parseFromLocalFileData(data, 0, data.length);
        });
        assertEquals("X7875_NewUnix length is too short, only 2 bytes", exception.getMessage());
    }

    @Test
    public void testParseFromLocalFileData_InvalidUidSize() {
        byte[] data = new byte[] { // version
        // uid size
        // uid (1 in reverse)
        // uid (1 in reverse)
        1, // uid (1 in reverse)
        4, // uid (1 in reverse)
        0, // gid size (not enough data for gid)
        0, 0, 1, 0, 0, 1, 1 };
        ZipException exception = assertThrows(ZipException.class, () -> {
            x7875NewUnix.parseFromLocalFileData(data, 0, data.length);
        });
        assertEquals("X7875_NewUnix invalid: gidSize 1 doesn't fit into 6 bytes", exception.getMessage());
    }

    @Test
    public void testParseFromLocalFileData_InvalidGidSize() {
        byte[] data = new byte[] { // version
        // uid size
        // uid (1 in reverse)
        // uid (1 in reverse)
        1, // uid (1 in reverse)
        4, // uid (1 in reverse)
        0, // gid size
        0, // gid (2 in reverse)
        0, // gid (2 in reverse)
        1, // gid (2 in reverse)
        0, // gid (2 in reverse)
        0, 0, 0, 2 };
        ZipException exception = assertThrows(ZipException.class, () -> {
            x7875NewUnix.parseFromLocalFileData(data, 0, 6);
        });
        assertEquals("X7875_NewUnix invalid: gidSize 4 doesn't fit into 6 bytes", exception.getMessage());
    }
}
