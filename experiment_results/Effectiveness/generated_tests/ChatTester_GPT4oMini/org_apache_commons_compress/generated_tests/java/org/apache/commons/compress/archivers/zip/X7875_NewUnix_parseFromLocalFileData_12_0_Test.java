package org.apache.commons.compress.archivers.zip;

import java.math.BigInteger;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.compress.archivers.zip.ZipUtil.reverse;
import static org.apache.commons.compress.archivers.zip.ZipUtil.unsignedIntToSignedByte;
import java.io.Serializable;
import java.util.zip.ZipException;
import org.apache.commons.compress.utils.ByteUtils;

class X7875_NewUnix_parseFromLocalFileData_12_0_Test {

    private X7875_NewUnix x7875;

    @BeforeEach
    void setUp() {
        x7875 = new X7875_NewUnix();
    }

    @Test
    void testParseFromLocalFileData_ValidData() throws Exception {
        // version = 1, uidSize = 4, uid = 0x00000001, gidSize = 2, gid = 0x0002
        byte[] data = new byte[] { 1, 4, 0, 0, 0, 0, 1, 2 };
        int offset = 0;
        int length = data.length;
        x7875.parseFromLocalFileData(data, offset, length);
        // Use reflection to access private fields
        Method getUidMethod = X7875_NewUnix.class.getDeclaredMethod("getUID");
        getUidMethod.setAccessible(true);
        BigInteger uid = (BigInteger) getUidMethod.invoke(x7875);
        Method getGidMethod = X7875_NewUnix.class.getDeclaredMethod("getGID");
        getGidMethod.setAccessible(true);
        BigInteger gid = (BigInteger) getGidMethod.invoke(x7875);
        assertEquals(BigInteger.valueOf(1), uid);
        assertEquals(BigInteger.valueOf(2), gid);
    }

    @Test
    void testParseFromLocalFileData_LengthTooShort() {
        // length is too short
        byte[] data = new byte[] { 1, 1 };
        assertThrows(ZipException.class, () -> {
            x7875.parseFromLocalFileData(data, 0, data.length);
        });
    }

    @Test
    void testParseFromLocalFileData_InvalidUidSize() {
        // uidSize is valid
        byte[] data = new byte[] { 1, 4, 0, 0, 0, 0, 1, 2 };
        assertThrows(ZipException.class, () -> {
            // length is less than required
            x7875.parseFromLocalFileData(data, 0, 6);
        });
    }

    @Test
    void testParseFromLocalFileData_InvalidGidSize() {
        // gidSize is valid
        byte[] data = new byte[] { 1, 4, 0, 0, 0, 0, 1, 2 };
        assertThrows(ZipException.class, () -> {
            // length is less than required
            x7875.parseFromLocalFileData(data, 0, 7);
        });
    }

    // Additional helper methods for reflection
    private BigInteger getUid(X7875_NewUnix x7875) throws Exception {
        Method getUidMethod = X7875_NewUnix.class.getDeclaredMethod("getUID");
        getUidMethod.setAccessible(true);
        return (BigInteger) getUidMethod.invoke(x7875);
    }

    private BigInteger getGid(X7875_NewUnix x7875) throws Exception {
        Method getGidMethod = X7875_NewUnix.class.getDeclaredMethod("getGID");
        getGidMethod.setAccessible(true);
        return (BigInteger) getGidMethod.invoke(x7875);
    }
}
