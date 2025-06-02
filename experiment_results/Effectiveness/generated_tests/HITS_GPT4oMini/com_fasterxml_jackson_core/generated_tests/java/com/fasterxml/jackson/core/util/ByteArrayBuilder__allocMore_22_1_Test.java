package com.fasterxml.jackson.core.util;

import java.lang.reflect.Field;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.OutputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class ByteArrayBuilder__allocMore_22_1_Test {

    private ByteArrayBuilder byteArrayBuilder;

    @BeforeEach
    void setUp() {
        byteArrayBuilder = new ByteArrayBuilder(new BufferRecycler());
    }

    private void setPrivateField(String fieldName, Object value) throws Exception {
        Field field = ByteArrayBuilder.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(byteArrayBuilder, value);
    }

    private Object getPrivateField(String fieldName) throws Exception {
        Field field = ByteArrayBuilder.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(byteArrayBuilder);
    }

    private int getStaticField(String fieldName) throws Exception {
        Field field = ByteArrayBuilder.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        // Accessing static field
        return (int) field.get(null);
    }

    @Test
    void testAllocMore_InitialAllocation() throws Exception {
        // Arrange
        setPrivateField("_currBlock", new byte[getStaticField("INITIAL_BLOCK_SIZE")]);
        setPrivateField("_currBlockPtr", 0);
        setPrivateField("_pastLen", 0);
        // Act
        byteArrayBuilder.getClass().getDeclaredMethod("_allocMore").invoke(byteArrayBuilder);
        // Assert
        assertEquals(getStaticField("INITIAL_BLOCK_SIZE") * 2, ((byte[]) getPrivateField("_currBlock")).length);
        assertEquals(getStaticField("INITIAL_BLOCK_SIZE"), ((LinkedList<byte[]>) getPrivateField("_pastBlocks")).get(0).length);
    }

    @Test
    void testAllocMore_ExceedingMaxBlockSize() throws Exception {
        // Arrange
        setPrivateField("_currBlock", new byte[getStaticField("MAX_BLOCK_SIZE")]);
        setPrivateField("_pastLen", getStaticField("MAX_BLOCK_SIZE"));
        // Act
        byteArrayBuilder.getClass().getDeclaredMethod("_allocMore").invoke(byteArrayBuilder);
        // Assert
        assertEquals(getStaticField("MAX_BLOCK_SIZE"), ((byte[]) getPrivateField("_currBlock")).length);
        assertEquals(1, ((LinkedList<byte[]>) getPrivateField("_pastBlocks")).size());
    }

    @Test
    void testAllocMore_AfterMultipleAllocations() throws Exception {
        // Arrange
        setPrivateField("_currBlock", new byte[getStaticField("INITIAL_BLOCK_SIZE")]);
        setPrivateField("_currBlockPtr", 0);
        setPrivateField("_pastLen", 0);
        byteArrayBuilder.getClass().getDeclaredMethod("_allocMore").invoke(byteArrayBuilder);
        // Act - Allocate more
        byteArrayBuilder.getClass().getDeclaredMethod("_allocMore").invoke(byteArrayBuilder);
        // Assert
        assertEquals(getStaticField("INITIAL_BLOCK_SIZE") * 2, ((byte[]) getPrivateField("_currBlock")).length);
        assertEquals(1, ((LinkedList<byte[]>) getPrivateField("_pastBlocks")).size());
    }
}
