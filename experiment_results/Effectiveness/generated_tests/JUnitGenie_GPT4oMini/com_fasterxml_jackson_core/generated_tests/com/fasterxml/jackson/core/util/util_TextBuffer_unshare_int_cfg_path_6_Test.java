package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.TextBuffer;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class util_TextBuffer_unshare_int_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testUnshare() {
        // Arrange
        TextBuffer textBuffer = new TextBuffer(null);
        // Set up the private fields using reflection
        setPrivateField(textBuffer, "_inputLen", 10);
        setPrivateField(textBuffer, "_inputBuffer", new char[20]);
        setPrivateField(textBuffer, "_inputStart", 0);
        
        // Act
        try {
            Method method = TextBuffer.class.getDeclaredMethod("unshare", int.class);
            method.setAccessible(true);
            method.invoke(textBuffer, 5);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Assert
        // Check that the _currentSegment is not null after unshare
        char[] currentSegment = (char[]) getPrivateField(textBuffer, "_currentSegment");
        assertNotNull(currentSegment);
    }

    private void setPrivateField(Object obj, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Object getPrivateField(Object obj, String fieldName) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}