package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.util.ObjectBuffer;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class util_ObjectBuffer__copyTo_Object_int_Object_____int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testCopyTo() {
        try {
            // Arrange
            ObjectBuffer objectBuffer = new ObjectBuffer();
            Object[] resultArray = new Object[10]; // Adjust size as needed
            int totalSize = 10; // Total size expected
            Object[] lastChunk = new Object[] { new Object[] { 1, 2, 3 } }; // Example last chunk
            int lastChunkEntries = ((Object[]) lastChunk[0]).length; // Number of entries in last chunk

            // Accessing the protected method using reflection
            Method method = ObjectBuffer.class.getDeclaredMethod("_copyTo", Object.class, int.class, Object[].class, int.class);
            method.setAccessible(true);

            // Act
            method.invoke(objectBuffer, resultArray, totalSize, lastChunk, lastChunkEntries);

            // Assert
            // Here you can add assertions to verify the contents of resultArray if needed

        } catch (IllegalAccessException e) {
            fail("Method access failed: " + e.getMessage());
        } catch (Exception e) {
            fail("An exception occurred: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testCopyToThrowsException() {
        try {
            // Arrange
            ObjectBuffer objectBuffer = new ObjectBuffer();
            Object[] resultArray = new Object[5]; // Adjust size as needed
            int totalSize = 10; // Total size expected
            Object[] lastChunk = new Object[] { new Object[] { 1, 2, 3 } }; // Example last chunk
            int lastChunkEntries = ((Object[]) lastChunk[0]).length; // Number of entries in last chunk

            // Accessing the protected method using reflection
            Method method = ObjectBuffer.class.getDeclaredMethod("_copyTo", Object.class, int.class, Object[].class, int.class);
            method.setAccessible(true);

            // Act
            method.invoke(objectBuffer, resultArray, totalSize, lastChunk, lastChunkEntries);

            // If no exception is thrown, fail the test
            fail("Expected IllegalStateException was not thrown");

        } catch (IllegalStateException e) {
            // Expected exception, test passes
        } catch (Exception e) {
            fail("An exception occurred: " + e.getMessage());
        }
    }


}