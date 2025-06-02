package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.nio.ByteOrder;
import org.apache.commons.compress.compressors.lzw.LZWInputStream;

@ExtendWith(MockitoExtension.class)
class UnshrinkingInputStream_addEntry_0_0_Test {

    private UnshrinkingInputStream unshrinkingInputStream;

    private InputStream mockInputStream;

    @BeforeEach
    void setUp() {
        mockInputStream = Mockito.mock(InputStream.class);
        unshrinkingInputStream = new UnshrinkingInputStream(mockInputStream);
    }

    @Test
    void testAddEntryWithValidPreviousCodeAndCharacter() throws IOException {
        int previousCode = 0;
        byte character = 'a';
        int result = unshrinkingInputStream.addEntry(previousCode, character);
        assertEquals(0, result);
    }

    @Test
    void testAddEntryWithMaxTableSize() throws IOException {
        int previousCode = 0;
        byte character = 'b';
        int result = unshrinkingInputStream.addEntry(previousCode, character);
        assertEquals(1, result);
    }

    @Test
    void testAddEntryWithInvalidPreviousCode() {
        int invalidPreviousCode = -1;
        byte character = 'c';
        assertThrows(IOException.class, () -> {
            unshrinkingInputStream.addEntry(invalidPreviousCode, character);
        });
    }

    @Test
    void testAddEntryWhenTableSizeIsFull() throws IOException {
        int previousCode = 0;
        byte character = 'd';
        int result = unshrinkingInputStream.addEntry(previousCode, character);
        assertEquals(-1, result);
    }
}
