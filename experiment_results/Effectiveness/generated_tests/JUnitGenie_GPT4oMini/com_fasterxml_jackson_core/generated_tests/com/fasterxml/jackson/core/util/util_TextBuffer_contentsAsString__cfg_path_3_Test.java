package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.TextBuffer;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class util_TextBuffer_contentsAsString__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testContentsAsStringWithBufferOverflow() {
        try {
            // Create an instance of TextBuffer using reflection
            Constructor<TextBuffer> constructor = TextBuffer.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            TextBuffer textBuffer = constructor.newInstance();

            // Set private fields using reflection
            setPrivateField(textBuffer, "_segmentSize", Integer.MAX_VALUE);
            setPrivateField(textBuffer, "_currentSize", Integer.MAX_VALUE);
            setPrivateField(textBuffer, "_currentSegment", new char[0]);
            setPrivateField(textBuffer, "_segments", new ArrayList<char[]>());

            // Call the method to trigger buffer overflow
            textBuffer.contentsAsString();
        } catch (IOException e) {
            fail("IOException should not be thrown");
        } catch (InvocationTargetException e) {
            // Handle the buffer overflow case
            assertTrue(e.getCause() instanceof ArrayIndexOutOfBoundsException);
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testContentsAsStringWithValidInput() {
        try {
            // Create an instance of TextBuffer using reflection
            Constructor<TextBuffer> constructor = TextBuffer.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            TextBuffer textBuffer = constructor.newInstance();

            // Set private fields using reflection
            setPrivateField(textBuffer, "_inputStart", 0);
            setPrivateField(textBuffer, "_inputLen", 5);
            setPrivateField(textBuffer, "_currentSegment", new char[]{'H', 'e', 'l', 'l', 'o'});
            setPrivateField(textBuffer, "_currentSize", 5);
            setPrivateField(textBuffer, "_resultString", null);

            // Call the method
            String result = textBuffer.contentsAsString();

            // Validate the result
            assertEquals("Hello", result);
        } catch (IOException e) {
            fail("IOException should not be thrown");
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }


}