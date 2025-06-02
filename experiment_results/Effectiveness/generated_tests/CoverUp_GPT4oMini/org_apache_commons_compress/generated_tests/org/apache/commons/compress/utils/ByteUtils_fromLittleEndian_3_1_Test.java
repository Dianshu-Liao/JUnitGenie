package org.apache.commons.compress.utils;

import org.apache.commons.compress.utils.ByteUtils;
import java.io.IOException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InputStream;
import java.io.OutputStream;

@ExtendWith(MockitoExtension.class)
class ByteUtils_fromLittleEndian_3_1_Test {

    interface ByteSupplier {

        byte getAsByte();
    }

    @Test
    void testFromLittleEndian_ValidInput() throws Exception {
        ByteSupplier supplier = new ByteSupplier() {

            private final byte[] bytes = { 1, 2, 3, 4, 5, 6, 7, 8 };

            private int index = 0;

            @Override
            public byte getAsByte() {
                return index < bytes.length ? bytes[index++] : -1;
            }
        };
        Method method = ByteUtils.class.getDeclaredMethod("fromLittleEndian", ByteSupplier.class, int.class);
        method.setAccessible(true);
        long result = (long) method.invoke(null, supplier, 8);
        assertEquals(0x0807060504030201L, result);
    }

    @Test
    void testFromLittleEndian_PrematureEndOfData() throws Exception {
        ByteSupplier supplier = new ByteSupplier() {

            private final byte[] bytes = { 1, 2, 3 };

            private int index = 0;

            @Override
            public byte getAsByte() {
                return index < bytes.length ? bytes[index++] : -1;
            }
        };
        Method method = ByteUtils.class.getDeclaredMethod("fromLittleEndian", ByteSupplier.class, int.class);
        method.setAccessible(true);
        IOException exception = assertThrows(IOException.class, () -> {
            method.invoke(null, supplier, 8);
        });
        assertEquals("Premature end of data", exception.getMessage());
    }

    @Test
    void testFromLittleEndian_ExceedsLength() throws Exception {
        ByteSupplier supplier = new ByteSupplier() {

            private final byte[] bytes = { 1, 2, 3, 4, 5, 6, 7, 8 };

            private int index = 0;

            @Override
            public byte getAsByte() {
                return index < bytes.length ? bytes[index++] : -1;
            }
        };
        Method method = ByteUtils.class.getDeclaredMethod("fromLittleEndian", ByteSupplier.class, int.class);
        method.setAccessible(true);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            method.invoke(null, supplier, 9);
        });
        assertEquals("Can't read more than eight bytes into a long value", exception.getMessage());
    }

    @Test
    void testFromLittleEndian_ZeroLength() throws Exception {
        ByteSupplier supplier = () -> -1;
        Method method = ByteUtils.class.getDeclaredMethod("fromLittleEndian", ByteSupplier.class, int.class);
        method.setAccessible(true);
        long result = (long) method.invoke(null, supplier, 0);
        assertEquals(0L, result);
    }
}
