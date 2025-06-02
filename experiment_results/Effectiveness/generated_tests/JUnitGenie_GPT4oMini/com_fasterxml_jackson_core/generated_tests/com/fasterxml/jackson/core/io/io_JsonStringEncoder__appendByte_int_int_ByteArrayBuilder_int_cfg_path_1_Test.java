package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.JsonStringEncoder;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class io_JsonStringEncoder__appendByte_int_int_ByteArrayBuilder_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAppendByteWithStandardEscape() {
        try {
            // Arrange
            JsonStringEncoder encoder = new JsonStringEncoder();
            ByteArrayBuilder bb = new ByteArrayBuilder();
            int ch = 65; // 'A' in ASCII, valid byte
            int esc = -1; // standard escape
            int ptr = 0; // starting pointer

            // Act
            Method method = JsonStringEncoder.class.getDeclaredMethod("_appendByte", int.class, int.class, ByteArrayBuilder.class, int.class);
            method.setAccessible(true);
            int result = (int) method.invoke(encoder, ch, esc, bb, ptr);

            // Assert
            assertEquals(6, result); // Expecting 6 bytes to be appended: \u0041
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAppendByteWithSimpleEscape() {
        try {
            // Arrange
            JsonStringEncoder encoder = new JsonStringEncoder();
            ByteArrayBuilder bb = new ByteArrayBuilder();
            int ch = 92; // '\\' in ASCII, valid byte
            int esc = 92; // simple escape for backslash
            int ptr = 0; // starting pointer

            // Act
            Method method = JsonStringEncoder.class.getDeclaredMethod("_appendByte", int.class, int.class, ByteArrayBuilder.class, int.class);
            method.setAccessible(true);
            int result = (int) method.invoke(encoder, ch, esc, bb, ptr);

            // Assert
            assertEquals(1, result); // Expecting 1 byte to be appended: \
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}