package com.fasterxml.jackson.core.sym;

import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.util.Arrays;
import java.util.BitSet;
import java.util.concurrent.atomic.AtomicReference;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.StreamReadConstraints;
import com.fasterxml.jackson.core.TokenStreamFactory;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.util.InternCache;

public class // Additional tests can be added here to cover other scenarios or edge cases if needed
CharsToNameCanonicalizer_createRoot_1_0_Test {

    private CharsToNameCanonicalizer canonicalizer;

    @BeforeEach
    public void setUp() {
        canonicalizer = CharsToNameCanonicalizer.createRoot();
    }

    @Test
    public void testCreateRoot() {
        assertNotNull(canonicalizer, "The created CharsToNameCanonicalizer should not be null");
    }

    @Test
    public void testCreateRootProperties() throws Exception {
        // Using reflection to access private fields
        Field symbolsField = CharsToNameCanonicalizer.class.getDeclaredField("_symbols");
        symbolsField.setAccessible(true);
        String[] symbols = (String[]) symbolsField.get(canonicalizer);
        assertNotNull(symbols, "The symbols array should not be null");
        Field sizeField = CharsToNameCanonicalizer.class.getDeclaredField("_size");
        sizeField.setAccessible(true);
        int size = (int) sizeField.get(canonicalizer);
        assertEquals(0, size, "The initial size of the canonicalizer should be 0");
        Field sizeThresholdField = CharsToNameCanonicalizer.class.getDeclaredField("_sizeThreshold");
        sizeThresholdField.setAccessible(true);
        int sizeThreshold = (int) sizeThresholdField.get(canonicalizer);
        assertEquals(64, sizeThreshold, "The size threshold should be initialized to DEFAULT_T_SIZE");
        Field indexMaskField = CharsToNameCanonicalizer.class.getDeclaredField("_indexMask");
        indexMaskField.setAccessible(true);
        int indexMask = (int) indexMaskField.get(canonicalizer);
        assertEquals(63, indexMask, "The index mask should be initialized correctly for DEFAULT_T_SIZE");
        Field longestCollisionListField = CharsToNameCanonicalizer.class.getDeclaredField("_longestCollisionList");
        longestCollisionListField.setAccessible(true);
        int longestCollisionList = (int) longestCollisionListField.get(canonicalizer);
        assertEquals(0, longestCollisionList, "The longest collision list should be initialized to 0");
    }
}
