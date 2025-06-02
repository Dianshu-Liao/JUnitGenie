package org.apache.commons.compress.archivers.zip;

import org.junit.jupiter.api.function.Executable;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.ByteOrder;
import org.apache.commons.compress.compressors.lzw.LZWInputStream;

class UnshrinkingInputStream_addEntry_0_0_Test {

    private UnshrinkingInputStream unshrinkingInputStream;

    @BeforeEach
    void setUp() {
        InputStream inputStream = new ByteArrayInputStream(new byte[] {});
        unshrinkingInputStream = new UnshrinkingInputStream(inputStream);
    }

    @Test
    void testAddEntryWithValidParameters() throws Exception {
        // Access the private method using reflection
        Method addEntryMethod = UnshrinkingInputStream.class.getDeclaredMethod("addEntry", int.class, byte.class);
        addEntryMethod.setAccessible(true);
        // Test with valid parameters
        int previousCode = 0;
        byte character = 'a';
        int result = (int) addEntryMethod.invoke(unshrinkingInputStream, previousCode, character);
        // Assert that the result is valid
        assertTrue(result >= 0);
    }

    @Test
    void testAddEntryWithMaxTableSize() throws Exception {
        // Access the private method using reflection
        Method addEntryMethod = UnshrinkingInputStream.class.getDeclaredMethod("addEntry", int.class, byte.class);
        addEntryMethod.setAccessible(true);
        // Fill the isUsed array to its maximum
        for (int i = 0; i < 1 << 13; i++) {
            // Use reflection to set the private isUsed array
            setIsUsed(i, true);
        }
        // Test with valid parameters
        int previousCode = 0;
        byte character = 'b';
        int result = (int) addEntryMethod.invoke(unshrinkingInputStream, previousCode, character);
        // Assert that the result is -1 (indicating no entry was added)
        assertEquals(-1, result);
    }

    private void setIsUsed(int index, boolean value) throws Exception {
        // Use reflection to set the private isUsed array
        java.lang.reflect.Field isUsedField = UnshrinkingInputStream.class.getDeclaredField("isUsed");
        isUsedField.setAccessible(true);
        boolean[] isUsedArray = (boolean[]) isUsedField.get(unshrinkingInputStream);
        isUsedArray[index] = value;
    }
}
